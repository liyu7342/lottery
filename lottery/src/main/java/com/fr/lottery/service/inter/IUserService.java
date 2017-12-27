package com.fr.lottery.service.inter;

import com.fr.lottery.dto.LimitSetDto;
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

    int Save(User entity, LimitSetDto limitSetDto);


    int delete(String id);

    int updatePassword( String id, String password);

    int changeStatus(Integer level,String pid,String id,Integer status);

    Page<User> getUsers(String parentId,Integer userType,String keyword,Integer status,Integer pageId);

    //獲取當前用戶指定級別的用戶
    List<User> getUsers(String xpath,Integer userType);

    Page<User> getDagudongs(Integer userType,String keyword,Integer status,Integer pageId);

    Integer getChildSumCredit(String id);

    User getUserFromCache(String id);

}
