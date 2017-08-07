package com.fr.lottery.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import sun.beans.editors.DoubleEditor;
import sun.beans.editors.FloatEditor;
import sun.beans.editors.IntEditor;
import sun.beans.editors.LongEditor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Liyu7342 on 2017-8-3.
 */
@Controller
public class BaseController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {

         binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
         binder.registerCustomEditor(int.class, new IntEditor());
         binder.registerCustomEditor(long.class, new LongEditor());
         binder.registerCustomEditor(double.class, new DoubleEditor());
         binder.registerCustomEditor(float.class, new FloatEditor());
     }



}
