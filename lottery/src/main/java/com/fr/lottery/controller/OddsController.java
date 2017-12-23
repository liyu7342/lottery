package com.fr.lottery.controller;

import com.fr.lottery.dto.Page;
import com.fr.lottery.entity.*;
import com.fr.lottery.enums.OddsTypeEnum;
import com.fr.lottery.init.Global;
import com.fr.lottery.service.inter.IHandicapService;
import com.fr.lottery.service.inter.IOddsService;
import com.fr.lottery.service.inter.IOrderService;
import com.fr.lottery.service.inter.IShengxiaoService;
import com.fr.lottery.utils.*;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by Administrator on 2017/7/11.
 * 赔率设置
 */
@Controller
@RequestMapping("/odds")
public class OddsController {
    @Autowired
    private IOddsService oddsService;
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IHandicapService handicapService;
    @Autowired
    private IShengxiaoService shengxiaoService;

    @RequestMapping("/temaa")
    public ModelAndView temaa(Boolean isDefault, String handicap) {
        if (isDefault == null) isDefault = false;
        ModelAndView modelAndView = new ModelAndView("/odds/temaa");
        String[] oddsTypes = {OddsTypeEnum.tema.getValue(), OddsTypeEnum.lmtema.getValue(), OddsTypeEnum.sebotema.getValue()};

        Map<String, String> map = oddsService.getOddsMap(handicap + "A", oddsTypes);
        modelAndView.addObject("entity", map);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    @RequestMapping("/temab")
    public ModelAndView temab(Boolean isDefault, String handicap) {
        if (isDefault == null) isDefault = false;
        ModelAndView modelAndView = new ModelAndView("/odds/temab");
        String[] oddsTypes = {OddsTypeEnum.tema.getValue(), OddsTypeEnum.lmtema.getValue(), OddsTypeEnum.sebotema.getValue()};
        Map<String, String> map = oddsService.getOddsMap(handicap + "B", oddsTypes);
        modelAndView.addObject("entity", map);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    @RequestMapping("/banbo")
    public ModelAndView banbo(Boolean isDefault, String handicap) {
        if (isDefault == null) isDefault = false;
        ModelAndView modelAndView = new ModelAndView("/odds/banbo");
        String[] oddsTypes = {OddsTypeEnum.banbo.getValue()};
        Map<String, String> map = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    @RequestMapping("/buzhong")
    public ModelAndView buzhong(Boolean isDefault, String handicap) {
        if (isDefault == null) isDefault = false;
        ModelAndView modelAndView = new ModelAndView("/odds/buzhong");
        String[] oddsTypes = {OddsTypeEnum.buzhong5.getValue()};
        Map<String, String> map = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    @RequestMapping("/buzhong6")
    public ModelAndView buzhong6(Boolean isDefault, String handicap) {
        if (isDefault == null) isDefault = false;
        ModelAndView modelAndView = new ModelAndView("/odds/buzhong6");
        String[] oddsTypes = {OddsTypeEnum.buzhong6.getValue()};
        Map<String, String> map = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    @RequestMapping("/buzhong7")
    public ModelAndView buzhong7(Boolean isDefault, String handicap) {
        if (isDefault == null) isDefault = false;
        ModelAndView modelAndView = new ModelAndView("/odds/buzhong7");
        String[] oddsTypes = {OddsTypeEnum.buzhong7.getValue()};
        Map<String, String> map = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    @RequestMapping("/buzhong8")
    public ModelAndView buzhong8(Boolean isDefault, String handicap) {
        if (isDefault == null) isDefault = false;
        ModelAndView modelAndView = new ModelAndView("/odds/buzhong8");
        String[] oddsTypes = {OddsTypeEnum.buzhong8.getValue()};
        Map<String, String> map = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("handicap",handicap);
        modelAndView.addObject("entity", map);
        return modelAndView;
    }

    @RequestMapping("/buzhong9")
    public ModelAndView buzhong9(Boolean isDefault, String handicap) {
        if (isDefault == null) isDefault = false;
        ModelAndView modelAndView = new ModelAndView("/odds/buzhong9");
        String[] oddsTypes = {OddsTypeEnum.buzhong9.getValue()};
        Map<String, String> map = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    @RequestMapping("/buzhong10")
    public ModelAndView buzhong10(Boolean isDefault, String handicap) {
        if (isDefault == null) isDefault = false;
        ModelAndView modelAndView = new ModelAndView("/odds/buzhong10");
        String[] oddsTypes = {OddsTypeEnum.buzhong10.getValue()};
        Map<String, String> map = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    @RequestMapping("/guoguan")
    public ModelAndView guoguan(Boolean isDefault, String handicap) {
        ModelAndView modelAndView = new ModelAndView("/odds/guoguan");
        String[] oddsTypes = {OddsTypeEnum.guoguan.getValue()};
        Map<String, String> map = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    @RequestMapping("/erquanzh")
    public ModelAndView erquanzh(Boolean isDefault, String handicap) {
        if (isDefault == null) isDefault = false;
        ModelAndView modelAndView = new ModelAndView("/odds/lianma");
        String[] oddsTypes = {OddsTypeEnum.erquanzh.getValue()};
        Map<String, String> map = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    @RequestMapping("/erzhongte")
    public ModelAndView erzhongte(Boolean isDefault, String handicap) {
        if (isDefault == null) isDefault = false;
        ModelAndView modelAndView = new ModelAndView("/odds/lianma2_t");
        String[] oddsTypes = {OddsTypeEnum.erzhongte.getValue()};
        Map<String, String> map = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    @RequestMapping("/techuan")
    public ModelAndView techuan(Boolean isDefault, String handicap) {
        if (isDefault == null) isDefault = false;
        ModelAndView modelAndView = new ModelAndView("/odds/lianmatec");
        String[] oddsTypes = {OddsTypeEnum.techuan.getValue()};
        Map<String, String> map = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    @RequestMapping("/sanquanzh")
    public ModelAndView sanquanzh(Boolean isDefault, String handicap) {
        if (isDefault == null) isDefault = false;
        ModelAndView modelAndView = new ModelAndView("/odds/lianma3_3");
        String[] oddsTypes = {OddsTypeEnum.sanquanzh.getValue()};
        Map<String, String> map = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    @RequestMapping("/sanzher")
    public ModelAndView sanzher(Boolean isDefault, String handicap) {
        if (isDefault == null) isDefault = false;
        ModelAndView modelAndView = new ModelAndView("/odds/lianma3_2");
        String[] oddsTypes = {OddsTypeEnum.sanzher.getValue()};
        Map<String, String> map = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }


    @RequestMapping("/liuxiao")
    public ModelAndView liuxiao(Boolean isDefault, String handicap) {
        if (isDefault == null) isDefault = false;
        ModelAndView modelAndView = new ModelAndView("/odds/liuxiao");
        String[] oddsTypes = {OddsTypeEnum.liuxiaozh.getValue(), OddsTypeEnum.liuxiaobuzh.getValue()};
        Map<String, String> map1 = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map1);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    @RequestMapping("/shengxiao")
    public ModelAndView shengxiao(Boolean isDefault, String handicap) {
        ModelAndView modelAndView = new ModelAndView("/odds/shengxiao");
        Map<String, String> map = shengxiaoService.findMapByYear();
        modelAndView.addObject("shengxiao", map);
        String[] oddsTypes = {OddsTypeEnum.shxiao.getValue()};
        Map<String, String> map1 = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map1);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    @RequestMapping("/shengxiaobuzhong")
    public ModelAndView shengxiaobuzhong(Boolean isDefault, String handicap) {
        ModelAndView modelAndView = new ModelAndView("/odds/shengxiaobuzhong");
        Map<String, String> map = shengxiaoService.findMapByYear();
        modelAndView.addObject("shengxiao", map);
        String[] oddsTypes = {OddsTypeEnum.shengxiaobuzhong.getValue()};
        Map<String, String> map1 = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map1);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }


    @RequestMapping("/shengxiaolian")
    public ModelAndView shengxiaolian(Boolean isDefault, String handicap) {
        if (isDefault == null) isDefault = false;
        ModelAndView modelAndView = new ModelAndView("/odds/shengxiaolian");
        String[] oddsTypes = OddsTypeEnum.shengxiaolian.getValue().split("\\|");
        Map<String, String> map1 = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map1);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    @RequestMapping("/texiao")
    public ModelAndView texiao(Boolean isDefault, String handicap) {
        if (isDefault == null) isDefault = false;
        ModelAndView modelAndView = new ModelAndView("/odds/texiao");
        Map<String, String> map = shengxiaoService.findMapByYear();
        modelAndView.addObject("shengxiao", map);
        String[] oddsTypes = {OddsTypeEnum.texiao.getValue()};
        Map<String, String> map1 = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map1);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    @RequestMapping("/weishu")
    public ModelAndView weishu(Boolean isDefault, String handicap) {
        ModelAndView modelAndView = new ModelAndView("/odds/weishu");
        String[] oddsTypes = {OddsTypeEnum.weishu.getValue()};
        Map<String, String> map1 = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map1);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    @RequestMapping("/weishulian")
    public ModelAndView weishulian(Boolean isDefault, String handicap) {
        if (isDefault == null) isDefault = false;
        ModelAndView modelAndView = new ModelAndView("/odds/weishulian");
        String[] oddsTypes = OddsTypeEnum.weishulian.getValue().split("\\|");
        Map<String, String> map1 = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map1);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    @RequestMapping("/zheng16")
    public ModelAndView zheng16(Boolean isDefault, String handicap) {
        if (isDefault == null) isDefault = false;
        ModelAndView modelAndView = new ModelAndView("/odds/zheng16");
        String[] oddsTypes = {OddsTypeEnum.lmzhmate1.getValue(), OddsTypeEnum.lmzhmate2.getValue(), OddsTypeEnum.lmzhmate3.getValue(),
                OddsTypeEnum.lmzhmate4.getValue(), OddsTypeEnum.lmzhmate5.getValue(), OddsTypeEnum.lmzhmate6.getValue()};
        Map<String, String> map = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    @RequestMapping("/zhengma")
    public ModelAndView zhengma(Boolean isDefault, String handicap) {
        if (isDefault == null) isDefault = false;
        ModelAndView modelAndView = new ModelAndView("/odds/zhengma");

        String[] oddsTypes = {OddsTypeEnum.zhengma.getValue(), OddsTypeEnum.lmzhma.getValue()};
        Map<String, String> map = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    @RequestMapping("/zhengmate")
    public ModelAndView zhengmate(Boolean isDefault, String handicap) {
        if (isDefault == null) isDefault = false;
        ModelAndView modelAndView = new ModelAndView("/odds/zhengmate");
        String[] oddsTypes = {OddsTypeEnum.zhengmate1.getValue(), OddsTypeEnum.lmzhmate1.getValue(), OddsTypeEnum.sebozhmate1.getValue()};
        Map<String, String> map = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    @RequestMapping("/zhengmate2")
    public ModelAndView zhengmate2(Boolean isDefault, String handicap) {
        if (isDefault == null) isDefault = false;
        ModelAndView modelAndView = new ModelAndView("/odds/zhengmate2");
        String[] oddsTypes = {OddsTypeEnum.zhengmate2.getValue(), OddsTypeEnum.lmzhmate2.getValue(), OddsTypeEnum.sebozhmate2.getValue()};
        Map<String, String> map = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    @RequestMapping("/zhengmate3")
    public ModelAndView zhengmate3(Boolean isDefault, String handicap) {
        if (isDefault == null) isDefault = false;
        ModelAndView modelAndView = new ModelAndView("/odds/zhengmate3");
        String[] oddsTypes = {OddsTypeEnum.zhengmate3.getValue(), OddsTypeEnum.lmzhmate3.getValue(), OddsTypeEnum.sebozhmate3.getValue()};
        Map<String, String> map = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    @RequestMapping("/zhengmate4")
    public ModelAndView zhengmate4(Boolean isDefault, String handicap) {
        if (isDefault == null) isDefault = false;
        ModelAndView modelAndView = new ModelAndView("/odds/zhengmate4");

        String[] oddsTypes = {OddsTypeEnum.zhengmate4.getValue(), OddsTypeEnum.lmzhmate4.getValue(), OddsTypeEnum.sebozhmate4.getValue()};
        Map<String, String> map = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    @RequestMapping("/zhengmate5")
    public ModelAndView zhengmate5(Boolean isDefault, String handicap) {
        if (isDefault == null) isDefault = false;
        ModelAndView modelAndView = new ModelAndView("/odds/zhengmate5");
        String[] oddsTypes = {OddsTypeEnum.zhengmate5.getValue(), OddsTypeEnum.lmzhmate5.getValue(), OddsTypeEnum.sebozhmate5.getValue()};
        Map<String, String> map = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    @RequestMapping("/zhengmate6")
    public ModelAndView zhengmate6(Boolean isDefault, String handicap) {
        if (isDefault == null) isDefault = false;
        ModelAndView modelAndView = new ModelAndView("/odds/zhengmate6");
        String[] oddsTypes = {OddsTypeEnum.zhengmate6.getValue(), OddsTypeEnum.lmzhmate6.getValue(), OddsTypeEnum.sebozhmate6.getValue()};
        Map<String, String> map = oddsService.getOddsMap(handicap, oddsTypes);
        modelAndView.addObject("entity", map);
        modelAndView.addObject("handicap", handicap);
        return modelAndView;
    }

    /**
     * @Date 2017/7/11
     * 获取赔率
     * * @param type
     */
    @RequestMapping("/getOdds")
    public void getOdds(String game_ids, String odds_set, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] gameIds = game_ids.split("\\|");

        List<Odds> oddsList = oddsService.getOddsChange(odds_set, gameIds);
        Map<String, Object> map = new HashedMap();
        Map<String, String> oddsMap = new HashMap<String, String>();
        for (Odds odds : oddsList) {
            if (!odds.getNumkey().contains("_")) {
                oddsMap.put(odds.getNumkey(), odds.getNumvalue() == null ? "" : odds.getNumvalue().toString());
            }
        }
        if (game_ids.indexOf("009") > 0 || game_ids.indexOf("012") > 0) {
            for (Odds odds : oddsList) {
                if (odds.getNumkey().contains("_")) {
                    String key = odds.getNumkey().substring(0, odds.getNumkey().indexOf("_"));
                    if (!StringUtil.isNullOrEmpty(oddsMap.get(key)) && odds.getNumvalue() != null)
                        oddsMap.put(key, (oddsMap.get(key) + "/" + (odds.getNumvalue() == null ? "" : odds.getNumvalue().toString())));
                    else
                        oddsMap.put(key, "");
                }
            }
        }
        Map<String, Object> outMap = new HashedMap();
        boolean isOpen = handicapService.IsOpenHandicap();
        if (isOpen) {
            for (String gameId : gameIds) {
                map.put(gameId, 1);
            }
        } else {
            for (String gameId : gameIds) {
                map.put(gameId, 0);
            }
        }
        outMap.put("odds", oddsMap);
        outMap.put("status", map);
        Map<String, Object> header = new HashedMap();
        User user = UserHelper.getCurrentUser();
        header.put("marquee", "欢迎进入A28 ! 2017年香港六合彩第095期開獎時間為：2017年8月15日（星期2）21:30，本公司於開獎日17:00至17:40開盤，21:30開獎前收盤。如有異動以香港馬會公佈為準!! 敬告：投注後請查看下注明細，確認注單是否交易成功，以免重複下注，所有注單恕不更改，本公司對開獎後的投注均視無效,不便之處敬請諒解");
        Handicap handicap = handicapService.getCurrentHandicap();
        header.put("draws",handicap !=null?handicap.getRiqi():"" );
        header.put("sum", user.getAmount());
        header.put("credit", user.getCredits());
        header.put("fail_count", 0);
        header.put("calc_status", 20);
        Page<Orders> orderDetails = orderService.getOrders(handicap !=null?handicap.getId():"",1,"",user.getId(), Global.pageSizeOfTen);
        List<List<String>> new_order = new ArrayList<List<String>>();

        for (Orders detail : orderDetails.getList()) {
            List<String> detailArr = new ArrayList<String>();
            //detailArr.add(Global.cfg_category_key.get(detail.getGametype()+detail.getNo()).getGameDesc());
            detailArr.add(detail.getDescription());
            detailArr.add(detail.getTotalAmount().toString());
            detailArr.add(detail.getOdds().toString());

            new_order.add(detailArr);
        }

        header.put("new_order", new_order);
        outMap.put("winnums", "04-20-07-03-19-23-27");
        header.put("limit", "");
        header.put("time_stamp", System.currentTimeMillis());
        header.put("lines", new String[]{});
        header.put("ustatus", 1);


        outMap.put("header", header);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(JsonUtil.toJson(outMap));

    }

    @RequestMapping("getHeaderInfo")
    public void getHeaderInfo(HttpServletRequest request, HttpServletResponse response)  throws  IOException{
        Map<String, Object> map = new HashedMap();
        Map<String, Object> header = new HashedMap();
        User user =UserHelper.getCurrentUser();
        header.put("marquee", "欢迎进入A28 ! 2017年香港六合彩第095期開獎時間為：2017年8月15日（星期2）21:30，本公司於開獎日17:00至17:40開盤，21:30開獎前收盤。如有異動以香港馬會公佈為準!! 敬告：投注後請查看下注明細，確認注單是否交易成功，以免重複下注，所有注單恕不更改，本公司對開獎後的投注均視無效,不便之處敬請諒解");
        header.put("draws", DateTimeUtils.Date2String(new Date(), "yyyy-MM-dd"));
        header.put("sum", user.getAmount());
        header.put("credit", user.getCredits());
        header.put("fail_count", 0);
        header.put("calc_status", -1);
        Page<Orders> orderDetails = orderService.getOrders("",1,"",user.getId(),Global.pageSizeOfTen);
        List<List<String>> new_order = new ArrayList<List<String>>();
//        if(Global.cfg_category_key.size()==0){
//            List<LotConfig> lotConfigs=LotConfigHelper.findAll();
//            for(LotConfig lotConfig: lotConfigs)
//                Global..put(lotConfig.getGameNo(),lotConfig);
//        }
        for (Orders detail : orderDetails.getList()) {
            List<String> detailArr = new ArrayList<String>();
            //detailArr.add(Global.cfg_category_key.get(detail.getGametype()+detail.getNo()).getGameDesc());
            detailArr.add(detail.getDescription());
            detailArr.add(detail.getTotalAmount().toString());
            detailArr.add(detail.getOdds().toString());

            new_order.add(detailArr);
        }

        header.put("new_order", new_order);
        header.put("winnums", "04-20-07-03-19-23-27");
        header.put("limit", "");
        header.put("time_stamp", System.currentTimeMillis());
        header.put("lines", new String[]{});
        header.put("ustatus", 1);


        map.put("get_header_info", header);
        map.put("refer_version_number", 1);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(JsonUtil.toJson(map));
    }

    @ResponseBody
    @RequestMapping("save")
    public void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String referer = request.getHeader("Referer");
        Map map = RequestDataUtils.getParameterMap(request);
        boolean isSuccess = oddsService.insert(map);
        response.setContentType("text/html;charset=UTF-8");
        if (isSuccess) {
            response.getWriter().write("<script type=\"text/javascript\"> alert(\"保存成功！\");location.href =\"" + referer + "\"</script>");
        } else {
            response.getWriter().write("<script type=\"text/javascript\"> alert(\"保存失败！\");</script>");
        }


    }
}
