package com.fr.lottery.controller;

import com.fr.lottery.dto.StatisDto;
import com.fr.lottery.entity.User;
import com.fr.lottery.enums.GameTypeEnum;
import com.fr.lottery.enums.OddsTypeEnum;
import com.fr.lottery.init.GameCfg;
import com.fr.lottery.service.inter.IOrderService;
import com.fr.lottery.utils.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Liyu7342 on 2017-7-12.
 */
@Controller
@RequestMapping("statis")
public class StatisController {
    @Autowired
    private IOrderService orderService;
    @RequestMapping("/statis")
    public ModelAndView statis(String category_id){
        ModelAndView modelAndView = new ModelAndView("statis/statis");

        String[] oddsTypes=GameCfg.getCategoryGame(category_id);
        List<StatisDto> statisDtoList= orderService.getStatis(category_id,oddsTypes);
        modelAndView.addObject("orderDetails",statisDtoList);
        Integer orderNum=0;
        Float amount=0F;
        Float shareTotal=0F;
        for(StatisDto statisDto : statisDtoList){
            orderNum+=statisDto.getOrderNum();
            amount +=statisDto.getAmount();
            shareTotal += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
        }
        modelAndView.addObject("orderNum",orderNum);
        modelAndView.addObject("amount",amount);
        modelAndView.addObject("shareTotal",shareTotal);
        return modelAndView;
    }
    @RequestMapping("/tjzhengma")
    public ModelAndView tjzhengma(String category_id){
        ModelAndView modelAndView = new ModelAndView("statis/tjzhengma");

        String[] oddsTypes=GameCfg.getCategoryGame(category_id);
        List<StatisDto> statisDtoList= orderService.getStatis(category_id,oddsTypes);
        modelAndView.addObject("orderDetails",statisDtoList);
        Integer orderNum=0;
        Float amount=0F;
        Float shareTotal=0F;
        Float yongjin = 0F;
        for(StatisDto statisDto : statisDtoList){
            orderNum+=statisDto.getOrderNum();
            amount +=statisDto.getAmount();
            shareTotal += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
            yongjin +=statisDto.getYongJin();
        }
        modelAndView.addObject("orderNum",orderNum);
        modelAndView.addObject("amount",amount);
        modelAndView.addObject("shareTotal",shareTotal);
        modelAndView.addObject("yongjin",yongjin);
        return modelAndView;
    }
    @RequestMapping("/tjzhengmate")
    public ModelAndView tjzhengmate(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/tjzhengmate");

        List<StatisDto> statisDtoList= orderService.getStatis(category_id,new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        modelAndView.addObject("game_id",game_id);
        Integer orderNum=0;
        Float amount=0F;
        Float shareTotal=0F;
        Float yongjin = 0F;
        for(StatisDto statisDto : statisDtoList){
            orderNum+=statisDto.getOrderNum();
            amount +=statisDto.getAmount();
            shareTotal += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
            yongjin +=statisDto.getYongJin();
        }
        modelAndView.addObject("orderNum",orderNum);
        modelAndView.addObject("amount",amount);
        modelAndView.addObject("shareTotal",shareTotal);
        modelAndView.addObject("yongjin",yongjin);
        return modelAndView;
    }

    @RequestMapping("/tjlianma")
    public ModelAndView tjlianma(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/tjlianma");

        String[] oddsTypes=GameCfg.getCategoryGame(category_id);
        //二全中
        List<StatisDto> statisDtoList= orderService.getStatis(category_id,new String[]{OddsTypeEnum.erquanzh.getValue()});
        modelAndView.addObject("orderDetails",statisDtoList);
        Integer orderNum=0;
        Float amount=0F;
        Float shareTotal=0F;
        for(StatisDto statisDto : statisDtoList){
            orderNum+=statisDto.getOrderNum();
            amount +=statisDto.getAmount();
            shareTotal += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
        }
        modelAndView.addObject("orderNum",orderNum);
        modelAndView.addObject("amount",amount);
        modelAndView.addObject("shareTotal",shareTotal);

        //二中特
        List<StatisDto> statisDtoList009= orderService.getStatis(category_id,new String[]{OddsTypeEnum.erzhongte.getValue()});
        Integer orderNum009=0;
        Float amount009=0F;
        Float shareTotal009=0F;
        for(StatisDto statisDto : statisDtoList009){
            orderNum009+=statisDto.getOrderNum();
            amount009 +=statisDto.getAmount();
            shareTotal009 += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
        }
        modelAndView.addObject("orderDetails009",statisDtoList009);
        modelAndView.addObject("orderNum009",orderNum009);
        modelAndView.addObject("amount009",amount009);
        modelAndView.addObject("shareTotal009",shareTotal009);

        //特串
        List<StatisDto> statisDtoList010= orderService.getStatis(category_id,new String[]{OddsTypeEnum.techuan.getValue()});
        Integer orderNum010=0;
        Float amount010=0F;
        Float shareTotal010=0F;
        for(StatisDto statisDto : statisDtoList010){
            orderNum010+=statisDto.getOrderNum();
            amount010 +=statisDto.getAmount();
            shareTotal010 += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
        }
        modelAndView.addObject("orderDetails010",statisDtoList010);
        modelAndView.addObject("orderNum010",orderNum010);
        modelAndView.addObject("amount010",amount010);
        modelAndView.addObject("shareTotal010",shareTotal010);

        //三全中
        List<StatisDto> statisDtoList011= orderService.getStatis(category_id,new String[]{OddsTypeEnum.sanquanzh.getValue()});
        Integer orderNum011=0;
        Float amount011=0F;
        Float shareTotal011=0F;
        for(StatisDto statisDto : statisDtoList011){
            orderNum011+=statisDto.getOrderNum();
            amount011 +=statisDto.getAmount();
            shareTotal011 += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
        }
        modelAndView.addObject("orderDetails011",statisDtoList011);
        modelAndView.addObject("orderNum011",orderNum011);
        modelAndView.addObject("amount011",amount011);
        modelAndView.addObject("shareTotal011",shareTotal011);

        //三中二
        List<StatisDto> statisDtoList012= orderService.getStatis(category_id,new String[]{OddsTypeEnum.sanzher.getValue()});
        Integer orderNum012=0;
        Float amount012=0F;
        Float shareTotal012=0F;
        for(StatisDto statisDto : statisDtoList011){
            orderNum012+=statisDto.getOrderNum();
            amount012 +=statisDto.getAmount();
            shareTotal012 += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
        }
        modelAndView.addObject("orderDetails012",statisDtoList012);
        modelAndView.addObject("orderNum012",orderNum012);
        modelAndView.addObject("amount012",amount012);
        modelAndView.addObject("shareTotal012",shareTotal012);
        return modelAndView;
    }
    @RequestMapping("/guoguan")
    public ModelAndView guoguan(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/guoguan");

        List<StatisDto> statisDtoList= orderService.getStatis(category_id,new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }

    @RequestMapping("/shengxiao")
    public ModelAndView shengxiao(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/shengxiao");
        List<StatisDto> statisDtoList= orderService.getStatis(category_id,new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        modelAndView.addObject("game_id",game_id);
        Integer orderNum=0;
        Float amount=0F;
        Float shareTotal=0F;
        Float yongjin = 0F;
        for(StatisDto statisDto : statisDtoList){
            orderNum+=statisDto.getOrderNum();
            amount +=statisDto.getAmount();
            shareTotal += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
            yongjin +=statisDto.getYongJin();
        }
        modelAndView.addObject("orderNum",orderNum);
        modelAndView.addObject("amount",amount);
        modelAndView.addObject("shareTotal",shareTotal);
        modelAndView.addObject("yongjin",yongjin);
        return modelAndView;
    }

    @RequestMapping("/weishu")
    public ModelAndView weishu(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/weishu");


        List<StatisDto> statisDtoList= orderService.getStatis(category_id,GameCfg.getCategoryGame(category_id));
        modelAndView.addObject("orderDetails",statisDtoList);
        Integer orderNum=0;
        Float amount=0F;
        Float shareTotal=0F;
        Float yongjin = 0F;
        for(StatisDto statisDto : statisDtoList){
            orderNum+=statisDto.getOrderNum();
            amount +=statisDto.getAmount();
            shareTotal += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
            yongjin +=statisDto.getYongJin();
        }
        modelAndView.addObject("orderNum",orderNum);
        modelAndView.addObject("amount",amount);
        modelAndView.addObject("shareTotal",shareTotal);
        modelAndView.addObject("yongjin",yongjin);
        return modelAndView;
    }

    @RequestMapping("/banbo")
    public ModelAndView banbo(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/banbo");
        List<StatisDto> statisDtoList= orderService.getStatis(category_id,GameCfg.getCategoryGame(category_id));
        modelAndView.addObject("orderDetails",statisDtoList);
        Integer orderNum=0;
        Float amount=0F;
        Float shareTotal=0F;
        Float yongjin = 0F;
        for(StatisDto statisDto : statisDtoList){
            orderNum+=statisDto.getOrderNum();
            amount +=statisDto.getAmount();
            shareTotal += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
            yongjin +=statisDto.getYongJin();
        }
        modelAndView.addObject("orderNum",orderNum);
        modelAndView.addObject("amount",amount);
        modelAndView.addObject("shareTotal",shareTotal);
        modelAndView.addObject("yongjin",yongjin);
        return modelAndView;
    }


    @RequestMapping("/texiao")
    public ModelAndView texiao(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/texiao");

        List<StatisDto> statisDtoList= orderService.getStatis(category_id,GameCfg.getCategoryGame(category_id));
        modelAndView.addObject("orderDetails",statisDtoList);
        Integer orderNum=0;
        Float amount=0F;
        Float shareTotal=0F;
        Float yongjin = 0F;
        for(StatisDto statisDto : statisDtoList){
            orderNum+=statisDto.getOrderNum();
            amount +=statisDto.getAmount();
            shareTotal += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
            yongjin +=statisDto.getYongJin();
        }
        modelAndView.addObject("orderNum",orderNum);
        modelAndView.addObject("amount",amount);
        modelAndView.addObject("shareTotal",shareTotal);
        modelAndView.addObject("yongjin",yongjin);

        return modelAndView;
    }

    @RequestMapping("/liuxiao")
    public ModelAndView liuxiao(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/liuxiao");
        List<StatisDto> statisDtoList= orderService.getStatis(category_id,GameCfg.getCategoryGame(category_id));
        modelAndView.addObject("orderDetails",statisDtoList);
        Integer orderNum=0;
        Float amount=0F;
        Float shareTotal=0F;
        Float yongjin = 0F;
        for(StatisDto statisDto : statisDtoList){
            orderNum+=statisDto.getOrderNum();
            amount +=statisDto.getAmount();
            shareTotal += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
            yongjin +=statisDto.getYongJin();
        }
        modelAndView.addObject("orderNum",orderNum);
        modelAndView.addObject("amount",amount);
        modelAndView.addObject("shareTotal",shareTotal);
        modelAndView.addObject("yongjin",yongjin);
        return modelAndView;
    }

    @RequestMapping("/liangmian")
    public ModelAndView liangmian(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/liangmian");
        List<StatisDto> statisDtoList= orderService.getStatis(category_id,GameCfg.getCategoryGame(category_id));
        modelAndView.addObject("orderDetails",statisDtoList);
        Integer orderNum=0;
        Float amount=0F;
        Float shareTotal=0F;
        Float yongjin = 0F;
        for(StatisDto statisDto : statisDtoList){
            orderNum+=statisDto.getOrderNum();
            amount +=statisDto.getAmount();
            shareTotal += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
            yongjin +=statisDto.getYongJin();
        }
        modelAndView.addObject("orderNum",orderNum);
        modelAndView.addObject("amount",amount);
        modelAndView.addObject("shareTotal",shareTotal);
        modelAndView.addObject("yongjin",yongjin);
        return modelAndView;
    }

    @RequestMapping("/sebo")
    public ModelAndView sebo(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/sebo");
        List<StatisDto> statisDtoList= orderService.getStatis(category_id,GameCfg.getCategoryGame(category_id));
        modelAndView.addObject("orderDetails",statisDtoList);
        Integer orderNum=0;
        Float amount=0F;
        Float shareTotal=0F;
        Float yongjin = 0F;
        for(StatisDto statisDto : statisDtoList){
            orderNum+=statisDto.getOrderNum();
            amount +=statisDto.getAmount();
            shareTotal += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
            yongjin +=statisDto.getYongJin();
        }
        modelAndView.addObject("orderNum",orderNum);
        modelAndView.addObject("amount",amount);
        modelAndView.addObject("shareTotal",shareTotal);
        modelAndView.addObject("yongjin",yongjin);
        return modelAndView;
    }

    @RequestMapping("/shengxiaolian")
    public ModelAndView shengxiaolian(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/shengxiaolian");


        List<StatisDto> statisDtoList= orderService.getStatis(category_id,new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }
    @RequestMapping("/weishulian")
    public ModelAndView weishulian(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/weishulian");


        List<StatisDto> statisDtoList= orderService.getStatis(category_id,new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        return modelAndView;
    }

    @RequestMapping("/wubuzhong")
    public ModelAndView wubuzhong(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/wubuzhong");

        List<StatisDto> statisDtoList= orderService.getStatis(category_id,new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        Integer orderNum=0;
        Float amount=0F;
        Float shareTotal=0F;
        Float yongjin = 0F;
        for(StatisDto statisDto : statisDtoList){
            orderNum+=statisDto.getOrderNum();
            amount +=statisDto.getAmount();
            shareTotal += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
            yongjin +=statisDto.getYongJin();
        }
        modelAndView.addObject("orderNum",orderNum);
        modelAndView.addObject("amount",amount);
        modelAndView.addObject("shareTotal",shareTotal);
        modelAndView.addObject("yongjin",yongjin);
        modelAndView.addObject("game_id",game_id);

        return modelAndView;
    }


}
