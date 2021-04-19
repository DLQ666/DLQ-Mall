package com.dlq.manager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dlq.pojo.QioOrderItem;
import com.dlq.pojo.QioOrderShop;
import com.dlq.service.QioOrderShopService;

@RestController
@RequestMapping("/order")
public class QioOrderShopController {
	
	@Reference
	private QioOrderShopService orderShopService;
	
	
	@RequestMapping("/seekOrderSum")
	public Map seekOrderSum(){
		int orderSum = orderShopService.seekOrderSum();
		Map map = new HashMap<>();
		map.put("ordernum", orderSum);
		return map;
	}
	
	
	@RequestMapping("/seekOrderAll")
	public List<QioOrderShop> seekOrderAll(){
		List<QioOrderShop> orderlist = orderShopService.seekOrder();
		return orderlist;
	}
	
	@RequestMapping("/findOrder")
	public QioOrderShop findOrder(String id){
		QioOrderShop findorder = orderShopService.findorder(id);
		return findorder;
	}
	
	@RequestMapping("/seekOrderItemAll")
	public List<QioOrderItem> seekOrderItemAll(){
		List<QioOrderItem> orderItemAll = orderShopService.seekOrderItem();
		return orderItemAll;
	}
	
	@RequestMapping("/findOrderItem")
	public QioOrderItem findOrderItem(String id){
		QioOrderItem findorderitem = orderShopService.findorderitem(id);
		return findorderitem;
	}
}
