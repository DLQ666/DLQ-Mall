package com.dlq.search.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dlq.common.pojo.SearchResult;
import com.dlq.search.service.QioSolrService;

@Controller
public class QioSearchController {

	
	@Value("${SEARCH_RESULT_ROWS}")
	private Integer SEARCH_RESULT_ROWS;
	
	@Reference
	private QioSolrService qioSolrService;
	
	
	
	@RequestMapping("/search")
	public String search(@RequestParam("q")String queryString, 
			@RequestParam(defaultValue="1")Integer page, Model model) throws Exception {
			//调用服务执行查询
			//把查询条件进行转码，解决get乱码问题
			queryString = new String(queryString.getBytes("iso8859-1"), "utf-8");
			SearchResult search = qioSolrService.search(queryString, page, SEARCH_RESULT_ROWS);
			//把结果传递给页面
			model.addAttribute("query", queryString);
			
			model.addAttribute("totalPages", search.getTotalPages());
			model.addAttribute("itemList", search.getItemList());
			model.addAttribute("page", page);

			//返回逻辑视图
			return "search";
			
		}
	}

