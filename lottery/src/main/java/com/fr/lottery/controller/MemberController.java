package com.fr.lottery.controller;

import com.fr.lottery.dto.LimitSetDto;
import com.fr.lottery.dto.Page;
import com.fr.lottery.entity.LimitSet;
import com.fr.lottery.entity.User;
import com.fr.lottery.enums.UserTypeEnum;
import com.fr.lottery.service.inter.IHandicapService;
import com.fr.lottery.service.inter.ILimitSetService;
import com.fr.lottery.service.inter.IOddsService;
import com.fr.lottery.service.inter.IUserService;
import com.fr.lottery.utils.UserHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by Liyu7342 on 2017-7-16.
 */
@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ILimitSetService limitSetService;
    @Autowired
    private  IHandicapService handicapService;


    @RequestMapping("/index")
    public ModelAndView index(Integer pageId) {
        ModelAndView modelAndView = new ModelAndView("/member/index");
        String agentId = UserHelper.getCurrentUser().getId();
        Page<User> members = userService.getUsers(agentId,"", UserTypeEnum.Member.ordinal(), "", null, pageId);
        modelAndView.addObject("users", members.getList());
        modelAndView.addObject("page", members.toString());
        return modelAndView;
    }

    @RequestMapping("/info")
    public ModelAndView info(String id, String parentId) {
        ModelAndView modelAndView = new ModelAndView("/member/info");
        User user;
        List<LimitSet> limitSets;
        List<LimitSet> plimitSets;
        User parentUser = userService.get(parentId);

        if (StringUtils.isNotBlank(parentId)) {
            plimitSets = limitSetService.findAll(parentId);
        } else {
            plimitSets = limitSetService.findAll("-1");
        }
        if (StringUtils.isNotBlank(id)) {
            user = userService.get(id);
            limitSets = limitSetService.findAll(id);
        } else {
            user = new User();
            user.setHandicap(parentUser.getHandicap());
            limitSets = plimitSets;
        }
        Integer credits = userService.getChildSumCredit(parentId);
        parentUser.setCredits(parentUser.getCredits() -credits+user.getCredits());

        Map<String, Object> map = new HashMap<String, Object>();
        for (LimitSet limitset : limitSets) {
            map.put("gameType_" + limitset.getLimitType(), limitset);
        }
        Map<String, Object> pmap = new HashMap<String, Object>();
        for (LimitSet limitset : plimitSets) {
            pmap.put("gameType_" + limitset.getLimitType(), limitset);
        }

        List<Integer> shareUpArr = new ArrayList<Integer>();
        for (int i = 0; i <= parentUser.getShareTotal(); i += 5) {
            shareUpArr.add(i);
        }
        modelAndView.addObject("limitSets", map);
        modelAndView.addObject("plimit", pmap);
        modelAndView.addObject("info", user);
        modelAndView.addObject("parentUser", parentUser);
        modelAndView.addObject("shareUpList", shareUpArr);
        modelAndView.addObject("isopen",StringUtils.isNotBlank(id) && handicapService.IsOpenHandicap(false));
        User user1 = userService.getUserCount(false);
        modelAndView.addObject("user",user1);
        return modelAndView;
    }

    @RequestMapping("/info1")
    public ModelAndView info1(String id, String parentId) {
        ModelAndView modelAndView = new ModelAndView("/member/info1");
        User user;
        Integer childsumcredit = 0;
        List<LimitSet> limitSets;
        List<LimitSet> plimitSets;
        if (StringUtils.isNotBlank(parentId)) {
            plimitSets = limitSetService.findAll(parentId);
        } else {
            plimitSets = limitSetService.findAll("-1");
        }
        if (StringUtils.isNotBlank(id)) {
            user = userService.get(id);
            user.setSys_user_oddsSet(user.getHandicap());
            childsumcredit = userService.getChildSumCredit(id);
            limitSets = limitSetService.findAll(id);
        } else {
            user = new User();
            user.setSys_user_oddsSet("C");
            limitSets = plimitSets;
        }

        Map<String, Object> map = new HashMap<String, Object>();
        for (LimitSet limitset : limitSets
                ) {
            map.put("gameType_" + limitset.getLimitType(), limitset);
        }

        modelAndView.addObject("limitSets", map);
        modelAndView.addObject("info", user);
        int shareTotal = 100 - user.getShareUp();
        List<Integer> shareArr = new ArrayList<Integer>();
        for (int i = 0; i <= shareTotal; i += 5) {
            shareArr.add(i);
        }
        modelAndView.addObject("shareTotalList", shareArr);
        modelAndView.addObject("childsumcredit", childsumcredit);
        User user1 = userService.getUserCount(false);
        modelAndView.addObject("user",user1);
        modelAndView.addObject("isopen",StringUtils.isNotBlank(id) && handicapService.IsOpenHandicap(false));
        return modelAndView;

    }

    @RequestMapping("/info2")
    public ModelAndView info2(String id, String parentId) {
        ModelAndView modelAndView = new ModelAndView("/member/info2");
        User user;
        User parentUser = userService.get(parentId);
        List<LimitSet> limitSets;
        List<LimitSet> plimitSets;
        if (StringUtils.isNotBlank(parentId)) {
            plimitSets = limitSetService.findAll(parentId);
        } else {
            plimitSets = limitSetService.findAll("-1");
        }
        if (StringUtils.isNotBlank(id)) {
            user = userService.get(id);
            user.setSys_user_oddsSet(user.getHandicap());
            limitSets = limitSetService.findAll(id);
        } else {
            user = new User();
            user.setSys_user_oddsSet(parentUser.getHandicap());
            limitSets = plimitSets;
        }
        Integer credits = userService.getChildSumCredit(parentId);
        parentUser.setCredits(parentUser.getCredits() -credits+user.getCredits());
        Map<String, Object> map = new HashMap<String, Object>();
        for (LimitSet limitset : limitSets) {
            map.put("gameType_" + limitset.getLimitType(), limitset);
        }

        Map<String, Object> pmap = new HashMap<String, Object>();
        for (LimitSet limitset : plimitSets) {
            pmap.put("gameType_" + limitset.getLimitType(), limitset);
        }
        modelAndView.addObject("limitSets", map);
        modelAndView.addObject("plimit", pmap);

        modelAndView.addObject("info", user);
        modelAndView.addObject("credits", user.getCredits() != null ? user.getCredits().toString() : "0~" + parentUser.getCredits().toString());
        int shareTotal = parentUser.getShareTotal() - user.getShareUp();
        List<Integer> shareArr = new ArrayList<Integer>();
        for (int i = 0; i <= shareTotal; i += 5) {
            shareArr.add(i);
        }
        List<Integer> shareUpArr = new ArrayList<Integer>();
        for (int i = 0; i <= parentUser.getShareTotal(); i += 5) {
            shareUpArr.add(i);
        }
        modelAndView.addObject("shareTotalList", shareArr);
        modelAndView.addObject("shareUpList", shareUpArr);
        modelAndView.addObject("parentUser", parentUser);
        modelAndView.addObject("currentuser", UserHelper.getCurrentUser());
        modelAndView.addObject("isopen",StringUtils.isNotBlank(id) && handicapService.IsOpenHandicap(false));
        User user1 = userService.getUserCount(false);
        modelAndView.addObject("user",user1);
        return modelAndView;
    }

    @RequestMapping("/info3")
    public ModelAndView info3(String id, String parentId) {
        ModelAndView modelAndView = new ModelAndView("/member/info3");
        User user;
        User parentUser = userService.get(parentId);
        List<LimitSet> limitSets;
        List<LimitSet> plimitSets;
        if (StringUtils.isNotBlank(parentId)) {
            plimitSets = limitSetService.findAll(parentId);
        } else {
            plimitSets = limitSetService.findAll("-1");
        }
        if (StringUtils.isNotBlank(id)) {
            user = userService.get(id);
            user.setSys_user_oddsSet(user.getHandicap());
            limitSets = limitSetService.findAll(id);
        } else {
            user = new User();
            user.setSys_user_oddsSet(parentUser.getHandicap());

            limitSets = plimitSets;
        }
        Integer credits = userService.getChildSumCredit(parentId);
        parentUser.setCredits(parentUser.getCredits() -credits+user.getCredits());
        Map<String, Object> map = new HashMap<String, Object>();
        for (LimitSet limitset : limitSets  ) {
            map.put("gameType_" + limitset.getLimitType(), limitset);
        }

        Map<String, Object> pmap = new HashMap<String, Object>();
        for (LimitSet limitset : plimitSets  ) {
            pmap.put("gameType_" + limitset.getLimitType(), limitset);
        }
        modelAndView.addObject("limitSets", map);
        modelAndView.addObject("plimit", pmap);


        modelAndView.addObject("info", user);
        modelAndView.addObject("credits", user.getCredits() != null ? user.getCredits().toString() : "0~" + parentUser.getCredits().toString());
        int shareTotal = parentUser.getShareTotal() - user.getShareUp();
        List<Integer> shareArr = new ArrayList<Integer>();
        for (int i = 0; i <= shareTotal; i += 5) {
            shareArr.add(i);
        }
        List<Integer> shareUpArr = new ArrayList<Integer>();
        for (int i = 0; i <= parentUser.getShareTotal(); i += 5) {
            shareUpArr.add(i);
        }
        modelAndView.addObject("shareTotalList", shareArr);
        modelAndView.addObject("shareUpList", shareUpArr);
        modelAndView.addObject("parentUser", parentUser);
        modelAndView.addObject("isopen",handicapService.IsOpenHandicap(false));
        User user1 = userService.getUserCount(false);
        modelAndView.addObject("user",user1);
        return modelAndView;
    }

    @RequestMapping("/info4")
    public ModelAndView info4(String id, String parentId) {
        ModelAndView modelAndView = new ModelAndView("/member/info4");
        User user;
        User parentUser = userService.get(parentId);
        List<LimitSet> limitSets;
        List<LimitSet> plimitSets;
        if (StringUtils.isNotBlank(parentId)) {
            plimitSets = limitSetService.findAll(parentId);
        } else {
            plimitSets = limitSetService.findAll("-1");
        }
        if (StringUtils.isNotBlank(id)) {
            user = userService.get(id);
            user.setSys_user_oddsSet(user.getHandicap());
            limitSets = limitSetService.findAll(id);
        } else {
            user = new User();
            user.setSys_user_oddsSet(parentUser.getHandicap());

            limitSets = plimitSets;
        }
        Integer credits = userService.getChildSumCredit(parentId);
        parentUser.setCredits(parentUser.getCredits() -credits+user.getCredits());
        Map<String, Object> map = new HashMap<String, Object>();
        for (LimitSet limitset : limitSets) {
            map.put("gameType_" + limitset.getLimitType(), limitset);
        }

        Map<String, Object> pmap = new HashMap<String, Object>();
        for (LimitSet limitset : plimitSets) {
            pmap.put("gameType_" + limitset.getLimitType(), limitset);
        }
        modelAndView.addObject("limitSets", map);
        modelAndView.addObject("plimit", pmap);


        modelAndView.addObject("info", user);
        modelAndView.addObject("credits", user.getCredits() != null ? user.getCredits().toString() : "0~" + parentUser.getCredits().toString());
        int shareTotal = parentUser.getShareTotal() - user.getShareUp();
        List<Integer> shareArr = new ArrayList<Integer>();
        for (int i = 0; i <= shareTotal; i += 5) {
            shareArr.add(i);
        }
        List<Integer> shareUpArr = new ArrayList<Integer>();
        for (int i = 0; i <= parentUser.getShareTotal(); i += 5) {
            shareUpArr.add(i);
        }
        modelAndView.addObject("shareTotalList", shareArr);
        modelAndView.addObject("shareUpList", shareUpArr);
        modelAndView.addObject("parentUser", parentUser);
        modelAndView.addObject("currentuser", UserHelper.getCurrentUser());
        modelAndView.addObject("isopen",StringUtils.isNotBlank(id) && handicapService.IsOpenHandicap(false));

        User user1 = userService.getUserCount(false);
        modelAndView.addObject("user",user1);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/admin_create")
    public ModelAndView admin_create(String id,String parentId){
        User user;
        if(StringUtils.isNotBlank(id)){
             user = userService.get(id);
        }
        else{
             user =new User();
        }
        User currentUser = UserHelper.getCurrentUser();

        ModelAndView modelAndView = new ModelAndView("/member/admin_create");
        modelAndView.addObject("info",user);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/saveAdmin")
    public void saveAdmin(User user,String sys_user_permission,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if(StringUtils.isBlank(user.getId())){
            User parentUser =UserHelper.getCurrentUser();
            user.setParentid(parentUser.getId());
            user.setXpath(parentUser.getXpath());
        }
        userService.saveAdmin(user,sys_user_permission);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("<script type=\"text/javascript\"> alert(\"保存成功！\");location.href =\"/user/admin_list\";</script>");
    }

    @ResponseBody
    @RequestMapping("/save")
    public void save(User user, LimitSetDto limitSetDto, String requestUrl, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        boolean isOpenHandicap=handicapService.IsOpenHandicap();
//        if( isOpenHandicap){
//            response.setContentType("text/html;charset=UTF-8");
//            response.getWriter().write("<script type=\"text/javascript\"> alert(\"保存失败！开盘中，不允许修改信息！\");</script>");
//            return;
//        }
//        else
          Integer result =  userService.Save(user, limitSetDto);
          if(result==-1){
              response.setContentType("text/html;charset=UTF-8");
              response.getWriter().write("<script type=\"text/javascript\"> alert(\"下级占成和大于本级占成，请先调整下级占成！\");location.href =\"" + requestUrl + "\";</script>");
          }
          else{
              response.setContentType("text/html;charset=UTF-8");
              response.getWriter().write("<script type=\"text/javascript\"> alert(\"保存成功！\");location.href =\"" + requestUrl + "\";</script>");
          }

    }
}
