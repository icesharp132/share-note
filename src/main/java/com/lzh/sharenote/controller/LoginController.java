package com.lzh.sharenote.controller;

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
