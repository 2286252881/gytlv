package com.gytlv.base.baseEntity;

import java.util.Date;

public class TPhotos {
    private String id;

    private String photoname;

    private String photosrc;

    private String photodescription;

    private String userid;

    private String phonetypeid;

    private Date uploadtime;

    private String uploadip;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPhotoname() {
        return photoname;
    }

    public void setPhotoname(String photoname) {
        this.photoname = photoname == null ? null : photoname.trim();
    }

    public String getPhotosrc() {
        return photosrc;
    }

    public void setPhotosrc(String photosrc) {
        this.photosrc = photosrc == null ? null : photosrc.trim();
    }

    public String getPhotodescription() {
        return photodescription;
    }

    public void setPhotodescription(String photodescription) {
        this.photodescription = photodescription == null ? null : photodescription.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getPhonetypeid() {
        return phonetypeid;
    }

    public void setPhonetypeid(String phonetypeid) {
        this.phonetypeid = phonetypeid == null ? null : phonetypeid.trim();
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getUploadip() {
        return uploadip;
    }

    public void setUploadip(String uploadip) {
        this.uploadip = uploadip == null ? null : uploadip.trim();
    }
}