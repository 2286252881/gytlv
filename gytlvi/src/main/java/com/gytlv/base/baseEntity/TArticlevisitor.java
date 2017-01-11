package com.gytlv.base.baseEntity;

import java.util.Date;

public class TArticlevisitor {
    private String id;

    private String userid;

    private String visitorname;

    private String visitorip;

    private Date visitortime;

    private String visitoruserid;

    private String visitorarticleid;

    private String visitorarticletypeid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getVisitorname() {
        return visitorname;
    }

    public void setVisitorname(String visitorname) {
        this.visitorname = visitorname == null ? null : visitorname.trim();
    }

    public String getVisitorip() {
        return visitorip;
    }

    public void setVisitorip(String visitorip) {
        this.visitorip = visitorip == null ? null : visitorip.trim();
    }

    public Date getVisitortime() {
        return visitortime;
    }

    public void setVisitortime(Date visitortime) {
        this.visitortime = visitortime;
    }

    public String getVisitoruserid() {
        return visitoruserid;
    }

    public void setVisitoruserid(String visitoruserid) {
        this.visitoruserid = visitoruserid == null ? null : visitoruserid.trim();
    }

    public String getVisitorarticleid() {
        return visitorarticleid;
    }

    public void setVisitorarticleid(String visitorarticleid) {
        this.visitorarticleid = visitorarticleid == null ? null : visitorarticleid.trim();
    }

    public String getVisitorarticletypeid() {
        return visitorarticletypeid;
    }

    public void setVisitorarticletypeid(String visitorarticletypeid) {
        this.visitorarticletypeid = visitorarticletypeid == null ? null : visitorarticletypeid.trim();
    }
}