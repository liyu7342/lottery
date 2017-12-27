package com.fr.lottery.dao;

import com.fr.lottery.entity.UserShare;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Liyu7342 on 2017-12-24.
 */
@Repository
public interface UserShareMapper {
    List<UserShare> getDatas(UserShare entity);

    UserShare getData(@Param("handicapId") String handicapId,@Param("userId") String userId
            ,@Param("category") String category,@Param("gameType") String gameType,@Param("numbers") String numbers);

    int insert(UserShare entity);

    int update(UserShare entity);


}
