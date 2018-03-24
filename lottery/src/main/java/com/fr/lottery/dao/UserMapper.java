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


    Long count(@Param("xpath") String xpath,@Param("parentId") String parentid,@Param("userType") Integer userType,@Param("keyword") String keyword,@Param("status") Integer status);
    User getByAccount(@Param("account") String  account);

    User get(@Param("id")String id);
    User getUserCount(@Param("id")String id);
    int insert(User entity);

    int update(User entity);


    int updatePassword(@Param("id") String id,@Param("password") String password);

    int updateLoginSessionId(@Param("id") String id,@Param("sessionid") String sessionId);

    int changeStatus (@Param("id") String id,@Param("status") Integer status);

    List<User> getUsers(@Param("xpath") String xpath,@Param("parentId") String parentid,@Param("userType") Integer userType,@Param("keyword") String keyword,@Param("status") Integer status,@Param("start") Integer start,@Param("pageSize") Integer pageSize);

    int getSeq(@Param("parentID") String parentID);

    Integer getChildSumCredit(@Param("id") String id);

    /**
     * 获取子级最大占成
     * @param id
     * @return
     */
    Integer getChildMaxShareUp(@Param("id") String id);
    Integer hasChild(@Param("id") String id);

    int tingyongOrTingYaChild(@Param("xpath") String xpath,@Param("status") Integer status);
}
