package com.gytlv.extendEntity;
/***
 * 查看文章详情和统计文章阅读量用达到的实体类
 * @author Administrator
 *
 */
public class CustomAboutArticle {
	private String userid;
	private String articleid;
	private String articletypeid;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getArticleid() {
		return articleid;
	}
	public void setArticleid(String articleid) {
		this.articleid = articleid;
	}
	public String getArticletypeid() {
		return articletypeid;
	}
	public void setArticletypeid(String articletypeid) {
		this.articletypeid = articletypeid;
	}
}
