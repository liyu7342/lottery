package com.fr.lottery.service.inter;

import com.fr.lottery.dto.Page;
import com.fr.lottery.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
public interface IUserService {
    Page<User> Paging(String account,String name,Integer index,Integer size);

    User getByAccount( String  account);

    User get(String id);

    int insert(User entity);

    int update(User entity);

    int delete(String id);

    int updatePassword( String id, String password);

    int changeStatus(Integer level,String pid,String id,Integer status);

}
