package com.fr.lottery.utils;

import com.fr.lottery.entity.User;
import org.apache.commons.lang.StringUtils;
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
    public static void setCurrentUser(User user){
//        User userInfoApiDto = new User();
//        userInfoApiDto.setAccount(user.getAccount());
//        userInfoApiDto.setName(user.getName());
//        userInfoApiDto.setId(user.getId());
//        userInfoApiDto.setCredits(user.getCredits());
//
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        HttpSession session = request.getSession();
        if(StringUtils.isNotBlank(user.getSessionId()) && !session.getId().equals(user.getSessionId())){
            HttpSession absession= SessionContext.getSession(user.getSessionId());
            if(absession!=null){
                SessionContext.DelSession(absession);
                absession.setAttribute("dupSession","Duplicate session");
            }
        }
        user.setSessionId(session.getId());
        session.setAttribute(session_user,user);
    }

    public static void logout(HttpServletRequest request){
        if(request.getSession() !=null)
            request.getSession().invalidate();
    }

}
