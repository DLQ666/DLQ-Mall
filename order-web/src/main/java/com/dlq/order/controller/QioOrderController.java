package com.dlq.order.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dlq.common.pojo.QIResult;
import com.dlq.common.util.CookieUtils;
import com.dlq.common.util.JsonUtils;
import com.dlq.order.pojo.OrderInfo;
import com.dlq.order.service.QioOrderService;
import com.dlq.pojo.QioItems;
import com.dlq.pojo.QioOrderItem;
import com.dlq.pojo.QioOrderShop;
import com.dlq.pojo.QioResult;
import com.dlq.pojo.QioUser;
import com.dlq.pojo.QioUserAddress;
import com.dlq.sso.service.QioUserService;

@Controller
public class QioOrderController {

	
	@Value("${CART_KEY}")
	private String CART_KEY;
	@Value("${TOKEN_KEY}")
	private String TOKEN_KEY;
	
	@Reference
	private QioOrderService qioOrderService;
	@Reference
	private QioUserService qioUserService;
	
	
	@RequestMapping("/order/order-cart")
	public String showOrderCart(HttpServletRequest request,Model model){
		//应该用户必须登录状态
		String token = CookieUtils.getCookieValue(request, TOKEN_KEY);
		QIResult result = qioUserService.getUserByToken(token);
		QioUser user = (QioUser) result.getData();
		Integer id = user.getId();
		String mobile = user.getCustcall();
		QioUserAddress userAddress = qioUserService.selectByPrimaryKey(id);
		
		System.out.println(mobile);
		//取用户id
		//收货地址列表取出来传递给页面
		//从cookie中取购物车商品列表展示到页面
		List<QioItems> cartItemList = getCartItemList(request);
		//返回页面
		request.setAttribute("cartList", cartItemList);
		request.setAttribute("userAddress", userAddress);
		request.setAttribute("userInfo", user);
//		request.setAttribute("userAddressInfo", );
		return "order-cart";
		
	}
	
	private List<QioItems> getCartItemList(HttpServletRequest request){
		//从cookie中取购物车商品列表
		String cookieValuejson = CookieUtils.getCookieValue(request, CART_KEY, true);
		
		if(StringUtils.isBlank(cookieValuejson)){
			//如果没有值，返回一个空的列表
			return new ArrayList<>();
			//return (List<QioItems>) new QioResult(true, "请选择商品添加到购物车！！");
		}
		
		List<QioItems> jsonToList = JsonUtils.jsonToList(cookieValuejson, QioItems.class);
		return jsonToList;
	}
	
	
	//生成订单
	@RequestMapping(value="/order/create",method=RequestMethod.POST)
	public String createOrder(OrderInfo orderInfo,HttpServletRequest request,HttpServletResponse response ,Model model){
		//生成订单
		QIResult createOrder = qioOrderService.createOrder(orderInfo);
		//返回视图
		model.addAttribute("orderId",createOrder.getData().toString());
		model.addAttribute("payment", orderInfo.getPayment());
		//预计几天天后送达
		DateTime dateTime = new DateTime();
		dateTime = dateTime.plusDays(3);
		model.addAttribute("date",dateTime.toString("yyyy-MM-dd") );
		CookieUtils.deleteCookie(request, response, CART_KEY);
		request.removeAttribute("cartList");
		return "success";
		
	}
}
