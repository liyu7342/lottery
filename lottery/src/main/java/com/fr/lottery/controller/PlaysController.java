package com.fr.lottery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/6/21.
 */
@Controller
@RequestMapping("/plays")
public class PlaysController {

    @RequestMapping("/tema")
    public ModelAndView tema() {
        ModelAndView mv = new ModelAndView("/plays/tema");
        return mv;
    }

    @RequestMapping("/zhengma")
    public ModelAndView zhengma() {
        ModelAndView mv = new ModelAndView("/plays/zhengma");
        return mv;
    }
    @RequestMapping("/zhengmate")
    public ModelAndView zhengmate() {
        ModelAndView mv = new ModelAndView("/plays/zhengmate");
        return mv;
    }
    @RequestMapping("/zhengmate2")
    public ModelAndView zhengmate2() {
        ModelAndView mv = new ModelAndView("/plays/zhengmate2");
        return mv;
    }
    @RequestMapping("/zhengmate3")
    public ModelAndView zhengmate3() {
        ModelAndView mv = new ModelAndView("/plays/zhengmate3");
        return mv;
    }
    @RequestMapping("/zhengmate4")
    public ModelAndView zhengmate4() {
        ModelAndView mv = new ModelAndView("/plays/zhengmate4");
        return mv;
    }
    @RequestMapping("/zhengmate5")
    public ModelAndView zhengmate5() {
        ModelAndView mv = new ModelAndView("/plays/zhengmate5");
        return mv;
    }
    @RequestMapping("/zhengmate6")
    public ModelAndView zhengmate6() {
        ModelAndView mv = new ModelAndView("/plays/zhengmate6");
        return mv;
    }

    @RequestMapping("/zheng1_6")
    public ModelAndView zheng1_6() {
        ModelAndView mv = new ModelAndView("/plays/zheng1_6");
        return mv;
    }

    @RequestMapping("/lianma")
    public ModelAndView lianma() {
        ModelAndView mv = new ModelAndView("/plays/lianma");
        return mv;
    }

    @RequestMapping("/guoguan")
    public ModelAndView guoguan() {
        ModelAndView mv = new ModelAndView("/plays/guoguan");
        return mv;
    }

    @RequestMapping("/shengxiao")
    public ModelAndView shengxiao() {
        ModelAndView mv = new ModelAndView("/plays/shengxiao");
        return mv;
    }

    @RequestMapping("/weishu")
    public ModelAndView weishu() {
        ModelAndView mv = new ModelAndView("/plays/weishu");
        return mv;
    }

    @RequestMapping("/banbo")
    public ModelAndView banbo() {
        ModelAndView mv = new ModelAndView("/plays/banbo");
        return mv;
    }

    @RequestMapping("/liuxiao")
    public ModelAndView liuxiao() {
        ModelAndView mv = new ModelAndView("/plays/liuxiao");
        return mv;
    }

    @RequestMapping("/texiao")
    public ModelAndView texiao() {
        ModelAndView mv = new ModelAndView("/plays/texiao");
        return mv;
    }

    @RequestMapping("/shengxiaolian")
    public ModelAndView shengxiaolian() {
        ModelAndView mv = new ModelAndView("/plays/shengxiaolian");
        return mv;
    }

    @RequestMapping("/weishulian")
    public ModelAndView weishulian() {
        ModelAndView mv = new ModelAndView("/plays/weishulian");
        return mv;
    }

    @RequestMapping("/buzhong")
    public ModelAndView buzhong() {
        ModelAndView mv = new ModelAndView("/plays/buzhong");
        return mv;
    }
}
