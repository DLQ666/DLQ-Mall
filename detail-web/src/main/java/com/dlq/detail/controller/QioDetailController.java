package com.dlq.detail.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dlq.common.pojo.QIResult;
import com.dlq.detail.pojo.QioDetail;
import com.dlq.pojo.QioItemDesc;
import com.dlq.pojo.QioItems;
import com.dlq.pojogroup.QiItems;
import com.dlq.service.QioItemService;
import com.dlq.service.QioUserService;

//详情页面
@Controller
public class QioDetailController {
	
	@Reference
	private QioItemService qioItemService;
	
	@Reference
	private QioUserService qioUserService;
	
	@RequestMapping("/item/{itemId}")
	public String showItem(@PathVariable Long itemId, Model model) {
		//取商品基本信息
		QioItems qioItems = qioItemService.getItemId(itemId);
		QioDetail item = new QioDetail(qioItems);
		//取商品详情
		QioItemDesc qioItemDesc = qioItemService.getItemDescById(itemId);
		//把数据传递给页面
		model.addAttribute("item", item);
		model.addAttribute("itemDesc", qioItemDesc);
		//返回逻辑视图
		return "item";
	}
	
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

}
