package com.lzh.sharenote.dal.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lzh.sharenote.enums.NoteStatusEnum;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.lzh.sharenote.dal.pojo.NoteDo;

/**
 * Created by luzhaohui on 2017/6/24.
 */
@Repository("noteDao")
public class NoteDao extends AbstractBaseDao {
   
    public long insert(NoteDo note) throws Exception {
        SqlSession session = sqlSessionFactory.openSession(true);
        try {
            session.insert("noteMapper.insert",note);
        }finally {
            session.commit();
            session.close();
        }
        return note.getId();
    }

   
    public int update(NoteDo note) throws Exception {
        SqlSession session = sqlSessionFactory.openSession(true);
        int flag = 0;
        try {
            flag = session.update("noteMapper.updateById",note);
        }finally {
            session.commit();
            session.close();
        }
        return flag;
    }

    public NoteDo select(long id) throws Exception {
        Map idMap = new HashMap();
        idMap.put("id",id);
        SqlSession session = sqlSessionFactory.openSession(true);
        NoteDo beanList;
        try {
            beanList = session.selectOne("noteMapper.selectById",idMap);
        }finally {
            session.commit();
            session.close();
        }
        return beanList;
    }

    public List<NoteDo> selectByUserId(long userId) throws Exception {
        Map idMap = new HashMap();
        idMap.put("userId",userId);
        SqlSession session = sqlSessionFactory.openSession(true);
        List<NoteDo> beanList;
        try {
            beanList = session.selectList("noteMapper.selectByUserId",idMap);
        }finally {
            session.commit();
            session.close();
        }
        return beanList;
    }

    public int deleteByNoteId(long noteId) throws Exception {
        Map idMap = new HashMap();
        idMap.put("noteId",noteId);
        idMap.put("status", NoteStatusEnum.DELETE.getCode());
        SqlSession session = sqlSessionFactory.openSession(true);
        int flag = 0;
        try {
            flag = session.delete("noteMapper.updateStatusByNoteId",idMap);
        }finally {
            session.commit();
            session.close();
        }
        return flag;
    }
}
