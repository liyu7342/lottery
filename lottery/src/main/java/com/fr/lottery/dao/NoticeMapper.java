package com.fr.lottery.dao;

import com.fr.lottery.entity.Notice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Liyu7342 on 2018-1-28.
 */
@Repository
public interface NoticeMapper {
    int insert(Notice entity);
    int update(Notice entity);
    int delete(String id);
    List<Notice> getNotices(@Param("noticeType") Integer noticeType,@Param("start") Integer start,@Param("pageSize") Integer pageSize);
    Notice getNotice(String id);

    long count(@Param("noticeType") Integer type);
}
