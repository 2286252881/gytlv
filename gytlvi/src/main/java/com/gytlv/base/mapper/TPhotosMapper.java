package com.gytlv.base.mapper;

import com.gytlv.base.baseEntity.TPhotos;
import com.gytlv.base.baseEntity.TPhotosExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPhotosMapper {
    int countByExample(TPhotosExample example);

    int deleteByExample(TPhotosExample example);

    int insert(TPhotos record);

    int insertSelective(TPhotos record);

    List<TPhotos> selectByExample(TPhotosExample example);

    int updateByExampleSelective(@Param("record") TPhotos record, @Param("example") TPhotosExample example);

    int updateByExample(@Param("record") TPhotos record, @Param("example") TPhotosExample example);
}