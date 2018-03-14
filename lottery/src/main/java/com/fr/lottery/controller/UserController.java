package com.fr.lottery.controller;

import com.fr.lottery.dto.Page;
import com.fr.lottery.entity.LimitSet;
import com.fr.lottery.entity.User;
import com.fr.lottery.enums.UserTypeEnum;
import com.fr.lottery.service.inter.ILimitSetService;
import com.fr.lottery.service.inter.IUserService;
import com.fr.lottery.utils.MD5Util;
import com.fr.lottery.utils.UserHelper;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/16.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;
    @Autowired
    private ILimitSetService limitSetService;

    @RequestMapping(value = "/index",produces = "text/html;charset=UTF-8")
    public ModelAndView index(Integer pageId, Integer keywordstatus, String keyword,String parentid) {
                if (pageId == null) pageId = 1;
        if(StringUtils.isNotBlank(keyword)){
            try{
                keyword = URLDecoder.decode(keyword, "utf-8");
            }
            catch (UnsupportedEncodingException ex){

                ex.printStackTrace();
            }

        }
        ModelAndView modelAndView = new ModelAndView("/user/index");
        User user = UserHelper.getCurrentUser();
        String userId = user.getId();

        Page<User> users = userService.getUsers(userId,parentid, UserTypeEnum.Member.ordinal(), keyword, keywordstatus, pageId);

        modelAndView.addObject("currentUserId", userId);
        modelAndView.addObject("users", users.getList());
        modelAndView.addObject("page", users.toString());
        modelAndView.addObject("keyword",keyword);
        User user1 = userService.getUserCount(false);
        modelAndView.addObject("gudongNumber",user1.getGudongNumber());
        modelAndView.addObject("zongdaiNumber",user1.getZongdaiNumber());
        modelAndView.addObject("dailiNumber",user1.getDailiNumber());
        modelAndView.addObject("memberNumber",user1.getMemberNumber());
        modelAndView.addObject("parentid",parentid);
        return modelAndView;
    }
    @RequestMapping(value = "/default")
    public ModelAndView currentView(){
        String url = "";
        User user = UserHelper.getCurrentUser();

        if(UserTypeEnum.Admin.ordinal() == user.getUsertype()){
            url="redirect:/user/index1";
        }
        else if(UserTypeEnum.DaGudong.ordinal() == user.getUsertype()){
            url="redirect:/user/index2";
        }
       else if(UserTypeEnum.XiaoGudong.ordinal() == user.getUsertype()){
            url="redirect:/user/index3";
        }
        else if(UserTypeEnum.ZongDaili.ordinal() == user.getUsertype()){
            url="redirect:/user/index4";
        }
         else   if(UserTypeEnum.Daili.ordinal() == user.getUsertype())
            {
                url="redirect:/user/index";
            }
        else{
            url="/user/default";
        }
        ModelAndView modelAndView = new ModelAndView(url);
        return modelAndView;
    }

    @RequestMapping("/index1")
    public ModelAndView index1(Integer pageId, Integer keywordstatus, String keyword) {
        if (pageId == null) pageId = 1;

        ModelAndView modelAndView = new ModelAndView("/user/index_1");
        User user = UserHelper.getCurrentUser();
        String userId = user.getId();
        Page<User> users = userService.getDagudongs(UserTypeEnum.DaGudong.ordinal(), keyword, keywordstatus, pageId);
        modelAndView.addObject("currentUserId", userId);
        modelAndView.addObject("users", users.getList());
        modelAndView.addObject("page", users.toString());
        modelAndView.addObject("keyword",keyword);

        User user1 = userService.getUserCount(false);
        modelAndView.addObject("gudongNumber",user1.getGudongNumber());
        modelAndView.addObject("zongdaiNumber",user1.getZongdaiNumber());
        modelAndView.addObject("dailiNumber",user1.getDailiNumber());
        modelAndView.addObject("memberNumber",user1.getMemberNumber());
        return modelAndView;
    }

    @RequestMapping("/index2")
    public ModelAndView index2(Integer pageId, Integer keywordstatus, String keyword,String parentid) {
        if (pageId == null) pageId = 1;

        ModelAndView modelAndView = new ModelAndView("/user/index_2");
        User user = UserHelper.getCurrentUser();
        String userId = user.getId();

        Page<User> users = userService.getUsers(userId,parentid, UserTypeEnum.XiaoGudong.ordinal(), keyword, keywordstatus, pageId);
        modelAndView.addObject("currentUserId", userId);
        modelAndView.addObject("users", users.getList());
        modelAndView.addObject("page", users.toString());
        modelAndView.addObject("keyword",keyword);

        User user1 = userService.getUserCount(false);
        modelAndView.addObject("gudongNumber",user1.getGudongNumber());
        modelAndView.addObject("zongdaiNumber",user1.getZongdaiNumber());
        modelAndView.addObject("dailiNumber",user1.getDailiNumber());
        modelAndView.addObject("memberNumber",user1.getMemberNumber());
        modelAndView.addObject("parentid",parentid);
        return modelAndView;
    }

    @RequestMapping("/index3")
    public ModelAndView index3(Integer pageId, Integer keywordstatus, String keyword,String parentid) {
        if (pageId == null) pageId = 1;

        ModelAndView modelAndView = new ModelAndView("/user/index_3");

        User user = UserHelper.getCurrentUser();
        String userId = user.getId();
        Page<User> users = userService.getUsers(userId,parentid, UserTypeEnum.ZongDaili.ordinal(), keyword, keywordstatus, pageId);
        modelAndView.addObject("currentUserId", userId);
        modelAndView.addObject("users", users.getList());
        modelAndView.addObject("page", users.toString());
        modelAndView.addObject("keyword",keyword);

        User user1 = userService.getUserCount(false);
        modelAndView.addObject("gudongNumber",user1.getGudongNumber());
        modelAndView.addObject("zongdaiNumber",user1.getZongdaiNumber());
        modelAndView.addObject("dailiNumber",user1.getDailiNumber());
        modelAndView.addObject("memberNumber",user1.getMemberNumber());
        modelAndView.addObject("parentid",parentid);
        return modelAndView;
    }

    @RequestMapping("/index4")
    public ModelAndView index4(Integer pageId, Integer keywordstatus, String keyword,String parentid) {
        if (pageId == null) pageId = 1;

        ModelAndView modelAndView = new ModelAndView("/user/index_4");
        User user = UserHelper.getCurrentUser();
        String userId = user.getId();

        Page<User> users = userService.getUsers(userId,parentid, UserTypeEnum.Daili.ordinal(), keyword, keywordstatus, pageId);
        modelAndView.addObject("currentUserId", userId);
        modelAndView.addObject("users", users.getList());
        modelAndView.addObject("page", users.toString());
        modelAndView.addObject("keyword",keyword);

        User user1 = userService.getUserCount(false);
        modelAndView.addObject("gudongNumber",user1.getGudongNumber());
        modelAndView.addObject("zongdaiNumber",user1.getZongdaiNumber());
        modelAndView.addObject("dailiNumber",user1.getDailiNumber());
        modelAndView.addObject("memberNumber",user1.getMemberNumber());
        modelAndView.addObject("parentid",parentid);
        return modelAndView;
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = UserHelper.getCurrentUser();

        UserHelper.logout(request);
        if (UserTypeEnum.Member.ordinal() == user.getUsertype())
            response.sendRedirect("/login/login");
        else if (UserTypeEnum.Daili.ordinal() == user.getUsertype() || UserTypeEnum.ZongDaili.ordinal() == user.getUsertype()
                || UserTypeEnum.XiaoGudong.ordinal() == user.getUsertype() || UserTypeEnum.DaGudong.ordinal() == user.getUsertype())
            response.sendRedirect("/login/login1");
        else if (UserTypeEnum.Admin.ordinal() == user.getUsertype()) {
            response.sendRedirect("/login/login2");
        } else {
            response.sendRedirect("/login/index");
        }
    }

    @RequestMapping("/changepwd")
    public void changepwd(String oldpwd, String newpwd1, HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = UserHelper.getCurrentUser();
        MD5Util md5Util = new MD5Util();
        boolean result = false;
        if (user.getPassword().equals(md5Util.getMD5ofStr(oldpwd))) {
            userService.updatePassword(user.getId(), md5Util.getMD5ofStr(newpwd1));
            result = true;
        }
        response.setContentType("text/html;charset=UTF-8");
        if(result){
            response.getWriter().write("<script type=\"text/javascript\"> alert(\"保存成功！\");parent.location.href =\"/user/logout\";</script>");
        }
        else
            response.getWriter().write("<script type=\"text/javascript\"> alert(\"保存失败！\");</script>");
    }


    @RequestMapping("/history")
    public ModelAndView history() {
        ModelAndView mv = new ModelAndView("/history/index");
        return mv;
    }

    @RequestMapping("/repassword")

    public ModelAndView repassword() {
        ModelAndView mv = new ModelAndView("/user/password");

        
        return mv;
    }

    @RequestMapping("password1")
    public ModelAndView password1(){
        ModelAndView mv = new ModelAndView("/user/password1");

        return mv;
    }

    @RequestMapping("/info")
    public ModelAndView info() {
        ModelAndView mv = new ModelAndView("/user/info");
        User currentUser = UserHelper.getCurrentUser();
        Map<String, Object> map = new HashMap<String, Object>();
        List<LimitSet> limitSets = limitSetService.findAll(currentUser.getId());

        for (LimitSet limitset : limitSets) {
            if("B".equals(currentUser.getHandicap())){
                limitset.setaRetreat(limitset.getbRetreat());
            }
            else if("C".equals(currentUser.getHandicap())){
                limitset.setaRetreat(limitset.getcRetreat());
            }
            map.put("gameType_" + limitset.getLimitType(), limitset);
        }
        mv.addObject("limitSets", map);
        return mv;
    }

    @RequestMapping("/info1")
    public ModelAndView info1() {
        ModelAndView mv = new ModelAndView("/user/info1");
        User currentUser = UserHelper.getCurrentUser();
        Map<String, Object> map = new HashMap<String, Object>();
        List<LimitSet> limitSets = limitSetService.findAll(currentUser.getId());

        for (LimitSet limitset : limitSets) {
            map.put("gameType_" + limitset.getLimitType(), limitset);
        }
        mv.addObject("limitSets", map);

        return mv;
    }

    @RequestMapping("/changStatus")
    @ResponseBody
    public int changeStatus(Integer level, String pid, String id, Integer status) {
        return userService.changeStatus(level, pid, id, status);
    }

    @RequestMapping("/checkAccount")
    @ResponseBody
    public int checkAccount(String account) {
        User user = userService.getByAccount(account);
        int result = user == null ? 0 : 1;
        return result;
    }
    @RequestMapping("/userselect")
    public ModelAndView userselect(Integer userType){

        User user = UserHelper.getCurrentUser();

        String reqUrl ;
        String redirectUrl="";
        List<User> users =new ArrayList<User>();
        String title="";
        if(userType==UserTypeEnum.XiaoGudong.ordinal()){
            reqUrl ="/member/info2?op=create&id=&parentId=";//小股東
            title="新增小股東";
        }
        else if(userType==UserTypeEnum.ZongDaili.ordinal()){
            reqUrl ="/member/info3?op=create&id=&parentId=";//總代理
            title="新增總代理";
        }else if(userType == UserTypeEnum.Daili.ordinal()){
            reqUrl ="/member/info4?op=create&id=&parentId=";//代理
            title = "新增代理";
        }else {
            reqUrl ="/member/info?op=create&id=&parentId=";//會員
            title ="新增會員";
        }
        if(user.getUsertype()+1 <userType){//如果是跨級新增
            redirectUrl = reqUrl;
            reqUrl="/user/userselect";

            users = userService.getUsers(user.getXpath(),userType -1);
        }
        else{
            reqUrl+=user.getId();//
            reqUrl="redirect:"+reqUrl;
        }
        ModelAndView modelAndView = new ModelAndView(reqUrl);
        modelAndView.addObject("reqUrl",redirectUrl);
        modelAndView.addObject("users",users);
        modelAndView.addObject("title",title);
        return modelAndView;
    }
}