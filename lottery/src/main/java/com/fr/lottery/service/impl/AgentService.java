package com.fr.lottery.service.impl;

import com.fr.lottery.dao.AgentMapper;
import com.fr.lottery.entity.Agent;
import com.fr.lottery.service.inter.IAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Liyu7342 on 2017-7-25.
 */
@Service
public class  AgentService implements IAgentService {
    @Autowired
    private AgentMapper agentMapper;
    @Override
    public Agent getByAccount(String account) {
        return agentMapper.getByAccount(account);
    }

    @Override
    public Agent get(String id) {
        return agentMapper.get(id);
    }

    @Override
    public int insert(Agent agent) {
        return agentMapper.insert(agent);
    }

    @Override
    public int update(Agent agent) {
        return agentMapper.insert(agent);
    }

    @Override
    public int delete(String id) {
        return agentMapper.delete(id);
    }

    @Override
    public int updatePassword(String id, String password) {
        return 0;
        //return agentMapper.update(id,password);
    }
}
