package com.fr.lottery.dao;

import com.fr.lottery.entity.Bucang;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Liyu7342 on 2017-12-14.
 */
@Repository
public interface BucangMapper {
    int insert(Bucang bucang);

    List<Bucang> getDatas(Bucang bucang);
}
