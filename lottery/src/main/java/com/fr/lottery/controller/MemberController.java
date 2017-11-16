package com.fr.lottery.controller;

import com.fr.lottery.dto.LimitSetDto;
import com.fr.lottery.dto.Page;
import com.fr.lottery.dto.ResultInfo;
import com.fr.lottery.entity.LimitSet;
import com.fr.lottery.entity.User;
import com.fr.lottery.enums.UserTypeEnum;
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
    public ModelAndView index(Integer pageId){
        ModelAndView modelAndView = new ModelAndView("/member/index");
        String agentId = UserHelper.getCurrentUser().getId();
        Page<User> members = userService.getUsers(agentId, UserTypeEnum.Member.ordinal(),"",null,pageId);
        modelAndView.addObject("user",members.getList());
        modelAndView.addObject("page",members.toString());
        return modelAndView;
    }
    @RequestMapping("/info")
    public ModelAndView info(String id,String parentId){
        ModelAndView modelAndView = new ModelAndView("/member/info");
        User user = userService.get(id);
        User parentUser =null;
        if(StringUtils.isNotBlank(parentId)){
             parentUser = userService.get(parentId);
        }


        List<LimitSet> limitSets= limitSetService.findAll(parentId);
        Map<String,Object> map = new HashMap<String, Object>();
        for (LimitSet limitset: limitSets
             ) {
            map.put("gameType_"+limitset.getLimitType(),limitset.getaRetreat());
        }
       /* if(limitSets.size()==0){
            limitSets = limitSetService.findAll(UserHelper.getCurrentUser().getId());
        }*/
        modelAndView.addObject("limitSets",map);
        modelAndView.addObject("user",user);
        modelAndView.addObject("parentUser",parentUser);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/save")
    public void save(User user, LimitSetDto limitSetDto, HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        ResultInfo<String> resultInfo = new ResultInfo<String>();
        user.setPassword(new MD5Util().getMD5ofStr(user.getPassword()) );
        if(StringUtils.isBlank(user.getId())){
            user.setId(StringUtil.getUUID());
            if(StringUtils.isNoneBlank( user.getParentid())){
                User parentUser = userService.get(user.getParentid());
                if(parentUser !=null){
                    user.setUsertype(parentUser.getUsertype()+1);
                }
                else{
                    user.setUsertype(1);
                }
            }
            else{
                user.setUsertype(1);
            }
            user.setCreatedate(new Date());
            userService.insert(user);
        }
        else{
            User entity = userService.get(user.getId());
            user.setCreatedate( entity.getCreatedate());
            userService.update(user);
        }

        limitSetService.insert(user.getId(),limitSetDto);
        //ModelAndView modelAndView = new ModelAndView("redirect:/member/info?parentId="+user.getParentid()+"&id="+user.getId());
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write( "<script type=\"text/javascript\"> alert(\"保存成功！\");location.href =\"/user/index\";</script>");
        //return "<script type=\"text/javascript\"> alert(\"保存成功！\");location.href =\"/user/index\";</script>";
        //return modelAndView;
    }
}
