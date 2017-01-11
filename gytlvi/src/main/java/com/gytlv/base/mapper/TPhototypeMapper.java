package com.gytlv.base.mapper;

import com.gytlv.base.baseEntity.TPhototype;
import com.gytlv.base.baseEntity.TPhototypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPhototypeMapper {
    int countByExample(TPhototypeExample example);

    int deleteByExample(TPhototypeExample example);

    int deleteByPrimaryKey(String id);

    int insert(TPhototype record);

    int insertSelective(TPhototype record);

    List<TPhototype> selectByExample(TPhototypeExample example);

    TPhototype selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TPhototype record, @Param("example") TPhototypeExample example);

    int updateByExample(@Param("record") TPhototype record, @Param("example") TPhototypeExample example);

    int updateByPrimaryKeySelective(TPhototype record);

    int updateByPrimaryKey(TPhototype record);
}