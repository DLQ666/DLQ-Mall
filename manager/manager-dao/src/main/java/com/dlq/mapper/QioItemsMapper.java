package com.dlq.mapper;

import java.util.List;

import com.dlq.pojo.QioItems;
import com.dlq.pojo.QioItemsExample;
import org.apache.ibatis.annotations.Param;

public interface QioItemsMapper {
    int countByExample(QioItemsExample example);

    int deleteByExample(QioItemsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(QioItems record);

    int insertSelective(QioItems record);

    List<QioItems> selectByExample(QioItemsExample example);

    QioItems selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") QioItems record, @Param("example") QioItemsExample example);

    int updateByExample(@Param("record") QioItems record, @Param("example") QioItemsExample example);

    int updateByPrimaryKeySelective(QioItems record);

    int updateByPrimaryKey(QioItems record);
}
