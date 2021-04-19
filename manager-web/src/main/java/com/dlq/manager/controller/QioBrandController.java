package com.dlq.manager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dlq.pojo.QioBrand;
import com.dlq.pojo.QioResult;
import com.dlq.service.QioBrandService;

@RestController
@RequestMapping("/obrand")
public class QioBrandController {

	@Reference
	private QioBrandService oBrandService;
	
	/**
	 *<a> 查询品牌列表json 
	 * <a>网页可显示品牌json数据
	 * @return
	 */
	@RequestMapping("/seekBrandAll")
	public List<QioBrand> seekBrandAll(){
		List<QioBrand> brandAll = oBrandService.seekBrandAll();
		return brandAll;
	}
	/**
	 * <a>添加品牌
	 * <a>前端通过post来传用@requestbody
	 */
	@RequestMapping("/addBrand")
	public QioResult addBrand(@RequestBody QioBrand qioBrand){
		try {
			oBrandService.addBrand(qioBrand);
			return new QioResult(false,"添加品牌成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new QioResult(false,"添加品牌失败(原因：品牌名重复or首字母错误)");
		}
		
	}
	
	/**
	 * <a>删除品牌
	 * <a>可以多选删除
	 * @param bid
	 * @return
	 */
	@RequestMapping("/delBrand")
	public QioResult delBrand(int[] bid){
		try {
			oBrandService.delBrand(bid);
			return new QioResult(true,"删除品牌成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new QioResult(false,"删除品牌失败");
		}
	}
	
	/**
	 * <a>修改品牌 
	 * findcBrand先查询
	 * updateBrand在更新
	 * @param id
	 * @return
	 */
	@RequestMapping("/findcBrand")
	public QioBrand findcBrand(int id){
		QioBrand findcBrand = oBrandService.findcBrand(id);
		return findcBrand;
	}
	
	@RequestMapping("/updateBrand")
	public QioResult updateBrand(@RequestBody QioBrand qioBrand){
		try {
			oBrandService.updateBrand(qioBrand);
			return new QioResult(false,"修改品牌成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new QioResult(false,"修改品牌失败(原因：品牌名重复or首字母错误)");
		}
		
	}
	
	/**
	 * 控制面板统计品牌数量
	 * seekBrandSum()
	 * @return
	 */
	@RequestMapping("/seekBrandSum")
	public Map seekBrandSum(){
		int seekBrandSum = oBrandService.seekBrandSum();
		Map map = new HashMap<>();
		map.put("brandsum", seekBrandSum);
		return map;
	}
	
}
