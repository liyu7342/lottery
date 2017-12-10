package com.fr.lottery.service.impl;

import com.fr.lottery.dao.UserMapper;
import com.fr.lottery.dto.LimitSetDto;
import com.fr.lottery.dto.Page;
import com.fr.lottery.entity.User;
import com.fr.lottery.enums.StatusEnum;
import com.fr.lottery.enums.UserTypeEnum;
import com.fr.lottery.init.Global;
import com.fr.lottery.service.inter.ILimitSetService;
import com.fr.lottery.service.inter.IUserService;
import com.fr.lottery.utils.MD5Util;
import com.fr.lottery.utils.StringUtil;
import com.fr.lottery.utils.UserHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if(StringUtils.isNotBlank( user.getSys_user_oddsSet())){//盘口
            user.setHandicap(user.getSys_user_oddsSet());
        }
        if(user.getUsertype() == UserTypeEnum.Member.ordinal()){ //代理对会员占成
            user.setShareUp(user.getMember_shareUp());
        }

        if (StringUtils.isBlank(user.getId())) {
            user.setPassword(new MD5Util().getMD5ofStr(user.getPassword()));
            user.setId(StringUtil.getUUID());
            String xpath = "";
            Integer seq = userMapper.getSeq(user.getParentid());

            if (StringUtils.isNoneBlank(user.getParentid())) {
                User parentUser = get(user.getParentid());
                if (parentUser != null) {
                    xpath = parentUser.getXpath();
                    user.setParentAccount(parentUser.getAccount());
                    user.setParentName(parentUser.getUserName());
                    if(user.getUsertype()>UserTypeEnum.DaGudong.ordinal()){//股东
                        user.setDagudongAccount(parentUser.getDagudongAccount());
                        user.setDagudongId(parentUser.getDagudongId());
                        user.setDagudongName(parentUser.getDagudongName());
                    }
                    if(user.getUsertype()>UserTypeEnum.XiaoGudong.ordinal()){//总代理
                        user.setGudongId(parentUser.getGudongId());
                        user.setGudongAccount(parentUser.getGudongAccount());
                        user.setGudongName(parentUser.getGudongName());
                    }
                    if(user.getUsertype()>UserTypeEnum.ZongDaili.ordinal()){
                        user.setZongdailiId(parentUser.getZongdailiId());
                        user.setZongdaiAccount(parentUser.getZongdaiAccount());
                        user.setZongdailiName(parentUser.getZongdailiName());
                    }
                    if(user.getUsertype()>UserTypeEnum.Daili.ordinal()){
                        user.setDailiId(parentUser.getDailiId());
                        user.setDailiAccount(parentUser.getDailiAccount());
                        user.setDailiName(parentUser.getDailiName());
                    }
                }
            }

            if(user.getUsertype() ==UserTypeEnum.DaGudong.ordinal()){
                user.setDagudongAccount(user.getAccount());
                user.setDagudongId(user.getId());
                user.setDagudongName(user.getUserName());
            }
            else if(user.getUsertype() ==UserTypeEnum.XiaoGudong.ordinal()){
                user.setGudongAccount(user.getAccount());
                user.setGudongId(user.getId());
                user.setGudongName(user.getUserName());
            }
            else if(user.getUsertype() ==UserTypeEnum.ZongDaili.ordinal()){
                user.setZongdaiAccount(user.getAccount());
                user.setZongdailiId(user.getId());
                user.setZongdailiName(user.getUserName());
            }
            else if(user.getUsertype() ==UserTypeEnum.Daili.ordinal()){
                user.setDailiAccount(user.getAccount());
                user.setDailiId(user.getId());
                user.setDailiName(user.getUserName());
            }

            xpath+=String.format("%03d", seq);
            user.setXpath(xpath);
            user.setXseq(seq);


            user.setCreatedate(new Date());
            userMapper.insert(user);
        } else {
            if(StringUtils.isNotBlank(user.getPassword())){

                user.setPassword(new MD5Util().getMD5ofStr(user.getPassword()));
            }

            userMapper.update(user);
        }

        limitSetService.insert(user.getId(), limitSetDto);
        return 1;
    }

    @Override
    public int delete(String id) {
        return userMapper.changeStatus(id, Global.userStatus_delete);
    }

    @Override
    public int updatePassword(String id, String password) {
        return userMapper.updatePassword(id, password);
    }

    @Override
    public int changeStatus(Integer level, String pid, String id, Integer status) {
        User user = userMapper.get(id);
        if (user == null) return 10086;

     /*   if(user.isDefault())    //初始账号
            return 2;*//*
        User pUser = userMapper.get(pid);
        if(pUser.getStatus()== StatusEnum.TingYa.ordinal()){//必須先啟用上級賬號
            return -2;
        }
        if(pUser.getStatus()== StatusEnum.TingYong.ordinal()){//上級賬號已停用
            return -3;
        }
        if(user.getStatus()==StatusEnum.TingYong.ordinal()){
            return -5;
        }*/
        userMapper.changeStatus(id, status);
        return 0;
    }

    @Override
    public Page<User> getUsers(String parentId, Integer userType, String keyword, Integer status, Integer pageId) {
        Integer start = (pageId - 1) * Global.pageSizeOfTen;
        User user = userMapper.get(parentId);
        List<User> users = userMapper.getUsers(user.getXpath()+"%", userType, keyword, status, start,Global.pageSizeOfTen);
        long total = userMapper.count(user.getXpath()+"%", userType, keyword, status);
        Page<User> page = new Page<User>(pageId, Global.pageSizeOfTen, total, users);
        return page;
    }

    @Override
    public List<User> getUsers(String xpath,Integer userType){
       return userMapper.getUsers(xpath+"%",userType,"",null,null,null);
    }
    @Override
    public Page<User> getDagudongs(Integer userType, String keyword, Integer status, Integer pageId) {
        Integer start = (pageId - 1) * Global.pageSizeOfTen;
        User user = UserHelper.getCurrentUser();
        List<User> users = userMapper.getUsers(user.getXpath()+"%", userType, keyword, status, start,Global.pageSizeOfTen);
        long total = userMapper.count("", userType, keyword, status);
        Page<User> page = new Page<User>(pageId, Global.pageSizeOfTen, total, users);
        return page;
    }

    /**
     * 获取下级總信用
     * @param id
     * @return
     */
    @Override
    public Integer getChildSumCredit(String id) {
        if(StringUtils.isBlank( id)){
            return 0;
        }
        return userMapper.getChildSumCredit(id);
    }
}
