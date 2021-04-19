package com.dlq.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dlq.common.pojo.QIResult;
import com.dlq.search.service.QioSearchService;

@Controller
public class IndexManagerController {
	
	@Reference
	private QioSearchService qioSearchService;
	
	/**
	 *  
	 * @return
	 */
	@RequestMapping("/index/import")
	@ResponseBody
	public QIResult importIndex(){
		QIResult itemsIndex = qioSearchService.importItemsIndex();
		return itemsIndex;
	}

}
