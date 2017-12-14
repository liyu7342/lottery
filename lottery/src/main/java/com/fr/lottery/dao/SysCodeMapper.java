package com.fr.lottery.dao;

import com.fr.lottery.entity.SysCode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Liyu7342 on 2017-10-22.
 */
@Repository
public interface SysCodeMapper {

    long getNextSeq(@Param("codeType") String codeType,@Param("codeKey") String codeKey);

    int insert(SysCode sysCode);
}
