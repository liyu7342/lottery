package com.fr.lottery.controller;

import com.fr.lottery.dto.LimitSetDto;
import com.fr.lottery.dto.Page;
import com.fr.lottery.dto.ResultInfo;
import com.fr.lottery.entity.LimitSet;
import com.fr.lottery.entity.User;
import com.fr.lottery.enums.UserTypeEnum;
import com.fr.lottery.service.impl.UserService;
import com.fr.lottery.service.inter.ILimitSetService;
import com.fr.lottery.service.inter.IOddsService;
import com.fr.lottery.service.inter.IUserService;
import com.fr.lottery.utils.MD5Util;
import com.fr.lottery.utils.StringUtil;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Liyu7342 on 2017-7-16.
 */
@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IOddsService oddsService;
    @Autowired
    private ILimitSetService limitSetService;

    @RequestMapping("/index")
    public ModelAndView index(Integer pageId) {
        ModelAndView modelAndView = new ModelAndView("/member/index");
        String agentId = UserHelper.getCurrentUser().getId();
        Page<User> members = userService.getUsers(agentId, UserTypeEnum.Member.ordinal(), "", null, pageId);
        modelAndView.addObject("user", members.getList());
        modelAndView.addObject("page", members.toString());
        return modelAndView;
    }

    @RequestMapping("/info")
    public ModelAndView info(String id, String parentId) {
        ModelAndView modelAndView = new ModelAndView("/member/info");
        User user ;
        User parentUser = userService.get(parentId);
        List<LimitSet> limitSets ;
        List<LimitSet> plimitSets;
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
            limitSets = plimitSets;
        }

        Map<String, Object> map = new HashMap<String, Object>();
        for (LimitSet limitset : limitSets
                ) {
            map.put("gameType_" + limitset.getLimitType(), limitset);
        }
        Map<String, Object> pmap = new HashMap<String, Object>();
        for (LimitSet limitset : limitSets
                ) {
            pmap.put("gameType_" + limitset.getLimitType(), limitset);
        }
        modelAndView.addObject("limitSets", map);
        modelAndView.addObject("plimit", pmap);
        modelAndView.addObject("user", user);
        modelAndView.addObject("parentUser", parentUser);
        return modelAndView;
    }

    @RequestMapping("/info1")
    public ModelAndView info1(String id, String parentId) {
        ModelAndView modelAndView = new ModelAndView("/member/info1");
        User user = null;

        List<LimitSet> limitSets ;
        List<LimitSet> plimitSets ;
        if (StringUtils.isNotBlank(parentId)) {
            plimitSets = limitSetService.findAll(parentId);
        } else {
            plimitSets = limitSetService.findAll("-1");
        }
        if (StringUtils.isNotBlank(id)) {
            user = userService.get(id);
            limitSets = limitSetService.findAll(id);
        }
        else{
            user = new User();
            limitSets = plimitSets;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        for (LimitSet limitset : limitSets
                ) {
            map.put("gameType_" + limitset.getLimitType(), limitset);
        }

        modelAndView.addObject("limitSets", map);
        modelAndView.addObject("user", user);
//        modelAndView.addObject("parentUser",parentUser);
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
            limitSets = limitSetService.findAll(id);
        } else {
            user = new User();
            limitSets = plimitSets;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        for (LimitSet limitset : limitSets
                ) {
            map.put("gameType_" + limitset.getLimitType(), limitset);
        }

        Map<String, Object> pmap = new HashMap<String, Object>();
        for (LimitSet limitset : limitSets
                ) {
            pmap.put("gameType_" + limitset.getLimitType(), limitset);
        }
        modelAndView.addObject("limitSets", map);
        modelAndView.addObject("plimit", pmap);
        modelAndView.addObject("user", user);
        modelAndView.addObject("parentUser", parentUser);
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
            limitSets = limitSetService.findAll(id);
        } else {
            user = new User();
            limitSets = plimitSets;
        }

        Map<String, Object> map = new HashMap<String, Object>();
        for (LimitSet limitset : limitSets
                ) {
            map.put("gameType_" + limitset.getLimitType(), limitset);
        }
        Map<String, Object> pmap = new HashMap<String, Object>();
        for (LimitSet limitset : limitSets
                ) {
            pmap.put("gameType_" + limitset.getLimitType(), limitset);
        }
        modelAndView.addObject("limitSets", map);
        modelAndView.addObject("plimit", pmap);
        modelAndView.addObject("user", user);
        modelAndView.addObject("parentUser", parentUser);
        return modelAndView;
    }

    @RequestMapping("/info4")
    public ModelAndView info4(String id, String parentId) {
        ModelAndView modelAndView = new ModelAndView("/member/info4");
        User user = null;
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
            limitSets = limitSetService.findAll(id);
        } else {
            user = new User();
            limitSets = plimitSets;
        }

        Map<String, Object> map = new HashMap<String, Object>();
        for (LimitSet limitset : limitSets
                ) {
            map.put("gameType_" + limitset.getLimitType(), limitset);
        }
        Map<String, Object> pmap = new HashMap<String, Object>();
        for (LimitSet limitset : limitSets
                ) {
            pmap.put("gameType_" + limitset.getLimitType(), limitset);
        }
        modelAndView.addObject("limitSets", map);
        modelAndView.addObject("plimit", pmap);
        modelAndView.addObject("user", user);
        modelAndView.addObject("parentUser", parentUser);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/save")
    public void save(User user, LimitSetDto limitSetDto, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo<String> resultInfo = new ResultInfo<String>();
        userService.Save(user, limitSetDto);
        //ModelAndView modelAndView = new ModelAndView("redirect:/member/info?parentId="+user.getParentid()+"&id="+user.getId());
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("<script type=\"text/javascript\"> alert(\"保存成功！\");location.href =\"/user/index\";</script>");
        //return "<script type=\"text/javascript\"> alert(\"保存成功！\");location.href =\"/user/index\";</script>";
        //return modelAndView;
    }
}
