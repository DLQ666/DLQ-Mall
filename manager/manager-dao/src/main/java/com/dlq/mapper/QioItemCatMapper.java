package com.dlq.mapper;

import java.util.List;

import com.dlq.pojo.QioItemCat;
import com.dlq.pojo.QioItemCatExample;
import org.apache.ibatis.annotations.Param;

public interface QioItemCatMapper {
    int countByExample(QioItemCatExample example);

    int deleteByExample(QioItemCatExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QioItemCat record);

    int insertSelective(QioItemCat record);

    List<QioItemCat> selectByExample(QioItemCatExample example);

    QioItemCat selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QioItemCat record, @Param("example") QioItemCatExample example);

    int updateByExample(@Param("record") QioItemCat record, @Param("example") QioItemCatExample example);

    int updateByPrimaryKeySelective(QioItemCat record);

    int updateByPrimaryKey(QioItemCat record);
}
