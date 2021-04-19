package com.dlq.order.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.Md5Crypt;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.alibaba.dubbo.config.annotation.Service;
import com.dlq.common.pojo.QIResult;
import com.dlq.jedis.JedisClient;
import com.dlq.mapper.QioOrderItemMapper;
import com.dlq.mapper.QioOrderMapper;
import com.dlq.mapper.QioOrderShopMapper;
import com.dlq.order.pojo.OrderInfo;
import com.dlq.pojo.QioOrderItem;
import com.dlq.pojo.QioOrderShop;
import com.dlq.pojo.QioResult;


@Service
public class QioOrderService implements com.dlq.order.service.QioOrderService {

	@Value("${ORDER_ID_GEN_KEY}")
	private String ORDER_ID_GEN_KEY;
	
	@Value("${ORDER_ID_GEGIN_VALUE}")
	private String ORDER_ID_GEGIN_VALUE;
	
	@Value("${ORDER_ITEM_ID_GEN_KEY}")
	private String ORDER_ITEM_ID_GEN_KEY;
	
	@Autowired
	private QioOrderMapper orderMapper;
	
	@Autowired
	private QioOrderItemMapper orderItemMapper;
	
	@Autowired
	private QioOrderShopMapper orderShopMapper;
	
	@Autowired
	private JedisClient jedisClient;
	
	
	@Override
	public QIResult createOrder(OrderInfo orderInfo) {
		// 生成订单号
		if(!jedisClient.exists(ORDER_ID_GEN_KEY)){
			jedisClient.set(ORDER_ID_GEN_KEY, ORDER_ID_GEGIN_VALUE);
		}
		String orderId = jedisClient.incr(ORDER_ID_GEN_KEY).toString();
		//向订单表插入数据 补全pojo属性
		
		orderInfo.setOrderId(DateTime.now().toString("yyyyMMddHHmmss")+orderId);
		//免邮费
		orderInfo.setPostFee("0");
		//已付款
		orderInfo.setStatus(1);
		//补全时间
		orderInfo.setCreateTime(new Date());
		orderInfo.setUpdateTime(new Date());
		//想订单表插入数据
		orderMapper.insert(orderInfo);
		//想订单明细表插入数据
		List<QioOrderItem> orderItems = orderInfo.getOrderItems();
		
	
			
			for(QioOrderItem qioOrderItem : orderItems){
				//获得明细住建
				String oid = jedisClient.incr(ORDER_ITEM_ID_GEN_KEY).toString();
				qioOrderItem.setId(DateTime.now().toString("yyyyMMddHHmmss")+oid);
				qioOrderItem.setOrderId(orderInfo.getOrderId());
				//插入明细数据
				orderItemMapper.insert(qioOrderItem);
			}
			//向订单物流表插入数据
			
			QioOrderShop orderShipping = orderInfo.getOrderShipping();
			orderShipping.setOrderId(orderInfo.getOrderId());
			orderShipping.setCreated(new Date());
			orderShipping.setUpdated(new Date());

			orderShopMapper.insert(orderShipping);
			//返回订单号
			return QIResult.ok(orderInfo.getOrderId());
			
		
	}


	@Override
	public List<QioOrderItem> selectQioOrderItemByOrderId(String orderId) {
		List<QioOrderItem> qioOrderItems = orderItemMapper.selectQioOrderItemByOrderId(orderId);
		return qioOrderItems;
	}


	@Override
	public List<String> selectByMobile(String mobile) {
		List<String> orderIds = orderShopMapper.selectByMobile(mobile);
		return orderIds;
	}


	@Override
	public int deleteByPrimaryKey(String orderId) {
		orderShopMapper.deleteByPrimaryKey(orderId);
		return 0;
	}


	@Override
	public int deleteByOrderId(String orderId) {
		orderItemMapper.deleteByOrderId(orderId);
		return 0;
	}

}
