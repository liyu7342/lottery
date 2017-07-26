package com.fr.lottery.dao;

import com.fr.lottery.entity.Agent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by Liyu7342 on 2017-6-18.
 */
@Repository
public interface AgentMapper  {
    List<Agent> findAll(@Param("agent") Agent agent, @Param("start") Integer start, @Param("limit") Integer limit);

    Long count(@Param("agent") Agent agent);

    Agent getByAccount(@Param("account") String  account);

    Agent get(@Param("id")String id);

    int insert(Agent entity);

    int update(Agent entity);

    int delete(@Param("id")String id);
}
