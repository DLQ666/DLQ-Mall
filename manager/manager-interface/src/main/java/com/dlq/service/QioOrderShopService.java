package com.dlq.service;

import com.dlq.pojo.QioOrderItem;
import com.dlq.pojo.QioOrderShop;

import java.util.List;


public interface QioOrderShopService {
	
	public List<QioOrderShop> seekOrder();
	
	public int seekOrderSum();
	
	public QioOrderShop findorder(String id);
	
	public List<QioOrderItem> seekOrderItem();
	
	public QioOrderItem findorderitem(String id);

}
