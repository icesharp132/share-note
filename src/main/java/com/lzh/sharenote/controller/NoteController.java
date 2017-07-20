package com.lzh.sharenote.controller;

import com.alibaba.fastjson.JSON;
import com.lzh.sharenote.dal.dao.NoteDao;
import com.lzh.sharenote.dal.pojo.NoteDo;
import com.lzh.sharenote.service.NoteService;
import com.lzh.sharenote.utils.ParamUtil;
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
import java.util.Date;
import java.util.List;

/**
 * Created by Lu Zhaohui on 2017/7/6.
 */
@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    NoteService noteService;

    Logger logger = LoggerFactory.getLogger(NoteController.class);

    @RequestMapping("/rangelist")
    public @ResponseBody String list(HttpServletRequest request, HttpServletResponse response){
        Date startDate = ParamUtil.getDate(request, "startDate");
        Date endDate = ParamUtil.getDate(request, "endDate");
        List<NoteDo> noteDoList = noteService.listNoteBetweenDate(startDate, endDate, 10);
        return JSON.toJSONString(noteDoList);
    }

    @RequestMapping("/userrecent/")
    public @ResponseBody String recent(HttpServletRequest request, HttpServletResponse response){
        int current = 0;
        long userId = Long.parseLong(request.getSession().getAttribute("userId").toString());
        List<NoteDo> noteDoList = noteService.listRecentNote(userId, current, 10);
        return JSON.toJSONString(noteDoList);
    }
}
