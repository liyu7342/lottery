package com.fr.lottery.service.impl;

import com.fr.lottery.enums.LianMaEnum;

/**
 * Created by Administrator on 2017/10/27.
 */
public class LianMaService {
    public void settlement(){

    }

    /**
     * 获取单数
     * @return
     */
    public int getLength(String odds,String num,String lianma){
        if(LianMaEnum.zhengchang.getValue().equals(lianma)){

        }
        else if(LianMaEnum.dantuo.getValue().equals(lianma)){

        }
        else if( LianMaEnum.shengxiaoduipeng.getValue().equals(lianma)){

        }
        else if(LianMaEnum.shengweiduipeng.getValue().equals(lianma)){

        }
        else if(LianMaEnum.weishuduipeng.getValue().equals(lianma)){

        }
         return 1;
    }


}
