package com.fr.lottery.service.inter;

import com.fr.lottery.entity.SysMenu;

import java.util.List;

/**
 * Created by Liyu7342 on 2018-4-15.
 */
public interface ISysMenuService {
    List<SysMenu> getMenues(String userId);
    boolean save(String userId, String menuNos);
}
