package com.dlq.mapper;

import java.util.List;

import com.dlq.pojo.QioModel;
import com.dlq.pojo.QioModelExample;
import org.apache.ibatis.annotations.Param;

public interface QioModelMapper {
    int countByExample(QioModelExample example);

    int deleteByExample(QioModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QioModel record);

    int insertSelective(QioModel record);

    List<QioModel> selectByExample(QioModelExample example);

    QioModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QioModel record, @Param("example") QioModelExample example);

    int updateByExample(@Param("record") QioModel record, @Param("example") QioModelExample example);

    int updateByPrimaryKeySelective(QioModel record);

    int updateByPrimaryKey(QioModel record);
}
