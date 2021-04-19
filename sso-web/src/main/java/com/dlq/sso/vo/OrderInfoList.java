package com.dlq.sso.vo;

import java.util.List;

import com.dlq.pojo.QioOrderItem;

public class OrderInfoList {
	
	private String orderId;
	
	private List<QioOrderItem> items;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public List<QioOrderItem> getItems() {
		return items;
	}

	public void setItems(List<QioOrderItem> items) {
		this.items = items;
	}

	
}
