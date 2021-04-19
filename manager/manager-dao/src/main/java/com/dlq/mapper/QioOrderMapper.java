package com.dlq.mapper;

import java.util.List;

import com.dlq.pojo.QioOrder;
import com.dlq.pojo.QioOrderExample;
import org.apache.ibatis.annotations.Param;

public interface QioOrderMapper {
    int countByExample(QioOrderExample example);

    int deleteByExample(QioOrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(QioOrder record);

    int insertSelective(QioOrder record);

    List<QioOrder> selectByExample(QioOrderExample example);

    QioOrder selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") QioOrder record, @Param("example") QioOrderExample example);

    int updateByExample(@Param("record") QioOrder record, @Param("example") QioOrderExample example);

    int updateByPrimaryKeySelective(QioOrder record);

    int updateByPrimaryKey(QioOrder record);
    
}
