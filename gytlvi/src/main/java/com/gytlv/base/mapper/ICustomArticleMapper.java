package com.gytlv.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gytlv.base.baseEntity.TArticle;
import com.gytlv.extendEntity.CustomArticle;

public interface ICustomArticleMapper {
	/**
	 * 后台查询带分页的条数
	 * 
	 * @return
	 */
	public List<TArticle> finAllArticle(@Param("article") TArticle article);

	/**
	 * 后台查询所有文章列表总数
	 * 
	 * @param userid
	 * @param page
	 * @return
	 */
	public Integer finAllArticleCount(@Param("article") TArticle article);

	/**
	 * 根据文章id查询文章信息
	 * 
	 * @param id
	 */
	public TArticle getArticleById(@Param("id") String id);

	/**
	 * 修改文章
	 * 
	 * @param article
	 */
	public void doEditArticle(@Param("article") TArticle article);

	/**
	 * 根据文章分类类型查询该分类下的所有文章
	 * 
	 * @param articleType
	 * @return
	 */
	public List<TArticle> findArticlesByArticleType(@Param("articleType") String articleType);

	/**
	 * 公共查询博主推荐的前十名文章(按时间排行)
	 * 
	 * @return
	 */
	public List<CustomArticle> getSupportTopTen();

	/**
	 * 公共查询文章明细
	 * 
	 * @param userid
	 * @param articleid
	 * @param articletypeid
	 * @return
	 * @throws Exception
	 */
	public CustomArticle getArticleByuserIdandArticleIdandArticletypeId(@Param("userid") String userid, @Param("articleid") String articleid, @Param("articletypeid") String articletypeid) throws Exception;

	/**
	 * 查询最新的前10条文章
	 * 
	 * @return
	 */
	public List<CustomArticle> getNewsTopTen();

	/**
	 * 查询点击前5排名文章
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<CustomArticle> getClicksTopTen();

}
