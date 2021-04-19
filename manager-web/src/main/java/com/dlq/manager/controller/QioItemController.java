package com.dlq.manager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.dlq.common.pojo.QIResult;
import com.dlq.pojo.QioItem;
import com.dlq.pojo.QioItems;
import com.dlq.pojo.QioResult;
import com.dlq.pojogroup.QiItems;
import com.dlq.service.QioItemService;


/**
 * @author Qiqoo dai lian qi
 *     2019年4月6日
 *  @version v1.5
 *  
 * 商品列表查询  表现层 QioItemController  查询方法为seekAll()方法
 */

@RestController
@RequestMapping("/oitem")
public class QioItemController {
	
	@Reference
	private QioItemService  oItemService;
	
	/**
	 * 这里查询商品列表json
	 * 网页显示商品json数据
	 * @return 
	 */
	@RequestMapping("/seekAll")
	public List<QioItem> seekAll(){
		 List<QioItem> list = oItemService.seekAll();
		 return list;
	}
	
	@RequestMapping("/seekSum")
	public Map seekSum(){
		int seekSum = oItemService.seekSum();
		Map map = new HashMap<>();
		map.put("itemsum", seekSum);
		return map;
	}
	/**
	 * 根据id查询商品
	 */
	/*@RequestMapping("/deleteItem")*/
	
	/**
	 * 根据id删除商品
	 */

	@RequestMapping("/deleteItem")
	public QioResult delItem(Long[] gid){
		try {
			oItemService.delItem(gid);
			return new QioResult(true, "删除成功");
		} catch (Exception e) {
			return new QioResult(false, "删除失败");
			// TODO: handle exception
		}
	}
	/**
	 * 这里添加商品
	 * @param oitem
	 */
	@RequestMapping("/addProduct")
	public QioResult addProduct(@RequestBody QiItems items){
		try {
			oItemService.addProduct(items);
			return new QioResult(true,"添加商品成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new QioResult(false,"添加商品失败");
			// TODO: handle exception
		}
	}
	
	@RequestMapping("/findProduct")
	public QiItems findProduct(Long id){
		QiItems findProduct = oItemService.findProduct(id);
		return findProduct;
	}
	
	
	@RequestMapping("/updateProduct")
	public QioResult updateProduct(@RequestBody QiItems qiItems){
		try {
			oItemService.updateProduct(qiItems);
			return new QioResult(true,"修改商品成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new QioResult(false,"修改商品失败");
			// TODO: handle exception
		}
		
	}
	

}
