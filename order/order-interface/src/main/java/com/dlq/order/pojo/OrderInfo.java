package com.dlq.order.pojo;

import java.io.Serializable;
import java.util.List;

import com.dlq.pojo.QioOrder;
import com.dlq.pojo.QioOrderItem;
import com.dlq.pojo.QioOrderShop;

public class OrderInfo extends QioOrder implements Serializable{
	
	private List<QioOrderItem> orderItems;
	private QioOrderShop orderShipping;
	public List<QioOrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<QioOrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public QioOrderShop getOrderShipping() {
		return orderShipping;
	}
	public void setOrderShipping(QioOrderShop orderShipping) {
		this.orderShipping = orderShipping;
	}

}
