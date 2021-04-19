package com.dlq.mapper;

import java.util.List;

import com.dlq.pojo.QioItem;
import com.dlq.pojo.QioItemExample;
import org.apache.ibatis.annotations.Param;

public interface QioItemMapper {
    int countByExample(QioItemExample example);

    int deleteByExample(QioItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(QioItem record);

    int insertSelective(QioItem record);

    List<QioItem> selectByExample(QioItemExample example);

    QioItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") QioItem record, @Param("example") QioItemExample example);

    int updateByExample(@Param("record") QioItem record, @Param("example") QioItemExample example);

    int updateByPrimaryKeySelective(QioItem record);

    int updateByPrimaryKey(QioItem record);
}
