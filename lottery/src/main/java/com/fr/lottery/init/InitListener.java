package com.fr.lottery.init;

import com.fr.lottery.utils.StringUtil;
import com.fr.lottery.utils.UserHelper;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**初始化监听器
 * Created by Administrator on 2017/1/23.
 */
public class InitListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent context) {

    }

    @Override
    public void contextInitialized(ServletContextEvent context) {

        context.getServletContext().setAttribute("JSVersion", StringUtil.getVersion());

    }
}
