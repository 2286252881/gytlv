package com.gytlv.base.baseEntity;

import java.io.Serializable;
import java.util.Date;

public class TArticle implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1911625463405161783L;

	private String id;

    private String articlename;

    private Date articletime;

    private String articleip;

    private Integer articleclick;

    private String articletype;

    private String userid;

    private String articlemodle;

    private String articlesupport;

    private String articlecontent;
    
    private int page=0;

    private int pageSize=5;
    
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getArticlename() {
        return articlename;
    }

    public void setArticlename(String articlename) {
        this.articlename = articlename == null ? null : articlename.trim();
    }

    public Date getArticletime() {
        return articletime;
    }

    public void setArticletime(Date articletime) {
        this.articletime = articletime;
    }

    public String getArticleip() {
        return articleip;
    }

    public void setArticleip(String articleip) {
        this.articleip = articleip == null ? null : articleip.trim();
    }

    public Integer getArticleclick() {
        return articleclick;
    }

    public void setArticleclick(Integer articleclick) {
        this.articleclick = articleclick;
    }

    public String getArticletype() {
        return articletype;
    }

    public void setArticletype(String articletype) {
        this.articletype = articletype == null ? null : articletype.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getArticlemodle() {
        return articlemodle;
    }

    public void setArticlemodle(String articlemodle) {
        this.articlemodle = articlemodle == null ? null : articlemodle.trim();
    }

    public String getArticlesupport() {
        return articlesupport;
    }

    public void setArticlesupport(String articlesupport) {
        this.articlesupport = articlesupport == null ? null : articlesupport.trim();
    }

    public String getArticlecontent() {
        return articlecontent;
    }

    public void setArticlecontent(String articlecontent) {
        this.articlecontent = articlecontent == null ? null : articlecontent.trim();
    }
}