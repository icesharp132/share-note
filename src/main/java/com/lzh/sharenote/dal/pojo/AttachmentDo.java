package com.lzh.sharenote.dal.pojo;

import java.util.Date;

/**
 * Created by luzhoahui on 2017/6/24.
 */
public class AttachmentDo {
    private long id;

    private String noteId;

    private String title;

    private String description;

    private String file_uri;

    private int status;

    private Date addtime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFile_uri() {
        return file_uri;
    }

    public void setFile_uri(String file_uri) {
        this.file_uri = file_uri;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
}
