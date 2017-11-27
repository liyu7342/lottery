package com.fr.lottery.controller;

import com.fr.lottery.dto.BuhuoConfigDto;
import com.fr.lottery.entity.User;
import com.fr.lottery.service.inter.IBucangConfigService;
import com.fr.lottery.utils.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Liyu7342 on 2017-7-13.
 */
@Controller
@RequestMapping("/sysconfig")
public class SysConfigContorller {
    @Autowired
    private IBucangConfigService configService;
    @RequestMapping("/buhuo")
    public ModelAndView buhuo() {
        ModelAndView mv = new ModelAndView("sysconfig/buhuo");

        return mv;
    }

    @RequestMapping("/save")
    public void  save(BuhuoConfigDto configDto, HttpServletRequest request, HttpServletResponse response) throws IOException{
        String referer = request.getHeader("Referer");
        try{
            configService.save(configDto);
            response.getWriter().write("<script type=\"text/javascript\"> alert(\"保存成功！\");location.href =\"" + referer + "\"</script>");
        }
        catch (Exception ex){
            response.getWriter().write("<script type=\"text/javascript\"> alert(\"保存失败！\");</script>");
        }
    }
}
