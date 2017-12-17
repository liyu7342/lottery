package com.fr.lottery.controller;

import com.fr.lottery.dto.Page;
import com.fr.lottery.dto.StatisDto;
import com.fr.lottery.entity.Bucang;
import com.fr.lottery.entity.LotConfig;
import com.fr.lottery.entity.User;
import com.fr.lottery.enums.GameTypeEnum;
import com.fr.lottery.enums.OddsTypeEnum;
import com.fr.lottery.init.GameCfg;
import com.fr.lottery.init.Global;
import com.fr.lottery.service.inter.IBucangService;
import com.fr.lottery.service.inter.IOrderService;
import com.fr.lottery.utils.RequestDataUtils;
import com.fr.lottery.utils.StringUtil;
import com.fr.lottery.utils.UserHelper;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Liyu7342 on 2017-7-12.
 */
@Controller
@RequestMapping("statis")
public class StatisController {
    @Autowired
    private IOrderService orderService;

    @Autowired
    private IBucangService bucangService;

//    @RequestMapping("/staticsheader")
//    public ModelAndView staticsheader(String category_id){
//        ModelAndView modelAndView = new ModelAndView("statis/staticsheader");
//        modelAndView.addObject("category_id",category_id);
//        return modelAndView;
//    }

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
        List<Map> dataMaps=  orderService.get_statics_data();
        Map<String,Integer> menumaps= new HashMap<String, Integer>();
        for(Map menumap:dataMaps){
            Integer put = StringUtil.ToInteger(menumap.get("zhancheng").toString());
            menumaps.put("statics_"+menumap.get("category").toString(),put);
        }
        modelAndView.addObject("entity",menumaps);
        modelAndView.addObject("category_id",category_id);
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
        List<Map> dataMaps=  orderService.get_statics_data();
        Map<String,Integer> menumaps= new HashMap<String, Integer>();
        for(Map menumap:dataMaps){
            Integer put = StringUtil.ToInteger(menumap.get("zhancheng").toString());
            menumaps.put("statics_"+menumap.get("category").toString(),put);
        }
        modelAndView.addObject("entity",menumaps);
        modelAndView.addObject("category_id",category_id);
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
        List<Map> dataMaps=  orderService.get_statics_data();
        Map<String,Integer> menumaps= new HashMap<String, Integer>();
        for(Map menumap:dataMaps){
            Integer put = StringUtil.ToInteger(menumap.get("zhancheng").toString());
            menumaps.put("statics_"+menumap.get("category").toString(),put);
        }
        modelAndView.addObject("entity",menumaps);
        modelAndView.addObject("category_id",category_id);
        return modelAndView;
    }

    @RequestMapping("/tjlianma")
    public ModelAndView tjlianma(String category_id ,String game_id,Integer pageId){
        ModelAndView modelAndView = new ModelAndView("statis/tjlianma");

        //二全中
        Page<StatisDto> statisDtoList= orderService.getStatisLianma(category_id,new String[]{OddsTypeEnum.erquanzh.getValue()},pageId);

//        Integer orderNum=0;
//        Float amount=0F;
//        Float shareTotal=0F;
//        for(StatisDto statisDto : statisDtoList.getList()){
//            shareTotal += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
//        }
        modelAndView.addObject("shareTotal008",statisDtoList.getOtherInfo().get("shareTotal"));
        modelAndView.addObject("buhuo008",statisDtoList.getOtherInfo().get("buhuo"));
        modelAndView.addObject("orderDetails",statisDtoList.getList());
        modelAndView.addObject("page",statisDtoList.toString());

        //二中特
        //二全中
        Page<StatisDto> statisDtoList009= orderService.getStatisLianma(category_id,new String[]{OddsTypeEnum.erzhongte.getValue()},pageId);


        modelAndView.addObject("orderDetails009",statisDtoList009.getList());

        modelAndView.addObject("shareTotal009",statisDtoList009.getOtherInfo().get("shareTotal"));
        modelAndView.addObject("buhuo009",statisDtoList009.getOtherInfo().get("buhuo"));
        //特串
        Page<StatisDto> statisDtoList010= orderService.getStatisLianma(category_id,new String[]{OddsTypeEnum.techuan.getValue()},pageId);
        Integer orderNum010=0;
        Float amount010=0F;
        Float shareTotal010=0F;
        for(StatisDto statisDto : statisDtoList010.getList()){
            shareTotal010 += (statisDto.getShareTotal()==null?0F: statisDto.getShareTotal());
        }
        modelAndView.addObject("orderDetails010",statisDtoList010.getList());
        modelAndView.addObject("shareTotal010",statisDtoList010.getOtherInfo().get("shareTotal"));
        modelAndView.addObject("buhuo010",statisDtoList010.getOtherInfo().get("buhuo"));
        //三全中
        Page<StatisDto> statisDtoList011= orderService.getStatisLianma(category_id,new String[]{OddsTypeEnum.sanquanzh.getValue()},pageId);

        modelAndView.addObject("orderDetails011",statisDtoList011.getList());
        modelAndView.addObject("shareTotal011",statisDtoList011.getOtherInfo().get("shareTotal"));
        modelAndView.addObject("buhuo011",statisDtoList011.getOtherInfo().get("buhuo"));
        //三中二
        Page<StatisDto> statisDtoList012= orderService.getStatisLianma(category_id,new String[]{OddsTypeEnum.sanzher.getValue()},pageId);

        modelAndView.addObject("orderDetails012",statisDtoList012.getList());
        modelAndView.addObject("shareTotal012",statisDtoList012.getOtherInfo().get("shareTotal"));
        modelAndView.addObject("buhuo012",statisDtoList012.getOtherInfo().get("buhuo"));
        List<Map> dataMaps=  orderService.get_statics_data();
        Map<String,Integer> menumaps= new HashMap<String, Integer>();
        for(Map menumap:dataMaps){
            Integer put = StringUtil.ToInteger(menumap.get("zhancheng").toString());
            menumaps.put("statics_"+menumap.get("category").toString(),put);
        }
        modelAndView.addObject("entity",menumaps);
        modelAndView.addObject("category_id",category_id);
        return modelAndView;
    }
    @RequestMapping("/guoguan")
    public ModelAndView guoguan(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/guoguan");

        List<StatisDto> statisDtoList= orderService.getStatis(category_id,new String[]{game_id});
        modelAndView.addObject("orderDetails",statisDtoList);
        List<Map> dataMaps=  orderService.get_statics_data();
        Map<String,Integer> menumaps= new HashMap<String, Integer>();
        for(Map menumap:dataMaps){
            Integer put = StringUtil.ToInteger(menumap.get("zhancheng").toString());
            menumaps.put("statics_"+menumap.get("category").toString(),put);
        }
        modelAndView.addObject("entity",menumaps);
        modelAndView.addObject("category_id",category_id);
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
        List<Map> dataMaps=  orderService.get_statics_data();
        Map<String,Integer> menumaps= new HashMap<String, Integer>();
        for(Map menumap:dataMaps){
            Integer put = StringUtil.ToInteger(menumap.get("zhancheng").toString());
            menumaps.put("statics_"+menumap.get("category").toString(),put);
        }
        modelAndView.addObject("entity",menumaps);
        modelAndView.addObject("category_id",category_id);
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
        List<Map> dataMaps=  orderService.get_statics_data();
        Map<String,Integer> menumaps= new HashMap<String, Integer>();
        for(Map menumap:dataMaps){
            Integer put = StringUtil.ToInteger(menumap.get("zhancheng").toString());
            menumaps.put("statics_"+menumap.get("category").toString(),put);
        }
        modelAndView.addObject("entity",menumaps);
        modelAndView.addObject("category_id",category_id);
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
        List<Map> dataMaps=  orderService.get_statics_data();
        Map<String,Integer> menumaps= new HashMap<String, Integer>();
        for(Map menumap:dataMaps){
            Integer put = StringUtil.ToInteger(menumap.get("zhancheng").toString());
            menumaps.put("statics_"+menumap.get("category").toString(),put);
        }
        modelAndView.addObject("entity",menumaps);
        modelAndView.addObject("category_id",category_id);
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
        List<Map> dataMaps=  orderService.get_statics_data();
        Map<String,Integer> menumaps= new HashMap<String, Integer>();
        for(Map menumap:dataMaps){
            Integer put = StringUtil.ToInteger(menumap.get("zhancheng").toString());
            menumaps.put("statics_"+menumap.get("category").toString(),put);
        }
        modelAndView.addObject("entity",menumaps);
        modelAndView.addObject("category_id",category_id);
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
        List<Map> dataMaps=  orderService.get_statics_data();
        Map<String,Integer> menumaps= new HashMap<String, Integer>();
        for(Map menumap:dataMaps){
            Integer put = StringUtil.ToInteger(menumap.get("zhancheng").toString());
            menumaps.put("statics_"+menumap.get("category").toString(),put);
        }
        modelAndView.addObject("entity",menumaps);
        modelAndView.addObject("category_id",category_id);
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
        List<Map> dataMaps=  orderService.get_statics_data();
        Map<String,Integer> menumaps= new HashMap<String, Integer>();
        for(Map menumap:dataMaps){
            Integer put = StringUtil.ToInteger(menumap.get("zhancheng").toString());
            menumaps.put("statics_"+menumap.get("category").toString(),put);
        }
        modelAndView.addObject("entity",menumaps);
        modelAndView.addObject("category_id",category_id);
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
        List<Map> dataMaps=  orderService.get_statics_data();
        Map<String,Integer> menumaps= new HashMap<String, Integer>();
        for(Map menumap:dataMaps){
            Integer put = StringUtil.ToInteger(menumap.get("zhancheng").toString());
            menumaps.put("statics_"+menumap.get("category").toString(),put);
        }
        modelAndView.addObject("entity",menumaps);
        modelAndView.addObject("category_id",category_id);
        return modelAndView;
    }

    @RequestMapping("/shengxiaolian")
    public ModelAndView shengxiaolian(String category_id ,String game_id,Integer pageId){
        ModelAndView modelAndView = new ModelAndView("statis/shengxiaolian");

//二肖连(中)
        Page<StatisDto> statisDtoList= orderService.getStatisLianma(category_id,new String[]{"035"},pageId);


        modelAndView.addObject("shareTotal035",statisDtoList.getOtherInfo().get("shareTotal"));
        modelAndView.addObject("buhuo035",statisDtoList.getOtherInfo().get("buhuo"));
        modelAndView.addObject("orderDetails035",statisDtoList.getList());

        ////二肖连(不中)
        Page<StatisDto> statisDtoList036= orderService.getStatisLianma(category_id,new String[]{"036"},pageId);

        modelAndView.addObject("orderDetails036",statisDtoList036.getList());
        modelAndView.addObject("shareTotal036",statisDtoList036.getOtherInfo().get("shareTotal"));
        modelAndView.addObject("buhuo036",statisDtoList036.getOtherInfo().get("buhuo"));

        //三肖连(中)
        Page<StatisDto> statisDtoList037= orderService.getStatisLianma(category_id,new String[]{"037"},pageId);
        modelAndView.addObject("orderDetails037",statisDtoList037.getList());
        modelAndView.addObject("shareTotal037",statisDtoList037.getOtherInfo().get("shareTotal"));
        modelAndView.addObject("buhuo037",statisDtoList037.getOtherInfo().get("buhuo"));

        //三肖连（不中）
        Page<StatisDto> statisDtoList038= orderService.getStatisLianma(category_id,new String[]{"038"},pageId);
        modelAndView.addObject("orderDetails038",statisDtoList038.getList());

        modelAndView.addObject("shareTotal038",statisDtoList038.getOtherInfo().get("shareTotal"));
        modelAndView.addObject("buhuo038",statisDtoList038.getOtherInfo().get("buhuo"));

        //四肖连（不中）
        Page<StatisDto> statisDtoList039= orderService.getStatisLianma(category_id,new String[]{"039"},pageId);
        modelAndView.addObject("orderDetails039",statisDtoList039.getList());
        modelAndView.addObject("shareTotal039",statisDtoList039.getOtherInfo().get("shareTotal"));
        modelAndView.addObject("buhuo039",statisDtoList039.getOtherInfo().get("buhuo"));

        //四肖连（不中）
        Page<StatisDto> statisDtoList040= orderService.getStatisLianma(category_id,new String[]{"040"},pageId);

        modelAndView.addObject("orderDetails040",statisDtoList040.getList());
        modelAndView.addObject("shareTotal040",statisDtoList040.getOtherInfo().get("shareTotal"));
        modelAndView.addObject("buhuo040",statisDtoList040.getOtherInfo().get("buhuo"));
        List<Map> dataMaps=  orderService.get_statics_data();
        Map<String,Integer> menumaps= new HashMap<String, Integer>();
        for(Map menumap:dataMaps){
            Integer put = StringUtil.ToInteger(menumap.get("zhancheng").toString());
            menumaps.put("statics_"+menumap.get("category").toString(),put);
        }
        modelAndView.addObject("entity",menumaps);
        modelAndView.addObject("category_id",category_id);
        return modelAndView;
    }
    @RequestMapping("/weishulian")
    public ModelAndView weishulian(String category_id ,String game_id){
        ModelAndView modelAndView = new ModelAndView("statis/weishulian");
        Integer pageId=1;
//二尾连(中)
        Page<StatisDto> statisDtoList041= orderService.getStatisLianma(category_id,new String[]{"041"},pageId);

        modelAndView.addObject("shareTotal041",statisDtoList041.getOtherInfo().get("shareTotal"));
        modelAndView.addObject("buhuo041",statisDtoList041.getOtherInfo().get("buhuo"));
        modelAndView.addObject("orderDetails041",statisDtoList041.getList());

        ////二尾连(不中)
        Page<StatisDto> statisDtoList042= orderService.getStatisLianma(category_id,new String[]{"042"},pageId);

        modelAndView.addObject("orderDetails042",statisDtoList042.getList());
        modelAndView.addObject("shareTotal042",statisDtoList042.getOtherInfo().get("shareTotal"));
        modelAndView.addObject("buhuo042",statisDtoList042.getOtherInfo().get("buhuo"));

        //三尾连(中)
        Page<StatisDto> statisDtoList043= orderService.getStatisLianma(category_id,new String[]{"043"},pageId);

        modelAndView.addObject("orderDetails043",statisDtoList043.getList());
        modelAndView.addObject("shareTotal043",statisDtoList043.getOtherInfo().get("shareTotal"));
        modelAndView.addObject("buhuo043",statisDtoList043.getOtherInfo().get("buhuo"));

        //三尾连（不中）
        Page<StatisDto> statisDtoList044= orderService.getStatisLianma(category_id,new String[]{"044"},pageId);

        modelAndView.addObject("orderDetails044",statisDtoList044.getList());
        modelAndView.addObject("shareTotal044",statisDtoList044.getOtherInfo().get("shareTotal"));
        modelAndView.addObject("buhuo044",statisDtoList044.getOtherInfo().get("buhuo"));

        //四尾连（不中）
        Page<StatisDto> statisDtoList045 =orderService.getStatisLianma(category_id,new String[]{"045"},pageId);

        modelAndView.addObject("orderDetails045",statisDtoList045.getList());
        modelAndView.addObject("shareTotal045",statisDtoList045.getOtherInfo().get("shareTotal"));
        modelAndView.addObject("buhuo045",statisDtoList045.getOtherInfo().get("buhuo"));

        //四尾连（不中）
        Page<StatisDto> statisDtoList046= orderService.getStatisLianma(category_id,new String[]{"046"},pageId);

        modelAndView.addObject("orderDetails046",statisDtoList046.getList());
        modelAndView.addObject("shareTotal046",statisDtoList046.getOtherInfo().get("shareTotal"));
        modelAndView.addObject("buhuo046",statisDtoList046.getOtherInfo().get("buhuo"));
        List<Map> dataMaps=  orderService.get_statics_data();
        Map<String,Integer> menumaps= new HashMap<String, Integer>();
        for(Map menumap:dataMaps){
            Integer put = StringUtil.ToInteger(menumap.get("zhancheng").toString());
            menumaps.put("statics_"+menumap.get("category").toString(),put);
        }
        modelAndView.addObject("entity",menumaps);
        modelAndView.addObject("category_id",category_id);
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
        List<Map> dataMaps=  orderService.get_statics_data();
        Map<String,Integer> menumaps= new HashMap<String, Integer>();
        for(Map menumap:dataMaps){
            Integer put = StringUtil.ToInteger(menumap.get("zhancheng").toString());
            menumaps.put("statics_"+menumap.get("category").toString(),put);
        }
        modelAndView.addObject("entity",menumaps);
        modelAndView.addObject("category_id",category_id);
        return modelAndView;
    }
    @RequestMapping("/short_covering")
    public ModelAndView short_covering( String number,String game_id,String amt ,Bucang bucang, HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("/statis/short_covering");
        LotConfig config= Global.lotConfigDic.get(bucang.getGame_id()+bucang.getNumber());

        if(StringUtils.isNotBlank(bucang.getOdds_set())){
            bucangService.insert(bucang);
        }
        if(config!=null){
            bucang.setDescription( config.getGameDesc());
        }
        else{
            bucang.setDescription( bucang.getGame_id()+bucang.getNumber());
        }
        modelAndView.addObject("gameNumDesc",bucang.getDescription());
        modelAndView.addObject("number",bucang.getNumber());
        return  modelAndView;
    }

    @RequestMapping("/duobu")
    public ModelAndView duobu(String number,String game_id,Integer amt){
        ModelAndView modelAndView = new ModelAndView("/statis/duobu");

        return  modelAndView;
    }


}
