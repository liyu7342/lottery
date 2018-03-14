package com.fr.lottery.init;

import com.fr.lottery.entity.User;
import com.fr.lottery.utils.UserHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;


/**
 * 自定义拦截器
 * Created by Administrator on 2017/4/5.
 */
public class MyInterceptor extends HandlerInterceptorAdapter {
    private long beginTime;

    public MyInterceptor() {
        super();
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        beginTime = new Date().getTime();//请求开始时间
        String request_Url = request.getRequestURL().toString();//请求的链接
        String reg = ".*\\.(?i)(jpg|js|png|css|gif|dwr)";
        //静态资源不进行验证
        if (request_Url.matches(reg)) {
            return true;
        }
        //判断是否为ajax请求，默认不是
        boolean isajax=false;
        if(!StringUtils.isBlank(request.getHeader("x-requested-with")) && request.getHeader("x-requested-with").equals("XMLHttpRequest")) {
            isajax = true;
        }
         User user = UserHelper.getCurrentUser();
        if(user ==null){
            if(isajax){
                response.getWriter().write("Lost session");
            }
            else{
                request.getRequestDispatcher("/login/index").forward(request, response);
            }
            return false;
        }
        else{
            if(isajax) {
                HttpSession session = request.getSession();
                if (session.getAttribute("dupSession") != null) {
                    response.getWriter().write("Duplicate session");
                    session.invalidate();
                    return false;
                }
            }
            else{
                request.setAttribute("user", user);
            }
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 最后执行，可用于释放资源
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
