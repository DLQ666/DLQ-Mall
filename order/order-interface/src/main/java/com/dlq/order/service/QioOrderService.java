package com.dlq.order.service;

import java.util.List;

import com.dlq.common.pojo.QIResult;
import com.dlq.order.pojo.OrderInfo;
import com.dlq.pojo.QioOrderItem;

public interface QioOrderService {

	QIResult createOrder(OrderInfo orderInfo);
	
	List<QioOrderItem> selectQioOrderItemByOrderId(String orderId);
	
	List<String> selectByMobile(String mobile);
	
	int deleteByPrimaryKey(String orderId);
	
	int deleteByOrderId(String orderId);
	
}
