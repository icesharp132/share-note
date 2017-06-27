package com.lzh.sharenote.controller;

import com.lzh.sharenote.dal.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lu Zhaohui on 2017/6/23.
 */
@RestController
public class LoginController {

    @Autowired
    private UserDao userDao;

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

}
