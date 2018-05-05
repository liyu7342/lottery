package com.fr.lottery.controller;

import com.fr.lottery.dto.BuhuoConfigDto;
import com.fr.lottery.entity.BucangConfig;
import com.fr.lottery.entity.User;
import com.fr.lottery.service.inter.IBucangConfigService;
import com.fr.lottery.utils.JsonUtil;
import com.fr.lottery.utils.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        User user = UserHelper.getCurrentUser();
        List<BucangConfig> configList = configService.getDatas(user.getId());
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (BucangConfig config : configList) {
            map.put("base_" + config.getCategory() + "_" + config.getGameType(), config.getBaseAmount());
            map.put("flag_" + config.getCategory() + "_" + config.getGameType(), config.getFlagValue());
        }
        mv.addObject("entity", map);
        return mv;
    }

    @RequestMapping("/save")
    @ResponseBody
    public int save(String chg , HttpServletRequest request, HttpServletResponse response) throws IOException {
        String referer = request.getHeader("Referer");
        try {
            // Map map=RequestDataUtils.getParameterMap(request);
            BuhuoConfigDto configDto = JsonUtil.getObj(chg,BuhuoConfigDto.class);
            configService.save(configDto);
            return 1;

        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }
}
