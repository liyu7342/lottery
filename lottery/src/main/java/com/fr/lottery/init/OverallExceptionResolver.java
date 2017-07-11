package com.fr.lottery.init;

import com.fr.lottery.exception.CustomException;
import com.fr.lottery.utils.LogUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**全局异常处理
 * Created by Administrator on 2017/1/24.
 */
//@Controller
public class OverallExceptionResolver implements HandlerExceptionResolver {
    /**
     * 进行全局异常的过滤和处理
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        //handler为当前处理器适配器执行的对象
        ModelAndView modelAndView = new ModelAndView();
        String message = null;
        //判断是否为系统自定义异常。
        if (ex instanceof CustomException) {
            message = ((CustomException) ex).getMessage();
              /*  使用response返回    */
            response.setStatus(HttpStatus.OK.value()); //设置状态码
            response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
            response.setCharacterEncoding("UTF-8"); //避免乱码
            response.setHeader("Cache-Control", "no-cache, must-revalidate");
            try {
                response.getWriter().write("{\"success\":false,\"msg\":\"" + ex.getMessage() + "\"}");
            } catch (IOException e) {
                LogUtil.error(e);
            }
        } else {
            LogUtil.error(ex);
            try {
                response.getWriter().write("{\"success\":false,\"msg\":\"系统发生未知错误！请联系管理员 \"}");
            } catch (IOException e) {
                LogUtil.error(e);
            }
        }
        return modelAndView;
    }
}