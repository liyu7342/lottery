package com.fr.lottery.service.inter;

import com.fr.lottery.entity.Handicap;

import java.util.List;

/**
 * Created by Administrator on 2017/7/11.
 */
public interface IHandicapService {
    boolean save(Handicap entity);

    Handicap selectByPrimaryKey(String id);

    boolean openHandicap(Handicap handicap);



    List<Handicap> getHandicaps(Integer pageId) ;

    boolean delete(String id);
}
