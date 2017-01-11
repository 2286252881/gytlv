package com.gytlv.base.mapper;

import com.gytlv.base.baseEntity.TMenu;
import com.gytlv.base.baseEntity.TMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMenuMapper {
    int countByExample(TMenuExample example);

    int deleteByExample(TMenuExample example);

    int deleteByPrimaryKey(String id);

    int insert(TMenu record);

    int insertSelective(TMenu record);

    List<TMenu> selectByExample(TMenuExample example);

    TMenu selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TMenu record, @Param("example") TMenuExample example);

    int updateByExample(@Param("record") TMenu record, @Param("example") TMenuExample example);

    int updateByPrimaryKeySelective(TMenu record);

    int updateByPrimaryKey(TMenu record);
}