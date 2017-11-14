package com.fr.lottery.service.impl;

import com.fr.lottery.dao.UserMapper;
import com.fr.lottery.dto.Page;
import com.fr.lottery.entity.User;
import com.fr.lottery.enums.StatusEnum;
import com.fr.lottery.init.Global;
import com.fr.lottery.service.inter.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;

    public User getByAccount(String loginName){
        User result=userMapper.getByAccount(loginName);
        return result;
    }

    /**
     * 用户分页
     * @param page
     * @param index
     * @param size
     * @return
     */

    public Page<User> getData(Page<User> page, Integer index, Integer size) {
        List<User> list=new ArrayList<User>();
        if(list!=null&&list.size()>0){
            page.setList(list);
            page.setCount(list.size());
            page.setPageNo(page.getPageNo());
        }
        return page;
    }
    /**
     * 用户分页
     * @param index
     * @param size
     * @return
     */
    @Override
    public Page<User> Paging(String account,String name,Integer index,Integer size) {
//        List<User> data = userMapper.findAll(account,name,index,size);
//        Long total = userMapper.count(account,name);
//        Page<User> page = new Page<User>(index,size,total,data);
//        return page;
        return null;
        //return userMapper.findAll(account,name,index,size);
    }

    @Override
    public User get(String id) {
        return userMapper.get(id);
    }

    @Override
    public int insert(User entity) {
        return userMapper.insert(entity);
    }

    @Override
    public int update(User entity) {
        return userMapper.update(entity);
    }

    @Override
    public int delete(String id) {
       return  userMapper.changeStatus(id,Global.userStatus_delete);
    }

    @Override
    public int updatePassword(String id, String password) {
        return userMapper.updatePassword(id,password);
    }

    @Override
    public int changeStatus(Integer level, String pid, String id, Integer status) {
        User user = userMapper.get(id);
        if(user ==null) return 10086;

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
        userMapper.changeStatus(id,status);
        return 0;
    }

    @Override
    public Page<User> getUsers(String parentId,Integer userType, String keyword, Integer status, Integer pageId) {
        Integer start =(pageId -1) * 10;
        User user = userMapper.get(parentId);
        List<User> users= userMapper.getUsers(user.getXpath(),userType,keyword,status,start);
        long total = userMapper.count(user.getXpath(),userType,status);
        Page<User> page = new Page<User>(pageId,Global.pageSize,total,users);
        return page;
    }
}
