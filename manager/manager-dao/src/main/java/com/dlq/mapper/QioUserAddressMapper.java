package com.dlq.mapper;


import com.dlq.pojo.QioUserAddress;

public interface QioUserAddressMapper {

	QioUserAddress selectByPrimaryKey(Integer id);
    int insert(QioUserAddress record);
    int updateByPrimaryKey(QioUserAddress record);
}
