package com.fr.lottery.utils;

import com.fr.lottery.entity.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/2/17.
 */
public class UserHelper {
    private static final String session_user="session_user";
    /*
    * 获取当前用户信息
    * */
    public static User getCurrentUser() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session = request.getSession();
            User dto= (User)session.getAttribute(session_user);
            return  dto;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    public static void setCurrentUser(HttpServletRequest request,User user){
        User userInfoApiDto = new User();
        userInfoApiDto.setAccount(user.getAccount());
        userInfoApiDto.setName(user.getName());
        userInfoApiDto.setId(user.getId());
        HttpSession session = request.getSession();
        session.setAttribute(session_user,userInfoApiDto);
    }

}
