package com.gytlv.base.baseEntity;

import java.util.Date;

public class TComment {
    private String id;

    private String touserid;

    private String comuserid;

    private String articleid;

    private Date commenttime;

    private String commentip;

    private String commentcontent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTouserid() {
        return touserid;
    }

    public void setTouserid(String touserid) {
        this.touserid = touserid == null ? null : touserid.trim();
    }

    public String getComuserid() {
        return comuserid;
    }

    public void setComuserid(String comuserid) {
        this.comuserid = comuserid == null ? null : comuserid.trim();
    }

    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid == null ? null : articleid.trim();
    }

    public Date getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(Date commenttime) {
        this.commenttime = commenttime;
    }

    public String getCommentip() {
        return commentip;
    }

    public void setCommentip(String commentip) {
        this.commentip = commentip == null ? null : commentip.trim();
    }

    public String getCommentcontent() {
        return commentcontent;
    }

    public void setCommentcontent(String commentcontent) {
        this.commentcontent = commentcontent == null ? null : commentcontent.trim();
    }
}