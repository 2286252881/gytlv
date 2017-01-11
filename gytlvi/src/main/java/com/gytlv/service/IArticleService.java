package com.gytlv.service;

import java.util.List;

import com.gytlv.base.baseEntity.TArticle;
import com.gytlv.base.baseEntity.TArticlevisitor;
import com.gytlv.extendEntity.CustomArticle;
import com.process.result.LayPageResultInfo;

public interface IArticleService {
	/**
	 * 添加文章
	 * @param article
	 * @throws Exception
	 */
	public void addArticle(TArticle article,String userId)throws Exception;
	/**
	 * 后台查询所有文章列表
	 * @return
	 * @throws Exception
	 */
	public List<TArticle> getAllArticle(TArticle article)throws Exception;
	/**
	 * 查询总条数
	 * @param userid
	 * @return
	 */
	public Integer finAllArticleCount(TArticle article)throws Exception;
	/**
	 * 根据id获取文章详细信息
	 * @param id
	 */
	public TArticle getArticleById(String id)throws Exception;
	/**
	 * 编辑文章
	 * @param article
	 * @throws Exception
	 */
	public void doEditArticle(TArticle article)throws Exception;
	/**
	 * 删除文章
	 * @param id
	 * @throws Exception
	 */
	public int delArticle(TArticle article)throws Exception;
	/**
	 * 公共首页显示博主推荐前十(按时间排行)
	 * @return
	 */
	public List<CustomArticle> getSupportTopTen()throws Exception;
	
	
	/**
	 * 公共页面读取文章
	 * @param userid
	 * @param articleid
	 * @param articletypeid
	 * @return
	 */
	public CustomArticle getArticleByuserIdandArticleIdandArticletypeId(String userid, String articleid,String articletypeid)throws Exception;
	
	/**
	 * 判断访客是否访问过
	 * @param articlevisitor
	 * @return
	 * @throws Exception
	 */
	public int editArticleClickBy(TArticlevisitor articlevisitor)throws Exception;
	/**
	 * 公共页面根据文章类型id和用户userid查询分页文章
	 * @param article
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public LayPageResultInfo<CustomArticle> getPublicAllArticleByArticle(TArticle article)throws Exception;
	
	/**
	 * 查询最新的前10条文章
	 * @return
	 */
	public List<CustomArticle> getNewsTopTen()throws Exception;	
	/**
	 * 查询点击前5排名文章
	 * @return
	 * @throws Exception
	 */
	public List<CustomArticle> getClicksTopTen()throws Exception;	
}
