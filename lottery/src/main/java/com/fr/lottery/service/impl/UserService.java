package com.fr.lottery.service.impl;

import com.fr.lottery.dao.UserMapper;
import com.fr.lottery.dto.LimitSetDto;
import com.fr.lottery.dto.Page;
import com.fr.lottery.entity.User;
import com.fr.lottery.enums.StatusEnum;
import com.fr.lottery.enums.UserTypeEnum;
import com.fr.lottery.init.Global;
import com.fr.lottery.service.inter.ILimitSetService;
import com.fr.lottery.service.inter.ISysMenuService;
import com.fr.lottery.service.inter.IUserService;
import com.fr.lottery.utils.MD5Util;
import com.fr.lottery.utils.MemcacheUtil;
import com.fr.lottery.utils.StringUtil;
import com.fr.lottery.utils.UserHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ILimitSetService limitSetService;
    @Autowired
    private ISysMenuService sysMenuService;

    private static final String memcached_user_sessionid_key="user_sessionid_";

    public User getByAccount(String loginName) {
        User result = userMapper.getByAccount(loginName);
        return result;
    }

    /**
     * 用户分页
     *
     * @param page
     * @param index
     * @param size
     * @return
     */

    public Page<User> getData(Page<User> page, Integer index, Integer size) {
        List<User> list = new ArrayList<User>();
        if (list != null && list.size() > 0) {
            page.setList(list);
            page.setCount(list.size());
            page.setPageNo(page.getPageNo());
        }
        return page;
    }

    /**
     * 用户分页
     *
     * @param index
     * @param size
     * @return
     */
    @Override
    public Page<User> Paging(String account, String name, Integer index, Integer size) {

        return null;
    }

    @Override
    public User get(String id) {
        return userMapper.get(id);
    }


    public int insert(User entity) {
        entity.setId(StringUtil.getUUID());
        entity.setCreatedate(new Date());
        entity.setXpath("");
        entity.setXseq(0);
        return userMapper.insert(entity);
    }

    @Override
    public int Save(User user, LimitSetDto limitSetDto) {
        if (StringUtils.isNotBlank(user.getSys_user_oddsSet())) {//盘口
            user.setHandicap(user.getSys_user_oddsSet());
        }
        if (user.getUsertype() == UserTypeEnum.Member.ordinal()) { //代理对会员占成
            user.setShareUp(user.getMember_shareUp());
        }


        if (StringUtils.isBlank(user.getId())) {
            user.setPassword(new MD5Util().getMD5ofStr(user.getPassword()));
            user.setId(StringUtil.getUUID());
            String xpath = "";
            Integer seq = userMapper.getSeq(user.getParentid());
            user.setNeedToChangePwd(true);
            if (StringUtils.isNoneBlank(user.getParentid())) {
                User parentUser = get(user.getParentid());
                if (parentUser != null) {
                    xpath = parentUser.getXpath();
                    user.setParentAccount(parentUser.getAccount());
                    user.setParentName(parentUser.getUserName());

                    if (user.getUsertype() > UserTypeEnum.DaGudong.ordinal()) {//股东
                        if(parentUser.getUsertype() ==UserTypeEnum.DaGudong.ordinal()){
                            user.setDagudongAccount(parentUser.getAccount());
                            user.setDagudongId(parentUser.getId());
                            user.setDagudongName(parentUser.getUserName());
                        }
                        else{
                            user.setDagudongAccount(parentUser.getDagudongAccount());
                            user.setDagudongId(parentUser.getDagudongId());
                            user.setDagudongName(parentUser.getDagudongName());
                        }

                    }
                    if (user.getUsertype() > UserTypeEnum.XiaoGudong.ordinal()) {//总代理
                        user.setGudongId(parentUser.getGudongId());
                        user.setGudongAccount(parentUser.getGudongAccount());
                        user.setGudongName(parentUser.getGudongName());
                    }
                    if (user.getUsertype() > UserTypeEnum.ZongDaili.ordinal()) {
                        user.setZongdailiId(parentUser.getZongdailiId());
                        user.setZongdaiAccount(parentUser.getZongdaiAccount());
                        user.setZongdailiName(parentUser.getZongdailiName());
                    }
                    if (user.getUsertype() > UserTypeEnum.Daili.ordinal()) {
                        user.setDailiId(parentUser.getDailiId());
                        user.setDailiAccount(parentUser.getDailiAccount());
                        user.setDailiName(parentUser.getDailiName());
                    }
                }
            }

            if (user.getUsertype() == UserTypeEnum.DaGudong.ordinal()) {
                user.setDagudongAccount(user.getAccount());
                user.setDagudongId(user.getId());
                user.setDagudongName(user.getUserName());
            } else if (user.getUsertype() == UserTypeEnum.XiaoGudong.ordinal()) {
                user.setGudongAccount(user.getAccount());
                user.setGudongId(user.getId());
                user.setGudongName(user.getUserName());
            } else if (user.getUsertype() == UserTypeEnum.ZongDaili.ordinal()) {
                user.setZongdaiAccount(user.getAccount());
                user.setZongdailiId(user.getId());
                user.setZongdailiName(user.getUserName());
            } else if (user.getUsertype() == UserTypeEnum.Daili.ordinal()) {
                user.setDailiAccount(user.getAccount());
                user.setDailiId(user.getId());
                user.setDailiName(user.getUserName());
            }

            xpath += String.format("%03d", seq);
            user.setXpath(xpath);
            user.setXseq(seq);


            user.setCreatedate(new Date());
            userMapper.insert(user);
            getUserCount(true);
        } else {

            if (StringUtils.isNotBlank(user.getPassword())) {
                user.setPassword(new MD5Util().getMD5ofStr(user.getPassword()));
                user.setNeedToChangePwd(true);
            }
            if(user.getUsertype() != UserTypeEnum.Member.ordinal()){
                Integer childMaxShareUp = userMapper.getChildMaxShareUp(user.getId());
                if(childMaxShareUp==null || user.getShareTotal() <childMaxShareUp){
                    return -1;
                }
            }
            userMapper.update(user);
            MemcacheUtil.set(Global.memcached_user_key+user.getId(),user);
        }
        limitSetService.insert(user.getId(), limitSetDto);
        return 1;
    }

    @Override
    public int saveAdmin(User user,String menunos){
        if (StringUtils.isBlank(user.getId())) {
            user.setPassword(new MD5Util().getMD5ofStr(user.getPassword()));
            user.setId(StringUtil.getUUID());
            user.setNeedToChangePwd(true);
            Integer seq = userMapper.getSeq(user.getParentid());
             user.setXpath(user.getXpath()+String.format("%03d", seq));
             user.setXseq(seq);
            user.setUsertype(UserTypeEnum.UserAdmin.ordinal());
            user.setCreatedate(new Date());
            userMapper.insert(user);
        } else {
            if (StringUtils.isNotBlank(user.getPassword())) {
                user.setPassword(new MD5Util().getMD5ofStr(user.getPassword()));
                user.setNeedToChangePwd(true);
            }
            userMapper.update(user);
        }
        sysMenuService.save(user.getId(),menunos);
        return 1;
    }
    @Override
    public int delete(String id) {
        int exists= userMapper.hasChild(id);
        if(exists>0)
            return -1;
        userMapper.changeStatus(id, Global.userStatus_delete);
        getUserCount(true);
        return 1;
    }

    @Override
    public int updatePassword(String id, String password) {
        return userMapper.updatePassword(id, password);
    }

    @Override
    public int updateLoginStatus(User user) {
        MemcacheUtil.set(memcached_user_sessionid_key+ user.getRealId(),user.getSessionId());
        return userMapper.updateLoginSessionId(user.getRealId(), user.getSessionId());
    }

    /**R
     * 從緩存中獲取sessionid,獲取不到則從數據庫中獲取，并寫入緩存
     * @param userId
     * @return
     */
        @Override
        public String getUserSessionId(String userId){
            Object object= MemcacheUtil.get(memcached_user_sessionid_key+ userId);
            if(object==null){
                User user =userMapper.get(userId);
                MemcacheUtil.set(memcached_user_sessionid_key+ userId,user);
                return user.getSessionId();
            }
            return object.toString();
        }

    @Override
    public int changeStatus(Integer level, String pid, String id, Integer status) {
        User user = userMapper.get(id);
        if (user == null) return 10086;
        if(user.getStatus()==StatusEnum.Deleted.ordinal()){
            return -5;
        }
        if(status == StatusEnum.QiYong.ordinal()){
            User pUser = userMapper.get(pid);
            if(pUser!=null && pUser.getStatus()== StatusEnum.TingYa.ordinal()){//必須先啟用上級賬號
                return -2;
            }
            if(pUser != null && pUser.getStatus()== StatusEnum.TingYong.ordinal()){//上級賬號已停用
                return -3;
            }
            userMapper.changeStatus(id, status);
        }
       else if(status == StatusEnum.Deleted.ordinal()){
            int exists= userMapper.hasChild(id);
            if(exists>0)
                return -300;
            userMapper.changeStatus(id, status);
        }
        else if(status == StatusEnum.TingYa.ordinal() || status == StatusEnum.TingYong.ordinal())
        {
            userMapper.tingyongOrTingYaChild(user.getXpath()+"%",status);
        }
        else
            userMapper.changeStatus(id, status);
        return 0;
    }

    @Override
    public Page<User> getUsers(String userId, String parentid, Integer userType, String keyword, Integer status, Integer pageId) {
        Integer start = (pageId - 1) * Global.pageSizeOfFiften;
        User user = userMapper.get(userId);
        if (StringUtils.isNotBlank(keyword)) {
            keyword = "%" + keyword + "%";
        }
        List<User> users = userMapper.getUsers(user.getXpath() + "%", parentid, userType, keyword, status, start, Global.pageSizeOfFiften);
        long total = userMapper.count(user.getXpath() + "%", parentid, userType, keyword, status);
        Page<User> page = new Page<User>(pageId, Global.pageSizeOfFiften, total, users);
        return page;
    }

    @Override
    public List<User> getUsers(String xpath, Integer userType) {
        return userMapper.getUsers(xpath + "%", "", userType, "", null, null, null);
    }

    @Override
    public Page<User> getDagudongs(Integer userType, String keyword, Integer status, Integer pageId) {
        Integer start = (pageId - 1) * Global.pageSizeOfTen;
        User user = UserHelper.getCurrentUser();
        List<User> users = userMapper.getUsers(user.getXpath() + "%", "", userType, keyword, status, start, Global.pageSizeOfTen);
        long total = userMapper.count("", "", userType, keyword, status);
        Page<User> page = new Page<User>(pageId, Global.pageSizeOfTen, total, users);
        return page;
    }

    /**
     * 获取下级總信用
     *
     * @param id
     * @return
     */
    @Override
    public Integer getChildSumCredit(String id) {
        if (StringUtils.isBlank(id)) {
            return 0;
        }
        return userMapper.getChildSumCredit(id);
    }

    @Override
    public User getUserFromCache(String id) {
        Object object = MemcacheUtil.get(Global.memcached_user_key + id);
        if (object != null)
            return (User) object;
        User user = userMapper.get(id);
        if (user != null) {
            MemcacheUtil.set(Global.memcached_user_key + id, user);
        }
        return user;
    }

    /**
     *
     * @param user
     * @return
     */
    public void setUserCache(User user){
        MemcacheUtil.set(Global.memcached_user_key+user.getId(),user);
    }
    @Override
    public User getUserCount(boolean needToReload) {
        User currentUser = UserHelper.getCurrentUser();
        User user =  userMapper.getUserCount(currentUser.getId());
        /*User currentUser = UserHelper.getCurrentUser();
        if (!needToReload) {//不需要重新加载
            Object object = MemcacheUtil.get(memcached_key + currentUser.getId() + "_count");
            if (object != null) {
                user = (User) object;

            }
        }
        if (user == null) {
            user = userMapper.getUserCount(currentUser.getId());
            MemcacheUtil.add(memcached_key + currentUser.getId() + "_count",user);
        }*/
        return user;
    }

}
