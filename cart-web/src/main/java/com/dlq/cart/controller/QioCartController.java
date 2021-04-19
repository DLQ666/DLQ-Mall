package com.dlq.cart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dlq.common.pojo.QIResult;
import com.dlq.common.util.CookieUtils;
import com.dlq.common.util.JsonUtils;
import com.dlq.pojo.QioItems;
import com.dlq.pojo.QioResult;
import com.dlq.service.QioItemService;

@Controller
public class QioCartController {
	
	
	@Value("${CART_KEY}")
	private String CART_KEY;
	@Value("${CART_EXPIER}")
	private Integer CART_EXPIER;
	
	@Reference
	private QioItemService qioItemService;
	
	/**
	 * 更新购物车商品数量
	 */
	@RequestMapping("/cart/update/num/{itemId}/{num}")
	@ResponseBody
	public QIResult updateNum(@PathVariable Long itemId, @PathVariable Integer num,
	        HttpServletRequest request, HttpServletResponse response) {
	    // 取购物车商品列表
	    List<QioItems> cartList = getCartItemList(request);
	    // 遍历商品列表找到商品
	    for (QioItems tbItem : cartList) {
	        if (tbItem.getId().intValue() == itemId) {
	            // 更新商品数量
	            tbItem.setNum(num);
	            break;
	        }
	    }
	    // 写入cookie
	    CookieUtils.setCookie(request, response, CART_KEY, 
	            JsonUtils.objectToJson(cartList), CART_EXPIER, true);
	    // 返回结果
	    return QIResult.ok();
	}
	
	
	@RequestMapping("/cart/add/{itemId}")
	public String addItemCart(@PathVariable Long itemId,@RequestParam(defaultValue="1") Integer num,
			HttpServletRequest request,HttpServletResponse response){
		//取购物车商品列表
		List<QioItems> cartItemList = getCartItemList(request);
		//判断商品在购物车中是否存在
		boolean flag = false; 
		for (QioItems qioItems : cartItemList) {
			if(qioItems.getId() == itemId.longValue()){
				//如果存在数量相加
				qioItems.setNum(qioItems.getNum() + num);
				flag=true;
				break;
			}
		}
		
		//如果不存在，添加一个新的商品
		if(!flag){
			//需要调用服务商品信息
			QioItems items = qioItemService.getItemId(itemId);
			//设置购买的商品数量
			items.setNum(num);
			//取一张图片
			String image = items.getImage();
			if(StringUtils.isNotBlank(image)){
				String[] strings = image.split(",");
				items.setImage(strings[0]);
			}
			//商品添加到购物车
			cartItemList.add(items);
		}
		//把购物车列表写入cookie
		CookieUtils.setCookie(request, response, CART_KEY, JsonUtils.objectToJson(cartItemList), 
				CART_EXPIER, true);
		//返回添加页面
		
		return "cartSuccess";
	}
	
	
	private List<QioItems> getCartItemList(HttpServletRequest request){
		//从cookie中取购物车商品列表
		String cookieValuejson = CookieUtils.getCookieValue(request, CART_KEY, true);
		
		if(StringUtils.isBlank(cookieValuejson)){
			//如果没有值，返回一个空的列表
			return new ArrayList<>();
		}
		
		List<QioItems> jsonToList = JsonUtils.jsonToList(cookieValuejson, QioItems.class);
		return jsonToList;
	}
	
	@RequestMapping("/cart/cart")
	public String showCartList(HttpServletRequest request){
		//从cookie中取购物车列表
		List<QioItems> cartItemList = getCartItemList(request);
		//把购物车列表传递给jsp
		request.setAttribute("cartList", cartItemList);
		//返回逻辑视图
		return "cart";
	}
	
	@RequestMapping("/cart/delete/{itemId}")
	public String deleteCartItem(@PathVariable Long itemId, HttpServletRequest request,
			HttpServletResponse response){
		//从cookie中取购物车列表
		List<QioItems> cartItemList = getCartItemList(request);
		//查询得到对应的商品
		for(QioItems tbItem : cartItemList){
			if(tbItem.getId() == itemId.longValue()){
				//删除商品
				cartItemList.remove(tbItem);
				break;
			}
		}
		//把购物车列表写入cookie
		CookieUtils.setCookie(request, response, CART_KEY, JsonUtils.objectToJson(cartItemList),
						CART_EXPIER, true);
		//重定向到购物车列表页面
		return "redirect:/cart/cart.html";
	}

}
