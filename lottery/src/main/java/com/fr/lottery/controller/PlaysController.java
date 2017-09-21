package com.fr.lottery.controller;

import com.fr.lottery.entity.Odds;
import com.fr.lottery.entity.ShengXiao;
import com.fr.lottery.enums.OddsTypeEnum;
import com.fr.lottery.service.inter.IOddsService;
import com.fr.lottery.service.inter.IShengxiaoService;
import com.fr.lottery.utils.StringUtil;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/21.
 */
@Controller
@RequestMapping("/plays")
public class PlaysController {

    @Autowired
    private IOddsService oddsService;

    @Autowired
    private IShengxiaoService shengxiaoService;
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
        String[] oddsTypes= {OddsTypeEnum.lmzhmate1.getValue(),OddsTypeEnum.lmzhmate2.getValue(),OddsTypeEnum.lmzhmate3.getValue(),
                OddsTypeEnum.lmzhmate4.getValue(),OddsTypeEnum.lmzhmate5.getValue(),OddsTypeEnum.lmzhmate6.getValue()};
        Map<String,Float> map  =  oddsService.getOddsMap(oddsTypes);
        mv.addObject("entity",map);
        return mv;
    }

    @RequestMapping("/lianma")
    public ModelAndView lianma() {
        ModelAndView mv = new ModelAndView("/plays/lianma");
        String[] oddsTypes= {OddsTypeEnum.erquanzh.getValue()};
        Map<String,Float> map1 =oddsService.getOddsMap(oddsTypes);
        mv.addObject("entity",map1);
        return mv;
    }

    @RequestMapping("/guoguan")
    public ModelAndView guoguan() {
        ModelAndView mv = new ModelAndView("/plays/guoguan");
        String[] oddsTypes= {OddsTypeEnum.guoguan.getValue()};
        Map<String,Float> map  =  oddsService.getOddsMap(oddsTypes);
        mv.addObject("entity",map);
        return mv;
    }

    @RequestMapping("/shengxiao")
    public ModelAndView shengxiao() {
        ModelAndView mv = new ModelAndView("/plays/shengxiao");
        Map<String,String> map =shengxiaoService.findMapByYear();
        mv.addObject("shengxiao", map);

        String[] oddsTypes= {OddsTypeEnum.shxiao.getValue()};
        Map<String,Float> map1 =oddsService.getOddsMap(oddsTypes);
        mv.addObject("entity",map1);
        return mv;
    }

    @RequestMapping("/weishu")
    public ModelAndView weishu() {
        ModelAndView mv = new ModelAndView("/plays/weishu");
        String[] oddsTypes= {OddsTypeEnum.weishu.getValue()};
        Map<String,Float> map1 =oddsService.getOddsMap(oddsTypes);
        mv.addObject("entity",map1);
        return mv;
    }

    @RequestMapping("/banbo")
    public ModelAndView banbo() {
        ModelAndView mv = new ModelAndView("/plays/banbo");
        String[] oddsTypes= {OddsTypeEnum.banbo.getValue()};
        Map<String,Float> map1 =oddsService.getOddsMap(oddsTypes);
        mv.addObject("entity",map1);
        return mv;
    }

    @RequestMapping("/liuxiao")
    public ModelAndView liuxiao() {
        ModelAndView mv = new ModelAndView("/plays/liuxiao");
        String[] oddsTypes= {OddsTypeEnum.liuxiaozh.getValue(),OddsTypeEnum.liuxiaobuzh.getValue()};
        Map<String,Float> map1 =oddsService.getOddsMap(oddsTypes);
        mv.addObject("entity",map1);
        Map<String,String> map=  shengxiaoService.findMapByYear();
         mv.addObject("shengxiao",map);
        return mv;
    }

    @RequestMapping("/texiao")
    public ModelAndView texiao() {
        ModelAndView mv = new ModelAndView("/plays/texiao");
        Map<String,String> map=  shengxiaoService.findMapByYear();
        mv.addObject("shengxiao", map);
        String[] oddsTypes= {OddsTypeEnum.texiao.getValue()};
        Map<String,Float> map1 =oddsService.getOddsMap(oddsTypes);
        mv.addObject("entity",map1);
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
