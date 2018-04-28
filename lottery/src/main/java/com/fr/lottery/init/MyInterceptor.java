package com.fr.lottery.init;

import com.fr.lottery.entity.User;
import com.fr.lottery.service.inter.IUserService;
import com.fr.lottery.utils.UserHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;


/**
 * 自定义拦截器
 * Created by Administrator on 2017/4/5.
 */
public class MyInterceptor extends HandlerInterceptorAdapter {
    private long beginTime;
    private static final String dailiHome = "/home/index1";

    private List<String> notAllocUrls;

    public List<String> getNotAllocUrls() {
        return notAllocUrls;
    }

    public void setNotAllocUrls(List<String> notAllocUrls) {
        this.notAllocUrls = notAllocUrls;
    }

    private List<String> dailiNotAllowUrls;

    public List<String> getDailiNotAllowUrls() {
        return dailiNotAllowUrls;
    }

    public void setDailiNotAllowUrls(List<String> dailiNotAllowUrls) {
        this.dailiNotAllowUrls = dailiNotAllowUrls;
    }

    @Resource
    private IUserService userService;

    public MyInterceptor() {
        super();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        beginTime = new Date().getTime();//请求开始时间
        //String request_Url = request.getRequestURL().toString();//请求的链接

//        String reg = ".*\\.(?i)(jpg|js|png|css|gif|dwr)";
//        //静态资源不进行验证
//        if (request_Url.matches(reg)) {
//            return true;
//        }
        String request_Url = request.getServletPath();
        if("/".equals(request_Url)){
            request.getRequestDispatcher("/login/index").forward(request, response);
            return false;
        }

        //判断是否为ajax请求，默认不是
        boolean isajax = false;
        if (!StringUtils.isBlank(request.getHeader("x-requested-with")) && request.getHeader("x-requested-with").equals("XMLHttpRequest")) {
            isajax = true;
        }
        User user = UserHelper.getCurrentUser();
        if (user == null) {
            if (isajax) {
                response.getWriter().write("Lost session");
            } else {
                request.getRequestDispatcher("/login/index").forward(request, response);
            }
            return false;
        } else {
            if (user.getUsertype() != 0) {

                //判斷session是否相同，不同則使session失效
                String sessionId = userService.getUserSessionId(user.getRealId());//未获取到sessionId
                HttpSession session = request.getSession();
                if (StringUtils.isNotBlank(sessionId) && !session.getId().equals(sessionId)) {
                    session.invalidate();
                    if (isajax) {
                        response.getWriter().write("Duplicate session");
                    } else {
                        request.getRequestDispatcher("/login/index").forward(request, response);
                    }
                    return false;
                }
            }
            if (!isajax) {
                request.setAttribute("title_userAccount", user.getAccount());
            }
            if (user.getUsertype() == 5) {
                for (String url : notAllocUrls) {
                    if (request_Url.equals(url) ) {
                        return false;
                    }
                }
            } else if (user.getUsertype() > 0 && user.getUsertype() < 5) {
                for (String url : dailiNotAllowUrls) {
                    if (request_Url.equals(url) ) {
                        return false;
                    }
                }
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
