package com.fr.lottery.service.impl;

import com.fr.lottery.dao.HandicapMapper;
import com.fr.lottery.dto.Page;
import com.fr.lottery.entity.Handicap;
import com.fr.lottery.entity.ShengXiao;
import com.fr.lottery.init.Global;
import com.fr.lottery.service.inter.IHandicapService;
import com.fr.lottery.service.inter.IShengxiaoService;
import com.fr.lottery.service.inter.ISysCodeService;
import com.fr.lottery.utils.DateTimeUtils;
import com.fr.lottery.utils.HttpClientUtils;
import com.fr.lottery.utils.StringUtil;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.opensaml.xml.signature.G;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/11.
 */
@Service
public class HandicapService implements IHandicapService {

    @Autowired
    private HandicapMapper handicapMapper;
    @Autowired
    private IShengxiaoService shengxiaoService;
    @Autowired
    private ISysCodeService sysCodeService;
    @Override
    public boolean save(Handicap entity) {
        if(StringUtils.isBlank( entity.getId()) || entity.getId() ==null){
            entity.setAutoopen(true);
            entity.setStatus(0);
            entity.setQishu(sysCodeService.getQiShuAutoCode(entity.getRiqi()));
            entity.setId(StringUtil.getUUID());
            return handicapMapper.insert(entity)>0;
        }
        return handicapMapper.updateByPrimaryKey(entity)>0;
    }

    @Override
    public Handicap selectByPrimaryKey(String id) {
        return  handicapMapper.selectByPrimaryKey(id);
    }

    @Override
    public Handicap getHandicapByRiqi(String riqi) {
        return  handicapMapper.getHandicapByRiqi(riqi);
    }
    @Override
    public boolean openHandicap(Handicap handicap){
        handicap.setStatus(1);
        handicap.setTemastatus(true);
        handicap.setZhengmastatus(true);
        Integer no1 =Integer.valueOf(handicap.getNo1());
        Integer no2 =Integer.valueOf(handicap.getNo2());
        Integer no3 =Integer.valueOf(handicap.getNo3());
        Integer no4 =Integer.valueOf(handicap.getNo4());
        Integer no5 =Integer.valueOf(handicap.getNo5());
        Integer no6 =Integer.valueOf(handicap.getNo6());
        Integer tema =Integer.valueOf(handicap.getTema());


        //特碼單雙
        if("49".equals( handicap.getTema())){
            handicap.setTeDanshuang("和");
        }else if(Integer.valueOf( handicap.getTema()) %2==0){
            handicap.setTeDanshuang("雙");
        }
        else{
            handicap.setTeDanshuang("單");
        }
        //特碼大小
        if("49".equals(handicap.getTema())){
            handicap.setTeDaxiao("和");
        }
        else if(Integer.valueOf(handicap.getTema())>24){
            handicap.setTeDaxiao("大");
        }
        else{
            handicap.setTeDaxiao("小");
        }
        if("49".equals(handicap.getTema())){
            handicap.setHeDanshuang("和");
        }
        else if((Integer.valueOf( handicap.getTema().substring(0,1))+ Integer.valueOf(handicap.getTema().substring(1))) %2==0){
            handicap.setHeDanshuang("雙");
        }
        else{
            handicap.setHeDanshuang("單");
        }

        //總分大小
        Integer zongfen = no1+no2+no3+no4+no5+no6+tema;
        handicap.setZongfen(zongfen);
        if(zongfen>174){
            handicap.setZongDaxiao("大");
        }
        else{
            handicap.setZongDaxiao("小");
        }
        //總分單雙
        if(zongfen%2==0){
            handicap.setZongDanshuang("雙");
        }
        else{
            handicap.setZongDanshuang("單");
        }

        Handicap currentHandicap = handicapMapper.selectByPrimaryKey(handicap.getId());

       List<ShengXiao> shengXiaos= shengxiaoService.findByDate(currentHandicap.getRiqi());
        for (ShengXiao xiao : shengXiaos){
            if(handicap.getNo1().equals( xiao.getNo1()) ||handicap.getNo1().equals( xiao.getNo2())||handicap.getNo1().equals( xiao.getNo3())
                    ||handicap.getNo1().equals( xiao.getNo4()) ||  handicap.getNo1().equals( xiao.getNo5())){
                handicap.setXiao1(String.format("%02d",xiao.getSortNo()) );
                handicap.setXiaoName1(xiao.getName());
            }
            if(handicap.getNo2().equals( xiao.getNo1()) ||handicap.getNo2().equals( xiao.getNo2())||handicap.getNo2().equals( xiao.getNo3())
                    ||handicap.getNo2().equals( xiao.getNo4()) ||  handicap.getNo2().equals( xiao.getNo5())){
                handicap.setXiao2(String.format("%02d",xiao.getSortNo()) );
                handicap.setXiaoName2(xiao.getName());
            }
            if(handicap.getNo3().equals( xiao.getNo1()) ||handicap.getNo3().equals( xiao.getNo2())||handicap.getNo3().equals( xiao.getNo3())
                    ||handicap.getNo3().equals( xiao.getNo4()) ||  handicap.getNo3().equals( xiao.getNo5())){
                handicap.setXiao3(String.format("%02d",xiao.getSortNo()) );
                handicap.setXiaoName3(xiao.getName());
            }
            if(handicap.getNo4().equals( xiao.getNo1()) ||handicap.getNo4().equals( xiao.getNo2())||handicap.getNo4().equals( xiao.getNo3())
                    ||handicap.getNo4().equals( xiao.getNo4()) ||  handicap.getNo4().equals( xiao.getNo5())){
                handicap.setXiao4(String.format("%02d",xiao.getSortNo()) );
                handicap.setXiaoName4(xiao.getName());
            }
            if(handicap.getNo5().equals( xiao.getNo1()) ||handicap.getNo5().equals( xiao.getNo2())||handicap.getNo5().equals( xiao.getNo3())
                    ||handicap.getNo5().equals( xiao.getNo4()) ||  handicap.getNo5().equals( xiao.getNo5())){
                handicap.setXiao5(String.format("%02d",xiao.getSortNo()) );
                handicap.setXiaoName5(xiao.getName());
            }
            if(handicap.getNo6().equals( xiao.getNo1()) ||handicap.getNo6().equals( xiao.getNo2())||handicap.getNo6().equals( xiao.getNo3())
                    ||handicap.getNo6().equals( xiao.getNo4()) ||  handicap.getNo6().equals( xiao.getNo5())){
                handicap.setXiao6(String.format("%02d",xiao.getSortNo()) );
                handicap.setXiaoName6(xiao.getName());
            }
            if(handicap.getTema().equals( xiao.getNo1()) ||handicap.getTema().equals( xiao.getNo2())||handicap.getTema().equals( xiao.getNo3())
                    ||handicap.getTema().equals( xiao.getNo4()) ||  handicap.getTema().equals( xiao.getNo5())){
                handicap.setTexiaono(String.format("%02d",xiao.getSortNo()) );
                handicap.setTexiaoName(xiao.getName());
            }

        }
        return handicapMapper.openHandicap(handicap) >0;
    }

    @Override
    public Page<Handicap> getHandicaps(Integer pageId) {
       if(pageId==null)
           pageId =1;
       return getHandicaps(pageId,Global.pageSize);
    }
    @Override
    public Page<Handicap> getHandicaps(Integer pageId,Integer pageSize) {
        if(pageId==null)
            pageId =1;

        Integer start = (pageId-1) * pageSize;
        List<Handicap> handicaps=  handicapMapper.findAll(start, pageSize);
        Long total = handicapMapper.count();
        Page<Handicap> page = new Page<Handicap>(pageId,pageSize,total);
        page.setList(handicaps);
        return page;
    }
    @Override
    public boolean delete(String id) {
        return handicapMapper.deleteByPrimaryKey(id)>0;
    }

    /**
     * 获取未结算的最新盘口
     * @return
     */
    @Override
    public Handicap getCurrentHandicap() {
        Handicap handicap= getLastestHandicap();
        if(handicap.getStatus()==0 || handicap.getStatus()==1)
            return handicap;
        return  null;
    }

    public  Handicap getNotOpenHandicap(){
       Handicap handicap =  getLastestHandicap();
       if(handicap.getStatus()==0)
           return handicap;
       return null;
    }

    public Handicap getLastestHandicap(){
        Handicap handicap = handicapMapper.getLastestHandicap();
        return handicap;
    }

    @Override
    public Handicap getHandicap(String handicapId) {
        return handicapMapper.selectByPrimaryKey(handicapId);
    }

    @Override
    public boolean IsOpenHandicap(){
        Handicap handicap =getNotOpenHandicap();
        if(handicap==null) return false;
        String dtStr =DateTimeUtils.Date2StringLong( new Date());
        boolean isOpen =handicap!=null && DateTimeUtils.Date2StringLong(handicap.getOpentime()).compareTo( dtStr)<=0
                && DateTimeUtils.Date2StringLong(handicap.getZhengmaclosetime()).compareTo( dtStr)>0;
        return isOpen;
    }

    public String get6hbd(String url){
        return HttpClientUtils.clientGetByHttps(url);
    }
}
