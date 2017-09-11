package com.fr.lottery.service.impl;

import com.fr.lottery.dao.ShengxiaoMapper;
import com.fr.lottery.entity.ShengXiao;
import com.fr.lottery.service.inter.IShengxiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Liyu7342 on 2017-9-11.
 */
@Service
public class ShengxiaoService implements IShengxiaoService {
    @Autowired
    private ShengxiaoMapper shengxiaoMapper;

    @Override
    public List<ShengXiao> findByYear(int year) {
        return shengxiaoMapper.findByYear(year);
    }

    @Override
    public List<ShengXiao> findByYear() {
        Calendar date = Calendar.getInstance();

        return shengxiaoMapper.findByYear(date.get(Calendar.YEAR));
    }
}
