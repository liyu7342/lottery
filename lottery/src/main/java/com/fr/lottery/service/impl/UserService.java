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
        user.setPassword(new MD5Util().getMD5ofStr(user.getPassword()));
        if(StringUtils.isNotBlank( user.getSys_user_oddsSet())){
            user.setHandicap(user.getSys_user_oddsSet());
        }
        if (StringUtils.isBlank(user.getId())) {
            String xpath = "";
            Integer seq = userMapper.getSeq(user.getParentid());

            if (StringUtils.isNoneBlank(user.getParentid())) {
                User parentUser = get(user.getParentid());
                if (parentUser != null) {
                    xpath = parentUser.getXpath();
                    user.setParentName(parentUser.getUserName());
                }
            }
            xpath+=String.format("%03d", seq);
            user.setXpath(xpath);
            user.setXseq(seq);
            user.setId(StringUtil.getUUID());
            user.setCreatedate(new Date());
            userMapper.insert(user);
        } else {
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
        Integer start = (pageId - 1) * Global.pageSize;
        User user = userMapper.get(parentId);
        List<User> users = userMapper.getUsers(user.getXpath()+"%", userType, keyword, status, start);
        long total = userMapper.count(user.getXpath(), userType, keyword, status);
        Page<User> page = new Page<User>(pageId, Global.pageSize, total, users);
        return page;
    }

    @Override
    public Page<User> getDagudongs(Integer userType, String keyword, Integer status, Integer pageId) {
        Integer start = (pageId - 1) * Global.pageSize;
        User user = UserHelper.getCurrentUser();
//        if (user.getUsertype() != UserTypeEnum.Admin.ordinal())
//            return new Page<User>(0, Global.pageSize);
        List<User> users = userMapper.getUsers("", userType, keyword, status, start);
        long total = userMapper.count("", userType, keyword, status);
        Page<User> page = new Page<User>(pageId, Global.pageSize, total, users);
        return page;
    }

    /**
     * 获取下级总信用
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
