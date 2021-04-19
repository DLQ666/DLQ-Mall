package com.dlq.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dlq.pojo.QioCategory;
import com.dlq.pojo.QioResult;
import com.dlq.service.QioCategoryService;

@RestController
@RequestMapping("/oclassify")
public class QioCategoryController {

	@Reference
	private QioCategoryService qiocategoryService;
	
	/**
	 * 根据顶级id查询分类列表
	 * @param firstId
	 * @return
	 */
	@RequestMapping("/seekFirstid")
	public List<QioCategory> seekFirstid(int firstId) {
		List<QioCategory> firstid = qiocategoryService.seekFirstid(firstId);
		return firstid;
	}
	
	@RequestMapping("/seekCategoryAll")
	public List<QioCategory> seekCategoryAll(){
		List<QioCategory> categoryAll = qiocategoryService.seekCategoryAll();
		return categoryAll;
	}
	
	
	@RequestMapping("/findCategory")
	public QioCategory findCategory(int id){
		QioCategory findCategory = qiocategoryService.findCategory(id);
		return findCategory;
	}
	
	@RequestMapping("/addCategory")
	public QioResult addCategory(@RequestBody QioCategory qioCategory){
		try {
			qiocategoryService.addCategory(qioCategory);
			return new QioResult(true,"添加分类成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new QioResult(false,"添加分类失败");
			// TODO: handle exception
		}
	}
	
	@RequestMapping("/delCategory")
	public QioResult delCategory(int[] firstId){
		try {
			qiocategoryService.delCategory(firstId);
			return new QioResult(true,"删除分类成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new QioResult(false,"删除分类失败");
			// TODO: handle exception
		}
	}
	
	@RequestMapping("/updateCategory")
	public QioResult updateCategory(@RequestBody QioCategory qioCategory){
		try {
			qiocategoryService.updateCategory(qioCategory);
			return new QioResult(true,"修改分类成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new QioResult(false,"修改分类失败");
			// TODO: handle exception
		}
		
	}
	
}
