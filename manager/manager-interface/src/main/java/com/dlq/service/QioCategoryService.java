package com.dlq.service;

import com.dlq.pojo.QioCategory;

import java.util.List;


/**
 * @author Qiqoo dai lian qi
 *     2019年4月13日
 *  @version v1.5
 *  商品分类的接口
 */
public interface QioCategoryService {
	
	/**
	 * 查询所有分类
	 * @return
	 */
	public List<QioCategory> seekCategoryAll();
	
	/**
	 * 根据顶级id查询
	 * @param firstId
	 * @return
	 */
	public List<QioCategory> seekFirstid(int firstId);
	
	
	/**
	 * 查询单个分类
	 * @param id
	 * @return
	 */
	public QioCategory findCategory(int id);
	
	
	public void addCategory(QioCategory qioCategory);
	
	public void delCategory(int[] firstId);
	
	public void updateCategory(QioCategory qioCategory); 

}
