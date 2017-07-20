package com.lzh.sharenote.dal.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by icesharp on 2017/6/24.
 */
public abstract class AbstractBaseDao {

    @Autowired
    @Qualifier("sqlSession")
    SqlSession session;

}
