package com.fr.lottery.service.inter;

import com.fr.lottery.dto.Page;
import com.fr.lottery.entity.Handicap;

import java.util.List;

/**
 * Created by Administrator on 2017/7/11.
 */
public interface IHandicapService {
    boolean save(Handicap entity);

    Handicap selectByPrimaryKey(String id);

    boolean openHandicap(Handicap handicap);



    Page<Handicap> getHandicaps(Integer pageId) ;

    boolean delete(String id);

    /**
     * 获取最新期数
     * @return
     */
    Handicap getCurrentHandicap();

    Handicap getNotOpenHandicap();

    /**
     * 是否开盘
     * @return
     */
    boolean IsOpenHandicap();

    boolean settlement(String handicapId);

    Handicap getHandicap(String handicapId);

    String get6hbd();
}
