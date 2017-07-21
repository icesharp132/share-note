package com.lzh.sharenote.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Lu Zhaohui on 2017/7/21.
 */
@RestController
public class PageController {

    @RequestMapping("index.html")
    public ModelAndView page(){
        ModelAndView model = new ModelAndView("/index");
        return model;
    }
}
