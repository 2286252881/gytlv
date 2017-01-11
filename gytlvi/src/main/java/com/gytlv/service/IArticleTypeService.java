package com.gytlv.service;

import java.util.List;

import com.gytlv.base.baseEntity.TArticletype;
import com.gytlv.extendEntity.Custarticletype;
import com.gytlv.extendEntity.CustomAboutArticle;

public interface IArticleTypeService {
	/**
	 * 判断文章分类是否存在
	 * @param articletypename,id
	 * @return
	 * @throws Exception
	 */
	public TArticletype getArticleType(String articletypename,String userid)throws Exception;
	/**
	 * 添加文章分类
	 * @param articletype
	 */
	public void addArticleType(TArticletype articletype)throws Exception;
	/**
	 * 查询登录用户的文章分类信息
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public List<TArticletype> getAllArticleTypeByuserId(String userid)throws Exception;
	/**
	 * 查询所有文章并包含该类下面的文章数目
	 * @param id
	 * @return
	 */
	public List<Custarticletype> getAllArticleTypesByuserId(String id)throws Exception;
	/**
	 * 根据articlename查询文章类型
	 * @param searchArticletype
	 * @return
	 * @throws Exception
	 */
	public TArticletype getAllArticleTypesByArticlename(String articlename)throws Exception;
	/**
	 * 根据id查询文章分类
	 * @param id
	 * @return
	 */
	public TArticletype getAllArticleTypesById(String id)throws Exception;
	/**
	 * 更改文章类型名称
	 * @param articletype_
	 * @return
	 */
	public int editArticleType(TArticletype articletype_)throws Exception;
	/**
	 * 删除文章类型
	 * @param id
	 * @return
	 */
	public void delArticleType(String id,String username)throws Exception;
	/**
	 * 根据用户userid和文章id获取该用户的所有分类
	 * @param aboutArticle
	 * @return
	 * @throws Exception
	 */
	public Custarticletype getArticleTypeArticleByIdandUserId(CustomAboutArticle aboutArticle)throws Exception;
}
