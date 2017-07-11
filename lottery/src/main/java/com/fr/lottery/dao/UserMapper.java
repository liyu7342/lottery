package com.fr.lottery.dao;



import com.fr.lottery.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@Repository
public interface UserMapper {

    List<User> findAll(@Param("account") String  account,@Param("name") String  name,@Param("start") Integer start ,@Param("limit") Integer limit);

    Long count(@Param("account") String  account,@Param("name") String  name);

    User getByAccount(@Param("account") String  account);

    User get(@Param("id")String id);

    int insert(User entity);

    int update(User entity);

    int delete(@Param("id")String id);

    int updatePassword(@Param("id") String id,@Param("password") String password);

}
