package com.dlq.service.impl;

import java.util.List;

import com.dlq.mapper.QioOrderItemMapper;
import com.dlq.mapper.QioOrderShopMapper;
import com.dlq.pojo.QioOrderItem;
import com.dlq.pojo.QioOrderShop;
import com.dlq.service.QioOrderShopService;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

@Service
public class QioOrderShopServiceImpl implements QioOrderShopService {

	@Autowired
	private QioOrderShopMapper qioShopMapper;
	
	@Autowired
	private QioOrderItemMapper qioOrderItemMapper;
	
	@Override
	public List<QioOrderShop> seekOrder() {
		List<QioOrderShop> list = qioShopMapper.selectByExample(null);
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public int seekOrderSum() {
		int orderSum = qioShopMapper.countByExample(null);
		// TODO Auto-generated method stub
		return orderSum;
	}

	@Override
	public QioOrderShop findorder(String id) {
		QioOrderShop qioOrderShop = qioShopMapper.selectByPrimaryKey(id);
		// TODO Auto-generated method stub
		return qioOrderShop;
	}

	@Override
	public List<QioOrderItem> seekOrderItem() {
		List<QioOrderItem> oderitemlist = qioOrderItemMapper.selectByExample(null);
		// TODO Auto-generated method stub
		return oderitemlist;
	}

	@Override
	public QioOrderItem findorderitem(String id) {
		QioOrderItem qioOrderItem = qioOrderItemMapper.selectByPrimaryKey(id);
		// TODO Auto-generated method stub
		return qioOrderItem;
	}


}
