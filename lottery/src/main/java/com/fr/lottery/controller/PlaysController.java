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
        String[] oddsTypes= {OddsTypeEnum.guoguan.getValue()};
        List<Odds> oddsList =  oddsService.selectByType(oddsTypes);
        Map<String,Float> map = new HashedMap();
        for(Odds odds : oddsList){
            map.put("pro_"+odds.getNumkey(),odds.getNumvalue());
        }
        mv.addObject("entity",map);
        return mv;
    }

    @RequestMapping("/shengxiao")
    public ModelAndView shengxiao() {
        ModelAndView mv = new ModelAndView("/plays/shengxiao");
        List<ShengXiao> shengXiaos=  shengxiaoService.findByYear();
        Map<String,String> map = new HashMap<String, String>();
        for(ShengXiao shengXiao :shengXiaos){
            String strr=  shengXiao.getNo1()+","+shengXiao.getNo2()+","+shengXiao.getNo3()+","+shengXiao.getNo4();
            if(!StringUtil.isNullOrEmpty(shengXiao.getNo5())){
                strr+=","+shengXiao.getNo5();
            }
            map.put(shengXiao.getName(),strr);
        }
        mv.addObject("shengxiao", map);

        String[] oddsTypes= {OddsTypeEnum.shxiao.getValue()};
        List<Odds> oddsList =  oddsService.selectByType(oddsTypes);
        Map<String,Float> map1 = new HashedMap();
        for(Odds odds : oddsList){
            map1.put("pro_"+odds.getNumkey(),odds.getNumvalue());
        }
        mv.addObject("entity",map1);
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
