package com.fr.lottery.service.inter;

import com.fr.lottery.entity.Member;

/**
 * Created by Liyu7342 on 2017-7-13.
 */
public interface IMemberService {
    Member getByAccount(String account);

    Member get(String id);

    int insert(Member member);

    int update(Member member);

    int delete(String id);

    int updatePassword(String id,String password);
}
