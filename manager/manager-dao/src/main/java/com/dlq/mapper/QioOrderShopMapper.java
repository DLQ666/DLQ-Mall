package com.dlq.mapper;

import java.util.List;

import com.dlq.pojo.QioOrderShop;
import com.dlq.pojo.QioOrderShopExample;
import org.apache.ibatis.annotations.Param;

public interface QioOrderShopMapper {
    int countByExample(QioOrderShopExample example);

    int deleteByExample(QioOrderShopExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(QioOrderShop record);

    int insertSelective(QioOrderShop record);

    List<QioOrderShop> selectByExample(QioOrderShopExample example);

    QioOrderShop selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") QioOrderShop record, @Param("example") QioOrderShopExample example);

    int updateByExample(@Param("record") QioOrderShop record, @Param("example") QioOrderShopExample example);

    int updateByPrimaryKeySelective(QioOrderShop record);

    int updateByPrimaryKey(QioOrderShop record);
    
    List<String> selectByMobile(@Param("mobile")String mobile);
}
