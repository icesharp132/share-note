package com.lzh.sharenote.dal.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by icesharp on 2017/6/24.
 */
public abstract class AbstractBaseDao {

    @Autowired
    SqlSessionFactory sqlSessionFactory;
}
