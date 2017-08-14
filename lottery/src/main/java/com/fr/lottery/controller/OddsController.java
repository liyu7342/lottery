package com.fr.lottery.controller;

import com.fr.lottery.dto.ResultInfo;
import com.fr.lottery.entity.Odds;
import com.fr.lottery.enums.OddsTypeEnum;
import com.fr.lottery.service.impl.OddsService;
import com.fr.lottery.service.inter.IOddsService;
import com.fr.lottery.utils.RequestDataUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/11.
 * 赔率设置
 */
@Controller
@RequestMapping("/odds")
public class OddsController {
    @Autowired
    private IOddsService oddsService;

    @RequestMapping("/temaa")
    public ModelAndView temaa(int isDefalut){
        ModelAndView modelAndView = new ModelAndView("/odds/temaa");
        String[] oddsTypes= {OddsTypeEnum.tema.getValue(),OddsTypeEnum.lmtema.getValue(),OddsTypeEnum.sebotema.getValue()};
        boolean isDefaultOdds = isDefalut>0;
        List<Odds> oddsList =  oddsService.getOddsList(oddsTypes,isDefaultOdds);
        Map<String,Float> map = new HashedMap();
        for(Odds odds : oddsList){
            map.put("pro_"+odds.getNumkey(),odds.getNumvalue());
        }
        modelAndView.addObject("entity",map);
        return modelAndView;
    }

    @RequestMapping("/temab")
    public ModelAndView temab(Boolean isDefalut){
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
    public ModelAndView banbo(Boolean isDefalut){
        ModelAndView modelAndView = new ModelAndView("/odds/banbo");
        return modelAndView;
    }
    @RequestMapping("/buzhong")
    public ModelAndView buzhong(Boolean isDefalut){
        ModelAndView modelAndView = new ModelAndView("/odds/buzhong");
        return modelAndView;
    }
    @RequestMapping("/guoguan")
    public ModelAndView guoguan(Boolean isDefalut){
        ModelAndView modelAndView = new ModelAndView("/odds/guoguan");
        return modelAndView;
    }
    @RequestMapping("/lianma")
    public ModelAndView lianma(Boolean isDefalut){
        ModelAndView modelAndView = new ModelAndView("/odds/lianma");
        return modelAndView;
    }
    @RequestMapping("/liuxiao")
    public ModelAndView liuxiao(Boolean isDefalut){
        ModelAndView modelAndView = new ModelAndView("/odds/liuxiao");
        return modelAndView;
    }
    @RequestMapping("/shengxiao")
    public ModelAndView shengxiao(Boolean isDefalut){
        ModelAndView modelAndView = new ModelAndView("/odds/shengxiao");
        return modelAndView;
    }
    @RequestMapping("/shengxiaolian")
    public ModelAndView shengxiaolian(Boolean isDefalut){
        ModelAndView modelAndView = new ModelAndView("/odds/shengxiaolian");
        return modelAndView;
    }
    @RequestMapping("/texiao")
    public ModelAndView texiao(Boolean isDefalut){
        ModelAndView modelAndView = new ModelAndView("/odds/texiao");
        return modelAndView;
    }
    @RequestMapping("/weishu")
    public ModelAndView weishu(Boolean isDefalut){
        ModelAndView modelAndView = new ModelAndView("/odds/weishu");
        return modelAndView;
    }
    @RequestMapping("/weishulian")
    public ModelAndView weishulian(Boolean isDefalut){
        ModelAndView modelAndView = new ModelAndView("/odds/weishulian");
        return modelAndView;
    }
    @RequestMapping("/zheng16")
    public ModelAndView zheng16(Boolean isDefalut){
        ModelAndView modelAndView = new ModelAndView("/odds/zheng16");
        String[] oddsTypes= {OddsTypeEnum.lmzhmate1.getValue(),OddsTypeEnum.lmzhmate2.getValue(),OddsTypeEnum.lmzhmate3.getValue(),
                OddsTypeEnum.lmzhmate4.getValue(),OddsTypeEnum.lmzhmate5.getValue(),OddsTypeEnum.lmzhmate6.getValue()};
        List<Odds> oddsList =  oddsService.getOddsList(oddsTypes,isDefalut);
        Map<String,Float> map = new HashedMap();
        for(Odds odds : oddsList){
            map.put("pro_"+odds.getNumkey(),odds.getNumvalue());
        }
        modelAndView.addObject("entity",map);
        return modelAndView;
    }
    @RequestMapping("/zhengma")
    public ModelAndView zhengma(Boolean isDefalut){
        ModelAndView modelAndView = new ModelAndView("/odds/zhengma");

        String[] oddsTypes= {OddsTypeEnum.zhengma.getValue(),OddsTypeEnum.lmzhma.getValue()};
        List<Odds> oddsList =  oddsService.getOddsList(oddsTypes,isDefalut);
        Map<String,Float> map = new HashedMap();
        for(Odds odds : oddsList){
            map.put("pro_"+odds.getNumkey(),odds.getNumvalue());
        }
        modelAndView.addObject("entity",map);
        return modelAndView;
    }

    @RequestMapping("/zhengmate")
    public ModelAndView zhengmate(Boolean isDefalut){
        ModelAndView modelAndView = new ModelAndView("/odds/zhengmate");
        String[] oddsTypes= {OddsTypeEnum.zhengmate1.getValue(),OddsTypeEnum.lmzhmate1.getValue(),OddsTypeEnum.sebozhmate1.getValue()};
        List<Odds> oddsList =  oddsService.getOddsList(oddsTypes,isDefalut);
        Map<String,Float> map = new HashedMap();
        for(Odds odds : oddsList){
            map.put("pro_"+odds.getNumkey(),odds.getNumvalue());
        }
        modelAndView.addObject("entity",map);
        return modelAndView;
    }

    @RequestMapping("/zhengmate2")
    public ModelAndView zhengmate2(Boolean isDefalut){
        ModelAndView modelAndView = new ModelAndView("/odds/zhengmate2");
        String[] oddsTypes= {OddsTypeEnum.zhengmate2.getValue(),OddsTypeEnum.lmzhmate2.getValue(),OddsTypeEnum.sebozhmate2.getValue()};
        List<Odds> oddsList =  oddsService.getOddsList(oddsTypes,isDefalut);
        Map<String,Float> map = new HashedMap();
        for(Odds odds : oddsList){
            map.put("pro_"+odds.getNumkey(),odds.getNumvalue());
        }
        modelAndView.addObject("entity",map);
        return modelAndView;
    }

    @RequestMapping("/zhengmate3")
    public ModelAndView zhengmate3(Boolean isDefalut){
        ModelAndView modelAndView = new ModelAndView("/odds/zhengmate3");
        String[] oddsTypes= {OddsTypeEnum.zhengmate3.getValue(),OddsTypeEnum.lmzhmate3.getValue(),OddsTypeEnum.sebozhmate3.getValue()};
        List<Odds> oddsList =  oddsService.getOddsList(oddsTypes,isDefalut);
        Map<String,Float> map = new HashedMap();
        for(Odds odds : oddsList){
            map.put("pro_"+odds.getNumkey(),odds.getNumvalue());
        }
        modelAndView.addObject("entity",map);
        return modelAndView;
    }

    @RequestMapping("/zhengmate4")
    public ModelAndView zhengmate4(Boolean isDefalut){
        ModelAndView modelAndView = new ModelAndView("/odds/zhengmate4");

        String[] oddsTypes= {OddsTypeEnum.zhengmate4.getValue(),OddsTypeEnum.lmzhmate4.getValue(),OddsTypeEnum.sebozhmate4.getValue()};
        List<Odds> oddsList =  oddsService.getOddsList(oddsTypes,isDefalut);
        Map<String,Float> map = new HashedMap();
        for(Odds odds : oddsList){
            map.put("pro_"+odds.getNumkey(),odds.getNumvalue());
        }
        modelAndView.addObject("entity",map);
        return modelAndView;
    }

    @RequestMapping("/zhengmate5")
    public ModelAndView zhengmate5(Boolean isDefalut){
        ModelAndView modelAndView = new ModelAndView("/odds/zhengmate5");
        String[] oddsTypes= {OddsTypeEnum.zhengmate5.getValue(),OddsTypeEnum.lmzhmate5.getValue(),OddsTypeEnum.sebozhmate5.getValue()};
        List<Odds> oddsList =  oddsService.getOddsList(oddsTypes,isDefalut);
        Map<String,Float> map = new HashedMap();
        for(Odds odds : oddsList){
            map.put("pro_"+odds.getNumkey(),odds.getNumvalue());
        }
        modelAndView.addObject("entity",map);
        return modelAndView;
    }

    @RequestMapping("/zhengmate6")
    public ModelAndView zhengmate6(Boolean isDefalut){
        ModelAndView modelAndView = new ModelAndView("/odds/zhengmate6");
        String[] oddsTypes= {OddsTypeEnum.zhengmate6.getValue(),OddsTypeEnum.lmzhmate6.getValue(),OddsTypeEnum.sebozhmate6.getValue()};
        List<Odds> oddsList =  oddsService.getOddsList(oddsTypes,isDefalut);
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
    @ResponseBody
    @RequestMapping("/getOdds")
    public List<Odds> getOdds(String type){
        String[] types = type.split("\\|");
        return oddsService.selectByType(types);
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
        Map   map= RequestDataUtils.getParameterMap(request);
        boolean isSuccess=oddsService.insert(map);
        response.setContentType("text/html;charset=UTF-8");
        if(isSuccess){
            response.getWriter().write( "<script type=\"text/javascript\"> alert(\"保存成功！\");location.href =\"/Odds/temaa\";</script>");
        }
        else{
            response.getWriter().write( "<script type=\"text/javascript\"> alert(\"保存失败！\");</script>");
        }


    }
}
