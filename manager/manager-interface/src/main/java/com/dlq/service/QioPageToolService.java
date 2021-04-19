package com.dlq.service;


import pagetool.Pages;

/**
 * @author Qiqoo dai lian qi
 *     2019年4月7日
 *  @version v1.5
 *  商品列表分页工具接口 QioPageToolService
 */
public interface QioPageToolService {
	
	/**分页实体类在qi-manager-pojo/pagetool/Pages.java
	 * 这里是商品列表的分页
	 * 参数代表：
	 *  pageNum  当前页面
	 *  pageRows 每页的记录数
	 * @return 返回result结果
	 */
	
	public Pages pagesRows(int pageNum, int pageRows);
	
	/**
	 * 这里是品牌的分页
	 * 参数同上
	 * @param pageNum
	 * @param pageRows
	 * @return
	 */
	public Pages pagesRows2(int pageNum,int pageRows);

	/**
	 * 这里是型号的分页
	 * 参数同上
	 * @param pageNum
	 * @param pageRows
	 * @return
	 */
	public Pages pagesRows3(int pageNum,int pageRows);
	
	/**
	 * 这里是分类的分页
	 * 参数同上
	 * @param pageNum
	 * @param pageRows
	 * @return
	 */
	public Pages pagesRows4(int pageNum,int pageRows);

	public Pages pagesRows5(int pageNum, int pageRows);
	
	public Pages pagesRows6(int pageNum, int pageRows);
	
	public Pages pagesRows7(int pageNum, int pageRows);
	
	public Pages pagesRows8(int pageNum, int pageRows);
}
