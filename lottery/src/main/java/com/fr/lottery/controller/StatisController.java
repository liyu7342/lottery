package com.fr.lottery.controller;

import com.fr.lottery.dto.Page;
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
    public ModelAndView tjlianma(String category_id ,String game_id,Integer pageId){
        ModelAndView modelAndView = new ModelAndView("statis/tjlianma");

        //二全中
        Page<StatisDto> statisDtoList= orderService.getStatisLianma(category_id,new String[]{OddsTypeEnum.erquanzh.getValue()},pageId);

        Integer orderNum=0;
        Float amount=0F;
        Float shareTotal=0F;
        for(StatisDto statisDto : statisDtoList.getList()){
            shareTotal += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
        }
        modelAndView.addObject("shareTotal",shareTotal);
        modelAndView.addObject("orderDetails",statisDtoList.getList());
        modelAndView.addObject("page",statisDtoList.toString());

        //二中特
        //二全中
        Page<StatisDto> statisDtoList009= orderService.getStatisLianma(category_id,new String[]{OddsTypeEnum.erquanzh.getValue()},pageId);
        modelAndView.addObject("orderDetails",statisDtoList009.getList());
        Integer orderNum009=0;
        Float amount009=0F;
        Float shareTotal009=0F;
        for(StatisDto statisDto : statisDtoList009.getList()){
            shareTotal009 += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
        }
        modelAndView.addObject("orderDetails009",statisDtoList009.getList());
        modelAndView.addObject("orderNum009",orderNum009);
        modelAndView.addObject("amount009",amount009);
        modelAndView.addObject("shareTotal009",shareTotal009);
        modelAndView.addObject("page009",shareTotal009.toString());
        //特串
        Page<StatisDto> statisDtoList010= orderService.getStatisLianma(category_id,new String[]{OddsTypeEnum.techuan.getValue()},pageId);
        Integer orderNum010=0;
        Float amount010=0F;
        Float shareTotal010=0F;
        for(StatisDto statisDto : statisDtoList010.getList()){
            shareTotal010 += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
        }
        modelAndView.addObject("orderDetails010",statisDtoList010.getList());
        modelAndView.addObject("orderNum010",orderNum010);
        modelAndView.addObject("amount010",amount010);
        modelAndView.addObject("shareTotal010",shareTotal010);
        modelAndView.addObject("page010",shareTotal010.toString());
        //三全中
        Page<StatisDto> statisDtoList011= orderService.getStatisLianma(category_id,new String[]{OddsTypeEnum.sanquanzh.getValue()},pageId);
        Integer orderNum011=0;
        Float amount011=0F;
        Float shareTotal011=0F;
        for(StatisDto statisDto : statisDtoList011.getList()){

            shareTotal011 += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
        }
        modelAndView.addObject("orderDetails011",statisDtoList011.getList());
        modelAndView.addObject("orderNum011",orderNum011);
        modelAndView.addObject("amount011",amount011);
        modelAndView.addObject("shareTotal011",shareTotal011);
        modelAndView.addObject("page011",shareTotal011.toString());
        //三中二
        Page<StatisDto> statisDtoList012= orderService.getStatisLianma(category_id,new String[]{OddsTypeEnum.sanzher.getValue()},pageId);
        Integer orderNum012=0;
        Float amount012=0F;
        Float shareTotal012=0F;
        for(StatisDto statisDto : statisDtoList012.getList()){
            shareTotal012 += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
        }
        modelAndView.addObject("orderDetails012",statisDtoList012.getList());
        modelAndView.addObject("orderNum012",orderNum012);
        modelAndView.addObject("amount012",amount012);
        modelAndView.addObject("shareTotal012",shareTotal012);
        modelAndView.addObject("page012",shareTotal012.toString());
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
    public ModelAndView shengxiaolian(String category_id ,String game_id,Integer pageId){
        ModelAndView modelAndView = new ModelAndView("statis/shengxiaolian");

//二肖连(中)
        Page<StatisDto> statisDtoList= orderService.getStatisLianma(category_id,new String[]{"035"},pageId);

        Integer orderNum=0;
        Float amount=0F;
        Float shareTotal=0F;
        for(StatisDto statisDto : statisDtoList.getList()){
            shareTotal += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
        }
        modelAndView.addObject("shareTotal035",shareTotal);
        modelAndView.addObject("orderDetails035",statisDtoList.getList());

        ////二肖连(不中)
        Page<StatisDto> statisDtoList036= orderService.getStatisLianma(category_id,new String[]{"036"},pageId);
        Integer orderNum036=0;
        Float amount036=0F;
        Float shareTotal036=0F;
        for(StatisDto statisDto : statisDtoList036.getList()){
            shareTotal036 += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
        }
        modelAndView.addObject("orderDetails036",statisDtoList036.getList());
        modelAndView.addObject("orderNum036",orderNum036);
        modelAndView.addObject("amount036",amount036);
        modelAndView.addObject("shareTotal036",shareTotal036);

        //三肖连(中)
        Page<StatisDto> statisDtoList037= orderService.getStatisLianma(category_id,new String[]{"037"},pageId);
        Integer orderNum037=0;
        Float amount037=0F;
        Float shareTotal037=0F;
        for(StatisDto statisDto : statisDtoList037.getList()){
            shareTotal037 += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
        }
        modelAndView.addObject("orderDetails037",statisDtoList037.getList());
        modelAndView.addObject("orderNum037",orderNum037);
        modelAndView.addObject("amount037",amount037);
        modelAndView.addObject("shareTotal037",shareTotal037);

        //三肖连（不中）
        Page<StatisDto> statisDtoList038= orderService.getStatisLianma(category_id,new String[]{"038"},pageId);
        Integer orderNum038=0;
        Float amount038=0F;
        Float shareTotal038=0F;
        for(StatisDto statisDto : statisDtoList038.getList()){

            shareTotal038 += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
        }
        modelAndView.addObject("orderDetails038",statisDtoList038.getList());
        modelAndView.addObject("orderNum038",orderNum038);
        modelAndView.addObject("amount038",amount038);
        modelAndView.addObject("shareTotal038",shareTotal038);

        //四肖连（不中）
        Page<StatisDto> statisDtoList039= orderService.getStatisLianma(category_id,new String[]{"039"},pageId);
        Integer orderNum039=0;
        Float amount039=0F;
        Float shareTotal039=0F;
        for(StatisDto statisDto : statisDtoList039.getList()){
            shareTotal039 += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
        }
        modelAndView.addObject("orderDetails039",statisDtoList039.getList());
        modelAndView.addObject("orderNum039",orderNum039);
        modelAndView.addObject("amount039",amount039);
        modelAndView.addObject("shareTotal039",shareTotal039);

        //四肖连（不中）
        Page<StatisDto> statisDtoList040= orderService.getStatisLianma(category_id,new String[]{"040"},pageId);
        Integer orderNum040=0;
        Float amount040=0F;
        Float shareTotal040=0F;
        for(StatisDto statisDto : statisDtoList040.getList()){
            shareTotal040 += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
        }
        modelAndView.addObject("orderDetails040",statisDtoList040.getList());
        modelAndView.addObject("orderNum040",orderNum040);
        modelAndView.addObject("amount040",amount040);
        modelAndView.addObject("shareTotal040",shareTotal040);
        return modelAndView;
    }
    @RequestMapping("/weishulian")
    public ModelAndView weishulian(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/weishulian");
        Integer pageId=1;
//二尾连(中)
        Page<StatisDto> statisDtoList041= orderService.getStatisLianma(category_id,new String[]{"041"},pageId);

        Integer orderNum=0;
        Float amount=0F;
        Float shareTotal=0F;
        for(StatisDto statisDto : statisDtoList041.getList()){
            shareTotal += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
        }
        modelAndView.addObject("shareTotal041",shareTotal);
        modelAndView.addObject("orderDetails041",statisDtoList041.getList());

        ////二尾连(不中)
        Page<StatisDto> statisDtoList042= orderService.getStatisLianma(category_id,new String[]{"042"},pageId);
        Integer orderNum042=0;
        Float amount042=0F;
        Float shareTotal042=0F;
        for(StatisDto statisDto : statisDtoList042.getList()){
            shareTotal042 += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
        }
        modelAndView.addObject("orderDetails042",statisDtoList042.getList());
        modelAndView.addObject("orderNum042",orderNum042);
        modelAndView.addObject("amount042",amount042);
        modelAndView.addObject("shareTotal042",shareTotal042);

        //三尾连(中)
        Page<StatisDto> statisDtoList043= orderService.getStatisLianma(category_id,new String[]{"043"},pageId);
        Integer orderNum043=0;
        Float amount043=0F;
        Float shareTotal043=0F;
        for(StatisDto statisDto : statisDtoList043.getList()){
            shareTotal043 += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
        }
        modelAndView.addObject("orderDetails043",statisDtoList043.getList());
        modelAndView.addObject("orderNum043",orderNum043);
        modelAndView.addObject("amount043",amount043);
        modelAndView.addObject("shareTotal043",shareTotal043);

        //三尾连（不中）
        Page<StatisDto> statisDtoList044= orderService.getStatisLianma(category_id,new String[]{"044"},pageId);
        Integer orderNum044=0;
        Float amount044=0F;
        Float shareTotal044=0F;
        for(StatisDto statisDto : statisDtoList044.getList()){

            shareTotal044 += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
        }
        modelAndView.addObject("orderDetails044",statisDtoList044.getList());
        modelAndView.addObject("orderNum044",orderNum044);
        modelAndView.addObject("amount044",amount044);
        modelAndView.addObject("shareTotal044",shareTotal044);

        //四尾连（不中）
        Page<StatisDto> statisDtoList045 =orderService.getStatisLianma(category_id,new String[]{"045"},pageId);
        Integer orderNum045=0;
        Float amount045=0F;
        Float shareTotal045=0F;
        for(StatisDto statisDto : statisDtoList045.getList()){
            shareTotal045 += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
        }
        modelAndView.addObject("orderDetails045",statisDtoList045.getList());
        modelAndView.addObject("orderNum045",orderNum045);
        modelAndView.addObject("amount045",amount045);
        modelAndView.addObject("shareTotal045",shareTotal045);

        //四尾连（不中）
        Page<StatisDto> statisDtoList046= orderService.getStatisLianma(category_id,new String[]{"046"},pageId);
        Integer orderNum046=0;
        Float amount046=0F;
        Float shareTotal046=0F;
        for(StatisDto statisDto : statisDtoList046.getList()){
            shareTotal046 += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
        }
        modelAndView.addObject("orderDetails046",statisDtoList046.getList());
        modelAndView.addObject("orderNum046",orderNum046);
        modelAndView.addObject("amount046",amount046);
        modelAndView.addObject("shareTotal046",shareTotal046);
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
