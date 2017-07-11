package com.fr.lottery.service.impl;

import com.fr.lottery.dao.UserMapper;
import com.fr.lottery.dto.Page;
import com.fr.lottery.entity.User;
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
        List<User> data = userMapper.findAll(account,name,index,size);
        Long total = userMapper.count(account,name);
        Page<User> page = new Page<User>(index,size,total,data);
        return page;
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
        return userMapper.delete(id);
    }

    @Override
    public int updatePassword(String id, String password) {
        return updatePassword(id,password);
    }
}
