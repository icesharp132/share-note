package com.lzh.sharenote.controller;

import com.lzh.sharenote.dal.dao.NoteDao;
import com.lzh.sharenote.service.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Lu Zhaohui on 2017/7/6.
 */
@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    NoteService noteService;

    Logger logger = LoggerFactory.getLogger(NoteController.class);

    @RequestMapping("/list")
    public @ResponseBody String list(HttpServletRequest request, HttpServletResponse response){
        return null;
    }

}
