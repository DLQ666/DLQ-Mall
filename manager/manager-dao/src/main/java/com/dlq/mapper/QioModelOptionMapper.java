package com.dlq.mapper;

import java.util.List;

import com.dlq.pojo.QioModelOption;
import com.dlq.pojo.QioModelOptionExample;
import org.apache.ibatis.annotations.Param;

public interface QioModelOptionMapper {
    int countByExample(QioModelOptionExample example);

    int deleteByExample(QioModelOptionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QioModelOption record);

    int insertSelective(QioModelOption record);

    List<QioModelOption> selectByExample(QioModelOptionExample example);

    QioModelOption selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QioModelOption record, @Param("example") QioModelOptionExample example);

    int updateByExample(@Param("record") QioModelOption record, @Param("example") QioModelOptionExample example);

    int updateByPrimaryKeySelective(QioModelOption record);

    int updateByPrimaryKey(QioModelOption record);
}
