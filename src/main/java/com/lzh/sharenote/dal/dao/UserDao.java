package com.lzh.sharenote.dal.dao;

import com.lzh.sharenote.dal.pojo.UserDo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by luzhaohui on 2017/6/24.
 */
@Repository("userDao")
public class UserDao extends AbstractBaseDao {
   
    public int insert(UserDo user) throws Exception {
        try {
            session.insert("userMapper.insert",user);
        }finally {
            session.commit();
            session.close();
        }
        return (int)user.getId();
    }

   
    public int update(UserDo user) throws Exception {
        int flag = 0;
        try {
            flag = session.update("userMapper.updateById",user);
        }finally {
            session.commit();
            session.close();
        }
        return flag;
    }

   
    public UserDo select(long id) throws Exception {
        Map idMap = new HashMap();
        idMap.put("id",id);
        List<UserDo> beanList;
        try {
            beanList = session.selectList("userMapper.selectUserById",idMap);
        }finally {
            session.commit();
            session.close();
        }
        return beanList.get(0);
    }

   
    public int delete(long id) throws Exception {
        Map idMap = new HashMap();
        idMap.put("id",id);
        int flag = 0;
        try {
            flag = session.delete("userMapper.deleteUserById",idMap);
        }finally {
            session.commit();
            session.close();
        }
        return flag;
    }

    
    public UserDo selectUserByUnameAndPwd(String uname, String pwd) throws Exception {
        Map idMap = new HashMap();
        idMap.put("pwd",pwd);
        idMap.put("uname",uname);
        List<UserDo> beanList;
        try {
            beanList = session.selectList("userMapper.selectUserByUnameAndPwd",idMap);
        }finally {
            session.commit();
            session.close();
        }
        if (beanList==null || beanList.size()<=0)
            return null;
        return beanList.get(0);
    }

   
    public UserDo selectUserByUname(String uname) throws Exception {
        Map idMap = new HashMap();
        idMap.put("uname",uname);
        List<UserDo> beanList;
        try {
            beanList = session.selectList("userMapper.selectUserByUname",idMap);
        }finally {
            session.commit();
            session.close();
        }
        if (beanList==null || beanList.size()<=0)
            return null;
        return beanList.get(0);
    }
}
