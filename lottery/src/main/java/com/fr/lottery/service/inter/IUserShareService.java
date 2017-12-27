package com.fr.lottery.service.inter;

import com.fr.lottery.entity.UserShare;

import java.util.List;

/**
 * Created by Liyu7342 on 2017-12-24.
 */
public interface IUserShareService {

    int save(UserShare entity);

    int save(String orderId);
    List<UserShare> getDatas(String handicapId, String userId);

    UserShare getData(String handicapId,String userId,String category,String gameType,String numbers);
}
