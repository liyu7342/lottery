package com.fr.lottery.service.inter;

import com.fr.lottery.entity.Agent;

import java.util.List;

/**
 * Created by Liyu7342 on 2017-7-25.
 */
public interface IAgentService {
    Agent getByAccount(String account);

    Agent get(String id);

    int insert(Agent Agent);

    int update(Agent Agent);

    int delete(String id);

    int updatePassword(String id,String password);

}
