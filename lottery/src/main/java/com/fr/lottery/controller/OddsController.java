package com.fr.lottery.controller;

import com.fr.lottery.dto.ResultInfo;
import com.fr.lottery.entity.*;
import com.fr.lottery.enums.OddsTypeEnum;
import com.fr.lottery.init.Global;
import com.fr.lottery.service.impl.OddsService;
import com.fr.lottery.service.inter.IOddsService;
import com.fr.lottery.service.inter.IOrderService;
import com.fr.lottery.service.inter.IShengxiaoService;
import com.fr.lottery.utils.*;
import com.google.gson.reflect.TypeToken;
import net.sourceforge.jtds.jdbc.DateTime;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
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
    private IShengxiaoService shengxiaoService;

    @RequestMapping("/temaa")
    public ModelAndView temaa(Boolean isDefault){
        if(isDefault==null) isDefault=false;
        ModelAndView modelAndView = new ModelAndView("/odds/temaa");
        String[] oddsTypes= {OddsTypeEnum.tema.getValue(),OddsTypeEnum.lmtema.getValue(),OddsTypeEnum.sebotema.getValue()};

        List<Odds> oddsList =  oddsService.getOddsList(oddsTypes,isDefault);
        Map<String,Float> map = new HashedMap();
        for(Odds odds : oddsList){
            map.put("pro_"+odds.getNumkey(),odds.getNumvalue());
        }
        modelAndView.addObject("entity",map);
        return modelAndView;
    }

    @RequestMapping("/temab")
    public ModelAndView temab(Boolean isDefault){
        if(isDefault==null) isDefault=false;
        ModelAndView modelAndView = new ModelAndView("/odds/temab");
        String[] oddsTypes= {OddsTypeEnum.tema.getValue(),OddsTypeEnum.lmtema.getValue(),OddsTypeEnum.sebotema.getValue()};
        List<Odds> oddsList =  oddsService.selectByType(oddsTypes);
        Map<String,Float> map = new HashedMap();
        for(Odds odds : oddsList){
            map.put("pro_"+odds.getNumkey(),odds.getNumvalue());
        }
        modelAndView.addObject("entity",map);
        return modelAndView;
    }

    @RequestMapping("/banbo")
    public ModelAndView banbo(Boolean isDefault){
        if(isDefault==null) isDefault=false;
        ModelAndView modelAndView = new ModelAndView("/odds/banbo");
        String[] oddsTypes= {OddsTypeEnum.banbo.getValue()};
        List<Odds> oddsList =  oddsService.selectByType(oddsTypes);
        Map<String,Float> map = new HashedMap();
        for(Odds odds : oddsList){
            map.put("pro_"+odds.getNumkey(),odds.getNumvalue());
        }
        modelAndView.addObject("entity",map);
        return modelAndView;
    }
    @RequestMapping("/buzhong")
    public ModelAndView buzhong(Boolean isDefault){
        if(isDefault==null) isDefault=false;
        ModelAndView modelAndView = new ModelAndView("/odds/buzhong");
        return modelAndView;
    }
    @RequestMapping("/guoguan")
    public ModelAndView guoguan(Boolean isDefault){
        ModelAndView modelAndView = new ModelAndView("/odds/guoguan");
        String[] oddsTypes= {OddsTypeEnum.guoguan.getValue()};
        List<Odds> oddsList =  oddsService.selectByType(oddsTypes);
        Map<String,Float> map = new HashedMap();
        for(Odds odds : oddsList){
            map.put("pro_"+odds.getNumkey(),odds.getNumvalue());
        }
        modelAndView.addObject("entity",map);
        return modelAndView;
    }
    @RequestMapping("/lianma")
    public ModelAndView lianma(Boolean isDefault){
        if(isDefault==null) isDefault=false;
        ModelAndView modelAndView = new ModelAndView("/odds/lianma");
        return modelAndView;
    }
    @RequestMapping("/liuxiao")
    public ModelAndView liuxiao(Boolean isDefault){
        if(isDefault==null) isDefault=false;
        ModelAndView modelAndView = new ModelAndView("/odds/liuxiao");
        return modelAndView;
    }
    @RequestMapping("/shengxiao")
    public ModelAndView shengxiao(Boolean isDefault){
        ModelAndView modelAndView = new ModelAndView("/odds/shengxiao");
        List<ShengXiao> shengXiaos=  shengxiaoService.findByYear();
        Map<String,String> map = new HashMap<String, String>();
        for(ShengXiao shengXiao :shengXiaos){
          String strr=  shengXiao.getNo1()+","+shengXiao.getNo2()+","+shengXiao.getNo3()+","+shengXiao.getNo4();
          if(!StringUtil.isNullOrEmpty(shengXiao.getNo5())){
              strr+=","+shengXiao.getNo5();
          }
          map.put(shengXiao.getName(),strr);
        }
        modelAndView.addObject("shengxiao", map);
        String[] oddsTypes= {OddsTypeEnum.shxiao.getValue()};
        List<Odds> oddsList =  oddsService.selectByType(oddsTypes);
        Map<String,Float> map1 = new HashedMap();
        for(Odds odds : oddsList){
            map1.put("pro_"+odds.getNumkey(),odds.getNumvalue());
        }
        modelAndView.addObject("entity",map1);
        return modelAndView;
    }
    @RequestMapping("/shengxiaolian")
    public ModelAndView shengxiaolian(Boolean isDefault){
        if(isDefault==null) isDefault=false;
        ModelAndView modelAndView = new ModelAndView("/odds/shengxiaolian");
        return modelAndView;
    }
    @RequestMapping("/texiao")
    public ModelAndView texiao(Boolean isDefault){
        if(isDefault==null) isDefault=false;
        ModelAndView modelAndView = new ModelAndView("/odds/texiao");
        return modelAndView;
    }
    @RequestMapping("/weishu")
    public ModelAndView weishu(Boolean isDefault){
        ModelAndView modelAndView = new ModelAndView("/odds/weishu");
        String[] oddsTypes= {OddsTypeEnum.weishu.getValue()};
        List<Odds> oddsList =  oddsService.selectByType(oddsTypes);
        Map<String,Float> map1 = new HashedMap();
        for(Odds odds : oddsList){
            map1.put("pro_"+odds.getNumkey(),odds.getNumvalue());
        }
        modelAndView.addObject("entity",map1);

        return modelAndView;
    }
    @RequestMapping("/weishulian")
    public ModelAndView weishulian(Boolean isDefault){
        if(isDefault==null) isDefault=false;
        ModelAndView modelAndView = new ModelAndView("/odds/weishulian");
        return modelAndView;
    }
    @RequestMapping("/zheng16")
    public ModelAndView zheng16(Boolean isDefault){
        if(isDefault==null) isDefault=false;
        ModelAndView modelAndView = new ModelAndView("/odds/zheng16");
        String[] oddsTypes= {OddsTypeEnum.lmzhmate1.getValue(),OddsTypeEnum.lmzhmate2.getValue(),OddsTypeEnum.lmzhmate3.getValue(),
                OddsTypeEnum.lmzhmate4.getValue(),OddsTypeEnum.lmzhmate5.getValue(),OddsTypeEnum.lmzhmate6.getValue()};
        List<Odds> oddsList =  oddsService.getOddsList(oddsTypes,isDefault);
        Map<String,Float> map = new HashedMap();
        for(Odds odds : oddsList){
            map.put("pro_"+odds.getNumkey(),odds.getNumvalue());
        }
        modelAndView.addObject("entity",map);
        return modelAndView;
    }
    @RequestMapping("/zhengma")
    public ModelAndView zhengma(Boolean isDefault){
        if(isDefault==null) isDefault=false;
        ModelAndView modelAndView = new ModelAndView("/odds/zhengma");

        String[] oddsTypes= {OddsTypeEnum.zhengma.getValue(),OddsTypeEnum.lmzhma.getValue()};
        List<Odds> oddsList =  oddsService.getOddsList(oddsTypes,isDefault);
        Map<String,Float> map = new HashedMap();
        for(Odds odds : oddsList){
            map.put("pro_"+odds.getNumkey(),odds.getNumvalue());
        }
        modelAndView.addObject("entity",map);
        return modelAndView;
    }

    @RequestMapping("/zhengmate")
    public ModelAndView zhengmate(Boolean isDefault){
        if(isDefault==null) isDefault=false;
        ModelAndView modelAndView = new ModelAndView("/odds/zhengmate");
        String[] oddsTypes= {OddsTypeEnum.zhengmate1.getValue(),OddsTypeEnum.lmzhmate1.getValue(),OddsTypeEnum.sebozhmate1.getValue()};
        List<Odds> oddsList =  oddsService.getOddsList(oddsTypes,isDefault);
        Map<String,Float> map = new HashedMap();
        for(Odds odds : oddsList){
            map.put("pro_"+odds.getNumkey(),odds.getNumvalue());
        }
        modelAndView.addObject("entity",map);
        return modelAndView;
    }

    @RequestMapping("/zhengmate2")
    public ModelAndView zhengmate2(Boolean isDefault){
        if(isDefault==null) isDefault=false;
        ModelAndView modelAndView = new ModelAndView("/odds/zhengmate2");
        String[] oddsTypes= {OddsTypeEnum.zhengmate2.getValue(),OddsTypeEnum.lmzhmate2.getValue(),OddsTypeEnum.sebozhmate2.getValue()};
        List<Odds> oddsList =  oddsService.getOddsList(oddsTypes,isDefault);
        Map<String,Float> map = new HashedMap();
        for(Odds odds : oddsList){
            map.put("pro_"+odds.getNumkey(),odds.getNumvalue());
        }
        modelAndView.addObject("entity",map);
        return modelAndView;
    }

    @RequestMapping("/zhengmate3")
    public ModelAndView zhengmate3(Boolean isDefault){
        if(isDefault==null) isDefault=false;
        ModelAndView modelAndView = new ModelAndView("/odds/zhengmate3");
        String[] oddsTypes= {OddsTypeEnum.zhengmate3.getValue(),OddsTypeEnum.lmzhmate3.getValue(),OddsTypeEnum.sebozhmate3.getValue()};
        List<Odds> oddsList =  oddsService.getOddsList(oddsTypes,isDefault);
        Map<String,Float> map = new HashedMap();
        for(Odds odds : oddsList){
            map.put("pro_"+odds.getNumkey(),odds.getNumvalue());
        }
        modelAndView.addObject("entity",map);
        return modelAndView;
    }

    @RequestMapping("/zhengmate4")
    public ModelAndView zhengmate4(Boolean isDefault){
        if(isDefault==null) isDefault=false;
        ModelAndView modelAndView = new ModelAndView("/odds/zhengmate4");

        String[] oddsTypes= {OddsTypeEnum.zhengmate4.getValue(),OddsTypeEnum.lmzhmate4.getValue(),OddsTypeEnum.sebozhmate4.getValue()};
        List<Odds> oddsList =  oddsService.getOddsList(oddsTypes,isDefault);
        Map<String,Float> map = new HashedMap();
        for(Odds odds : oddsList){
            map.put("pro_"+odds.getNumkey(),odds.getNumvalue());
        }
        modelAndView.addObject("entity",map);
        return modelAndView;
    }

    @RequestMapping("/zhengmate5")
    public ModelAndView zhengmate5(Boolean isDefault){
        if(isDefault==null) isDefault=false;
        ModelAndView modelAndView = new ModelAndView("/odds/zhengmate5");
        String[] oddsTypes= {OddsTypeEnum.zhengmate5.getValue(),OddsTypeEnum.lmzhmate5.getValue(),OddsTypeEnum.sebozhmate5.getValue()};
        List<Odds> oddsList =  oddsService.getOddsList(oddsTypes,isDefault);
        Map<String,Float> map = new HashedMap();
        for(Odds odds : oddsList){
            map.put("pro_"+odds.getNumkey(),odds.getNumvalue());
        }
        modelAndView.addObject("entity",map);
        return modelAndView;
    }

    @RequestMapping("/zhengmate6")
    public ModelAndView zhengmate6(Boolean isDefault){
        if(isDefault==null) isDefault=false;
        ModelAndView modelAndView = new ModelAndView("/odds/zhengmate6");
        String[] oddsTypes= {OddsTypeEnum.zhengmate6.getValue(),OddsTypeEnum.lmzhmate6.getValue(),OddsTypeEnum.sebozhmate6.getValue()};
        List<Odds> oddsList =  oddsService.getOddsList(oddsTypes,isDefault);
        Map<String,Float> map = new HashedMap();
        for(Odds odds : oddsList){
            map.put("pro_"+odds.getNumkey(),odds.getNumvalue());
        }
        modelAndView.addObject("entity",map);
        return modelAndView;
    }

    /**
     *@Date 2017/7/11
     * 获取赔率
     * * @param type
     */
    @RequestMapping("/getOdds")
    public void getOdds(String game_ids,HttpServletRequest request, HttpServletResponse response) throws  IOException{
        String[] gameIds = game_ids.split("\\|");

        List<Odds> oddsList= oddsService.selectByType(gameIds);
        Map<String,Object> map = new HashedMap();
        Map<String,Object> oddsMap = new HashMap<String, Object>();
        for(Odds odds : oddsList){
            oddsMap.put(odds.getNumkey(),odds.getNumvalue());
        }
        Map<String,Object> outMap =new  HashedMap();
        for(String gameId : gameIds){
            map.put(gameId,1);
        }
        outMap.put("odds",oddsMap);
        outMap.put("status",map);
        Map<String,Object> header = new HashedMap();
        User user =  UserHelper.getCurrentUser();
        header.put("marquee","欢迎进入A28 ! 2017年香港六合彩第095期開獎時間為：2017年8月15日（星期2）21:30，本公司於開獎日17:00至17:40開盤，21:30開獎前收盤。如有異動以香港馬會公佈為準!! 敬告：投注後請查看下注明細，確認注單是否交易成功，以免重複下注，所有注單恕不更改，本公司對開獎後的投注均視無效,不便之處敬請諒解");
        header.put("draws", DateTimeUtils.Date2String(new Date(),"yyyy-MM-dd"));
        header.put("sum",0);
        header.put("credit",user.getCredits());
        header.put("fail_count",0);
        header.put("calc_status",-1);
        List<OrderDetail> orderDetails = orderService.getOrderDetails();
        List<List<String>> new_order =new ArrayList<List<String>>();
//        if(Global.cfg_category_key.size()==0){
//            List<LotConfig> lotConfigs=LotConfigHelper.findAll();
//            for(LotConfig lotConfig: lotConfigs)
//                Global.cfg_category_key.put(lotConfig.getGameNo(),lotConfig);
//        }
        for(OrderDetail detail : orderDetails){
            List<String> detailArr = new ArrayList<String>();
            //detailArr.add(Global.cfg_category_key.get(detail.getGametype()+detail.getNo()).getGameDesc());
            detailArr.add(detail.getDescription());
            detailArr.add(detail.getAmout().toString());
            detailArr.add(detail.getOdds().toString());

            new_order.add(detailArr);
        }

        header.put("new_order", new_order);
        header.put("winnums","04-20-07-03-19-23-27");
        header.put("limit", "");
        header.put("time_stamp",System.currentTimeMillis());
        header.put("lines",new String[]{});
        header.put("ustatus",1);


        outMap.put("header",header);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(JsonUtil.toJson(outMap));

    }

    /**
     *@Date 2017/7/11
     * 获取默认赔率
     * * @param type
     */
    @ResponseBody
    @RequestMapping("getDefaultOdds")
    public List<Odds> getDefaultOdds(String type){
        return oddsService.selectDefault(type);
    }

    @ResponseBody
    @RequestMapping("save")
    public void save( HttpServletRequest request, HttpServletResponse response) throws IOException {
        String referer = request.getHeader("Referer");
        Map   map= RequestDataUtils.getParameterMap(request);
        boolean isSuccess=oddsService.insert(map);
        response.setContentType("text/html;charset=UTF-8");
        if(isSuccess){
            response.getWriter().write( "<script type=\"text/javascript\"> alert(\"保存成功！\");location.href =\""+referer+"\"</script>");
        }
        else{
            response.getWriter().write( "<script type=\"text/javascript\"> alert(\"保存失败！\");</script>");
        }


    }
}
