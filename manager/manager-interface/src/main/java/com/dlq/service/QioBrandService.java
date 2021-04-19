package com.dlq.service;

import com.dlq.pojo.QioBrand;

import java.util.List;


/**
 * @author Qiqoo dai lian qi
 *     2019年4月7日
 *  @version v1.5
 */
public interface QioBrandService { 
	/**
	 * 这里查询品牌
	 * @param qioBrand
	 */
	public List<QioBrand> seekBrandAll();
	
	/**
	 * 这里添加品牌
	 * @param qioBrand
	 */
	public void addBrand(QioBrand qioBrand);
	
	/**
	 * 这里删除品牌
	 * @param bid
	 */
	public void delBrand(int[] bid);
	
	/**
	 * 这里修改品牌
	 * 根据id查询品牌 
	 * @param id
	 * @return
	 */
	public QioBrand findcBrand(int id);
	
	
	/**
	 * 这里修改品牌
	 * @param qioBrand
	 */
	public void updateBrand(QioBrand qioBrand);
	
	
	
	/**
	 * 控制面板动态显示品牌数量
	 * @return
	 */
	public int seekBrandSum();
	
	
	
} 
