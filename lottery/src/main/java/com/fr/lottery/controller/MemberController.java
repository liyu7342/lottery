package com.fr.lottery.controller;

import com.fr.lottery.service.inter.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Liyu7342 on 2017-7-16.
 */
@Controller
public class MemberController {

    @Autowired
    private IMemberService memberService;


}
