package com.fr.lottery.service.inter;

import com.fr.lottery.entity.Bucang;
import com.fr.lottery.entity.User;

import java.util.List;

/**
 * Created by Liyu7342 on 2017-12-15.
 */
public interface IBucangService {
    int insert(Bucang bucang,User user);

    List<Bucang> getDatas(String handicapid,String userid);
}

