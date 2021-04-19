package com.dlq.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dlq.pojo.QioModel;
import com.dlq.pojo.QioResult;
import com.dlq.pojogroup.QiModelGroup;
import com.dlq.service.QioModelService;



@RestController
@RequestMapping("/Model")
public class QioModelController {

	@Reference
	private QioModelService oModelService;
	
	/**
	 * 这里查询xh列表json 
	 * 网页可显示xh json数据
	 * @return
	 */
	@RequestMapping("/seekModelAll")
	public List<QioModel> seekModelAll(){
		List<QioModel> modelAll = oModelService.seekModelAll();
		return modelAll;
	}
	
	/**
	 * 添加型号
	 * @param addModel
	 * @return
	 */
	@RequestMapping("/addModel")
	public QioResult addModel(@RequestBody QiModelGroup iModelGroup){
		try{
			oModelService.addModel(iModelGroup);
			return new QioResult(false ,"增加型号成功");
		}catch (Exception e) {
			e.printStackTrace();
			return new QioResult(false, "添加型号失败(规格名称重复)");
			// TODO: handle exception
		}
	}
	
	/**
	 * 这里修改xh 
	 * findModel先查询
	 * updateModel在更新
	 * @param id
	 * @return
	 */
	@RequestMapping("/findModel")
	public QiModelGroup findModel(int id){
		QiModelGroup findModel = oModelService.findModel(id);
		return  findModel;
	}
	
	@RequestMapping("/updateModel")
	public QioResult updateModel(@RequestBody QiModelGroup iModelGroup){
		try{
			oModelService.updateModel(iModelGroup);
			return new QioResult(false ,"修改型号成功");
			
		}catch (Exception e) {
			e.printStackTrace();
			return new QioResult(false, "修改型号失败(规格名称重复)");
			// TODO: handle exception
		}
	}
	
	/**
	 * 这里删除xh 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delModel")
	public QioResult deleteModel(int[] mid){
		try {
			oModelService.delModel(mid);
			return new QioResult(true,"删除型号规格成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new QioResult(false,"删除型号规格失败");
		}
	}
}
