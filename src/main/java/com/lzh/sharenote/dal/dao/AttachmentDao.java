package com.lzh.sharenote.dal.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.lzh.sharenote.dal.pojo.AttachmentDo;
import com.lzh.sharenote.enums.NoteStatusEnum;

/**
 * Created by luzhaohui on 2017/6/24.
 */
@Repository("attachmentDao")
public class AttachmentDao extends AbstractBaseDao {
   
    public long insert(AttachmentDo note) throws Exception {
        try {
            session.insert("attachmentMapper.insert",note);
        }finally {
            session.commit();
            session.close();
        }
        return note.getId();
    }

   
    public int update(AttachmentDo attachmentDo) throws Exception {
        int flag = 0;
        try {
            flag = session.update("attachmentMapper.updateById",attachmentDo);
        }finally {
            session.commit();
            session.close();
        }
        return flag;
    }

    public AttachmentDo select(long id) throws Exception {
        Map idMap = new HashMap();
        idMap.put("id",id);
        AttachmentDo beanList;
        try {
            beanList = session.selectOne("attachmentMapper.selectById",idMap);
        }finally {
            session.commit();
            session.close();
        }
        return beanList;
    }

    public List<AttachmentDo> selectByNoteId(long noteId) throws Exception {
        Map idMap = new HashMap();
        idMap.put("noteId",noteId);
        List<AttachmentDo> beanList;
        try {
            beanList = session.selectList("attachmentMapper.selectByNoteId",idMap);
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
        int flag = 0;
        try {
            flag = session.delete("attachmentMapper.updateStatusByNoteId",idMap);
        }finally {
            session.commit();
            session.close();
        }
        return flag;
    }
}
