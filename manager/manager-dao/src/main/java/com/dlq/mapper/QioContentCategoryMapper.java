package com.dlq.mapper;

import java.util.List;

import com.dlq.pojo.QioContentCategory;
import com.dlq.pojo.QioContentCategoryExample;
import org.apache.ibatis.annotations.Param;

public interface QioContentCategoryMapper {
    int countByExample(QioContentCategoryExample example);

    int deleteByExample(QioContentCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(QioContentCategory record);

    int insertSelective(QioContentCategory record);

    List<QioContentCategory> selectByExample(QioContentCategoryExample example);

    QioContentCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") QioContentCategory record, @Param("example") QioContentCategoryExample example);

    int updateByExample(@Param("record") QioContentCategory record, @Param("example") QioContentCategoryExample example);

    int updateByPrimaryKeySelective(QioContentCategory record);

    int updateByPrimaryKey(QioContentCategory record);
}
