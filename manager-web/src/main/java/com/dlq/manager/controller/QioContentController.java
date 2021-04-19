package com.dlq.manager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dlq.pojo.QioBrand;
import com.dlq.pojo.QioContent;
import com.dlq.pojo.QioContentCategory;
import com.dlq.pojo.QioResult;
import com.dlq.service.QioContentService;

@RestController
@RequestMapping("/ocontent")
public class QioContentController {
	
	@Reference
	private QioContentService qioContentService;
	
	@RequestMapping("/seekContentAll")
	public List<QioContent> seekContentAll(){
		List<QioContent> contentAll = qioContentService.seekContentAll();
		return contentAll;
	}
	@RequestMapping("/seekContentSum")
	public Map seekContentSum(){
		int contentSum = qioContentService.seekContentSum();
		Map map = new HashMap<>();
		map.put("contentsum", contentSum);
		return map;
	}
	
	@RequestMapping("/addContent")
	public QioResult addContent(@RequestBody QioContent qioContent) {
		try {
			qioContentService.addContent(qioContent);
			return new QioResult(false,"添加广告成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new QioResult(false,"添加广告失败");
		}
	}
	
	@RequestMapping("/findAll")
	public List<QioContentCategory> findAll(){
		return qioContentService.findAll();
	}
	
	@RequestMapping("/findContent")
	public QioContent findContent(Long id) {
		QioContent qioContent = qioContentService.findContent(id);
		return qioContent;
	}
	@RequestMapping("/updateContent")
	public QioResult updateContent(@RequestBody QioContent qioContent){
		try {
			qioContentService.updateContent(qioContent);
			return new QioResult(false,"修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new QioResult(false,"修改失败");
		}
	}
	@RequestMapping("/deleteContent")
	public QioResult delContent(Long[] cid){
		try {
			qioContentService.delContent(cid);
			return new QioResult(true, "删除成功");
		} catch (Exception e) {
			return new QioResult(false, "删除失败");
		}
	}
}
