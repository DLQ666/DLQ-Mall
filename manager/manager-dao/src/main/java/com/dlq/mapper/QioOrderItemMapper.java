package com.dlq.mapper;

import java.util.List;

import com.dlq.pojo.QioOrderItem;
import com.dlq.pojo.QioOrderItemExample;
import org.apache.ibatis.annotations.Param;

public interface QioOrderItemMapper {
    int countByExample(QioOrderItemExample example);

    int deleteByExample(QioOrderItemExample example);

    int deleteByPrimaryKey(String id);

    int insert(QioOrderItem record);

    int insertSelective(QioOrderItem record);

    List<QioOrderItem> selectByExample(QioOrderItemExample example);

    QioOrderItem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") QioOrderItem record, @Param("example") QioOrderItemExample example);

    int updateByExample(@Param("record") QioOrderItem record, @Param("example") QioOrderItemExample example);

    int updateByPrimaryKeySelective(QioOrderItem record);

    int updateByPrimaryKey(QioOrderItem record);
    
    List<QioOrderItem> selectQioOrderItemByOrderId(@Param("orderId")String orderId);
    
    int deleteByOrderId(@Param("orderId")String orderId);
}
