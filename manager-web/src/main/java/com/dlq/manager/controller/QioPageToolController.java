package com.dlq.manager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.dlq.service.QioPageToolService;

import pagetool.Pages;



/**
 * @author Qiqoo dai lian qi
 *     2019年4月7日
 *  @version v1.5
 *  
 *  分页插件  angular js mybatis分页插件 
 *  分页插件表现层 QioPageToolController  方法为findPages  参数pageNum pageRows
 */

@RestController
@RequestMapping("/qioPage")
public class QioPageToolController {

	@Reference
	private QioPageToolService oPageToolService;
	
	
	/**
	 * 商品分页
	 * @param pageNum
	 * @param pageRows
	 * @return
	 */
	@RequestMapping("/findPages")
	public Pages findPages(int pageNum,int pageRows){
		Pages pr = oPageToolService.pagesRows(pageNum, pageRows);
		return pr;
	}
	/**
	 * 品牌分页
	 * @param pageNum
	 * @param pageRows
	 * @return
	 */
	@RequestMapping("/findPages2")
	public Pages findPages2(int pageNum,int pageRows){
		Pages pr2 = oPageToolService.pagesRows2(pageNum, pageRows);
		return pr2;
	}
	
	/**
	 * 型号分页
	 * @param pageNum
	 * @param pageRows
	 * @return
	 */
	@RequestMapping("/findPages3")
	public Pages findPages3(int pageNum,int pageRows){
		Pages pr3 = oPageToolService.pagesRows3(pageNum, pageRows);
		return pr3;
	}
	
	/**
	 * 分类分页
	 * @param pageNum
	 * @param pageRows
	 * @return
	 */
	@RequestMapping("/findPages4")
	public Pages findPages4(int pageNum,int pageRows){
		Pages pr4 = oPageToolService.pagesRows4(pageNum, pageRows);
		return pr4;
	}
	
	@RequestMapping("/findPages5")
	public Pages findPages5(int pageNum,int pageRows){
		Pages pr5 = oPageToolService.pagesRows5(pageNum, pageRows);
		return pr5;
	}
	
	@RequestMapping("/findPages6")
	public Pages findPages6(int pageNum,int pageRows){
		Pages pr6 = oPageToolService.pagesRows6(pageNum, pageRows);
		return pr6;
	}
	
	@RequestMapping("/findPages7")
	public Pages findPages7(int pageNum,int pageRows){
		Pages pr7 = oPageToolService.pagesRows7(pageNum, pageRows);
		return pr7;
	}
	
	@RequestMapping("/findPages8")
	public Pages findPages8(int pageNum,int pageRows){
		Pages pr8 = oPageToolService.pagesRows8(pageNum, pageRows);
		return pr8;
	}
}
