package com.lzh.sharenote.dal.dao;

import java.util.Date;
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
   
    public long insert(NoteDo note) {
        try {
            session.insert("noteMapper.insert",note);
        }finally {
            session.commit();
            session.close();
        }
        return note.getId();
    }

   
    public int update(NoteDo note) {
        int flag = session.update("noteMapper.updateById",note);
        return flag;
    }

    public NoteDo select(long id) {
        Map idMap = new HashMap();
        idMap.put("id",id);
        NoteDo beanList = session.selectOne("noteMapper.selectById",idMap);
        return beanList;
    }

    public List<NoteDo> listByUserId(long userId, int offset, int size) {
        Map idMap = new HashMap();
        idMap.put("userId",userId);
        idMap.put("offset",offset);
        idMap.put("size",size);
        List<NoteDo> beanList = session.selectList("noteMapper.listByUserId",idMap);
        return beanList;
    }

    public List<NoteDo> selectBetweenDate(Date starttime, Date endtime, int offset, int size) {
        Map idMap = new HashMap();
        idMap.put("starttime",starttime);
        idMap.put("endtime",endtime);
        idMap.put("offset",offset);
        idMap.put("size",size);
        List<NoteDo> beanList;
        beanList = session.selectList("noteMapper.selectByUserId",idMap);
        return beanList;
    }

    public int deleteByNoteId(long noteId) {
        Map idMap = new HashMap();
        idMap.put("noteId",noteId);
        idMap.put("status", NoteStatusEnum.DELETE.getCode());
        int flag = session.delete("noteMapper.updateStatusByNoteId",idMap);
        return flag;
    }
}
