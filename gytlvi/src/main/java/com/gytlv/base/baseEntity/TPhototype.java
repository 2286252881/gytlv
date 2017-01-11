package com.gytlv.base.baseEntity;

public class TPhototype {
    private String id;

    private String userid;

    private String phonetypename;

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

    public String getPhonetypename() {
        return phonetypename;
    }

    public void setPhonetypename(String phonetypename) {
        this.phonetypename = phonetypename == null ? null : phonetypename.trim();
    }
}