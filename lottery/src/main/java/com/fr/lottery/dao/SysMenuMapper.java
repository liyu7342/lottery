package com.fr.lottery.dao;

import com.fr.lottery.entity.SysMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Liyu7342 on 2018-4-15.
 */
@Repository
public interface SysMenuMapper {
    List<SysMenu> getMenues(@Param("userId") String userId);

    Integer insert(@Param("menunos") String[] menuNos, @Param("userId") String userId);


}
