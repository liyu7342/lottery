package com.fr.lottery.controller;

import com.fr.lottery.entity.Odds;
import com.fr.lottery.entity.ShengXiao;
import com.fr.lottery.enums.OddsTypeEnum;
import com.fr.lottery.service.inter.IHandicapService;
import com.fr.lottery.service.inter.IOddsService;
import com.fr.lottery.service.inter.IShengxiaoService;
import com.fr.lottery.utils.JsonUtil;
import com.fr.lottery.utils.StringUtil;
import com.fr.lottery.utils.UserHelper;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
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
    private IHandicapService handicapService;

    @Autowired
    private IShengxiaoService shengxiaoService;
    @RequestMapping("/tema")
    public ModelAndView tema() {
        ModelAndView mv = new ModelAndView("/plays/tema");
        boolean isOpen = handicapService.IsOpenHandicap();
        Map<String,Integer> statusMap = new HashMap<String, Integer>();
        Integer status = isOpen ?1:0;
        statusMap.put(OddsTypeEnum.tema.getValue(),status);
        statusMap.put(OddsTypeEnum.lmtema.getValue(),status);
        statusMap.put(OddsTypeEnum.sebotema.getValue(),status);
        mv.addObject("status",JsonUtil.toJson(statusMap));
        mv.addObject("isOpen",isOpen);
        String[] oddsTypes= {OddsTypeEnum.tema.getValue(),OddsTypeEnum.lmtema.getValue(),OddsTypeEnum.sebotema.getValue()};
        Map<String,String> map  =  oddsService.getOddsMap(UserHelper.getCurrentUser().getHandicap()+"A",oddsTypes);
        mv.addObject("entity",map);
        return mv;
    }

    @RequestMapping("/zhengma")
    public ModelAndView zhengma() {
        ModelAndView mv = new ModelAndView("/plays/zhengma");
        boolean isOpen = handicapService.IsOpenHandicap();
        mv.addObject("isOpen",isOpen);
        String[] oddsTypes= {OddsTypeEnum.tema.getValue(),OddsTypeEnum.lmtema.getValue(),OddsTypeEnum.sebotema.getValue()};
        Map<String,String> map  =  oddsService.getOddsMap(UserHelper.getCurrentUser().getHandicap()+"B",oddsTypes);
        mv.addObject("entity",map);
        Map<String,Integer> map1 = new HashMap<String, Integer>();

        for(String oddsType : oddsTypes){
            map1.put(oddsType,isOpen?1:0);
        }
        mv.addObject("status",JsonUtil.toJson(map1));
        return mv;
    }
    @RequestMapping("/zhengmate")
    public ModelAndView zhengmate() {
        ModelAndView mv = new ModelAndView("/plays/zhengmate");
        boolean isOpen = handicapService.IsOpenHandicap();
        mv.addObject("isOpen",isOpen);
        String[] oddsTypes= {OddsTypeEnum.zhengmate1.getValue(),OddsTypeEnum.lmzhmate1.getValue(),OddsTypeEnum.sebozhmate1.getValue()};
        Map<String,String> map  =  oddsService.getOddsMap(UserHelper.getCurrentUser().getHandicap(),oddsTypes);
        mv.addObject("entity",map);
        Map<String,Integer> map1 = new HashMap<String, Integer>();

        for(String oddsType : oddsTypes){
            map1.put(oddsType,isOpen?1:0);
        }
        mv.addObject("status",JsonUtil.toJson(map1));
        return mv;
    }
    @RequestMapping("/zhengmate2")
    public ModelAndView zhengmate2() {
        ModelAndView mv = new ModelAndView("/plays/zhengmate2");
        boolean isOpen = handicapService.IsOpenHandicap();
        mv.addObject("isOpen",isOpen);
        String[] oddsTypes= {OddsTypeEnum.zhengmate2.getValue(),OddsTypeEnum.lmzhmate2.getValue(),OddsTypeEnum.sebozhmate2.getValue()};
        Map<String,String> map  =  oddsService.getOddsMap(UserHelper.getCurrentUser().getHandicap(),oddsTypes);
        mv.addObject("entity",map);
        Map<String,Integer> map1 = new HashMap<String, Integer>();

        for(String oddsType : oddsTypes){
            map1.put(oddsType,isOpen?1:0);
        }
        mv.addObject("status",JsonUtil.toJson(map1));
        return mv;
    }
    @RequestMapping("/zhengmate3")
    public ModelAndView zhengmate3() {
        ModelAndView mv = new ModelAndView("/plays/zhengmate3");
        boolean isOpen = handicapService.IsOpenHandicap();
        mv.addObject("isOpen",isOpen);
        String[] oddsTypes= {OddsTypeEnum.zhengmate3.getValue(),OddsTypeEnum.lmzhmate3.getValue(),OddsTypeEnum.sebozhmate3.getValue()};
        Map<String,String> map  =  oddsService.getOddsMap(UserHelper.getCurrentUser().getHandicap(),oddsTypes);
        mv.addObject("entity",map);
        Map<String,Integer> map1 = new HashMap<String, Integer>();

        for(String oddsType : oddsTypes){
            map1.put(oddsType,isOpen?1:0);
        }
        mv.addObject("status",JsonUtil.toJson(map1));
        return mv;
    }
    @RequestMapping("/zhengmate4")
    public ModelAndView zhengmate4() {
        ModelAndView mv = new ModelAndView("/plays/zhengmate4");
        boolean isOpen = handicapService.IsOpenHandicap();
        mv.addObject("isOpen",isOpen);
        String[] oddsTypes= {OddsTypeEnum.zhengmate4.getValue(),OddsTypeEnum.lmzhmate4.getValue(),OddsTypeEnum.sebozhmate4.getValue()};
        Map<String,String> map  =  oddsService.getOddsMap(UserHelper.getCurrentUser().getHandicap(),oddsTypes);
        mv.addObject("entity",map);
        Map<String,Integer> map1 = new HashMap<String, Integer>();

        for(String oddsType : oddsTypes){
            map1.put(oddsType,isOpen?1:0);
        }
        mv.addObject("status",JsonUtil.toJson(map1));
        return mv;
    }
    @RequestMapping("/zhengmate5")
    public ModelAndView zhengmate5() {
        ModelAndView mv = new ModelAndView("/plays/zhengmate5");
        boolean isOpen = handicapService.IsOpenHandicap();
        mv.addObject("isOpen",isOpen);
        String[] oddsTypes= {OddsTypeEnum.zhengmate5.getValue(),OddsTypeEnum.lmzhmate5.getValue(),OddsTypeEnum.sebozhmate5.getValue()};
        Map<String,String> map  =  oddsService.getOddsMap(UserHelper.getCurrentUser().getHandicap(),oddsTypes);
        mv.addObject("entity",map);
        Map<String,Integer> map1 = new HashMap<String, Integer>();

        for(String oddsType : oddsTypes){
            map1.put(oddsType,isOpen?1:0);
        }
        mv.addObject("status",JsonUtil.toJson(map1));
        return mv;
    }
    @RequestMapping("/zhengmate6")
    public ModelAndView zhengmate6() {
        ModelAndView mv = new ModelAndView("/plays/zhengmate6");
        boolean isOpen = handicapService.IsOpenHandicap();
        mv.addObject("isOpen",isOpen);
        String[] oddsTypes= {OddsTypeEnum.zhengmate6.getValue(),OddsTypeEnum.lmzhmate6.getValue(),OddsTypeEnum.sebozhmate6.getValue()};
        Map<String,String> map  =  oddsService.getOddsMap(UserHelper.getCurrentUser().getHandicap(),oddsTypes);
        mv.addObject("entity",map);
        Map<String,Integer> map1 = new HashMap<String, Integer>();

        for(String oddsType : oddsTypes){
            map1.put(oddsType,isOpen?1:0);
        }
        mv.addObject("status",JsonUtil.toJson(map1));
        return mv;
    }

    @RequestMapping("/zheng1_6")
    public ModelAndView zheng1_6() {
        ModelAndView mv = new ModelAndView("/plays/zheng1_6");
        String[] oddsTypes= {OddsTypeEnum.lmzhmate1.getValue(),OddsTypeEnum.lmzhmate2.getValue(),OddsTypeEnum.lmzhmate3.getValue(),
                OddsTypeEnum.lmzhmate4.getValue(),OddsTypeEnum.lmzhmate5.getValue(),OddsTypeEnum.lmzhmate6.getValue()};
        Map<String,String> map  =  oddsService.getOddsMap(UserHelper.getCurrentUser().getHandicap(),oddsTypes);
        mv.addObject("entity",map);
        boolean isOpen = handicapService.IsOpenHandicap();

        mv.addObject("isOpen",isOpen);
        Map<String,Integer> map1 = new HashMap<String, Integer>();

        for(String oddsType : oddsTypes){
            map1.put(oddsType,isOpen?1:0);
        }

        return mv;
    }

    @RequestMapping("/lianma")
    public ModelAndView lianma() {
        ModelAndView mv = new ModelAndView("/plays/lianma");
        String[] oddsTypes= {OddsTypeEnum.erquanzh.getValue()};
       Map<String,String> map1 =oddsService.getOddsMap(UserHelper.getCurrentUser().getHandicap(),oddsTypes);
        mv.addObject("entity",map1);
        String[] oddsTypes1={OddsTypeEnum.erquanzh.getValue(),OddsTypeEnum.erzhongte.getValue(),OddsTypeEnum.techuan.getValue(),OddsTypeEnum.sanquanzh.getValue(),OddsTypeEnum.sanzher.getValue()};
        List<Odds> oddsList = oddsService.getOddsList("",oddsTypes1);
        Map<String,String> oddsMap = new HashMap<String, String>();
        for(Odds odds : oddsList){
            if(!odds.getNumkey().contains("_")){
                oddsMap.put(odds.getNumkey(),odds.getNumvalue()==null?"":odds.getNumvalue().toString());
            }
        }
        for(Odds odds : oddsList){
            if(odds.getNumkey().contains("_")){
                String key= odds.getNumkey().substring(0,odds.getNumkey().indexOf("_"));
                System.out.println(key);
                if(!StringUtil.isNullOrEmpty(oddsMap.get(key))&& odds.getNumvalue()!=null)
                    oddsMap.put(key,(oddsMap.get(key)+"/"+(odds.getNumvalue()==null?"":odds.getNumvalue().toString())));
                else
                    oddsMap.put(key,"");
            }
        }

        boolean isOpen = handicapService.IsOpenHandicap();
        mv.addObject("isOpen",isOpen);
        Map<String,Integer> statusMap = new HashMap<String, Integer>();
        for(String oddsType : oddsTypes1){
            statusMap.put(oddsType,isOpen?1:0);
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
       Map<String,String> map  =  oddsService.getOddsMap(UserHelper.getCurrentUser().getHandicap(),oddsTypes);
        mv.addObject("entity",map);
        boolean isOpen = handicapService.IsOpenHandicap();
        mv.addObject("isOpen",isOpen);
        return mv;
    }

    @RequestMapping("/shengxiao")
    public ModelAndView shengxiao() {
        ModelAndView mv = new ModelAndView("/plays/shengxiao");
        Map<String,String> map =shengxiaoService.findMapByYear();
        mv.addObject("shengxiao", map);

        String[] oddsTypes= {OddsTypeEnum.shxiao.getValue()};
       Map<String,String> map1 =oddsService.getOddsMap(UserHelper.getCurrentUser().getHandicap(),oddsTypes);
        mv.addObject("entity",map1);
        boolean isOpen = handicapService.IsOpenHandicap();
        mv.addObject("isOpen",isOpen);
        return mv;
    }

    @RequestMapping("/weishu")
    public ModelAndView weishu() {
        ModelAndView mv = new ModelAndView("/plays/weishu");
        String[] oddsTypes= {OddsTypeEnum.weishu.getValue()};
       Map<String,String> map1 =oddsService.getOddsMap(UserHelper.getCurrentUser().getHandicap(),oddsTypes);
        mv.addObject("entity",map1);
        boolean isOpen = handicapService.IsOpenHandicap();
        mv.addObject("isOpen",isOpen);
        return mv;
    }

    @RequestMapping("/banbo")
    public ModelAndView banbo() {
        ModelAndView mv = new ModelAndView("/plays/banbo");
        String[] oddsTypes= {OddsTypeEnum.banbo.getValue()};
       Map<String,String> map1 =oddsService.getOddsMap(UserHelper.getCurrentUser().getHandicap(),oddsTypes);
        mv.addObject("entity",map1);
        boolean isOpen = handicapService.IsOpenHandicap();
        mv.addObject("isOpen",isOpen);
        return mv;
    }

    @RequestMapping("/liuxiao")
    public ModelAndView liuxiao() {
        ModelAndView mv = new ModelAndView("/plays/liuxiao");
        String[] oddsTypes= {OddsTypeEnum.liuxiaozh.getValue(),OddsTypeEnum.liuxiaobuzh.getValue()};
       Map<String,String> map1 =oddsService.getOddsMap(UserHelper.getCurrentUser().getHandicap(),oddsTypes);
        mv.addObject("entity",map1);
        Map<String,String> map=  shengxiaoService.findMapByYear();
         mv.addObject("shengxiao",map);
        boolean isOpen = handicapService.IsOpenHandicap();
        mv.addObject("isOpen",isOpen);
        return mv;
    }

    @RequestMapping("/texiao")
    public ModelAndView texiao() {
        ModelAndView mv = new ModelAndView("/plays/texiao");
        Map<String,String> map=  shengxiaoService.findMapByYear();
        mv.addObject("shengxiao", map);
        String[] oddsTypes= {OddsTypeEnum.texiao.getValue()};
       Map<String,String> map1 =oddsService.getOddsMap(UserHelper.getCurrentUser().getHandicap(),oddsTypes);
        mv.addObject("entity",map1);
        boolean isOpen = handicapService.IsOpenHandicap();
        mv.addObject("isOpen",isOpen);
        return mv;
    }

    @RequestMapping("/shengxiaolian")
    public ModelAndView shengxiaolian() {
        ModelAndView mv = new ModelAndView("/plays/shengxiaolian");
        String[] oddsTypes= OddsTypeEnum.shengxiaolian.getValue().split("\\|");
        Map<String,String> map1 =oddsService.getOddsMap(UserHelper.getCurrentUser().getHandicap(),oddsTypes);
        mv.addObject("entity",map1);
        boolean isOpen = handicapService.IsOpenHandicap();
        mv.addObject("isOpen",isOpen);
        return mv;
    }

    @RequestMapping("/weishulian")
    public ModelAndView weishulian() {
        ModelAndView mv = new ModelAndView("/plays/weishulian");
        String[] oddsTypes= OddsTypeEnum.weishulian.getValue().split("\\|");
       Map<String,String> map1 =oddsService.getOddsMap(UserHelper.getCurrentUser().getHandicap(),oddsTypes);
        mv.addObject("entity",map1);
        boolean isOpen = handicapService.IsOpenHandicap();
        mv.addObject("isOpen",isOpen);
        return mv;
    }

    @RequestMapping("/buzhong")
    public ModelAndView buzhong() {
        ModelAndView mv = new ModelAndView("/plays/buzhong");
        String[] oddsTypes= OddsTypeEnum.buzhong.getValue().split("\\|");
        Map<String,String> map1 =oddsService.getOddsMap(UserHelper.getCurrentUser().getHandicap(),oddsTypes);
        mv.addObject("entity",map1);
        Map<String,Object> map = new HashMap<String ,Object>();
        List<Odds> oddsList= oddsService.getOddsList("",oddsTypes);
        Map<String,String> oddsMap = new HashMap<String, String>();
        for(Odds odds : oddsList){
            if(!odds.getNumkey().contains("_")){
                oddsMap.put(odds.getNumkey(),odds.getNumvalue()==null?"":odds.getNumvalue().toString());
            }
        }
        map.put("odds",oddsMap);
        Map<String,Integer> statusmap = new HashMap<String, Integer>();
        boolean isOpen=handicapService.IsOpenHandicap();
        if(isOpen){
            for(String oddsType :oddsTypes){
                statusmap.put(oddsType,1);
            }
        }
        else{
            for(String oddsType :oddsTypes){
                statusmap.put(oddsType,0);
            }
        }
        mv.addObject("isOpen",isOpen);
        map.put("status",statusmap);
        mv.addObject("info",JsonUtil.toJson(map));
        //{"odds":{"04701":"","04702":"","04703":"","04704":"","04705":"","04706":"","04707":"","04708":"","04709":"","04710":"","04711":"","04712":"","04713":"","04714":"","04715":"","04716":"","04717":"","04718":"","04719":"","04720":"","04721":"","04722":"","04723":"","04724":"","04725":"","04726":"","04727":"","04728":"","04729":"","04730":"","04731":"","04732":"","04733":"","04734":"","04735":"","04736":"","04737":"","04738":"","04739":"","04740":"","04741":"","04742":"","04743":"","04744":"","04745":"","04746":"","04747":"","04748":"","04749":"","04801":"","04802":"","04803":"","04804":"","04805":"","04806":"","04807":"","04808":"","04809":"","04810":"","04811":"","04812":"","04813":"","04814":"","04815":"","04816":"","04817":"","04818":"","04819":"","04820":"","04821":"","04822":"","04823":"","04824":"","04825":"","04826":"","04827":"","04828":"","04829":"","04830":"","04831":"","04832":"","04833":"","04834":"","04835":"","04836":"","04837":"","04838":"","04839":"","04840":"","04841":"","04842":"","04843":"","04844":"","04845":"","04846":"","04847":"","04848":"","04849":"","04901":"","04902":"","04903":"","04904":"","04905":"","04906":"","04907":"","04908":"","04909":"","04910":"","04911":"","04912":"","04913":"","04914":"","04915":"","04916":"","04917":"","04918":"","04919":"","04920":"","04921":"","04922":"","04923":"","04924":"","04925":"","04926":"","04927":"","04928":"","04929":"","04930":"","04931":"","04932":"","04933":"","04934":"","04935":"","04936":"","04937":"","04938":"","04939":"","04940":"","04941":"","04942":"","04943":"","04944":"","04945":"","04946":"","04947":"","04948":"","04949":"","05001":"","05002":"","05003":"","05004":"","05005":"","05006":"","05007":"","05008":"","05009":"","05010":"","05011":"","05012":"","05013":"","05014":"","05015":"","05016":"","05017":"","05018":"","05019":"","05020":"","05021":"","05022":"","05023":"","05024":"","05025":"","05026":"","05027":"","05028":"","05029":"","05030":"","05031":"","05032":"","05033":"","05034":"","05035":"","05036":"","05037":"","05038":"","05039":"","05040":"","05041":"","05042":"","05043":"","05044":"","05045":"","05046":"","05047":"","05048":"","05049":"","05101":"","05102":"","05103":"","05104":"","05105":"","05106":"","05107":"","05108":"","05109":"","05110":"","05111":"","05112":"","05113":"","05114":"","05115":"","05116":"","05117":"","05118":"","05119":"","05120":"","05121":"","05122":"","05123":"","05124":"","05125":"","05126":"","05127":"","05128":"","05129":"","05130":"","05131":"","05132":"","05133":"","05134":"","05135":"","05136":"","05137":"","05138":"","05139":"","05140":"","05141":"","05142":"","05143":"","05144":"","05145":"","05146":"","05147":"","05148":"","05149":"","05201":"","05202":"","05203":"","05204":"","05205":"","05206":"","05207":"","05208":"","05209":"","05210":"","05211":"","05212":"","05213":"","05214":"","05215":"","05216":"","05217":"","05218":"","05219":"","05220":"","05221":"","05222":"","05223":"","05224":"","05225":"","05226":"","05227":"","05228":"","05229":"","05230":"","05231":"","05232":"","05233":"","05234":"","05235":"","05236":"","05237":"","05238":"","05239":"","05240":"","05241":"","05242":"","05243":"","05244":"","05245":"","05246":"","05247":"","05248":"","05249":""},"time_stamp":"1497948387","status":{"047":0,"048":0,"049":0,"050":0,"051":0,"052":0},"winnums":[],"member_status":1}
        return mv;
    }
}
