package com.lzh.sharenote.service;

import com.lzh.sharenote.dal.dao.NoteDao;
import com.lzh.sharenote.dal.pojo.NoteDo;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Lu Zhaohui on 2017/7/6.
 */
@Repository
public class NoteService {

    @Autowired
    NoteDao noteDao;

    public List<NoteDo> listRecentNote(long uid,int offset, int count) {
        List<NoteDo> noteDoList = noteDao.listByUserId(uid, offset, count);
        return  noteDoList;
    }

    public List<NoteDo> listNoteBetweenDate(Date startDate, Date endDate, int count) {
        List<NoteDo> noteDoList = noteDao.selectBetweenDate(startDate, endDate, 0, count);
        return  noteDoList;
    }
}
