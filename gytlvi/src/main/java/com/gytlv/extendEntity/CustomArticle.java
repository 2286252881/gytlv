package com.gytlv.extendEntity;

import java.util.ArrayList;
import java.util.List;

import com.gytlv.base.baseEntity.TArticle;

@SuppressWarnings("serial")
public class CustomArticle extends TArticle {
	private String username;
	private String articleTypename;
	private List<String> imgs=new ArrayList<String>();
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getArticleTypename() {
		return articleTypename;
	}
	public void setArticleTypename(String articleTypename) {
		this.articleTypename = articleTypename;
	}
	public List<String> getImgs() {
		return imgs;
	}
	public void setImgs(List<String> imgs) {
		this.imgs = imgs;
	}
}
