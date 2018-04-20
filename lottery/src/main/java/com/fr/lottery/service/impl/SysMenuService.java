package com.fr.lottery.service.impl;

import com.fr.lottery.dao.SysMenuMapper;
import com.fr.lottery.entity.SysMenu;
import com.fr.lottery.service.inter.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Liyu7342 on 2018-4-15.
 */
@Service
public class SysMenuService implements ISysMenuService{

    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Override
    public List<SysMenu> getMenues(String userId) {
        return sysMenuMapper.getMenues(userId);
    }

    @Override
    public boolean save(String userId,String menuNos) {
        String[] menunoarr = menuNos.split(",");
        return sysMenuMapper.insert(menunoarr,userId)>0;
    }
}
