package com.fr.lottery.controller;

import com.fr.lottery.dto.Page;
import com.fr.lottery.dto.ResultInfo;
import com.fr.lottery.entity.Handicap;
import com.fr.lottery.entity.User;
import com.fr.lottery.enums.StatusEnum;
import com.fr.lottery.enums.UserTypeEnum;
import com.fr.lottery.service.inter.IHandicapService;
import com.fr.lottery.service.inter.IUserService;
import com.fr.lottery.utils.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Console;
import java.io.IOException;
import java.util.*;

/**
 * Created by Administrator on 2017/11/22.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private IUserService userService;
    /**
     * 会员首页
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/login/index");
        return mv;
    }


    @RequestMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("/login/login");
        return mv;
    }

    @RequestMapping("/login1")
    public ModelAndView login1() {
        ModelAndView mv = new ModelAndView("/login/login1");
        return mv;
    }

    @RequestMapping("/login2")
    public ModelAndView login2() {
        ModelAndView mv = new ModelAndView("/login/login2");
        return mv;
    }

    /**
     * 会员登录
     * @param request
     * @param response
     * @param userAccount
     * @param userPwd
     * @param verifyCode
     * @return
     */
    @RequestMapping("/doLogin")
    @ResponseBody
    public ResultInfo<String> doLogin(HttpServletRequest request, HttpServletResponse response, String userAccount, String userPwd, String verifyCode){
        ResultInfo<String> result = new ResultInfo<String>();
        try{
            if(StringUtils.isBlank(verifyCode)){
                result.setMsg("验证码不能为空");
                result.setSuccess(false);
                return result;
            }
            if(request.getSession().getAttribute("verCode") ==null || !verifyCode.equals(request.getSession().getAttribute("verCode"))){
                result.setMsg("验证码不正确");
                result.setSuccess(false);
                return result;
            }
            String md5_pwd = new MD5Util().getMD5ofStr(userPwd);
            User user=  userService.getByAccount(userAccount);

            if(user !=null && md5_pwd.equals( user.getPassword()) &&user.getUsertype() == UserTypeEnum.Member.ordinal()){
                if(user.getStatus() == StatusEnum.TingYong.ordinal()){
                    result.setSuccess(false);
                    result.setMsg("賬號已经被停用");
                }
                else {
                    User daili = userService.get(user.getDailiId());
                    User zongdai =userService.get(user.getZongdailiId());
                    User gudong =userService.get(user.getGudongId());
                    User dagudong =userService.get(user.getDagudongId());
                    if(daili.getStatus() == StatusEnum.TingYong.ordinal()){
                        result.setSuccess(false);
                        result.setMsg("公司被停用了");
                    }
                    else if(zongdai.getStatus() == StatusEnum.TingYong.ordinal()){
                        result.setSuccess(false);
                        result.setMsg("公司被停用了");
                    }
                    else if(gudong.getStatus() == StatusEnum.TingYong.ordinal()){
                        result.setSuccess(false);
                        result.setMsg("公司被停用了");
                    }
                    else  if(dagudong.getStatus() == StatusEnum.TingYong.ordinal()){
                        result.setSuccess(false);
                        result.setMsg("公司被停用了");
                    }
                    else{
                        result.setSuccess(true);
                        UserHelper.setCurrentUser(user);
                        request.getSession().setAttribute("first_login","1");
                        request.getSession().removeAttribute("verCode");
                        userService.updateLoginStatus(user);
                        if(user.getNeedToChangePwd() || (user.getLastChangeDate()!=null && new Date().compareTo(DateTimeUtils.addMonths( user.getLastChangeDate(),3))>0)){
                            request.getSession().setAttribute("needToChangPwd","1");
                        }
                    }

                }

            }
            else{
                result.setSuccess(false);
                result.setMsg("賬號或密碼有誤！");
            }
        }
        catch (Exception ex){
            result.setSuccess(false);
            result.setMsg("内部500错误");
            ex.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/doLogin1")
    @ResponseBody
    public ResultInfo<String> doLogin1(HttpServletRequest request, HttpServletResponse response, String userAccount, String userPwd,String verifyCode){

        ResultInfo<String> result = new ResultInfo<String>();
        try{
            if(StringUtils.isBlank(verifyCode)){
                result.setMsg("验证码不能为空");
                result.setSuccess(false);
                return result;
            }
            if(request.getSession().getAttribute("verCode") ==null || !verifyCode.equals(request.getSession().getAttribute("verCode"))){
                result.setMsg("验证码不正确");
                result.setSuccess(false);
                return result;
            }
            String md5_pwd = new MD5Util().getMD5ofStr(userPwd);
            User user=  userService.getByAccount(userAccount);

            if(user !=null && md5_pwd.equals( user.getPassword()) &&user.getUsertype() != UserTypeEnum.Admin.ordinal() &&user.getUsertype() != UserTypeEnum.Member.ordinal()){
                if(user.getStatus() == StatusEnum.TingYong.ordinal()){
                   result.setSuccess(false);
                   result.setMsg("賬號已经被停用");
               }
               else {
                   User zongdai =userService.get(user.getZongdailiId());
                   User gudong =userService.get(user.getGudongId());
                   User dagudong =userService.get(user.getDagudongId());

                  if(zongdai!=null && zongdai.getStatus() == StatusEnum.TingYong.ordinal()){
                       result.setSuccess(false);
                       result.setMsg("公司被停用了");
                   }
                   else if(gudong!=null && gudong.getStatus() == StatusEnum.TingYong.ordinal()){
                       result.setSuccess(false);
                       result.setMsg("公司被停用了");
                   }
                   else  if(dagudong!=null && dagudong.getStatus() == StatusEnum.TingYong.ordinal()){
                       result.setSuccess(false);
                       result.setMsg("公司被停用了");
                   }
                   else{
                       result.setSuccess(true);
                       if(user.getUsertype()==UserTypeEnum.UserAdmin.ordinal()){
                           User parentUser = userService.get(user.getParentid());
                           UserHelper.setCurrentUser(user,parentUser);
                       }else{
                           UserHelper.setCurrentUser(user);
                       }

                      request.getSession().removeAttribute("verCode");
                      request.getSession().setAttribute("first_login","1");
                      if(user.getNeedToChangePwd() || (user.getLastChangeDate()!=null && new Date().compareTo(DateTimeUtils.addMonths( user.getLastChangeDate(),3))>0)){
                          request.getSession().setAttribute("needToChangPwd","1");
                      }
                      userService.updateLoginStatus(user);

                   }
               }
            }
            else{
                result.setSuccess(false);
                result.setMsg("賬號或密碼有誤！");
            }
        }
        catch (Exception ex){
            result.setSuccess(false);
            result.setMsg("内部500错误");
        }
        return result;
    }

    @RequestMapping("/doLogin2")
    @ResponseBody
    public ResultInfo<String> doLogin2(HttpServletRequest request, HttpServletResponse response, String userAccount, String userPwd,String verifyCode){

        ResultInfo<String> result = new ResultInfo<String>();
        try{
            if(StringUtils.isBlank(verifyCode)){
                result.setMsg("验证码不能为空");
                result.setSuccess(false);
                return result;
            }
            if(request.getSession().getAttribute("verCode") ==null || !verifyCode.equals(request.getSession().getAttribute("verCode"))){
                result.setMsg("验证码不正确");
                result.setSuccess(false);
                return result;
            }
            String md5_pwd = new MD5Util().getMD5ofStr(userPwd);
            User user=  userService.getByAccount(userAccount);

            if(user !=null && md5_pwd.equals( user.getPassword()) &&user.getUsertype() == UserTypeEnum.Admin.ordinal()){
                result.setSuccess(true);
                UserHelper.setCurrentUser(user);
                userService.updateLoginStatus(user);
                request.getSession().removeAttribute("verCode");
            }
            else{
                result.setSuccess(false);
                result.setMsg("賬號或密碼有誤！");
            }
        }
        catch (Exception ex){
            result.setSuccess(false);
            result.setMsg("内部500错误");
        }
        return result;
    }
    @RequestMapping(value = "getCodeInfo")
    public void getCodeInfo(HttpServletRequest request , HttpServletResponse response) throws IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        //生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(5);
        //存入会话session
        HttpSession session = request.getSession(true);
        //删除以前的
        session.removeAttribute("verCode");
        session.setAttribute("verCode", verifyCode.toLowerCase());
        //生成图片
        int w = 120, h = 32;
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
    }


    @Autowired
    IHandicapService handicapService;
    @RequestMapping("/calc")
    public void calc(HttpServletRequest request,HttpServletResponse response){
        Page<Handicap> page = handicapService.getHandicaps(1,10000);
        List<Handicap> handicaps = page.getList();
        Collections.sort(handicaps, new Comparator<Handicap>() {
            @Override
            public int compare(Handicap o1, Handicap o2) {
                return o1.getRiqi().compareTo(o2.getRiqi());
            }
        });
        int totalMoney=0;
        for( int i=0, len =handicaps.size();i<(len-1);i++){
            Handicap prev = handicaps.get(i);
            Handicap next =handicaps.get(i+1);
            int total =0;
            int currentMoney=0;
            if( (prev.getNo1().equals(next.getNo1() )|| prev.getNo1().equals(next.getNo2() )|| prev.getNo1().equals(next.getNo3()
                    )|| prev.getNo1().equals(next.getNo4())|| prev.getNo1().equals(next.getNo5())|| prev.getNo1().equals(next.getNo6()
                        )|| prev.getNo1().equals(next.getTema()))){
                total++;
            }
            if(prev.getNo2().equals(next.getNo1() )|| prev.getNo2().equals(next.getNo2() )|| prev.getNo2().equals(next.getNo3()
                    )|| prev.getNo2().equals(next.getNo4())|| prev.getNo2().equals(next.getNo5())|| prev.getNo2().equals(next.getNo6()
                    )|| prev.getNo2().equals(next.getTema())){
                total++;
            }
            if(prev.getNo3().equals(next.getNo1() )|| prev.getNo3().equals(next.getNo2() )|| prev.getNo3().equals(next.getNo3()
                    )|| prev.getNo3().equals(next.getNo4())|| prev.getNo3().equals(next.getNo5())|| prev.getNo3().equals(next.getNo6()
                    )|| prev.getNo3().equals(next.getTema())){
                total++;
            }
            if(prev.getNo4().equals(next.getNo1() )|| prev.getNo4().equals(next.getNo2() )|| prev.getNo4().equals(next.getNo3()
                    )|| prev.getNo4().equals(next.getNo4())|| prev.getNo4().equals(next.getNo5())|| prev.getNo4().equals(next.getNo6()
                    )|| prev.getNo4().equals(next.getTema())){
                total++;
            }
            if(prev.getNo5().equals(next.getNo1() )|| prev.getNo5().equals(next.getNo2() )|| prev.getNo5().equals(next.getNo3()
                    )|| prev.getNo5().equals(next.getNo4())|| prev.getNo5().equals(next.getNo5())|| prev.getNo5().equals(next.getNo6()
                    )|| prev.getNo5().equals(next.getTema())){
                total++;
            }
            if(prev.getNo6().equals(next.getNo1() )|| prev.getNo6().equals(next.getNo2() )|| prev.getNo6().equals(next.getNo3()
                    )|| prev.getNo6().equals(next.getNo4())|| prev.getNo6().equals(next.getNo5())|| prev.getNo6().equals(next.getNo6()
                    )|| prev.getNo6().equals(next.getTema())){
                total++;
            }
            if(prev.getTema().equals(next.getNo1() )|| prev.getTema().equals(next.getNo2() )|| prev.getTema().equals(next.getNo3()
                    )|| prev.getTema().equals(next.getNo4())|| prev.getTema().equals(next.getNo5())|| prev.getTema().equals(next.getNo6()
                    )|| prev.getTema().equals(next.getTema())){
                total++;
            }
            if(total==0){
                currentMoney=2520;
            }
            else if( total == 1){
                currentMoney =1320 - 2100;
            }
            else if( total==2){
                currentMoney = -1980;
            }else {
                currentMoney =-2100;
            }
            totalMoney+=currentMoney;
            System.out.println( i+"、"+next.getRiqi()+":出了"+total+"个数，"+"输赢："+currentMoney+",累计输赢："+totalMoney);
        }
    }


    @RequestMapping("/calc_wu")
    public void  calcWubuzhong(Integer num1,Integer num2,Integer num3,Integer num4,Integer num5,Integer amount,Float odds,HttpServletRequest request,HttpServletResponse response){
        Page<Handicap> page = handicapService.getHandicaps(1,10000);
        List<Handicap> handicaps = page.getList();
        Collections.sort(handicaps, new Comparator<Handicap>() {
            @Override
            public int compare(Handicap o1, Handicap o2) {
                return o1.getRiqi().compareTo(o2.getRiqi());
            }
        });
        if(amount==null) amount=500;
        if(odds == null) odds =2.2f;
        String no1 = String.format("%02d", num1);
        String no2 = String.format("%02d", num2);
        String no3 = String.format("%02d", num3);
        String no4 = String.format("%02d", num4);
        String no5 = String.format("%02d", num5);
        int totalMoney=0;
        StringBuilder sb = new StringBuilder();
        sb.append("您购买的是："+no1+","+no2+","+no3+","+no4+","+no5+"。 金额为:"+amount+"。赔率为："+odds);
        sb.append("<br/>");

        for( int i=0, len =handicaps.size();i<(len);i++){
            Handicap prev = handicaps.get(i);
            int total =0;
            Float currentMoney=0f;
            if( (prev.getNo1().equals(no1 )|| prev.getNo1().equals(no2 )|| prev.getNo1().equals(no3
            )|| prev.getNo1().equals(no4)|| prev.getNo1().equals(no5))){
                total++;
            }
            if( (prev.getNo2().equals(no1 )|| prev.getNo2().equals(no2 )|| prev.getNo2().equals(no3
            )|| prev.getNo2().equals(no4)|| prev.getNo2().equals(no5))){
                total++;
            }
            if( (prev.getNo3().equals(no1 )|| prev.getNo3().equals(no2 )|| prev.getNo3().equals(no3
            )|| prev.getNo3().equals(no4)|| prev.getNo3().equals(no5))){
                total++;
            }
            if( (prev.getNo4().equals(no1 )|| prev.getNo4().equals(no2 )|| prev.getNo4().equals(no3
            )|| prev.getNo4().equals(no4)|| prev.getNo4().equals(no5))){
                total++;
            }
            if( (prev.getNo5().equals(no1 )|| prev.getNo5().equals(no2 )|| prev.getNo5().equals(no3
            )|| prev.getNo5().equals(no4)|| prev.getNo5().equals(no5))){
                total++;
            }
            if( (prev.getNo6().equals(no1 )|| prev.getNo6().equals(no2 )|| prev.getNo6().equals(no3
            )|| prev.getNo6().equals(no4)|| prev.getNo6().equals(no5))){
                total++;
            }
            if( (prev.getTema().equals(no1 )|| prev.getTema().equals(no2 )|| prev.getTema().equals(no3
            )|| prev.getTema().equals(no4)|| prev.getTema().equals(no5))){
                total++;
            }

            if(total>0){
                currentMoney=-(float)amount;
            }
            else{
                currentMoney =amount * (odds-1);
            }

            totalMoney+=currentMoney;
            sb.append( i+"、"+prev.getRiqi()+":出了"+total+"个数，"+"输赢："+currentMoney+",累计输赢："+totalMoney);
            sb.append("<br/>");
            System.out.println( i+"、"+prev.getRiqi()+":出了"+total+"个数，"+"输赢："+currentMoney+",累计输赢："+totalMoney);
        }
        try{
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(sb.toString());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @RequestMapping("calc_no")
    public void calcAll(Integer qishu,HttpServletRequest request, HttpServletResponse response){
        Page<Handicap> page = handicapService.getHandicaps(1,10000);
        List<Handicap> handicaps = page.getList();
//        Collections.sort(handicaps, new Comparator<Handicap>() {
//            @Override
//            public int compare(Handicap o1, Handicap o2) {
//                return o1.getRiqi().compareTo(o2.getRiqi());
//            }
//        });
        Integer len =qishu>handicaps.size()?handicaps.size():qishu;
        Map<String,Integer> map =new TreeMap<String, Integer>();
        for( int i=0;i<len;i++) {
            Handicap handicap = handicaps.get(i);
            if(map.get(handicap.getNo1())!=null){
                map.put(handicap.getNo1(),map.get(handicap.getNo1())+1);
            }
            else{
                map.put(handicap.getNo1(),1);
            }
            if(map.get(handicap.getNo2())!=null){
                map.put(handicap.getNo2(),map.get(handicap.getNo2())+1);
            }
            else{
                map.put(handicap.getNo2(),1);
            }
            if(map.get(handicap.getNo3())!=null){
                map.put(handicap.getNo3(),map.get(handicap.getNo3())+1);
            }
            else{
                map.put(handicap.getNo3(),1);
            }
            if(map.get(handicap.getNo4())!=null){
                map.put(handicap.getNo4(),map.get(handicap.getNo4() )+1);
            }
            else{
                map.put(handicap.getNo4(),1);
            }
            if(map.get(handicap.getNo5())!=null){
                map.put(handicap.getNo5(),map.get(handicap.getNo5())+1);
            }
            else{
                map.put(handicap.getNo5(),1);
            }
            if(map.get(handicap.getNo6())!=null){
                map.put(handicap.getNo6(),map.get(handicap.getNo6())+1);
            }
            else{
                map.put(handicap.getNo6(),1);
            }
            if(map.get(handicap.getTema())!=null){
                map.put(handicap.getTema(),map.get(handicap.getTema())+1);
            }
            else{
                map.put(handicap.getTema(),1);
            }
        }
       /* List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
            //升序排序
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }

        });*/
        StringBuilder sb = new StringBuilder();
        for(String key :map.keySet()){
            sb.append(key+":"+ map.get(key));
            sb.append("<br/>");
        }
        try{
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(sb.toString());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
    /**
     * 特码胆拖正码之五不中
     * @param request
     * @param response
     */
    @RequestMapping("/calcTemaTuoWubuzhong")
    public void calcTeTuoLiu(HttpServletRequest request,HttpServletResponse response){
        Page<Handicap> page = handicapService.getHandicaps(1,10000);
        List<Handicap> handicaps = page.getList();
        Collections.sort(handicaps, new Comparator<Handicap>() {
            @Override
            public int compare(Handicap o1, Handicap o2) {
                return o1.getRiqi().compareTo(o2.getRiqi());
            }
        });
        int totalMoney=0;
        for( int i=0, len =handicaps.size();i<(len-1);i++){
            Handicap prev = handicaps.get(i);
            Handicap next = handicaps.get(i+1);
            int total =0;
            int temaTotal=0;
            int currentMoney=0;
            if( (prev.getNo1().equals(next.getNo1() )|| prev.getNo1().equals(next.getNo2() )|| prev.getNo1().equals(next.getNo3()
            )|| prev.getNo1().equals(next.getNo4())|| prev.getNo1().equals(next.getNo5())|| prev.getNo1().equals(next.getNo6()
            )|| prev.getNo1().equals(next.getTema()))){
                total++;
            }
            if(prev.getNo2().equals(next.getNo1() )|| prev.getNo2().equals(next.getNo2() )|| prev.getNo2().equals(next.getNo3()
            )|| prev.getNo2().equals(next.getNo4())|| prev.getNo2().equals(next.getNo5())|| prev.getNo2().equals(next.getNo6()
            )|| prev.getNo2().equals(next.getTema())){
                total++;
            }
            if(prev.getNo3().equals(next.getNo1() )|| prev.getNo3().equals(next.getNo2() )|| prev.getNo3().equals(next.getNo3()
            )|| prev.getNo3().equals(next.getNo4())|| prev.getNo3().equals(next.getNo5())|| prev.getNo3().equals(next.getNo6()
            )|| prev.getNo3().equals(next.getTema())){
                total++;
            }
            if(prev.getNo4().equals(next.getNo1() )|| prev.getNo4().equals(next.getNo2() )|| prev.getNo4().equals(next.getNo3()
            )|| prev.getNo4().equals(next.getNo4())|| prev.getNo4().equals(next.getNo5())|| prev.getNo4().equals(next.getNo6()
            )|| prev.getNo4().equals(next.getTema())){
                total++;
            }
            if(prev.getNo5().equals(next.getNo1() )|| prev.getNo5().equals(next.getNo2() )|| prev.getNo5().equals(next.getNo3()
            )|| prev.getNo5().equals(next.getNo4())|| prev.getNo5().equals(next.getNo5())|| prev.getNo5().equals(next.getNo6()
            )|| prev.getNo5().equals(next.getTema())){
                total++;
            }
            if(prev.getNo6().equals(next.getNo1() )|| prev.getNo6().equals(next.getNo2() )|| prev.getNo6().equals(next.getNo3()
            )|| prev.getNo6().equals(next.getNo4())|| prev.getNo6().equals(next.getNo5())|| prev.getNo6().equals(next.getNo6()
            )|| prev.getNo6().equals(next.getTema())){
                total++;
            }
            if(prev.getTema().equals(next.getNo1() )|| prev.getTema().equals(next.getNo2() )|| prev.getTema().equals(next.getNo3()
            )|| prev.getTema().equals(next.getNo4())|| prev.getTema().equals(next.getNo5())|| prev.getTema().equals(next.getNo6()
            )|| prev.getTema().equals(next.getTema())){
                temaTotal++;
            }

            if(temaTotal>0){
                currentMoney=-1500;
            }
            else if(total==0){
                currentMoney =1800;
            }
            else if( total==1){
                currentMoney=-400;
            }
            else if(total ==2){
                currentMoney=-1280;
            }
            else{
                currentMoney = -1500;
            }

            totalMoney+=currentMoney;
            System.out.println( i+"、"+next.getRiqi()+":正码出了"+total+"个数，"+"特码出了"+temaTotal+"个数，"+"输赢："+currentMoney+",累计输赢："+totalMoney);
        }
    }

    @RequestMapping("generate_code")
    public void  generateCode(HttpServletRequest request,HttpServletResponse response){
        Handicap handicap = handicapService.getLastestHandicap();
        String[] arr = new String[7];
        arr[0] = handicap.getNo1();
        arr[1] = handicap.getNo2();
        arr[2] = handicap.getNo3();
        arr[3] = handicap.getNo4();
        arr[4] = handicap.getNo5();
        arr[5] = handicap.getNo6();
        arr[6] = handicap.getTema();
        tmpArr.clear();
        combine(0 ,5 ,arr,handicap.getTema());
    }

    private static ArrayList<String> tmpArr = new ArrayList<String>();
    /**
     * 组合
     * 按一定的顺序取出元素，就是组合,元素个数[C arr.len 3]
     * @param index 元素位置
     * @param k 选取的元素个数
     * @param arr 数组
     */

    public static void combine(int index,int k,String[] arr,String tema) {
        if(k == 1){
            for (int i = index; i < arr.length; i++) {
                tmpArr.add(arr[i]);
                System.out.println(tmpArr.toString() + ",");
                tmpArr.remove((Object)arr[i]);
            }
        }else if(k > 1){
            for (int i = index; i <= arr.length - k; i++) {
                tmpArr.add(arr[i]); //tmpArr都是临时性存储一下
                combine(i + 1,k - 1, arr,tema); //索引右移，内部循环，自然排除已经选择的元素
                tmpArr.remove((Object)arr[i]); //tmpArr因为是临时存储的，上一个组合找出后就该释放空间，存储下一个元素继续拼接组合了
            }
        }else{
            return ;
        }
    }
}
