package com.fr.lottery.service.inter;

/**
 * Created by Liyu7342 on 2017-10-22.
 */
public interface ISysCodeService {
     String getAutoCode(String handicapId);

     String getBuCangAutoCode(String handicapId);

     String getQiShuAutoCode();
}
