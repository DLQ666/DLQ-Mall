package com.dlq.service;

import com.dlq.pojo.QioItem;
import com.dlq.pojo.QioItemDesc;
import com.dlq.pojo.QioItems;
import com.dlq.pojogroup.QiItems;

import java.util.List;





/**
 * @author Qiqoo dai lian qi
 *     2019年4月7日
 *  @version v1.5
 *  
 *  查询商品列表 的接口 QioItemService 方法名seekAll()
 *  增加商品 的接口 QioItemService    方法名及参数addProduct(QioItem oitem)参数为商品实体类
 */
public interface QioItemService {
	
	/**
	 * 查询商品
	 * @return
	 */
	public List<QioItem> seekAll();
	
	/**
	 * 查询控制面板总数
	 * @return
	 */
	public int seekSum(); 
	
	/**
	 * 添加商品
	 * @param oitem
	 */
	public void addProduct(QiItems qiItems);
	
	/**
	 * 删除商品
	 * deleteItem
	 */
	public void delItem(Long[] gid);
	
	public QioItems getItemId(long itemId);
	
	public QiItems findProduct(Long id);
	
	QioItemDesc getItemDescById(long itemId);
	
	public void updateProduct(QiItems qiItems);
	
	
}
