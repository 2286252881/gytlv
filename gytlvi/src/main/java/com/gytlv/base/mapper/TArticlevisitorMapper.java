package com.gytlv.base.mapper;

import com.gytlv.base.baseEntity.TArticlevisitor;
import com.gytlv.base.baseEntity.TArticlevisitorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TArticlevisitorMapper {
    int countByExample(TArticlevisitorExample example);

    int deleteByExample(TArticlevisitorExample example);

    int deleteByPrimaryKey(String id);

    int insert(TArticlevisitor record);

    int insertSelective(TArticlevisitor record);

    List<TArticlevisitor> selectByExample(TArticlevisitorExample example);

    TArticlevisitor selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TArticlevisitor record, @Param("example") TArticlevisitorExample example);

    int updateByExample(@Param("record") TArticlevisitor record, @Param("example") TArticlevisitorExample example);

    int updateByPrimaryKeySelective(TArticlevisitor record);

    int updateByPrimaryKey(TArticlevisitor record);
}