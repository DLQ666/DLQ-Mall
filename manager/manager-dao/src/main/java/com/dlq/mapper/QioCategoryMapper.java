package com.dlq.mapper;

import java.util.List;

import com.dlq.pojo.QioCategory;
import com.dlq.pojo.QioCategoryExample;
import org.apache.ibatis.annotations.Param;

public interface QioCategoryMapper {
    int countByExample(QioCategoryExample example);

    int deleteByExample(QioCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QioCategory record);

    int insertSelective(QioCategory record);

    List<QioCategory> selectByExample(QioCategoryExample example);

    QioCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QioCategory record, @Param("example") QioCategoryExample example);

    int updateByExample(@Param("record") QioCategory record, @Param("example") QioCategoryExample example);

    int updateByPrimaryKeySelective(QioCategory record);

    int updateByPrimaryKey(QioCategory record);
}
