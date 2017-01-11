package com.gytlv.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gytlv.base.baseEntity.TArticletype;
import com.gytlv.extendEntity.Custarticletype;

public interface ICustomArticleTypeMapper {
	/**
	 * 判断文章分类是否存在
	 * @param articletypename
	 * @return
	 */
	public TArticletype getArticleType(@Param("articletypename")String articletypename,@Param("userid")String userid);
	
	/**
	 * 添加文章分类
	 * @param articletype
	 */
	public void addArticleType(@Param("articletype") TArticletype articletype);
	/**
	 * 获取登录用户的文章分类信息
	 * @param userid
	 * @return
	 */
	public List<TArticletype> getAllArticleTypeByuserId(@Param("userid")String userid);
	/**
	 * 获取所有文章类型并包含该分类下面的文章数目
	 * @param id
	 * @return
	 */
	public List<Custarticletype> getAllArticleTypesByuserId(String id);
}
