package com.fr.lottery.init;

import com.fr.lottery.enums.OddsTypeEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Liyu7342 on 2017-9-18.
 */
public class GameCfg {
    private static final Map<String,String[]> cfg_weishu= new HashMap<String, String[]>();

    private static final Map<String,String> cfg_play_keys = new HashMap<String, String>();

    private static final Map<String,String> cfg_category_key =new HashMap<String, String>();

    private static  final Map<String,String> game_category =new HashMap<String, String>();

    private static  final Map<String,String[]> category_game = new HashMap<String, String[]>();
    private static  final Map<String,String> cfg_number_shengxiao =new HashMap<String, String>();

    static {
        cfg_weishu.put("0", new String[]{"10", "20", "30", "40"});
        cfg_weishu.put("1", new String[]{"01", "11", "21", "31","41"});
        cfg_weishu.put("2", new String[]{"02", "12", "22", "32","42"});
        cfg_weishu.put("3", new String[]{"03", "13", "23", "33","43"});
        cfg_weishu.put("4", new String[]{"04", "14", "24", "34","44"});
        cfg_weishu.put("5", new String[]{"05", "15", "25", "35","45"});
        cfg_weishu.put("6", new String[]{"06", "16", "26", "36","46"});
        cfg_weishu.put("7", new String[]{"07", "17", "27", "37","47"});
        cfg_weishu.put("8", new String[]{"08", "18", "28", "38","48"});
        cfg_weishu.put("9", new String[]{"09", "19", "29", "39","49"});

        cfg_play_keys.put("tema","000");
        cfg_play_keys.put("zhengma","001");
        cfg_play_keys.put("zhengmate1","002");
        cfg_play_keys.put("zhengmate2","003");
        cfg_play_keys.put("zhengmate3","004");
        cfg_play_keys.put("zhengmate4","005");
        cfg_play_keys.put("zhengmate5","006");
        cfg_play_keys.put("zhengmate6","007");
        cfg_play_keys.put("erquanzh","008");
        cfg_play_keys.put("erzhongte","009");
        cfg_play_keys.put("techuan","010");
        cfg_play_keys.put("sanquanzh","011");
        cfg_play_keys.put("sanzher","012");
        cfg_play_keys.put("guoguan","013");
        cfg_play_keys.put("shxiao","014");
        cfg_play_keys.put("weishu","015");
        cfg_play_keys.put("banbo","016");
        cfg_play_keys.put("liuxiaozh","017");
        cfg_play_keys.put("liuxiaobuzh","018");
        cfg_play_keys.put("lmtema","019");
        cfg_play_keys.put("lmzhma","020");
        cfg_play_keys.put("lmzhmate1","021");
        cfg_play_keys.put("lmzhmate2","022");
        cfg_play_keys.put("lmzhmate3","023");
        cfg_play_keys.put("lmzhmate4","024");
        cfg_play_keys.put("lmzhmate5","025");
        cfg_play_keys.put("lmzhmate6","026");
        cfg_play_keys.put("sebotema","027");
        cfg_play_keys.put("sebozhmate1","028");
        cfg_play_keys.put("sebozhmate2","029");
        cfg_play_keys.put("sebozhmate3","030");
        cfg_play_keys.put("sebozhmate4","031");
        cfg_play_keys.put("sebozhmate5","032");
        cfg_play_keys.put("sebozhmate6","033");
        cfg_play_keys.put("texiao","034");
        cfg_play_keys.put("shengxiaolian","035|036|037|038|039|040|054|055");
        cfg_play_keys.put("weishulian","041|042|043|044|045|046");
        cfg_play_keys.put("buzhong","047|048|049|050|051|052");
        cfg_play_keys.put("shengxiaobuzhong","053");


        cfg_category_key.put("tema","00");
        cfg_category_key.put("zhengma","01");
        cfg_category_key.put("zhengmate1","02");
        cfg_category_key.put("lianma2","03");
        cfg_category_key.put("lianma3","04");
        cfg_category_key.put("guoguan","05");
        cfg_category_key.put("shengxiao","06");
        cfg_category_key.put("shengxiaobuzhong","06");
        cfg_category_key.put("weishu","07");
        cfg_category_key.put("banbo","08");
        cfg_category_key.put("liuxiao","09");
        cfg_category_key.put("liangmian","10");
        cfg_category_key.put("zhengma1to6","10");
        cfg_category_key.put("sebo","11");
        cfg_category_key.put("texiao","12");
        cfg_category_key.put("shengxiaolian","13");
        cfg_category_key.put("weishulian","14");
        cfg_category_key.put("buzhong","15");

        game_category.put("000","00");
        game_category.put("001","01");
        game_category.put("002","02");
        game_category.put("003","02");
        game_category.put("004","02");
        game_category.put("005","02");
        game_category.put("006","02");
        game_category.put("007","02");
        game_category.put("008","03");
        game_category.put("009","03");
        game_category.put("010","03");
        game_category.put("011","04");
        game_category.put("012","04");
        game_category.put("013","05");
        game_category.put("014","06");
        game_category.put("015","07");
        game_category.put("016","08");
        game_category.put("017","09");
        game_category.put("018","09");
        game_category.put("019","10");
        game_category.put("020","10");
        game_category.put("021","10");
        game_category.put("022","10");
        game_category.put("023","10");
        game_category.put("024","10");
        game_category.put("025","10");
        game_category.put("026","10");
        game_category.put("027","11");
        game_category.put("028","11");
        game_category.put("029","11");
        game_category.put("030","11");
        game_category.put("031","11");
        game_category.put("032","11");
        game_category.put("033","11");
        game_category.put("034","12");
        game_category.put("035","13");
        game_category.put("036","13");
        game_category.put("037","13");
        game_category.put("038","13");
        game_category.put("039","13");
        game_category.put("040","13");
        game_category.put("041","14");
        game_category.put("042","14");
        game_category.put("043","14");
        game_category.put("044","14");
        game_category.put("045","14");
        game_category.put("046","14");
        game_category.put("047","15");
        game_category.put("048","15");
        game_category.put("049","15");
        game_category.put("050","15");
        game_category.put("051","15");
        game_category.put("052","15");
        game_category.put("053","06");
        game_category.put("054","13");
        game_category.put("055","13");



        category_game.put("00",new String[]{"000"});
        category_game.put("01",new String[]{"001"});
        category_game.put("02",new String[]{"002","003","004","005","006","007"});
        category_game.put("03",new String[]{"008","009","010"});
        category_game.put("04",new String[]{"011","012"});
        category_game.put("05",new String[]{"013"});
        category_game.put("06",new String[]{"014","053"});
        category_game.put("07",new String[]{"015"});
        category_game.put("08",new String[]{"016"});
        category_game.put("09",new String[]{"017","018"});
        category_game.put("10",new String[]{"019","020","021","022","023","024","025","026"});
        category_game.put("11",new String[]{"027","028","029","030","031","032","033"});
        category_game.put("12",new String[]{"034"});
        category_game.put("13",new String[]{"035","036","037","038","039","040","054","055"});
        category_game.put("14",new String[]{"041","042","043","044","045","046"});
        category_game.put("15",new String[]{"047","048","049","050","051","052"});
    }


    public static String getGameCategory(OddsTypeEnum oddsTypeEnum){
        String oddsType = oddsTypeEnum.getValue();
        return getGameCategory(oddsType);
    }

    public static String getGameCategory(String oddsType){
        if(game_category.containsKey(oddsType)){
            return game_category.get(oddsType);
        }
        return "";

    }

    public static String[] getCategoryGame(String categoryId){
        String[] gameType= category_game.get(categoryId);
        return gameType;
    }


}
