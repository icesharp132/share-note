package com.lzh.sharenote.controller;

import com.lzh.sharenote.dal.dao.UserDao;
import com.lzh.sharenote.dal.pojo.UserDo;
import com.lzh.sharenote.entities.BaseResponse;
import com.lzh.sharenote.enums.HttpCodeEnum;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Lu Zhaohui on 2017/6/23.
 */
@RestController
public class LoginController {

    @Autowired
    private UserDao userDao;

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login")
    public BaseResponse login(HttpServletRequest request, HttpServletResponse response){
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        BaseResponse res = new BaseResponse();
        res.setCode(HttpCodeEnum.ERROR.getCode());
        res.setMsg(HttpCodeEnum.ERROR.getDesc());
        if(StringUtils.isBlank(uname)||StringUtils.isBlank(pwd))
            return res;
        try {
            UserDo bean = userDao.selectUserByUnameAndPwd(uname,pwd);
            if(bean==null){
                res.setCode(HttpCodeEnum.ERROR.getCode());
                res.setMsg("用户名或密码错误");
                return res;
            }
            request.getSession().setAttribute("userId", String.valueOf(bean.getId()));
            request.getSession().setAttribute("userName", uname);
            request.getSession().setAttribute("userRole", bean.getRole());
            request.getSession().setAttribute("nickName", bean.getNickName());
            res.setCode(HttpCodeEnum.SUCCESS.getCode());
            res.setMsg(HttpCodeEnum.SUCCESS.getDesc());
            return res;
        } catch (Exception e) {
            logger.error("login error",e);
            res.setCode(HttpCodeEnum.ERROR.getCode());
            res.setMsg("系统错误，请稍后重试");
            return res;
        }
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response){
        request.getSession().invalidate();
        try {
            response.sendRedirect("/loginpage");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 管理员注册账号
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("adduser")
    public BaseResponse addUser(HttpServletRequest request, HttpServletResponse response){
        BaseResponse res = new BaseResponse();
        res.setCode(HttpCodeEnum.ERROR.getCode());

        boolean auth =  ifAuth(request);
        if(!auth){
            res.setCode(HttpCodeEnum.ERROR.getCode());
            res.setMsg("您没有权限");
            return res;
        }
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        String nickName = request.getParameter("nick_name");
        String role = request.getParameter("role");

        if(StringUtils.isBlank(uname)){
            res.setMsg("用户名不为空");
            return res;
        }
        if(StringUtils.isBlank(pwd)){
            res.setMsg("密码不为空");
            return res;
        }
        if(pwd.length()<6){
            res.setMsg("密码必须大于6位");
            return res;
        }
        if(StringUtils.isNotBlank(nickName)){
            if(nickName.length()>15){
                res.setMsg("昵称不能超过15位");
                return res;
            }
        }

        try {
            UserDo exist = userDao.selectUserByUname(uname);
            if(exist != null){
                res.setMsg("该账号已存在");
                return res;
            }

            UserDo bean = new UserDo();
            bean.setUname(uname);
            bean.setPwd(pwd);
            bean.setAddtime(new Date());
            bean.setNickName(nickName);
            bean.setRole(Integer.parseInt(role));
            bean.setStatus(1);

            int flag= userDao.insert(bean);
            if (flag>0) {
                res.setCode(HttpCodeEnum.SUCCESS.getCode());
                res.setMsg("添加成功");
            } else {
                res.setCode(HttpCodeEnum.ERROR.getCode());
                res.setMsg("添加失败");
            }
            return res;
        } catch (Exception e) {
            res.setCode(HttpCodeEnum.ERROR.getCode());
            res.setMsg("系统错误，请稍后重试");
            return res;
        }
    }




    public boolean ifAuth(HttpServletRequest request){
        String loginId = (String) request.getSession().getAttribute("loginId");
        if (StringUtils.isBlank(loginId))
            return false;
        try {
            long id = Long.valueOf(loginId);
            if (id<=0)
                return false;
            UserDo bean = userDao.select(id);
            if(bean != null && bean.getRole() < 3){
                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }


}
