package com.fr.lottery.controller;

import com.fr.lottery.entity.Odds;
import com.fr.lottery.entity.ShengXiao;
import com.fr.lottery.enums.OddsTypeEnum;
import com.fr.lottery.service.inter.IOddsService;
import com.fr.lottery.service.inter.IShengxiaoService;
import com.fr.lottery.utils.JsonUtil;
import com.fr.lottery.utils.StringUtil;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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
        String[] oddsTypes1={OddsTypeEnum.erquanzh.getValue(),OddsTypeEnum.erzhongte.getValue(),OddsTypeEnum.techuan.getValue(),OddsTypeEnum.sanquanzh.getValue(),OddsTypeEnum.sanzher.getValue()};
        List<Odds> oddsList = oddsService.getOddsList("",oddsTypes1);
        Map<String,Float> oddsMap = new HashMap<String, Float>();
        for(Odds odds : oddsList){
            oddsMap.put(odds.getNumkey(),odds.getNumvalue());
        }
        Map<String,Integer> statusMap = new HashMap<String, Integer>();
        for(String oddsType : oddsTypes1){
            statusMap.put(oddsType,1);
        }
        Map<String,Object> infoMap =  new HashMap<String,Object>();
        infoMap.put("odds",oddsMap);
        infoMap.put("status",statusMap);
        infoMap.put("winnums" ,new ArrayList<String>());
        mv.addObject("info", JsonUtil.toJson(infoMap));
        //{"odds":{"00801":"10","00802":"8","00803":"5","00804":"","00805":"","00806":"","00807":"","00808":"","00809":"","00810":"","00811":"","00812":"","00813":"","00814":"","00815":"","00816":"","00817":"","00818":"","00819":"","00820":"","00821":"","00822":"","00823":"","00824":"","00825":"","00826":"","00827":"","00828":"","00829":"","00830":"","00831":"","00832":"","00833":"","00834":"","00835":"","00836":"","00837":"","00838":"","00839":"","00840":"","00841":"","00842":"","00843":"","00844":"","00845":"","00846":"","00847":"","00848":"","00849":"","00901":"10","00902":"20","00903":"25","00904":"","00905":"","00906":"","00907":"","00908":"","00909":"","00910":"","00911":"","00912":"","00913":"","00914":"","00915":"","00916":"","00917":"","00918":"","00919":"","00920":"","00921":"","00922":"","00923":"","00924":"","00925":"","00926":"","00927":"","00928":"","00929":"","00930":"","00931":"","00932":"","00933":"","00934":"","00935":"","00936":"","00937":"","00938":"","00939":"","00940":"","00941":"","00942":"","00943":"","00944":"","00945":"","00946":"","00947":"","00948":"","00949":"","01001":"","01002":"","01003":"","01004":"","01005":"","01006":"","01007":"","01008":"","01009":"","01010":"","01011":"","01012":"","01013":"","01014":"","01015":"","01016":"","01018":"","01019":"","01020":"","01021":"","01022":"","01023":"","01024":"","01025":"","01026":"","01027":"","01028":"","01029":"","01030":"","01031":"","01032":"","01033":"","01034":"","01035":"","01036":"","01037":"","01038":"","01039":"","01040":"","01041":"","01042":"","01043":"","01044":"","01045":"","01046":"","01047":"","01048":"","01049":"","01017":"","01112":"","01130":"","01134":"","01142":"","01145":"","01146":"","01149":"","01139":"","01125":"","01113":"","01104":"","01140":"","01105":"","01123":"","01109":"","01143":"","01120":"","01129":"","01101":"","01106":"","01107":"","01117":"","01118":"","01137":"","01103":"","01122":"","01115":"","01132":"","01126":"","01114":"","01138":"","01144":"","01124":"","01135":"","01147":"","01110":"","01111":"","01121":"","01148":"","01127":"","01133":"","01108":"","01141":"","01136":"","01131":"","01102":"","01116":"","01128":"","01119":"","01201":"","01202":"","01203":"","01204":"","01205":"","01206":"","01207":"","01208":"","01209":"","01210":"","01211":"","01212":"","01213":"","01214":"","01215":"","01216":"","01217":"","01218":"","01219":"","01220":"","01221":"","01222":"","01223":"","01224":"","01225":"","01226":"","01227":"","01228":"","01229":"","01230":"","01231":"","01232":"","01233":"","01234":"","01235":"","01236":"","01237":"","01238":"","01239":"","01240":"","01241":"","01242":"","01243":"","01244":"","01245":"","01246":"","01247":"","01248":"","01249":""},"time_stamp":"1497965137","status":{"008":1,"009":1,"010":1,"011":1,"012":1},"winnums":[]}
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
