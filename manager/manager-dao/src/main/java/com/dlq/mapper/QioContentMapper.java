package com.dlq.mapper;

import java.util.List;

import com.dlq.pojo.QioContent;
import com.dlq.pojo.QioContentExample;
import org.apache.ibatis.annotations.Param;

public interface QioContentMapper {
    int countByExample(QioContentExample example);

    int deleteByExample(QioContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(QioContent record);

    int insertSelective(QioContent record);

    List<QioContent> selectByExampleWithBLOBs(QioContentExample example);

    List<QioContent> selectByExample(QioContentExample example);

    QioContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") QioContent record, @Param("example") QioContentExample example);

    int updateByExampleWithBLOBs(@Param("record") QioContent record, @Param("example") QioContentExample example);

    int updateByExample(@Param("record") QioContent record, @Param("example") QioContentExample example);

    int updateByPrimaryKeySelective(QioContent record);

    int updateByPrimaryKeyWithBLOBs(QioContent record);

    int updateByPrimaryKey(QioContent record);
}
