package com.dlq.sso.controller;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dlq.common.pojo.QIResult;
import com.dlq.common.util.CookieUtils;
import com.dlq.common.util.JsonUtils;
import com.dlq.order.pojo.OrderInfo;
import com.dlq.order.service.QioOrderService;
import com.dlq.pojo.QioOrderItem;
import com.dlq.pojo.QioUser;
import com.dlq.pojo.QioUserAddress;
import com.dlq.sso.service.QioUserService;
import com.dlq.sso.vo.OrderInfoList;

@Controller
public class QioUserController {
	
	@Value("${TOKEN_KEY}")
	private String TOKEN_KEY;
	
	@Reference
	private QioUserService qioUserService;
	@Reference
	private QioOrderService qioOrderService;
	
	@RequestMapping("/user/check/{param}/{type}")
	@ResponseBody
	public QIResult checkUserData(@PathVariable String param, @PathVariable Integer type) {
		QIResult result = qioUserService.checkData(param, type);
		return result;
	}
	
	@RequestMapping(value="/user/register", method=RequestMethod.POST)
	@ResponseBody
	public QIResult regitster(QioUser qioUser ) {
		QIResult result = qioUserService.register(qioUser);
		return result;
	}
	
	@RequestMapping(value="/user/login",method=RequestMethod.POST)
	@ResponseBody
	public QIResult login(String custname, String custpassword, HttpServletResponse response,HttpServletRequest request){
		QIResult qiResult = qioUserService.login(custname, custpassword);
		//把token写入cookie
		if (qiResult.getStatus() == 200) {
			CookieUtils.setCookie(request, response, TOKEN_KEY, qiResult.getData().toString());
		}
		/*CookieUtils.setCookie(request, response, TOKEN_KEY, qiResult.getData().toString());*/
		return qiResult;
	}
	
	@RequestMapping(value = "/user/loginout", method = RequestMethod.GET)
	public String loginout(HttpServletResponse response, HttpServletRequest request) {

		// 把token写入cookie

		CookieUtils.deleteCookie(request, response, TOKEN_KEY);

		/*
		 * CookieUtils.setCookie(request, response, TOKEN_KEY,
		 * qiResult.getData().toString());
		 */
		return "redirect:http://localhost:8082/";
	}
	
	/*@RequestMapping(value="/user/token/{token}",method=RequestMethod.GET,
			//指定返回响应数据的content-type
			produces=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Object getUserByToken(@PathVariable String token,String callback){
		QIResult result = qioUserService.getUserByToken(token);
		//判断是否为jsonp请求
		if(StringUtils.isNotBlank(callback)){
			MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
			//设置回调方法
			mappingJacksonValue.setJsonpFunction(callback);
			return mappingJacksonValue;
			return callback + "(" + JsonUtils.objectToJson(result) + ");";
		}
		return JsonUtils.objectToJson(result);
	}*/
	
	@RequestMapping(value="/user/token/{token}",method=RequestMethod.GET)
	@ResponseBody
	public Object getUserByToken(@PathVariable String token,String callback){
		QIResult result = qioUserService.getUserByToken(token);
		//判断是否为jsonp请求
		if(StringUtils.isNotBlank(callback)){
			MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
			//设置回调方法
			mappingJacksonValue.setJsonpFunction(callback);
			return mappingJacksonValue;
		}
		return result;
	}
	
	@RequestMapping(value="/user/center", method=RequestMethod.GET)
	public String center(HttpServletResponse response,HttpServletRequest request,Model model) {
		String token = CookieUtils.getCookieValue(request, TOKEN_KEY);
		QIResult result = qioUserService.getUserByToken(token);
		QioUser user = (QioUser) result.getData();
		String mobile = user.getCustcall();
		List<OrderInfoList> list = new ArrayList<OrderInfoList>();
		List<String> orderIds = qioOrderService.selectByMobile(mobile);
		for(String orderId : orderIds) {
			OrderInfoList orderInfoList = new OrderInfoList();
			orderInfoList.setOrderId(orderId);
			System.out.println(orderId);
			List<QioOrderItem> orderItemByOrderId = qioOrderService.selectQioOrderItemByOrderId(orderId);
			orderInfoList.setItems(orderItemByOrderId);
			list.add(orderInfoList);
			orderItemByOrderId.forEach(item->{
				System.out.println(item);
			});
		}
		model.addAttribute("userCenterInfo", user);
		model.addAttribute("orderItemList", list);
		return "userCenter";
	}
	
	@RequestMapping(value="/user/delOrder", method=RequestMethod.GET)
	public String delOrder(String orderId,Model model) {
		qioOrderService.deleteByOrderId(orderId);
		qioOrderService.deleteByPrimaryKey(orderId);
		return "redirect:http://localhost:8088/user/center";
	}
	
	@RequestMapping(value="/user/centerSafe", method=RequestMethod.GET)
	public String centerSafe(HttpServletResponse response,HttpServletRequest request,Model model) {
		String token = CookieUtils.getCookieValue(request, TOKEN_KEY);
		QIResult result = qioUserService.getUserByToken(token);
		QioUser user = (QioUser) result.getData();
		String mobile = user.getCustcall();
		model.addAttribute("userCenterInfo", user);
		return "userCenterSafe";
	}
	
	@RequestMapping(value="/user/pwd", method=RequestMethod.GET)
	public String pwd(HttpServletRequest request,HttpServletResponse response,Model model,
			@RequestParam("password") String password,@RequestParam("confirm_password")String confirm_password) {
		
		String token = CookieUtils.getCookieValue(request, TOKEN_KEY);
		QIResult result = qioUserService.getUserByToken(token);
		QioUser user = (QioUser) result.getData();
		Integer id = user.getId();
		QioUser qioUser = qioUserService.getUserById(id);
		String md5DigestAsHexPassword = DigestUtils.md5DigestAsHex(password.getBytes());
		qioUser.setCustpassword(md5DigestAsHexPassword);
		qioUserService.updateUserById(qioUser);
		CookieUtils.deleteCookie(request, response, TOKEN_KEY);
		return "login";
	}

}
