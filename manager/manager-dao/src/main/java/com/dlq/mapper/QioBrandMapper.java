package com.dlq.mapper;

import java.util.List;

import com.dlq.pojo.QioBrand;
import com.dlq.pojo.QioBrandExample;
import org.apache.ibatis.annotations.Param;

public interface QioBrandMapper {
    int countByExample(QioBrandExample example);

    int deleteByExample(QioBrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QioBrand record);

    int insertSelective(QioBrand record);

    List<QioBrand> selectByExample(QioBrandExample example);

    QioBrand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QioBrand record, @Param("example") QioBrandExample example);

    int updateByExample(@Param("record") QioBrand record, @Param("example") QioBrandExample example);

    int updateByPrimaryKeySelective(QioBrand record);

    int updateByPrimaryKey(QioBrand record);
}
