package com.fr.lottery.init;

import com.fr.lottery.entity.LotConfig;
import com.fr.lottery.utils.LotConfigHelper;
import com.fr.lottery.utils.StringUtil;
import com.fr.lottery.utils.UserHelper;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;
import java.util.Map;

import static com.fr.lottery.utils.LotConfigHelper.findAll;

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
        if(Global.cfg_category_key.size()==0){
            List<LotConfig> lotConfigs=LotConfigHelper.findAll();
            for(LotConfig lotConfig: lotConfigs)
                Global.cfg_category_key.put(lotConfig.getGameNo(),lotConfig);
        }
    }
}
