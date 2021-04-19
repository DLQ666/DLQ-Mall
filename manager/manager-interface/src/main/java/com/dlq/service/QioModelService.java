package com.dlq.service;

import com.dlq.pojo.QioModel;
import com.dlq.pojogroup.QiModelGroup;

import java.util.List;

/**
 * @author Qiqoo dai lian qi
 *     2019年4月7日
 *  @version v1.5
 *  
 *  型号操作的接口 QioModelService 
 */
public interface QioModelService {
	
	/**
	 * 查询型号
	 * 方法名seekModelAll()
	 * @return
	 */
	public List<QioModel> seekModelAll();
	
	/**
	 * 增加规格：运用组合实体类
	 * 将规格名称和规格选项添加到两个不同数据库中
	 * 数据库一对多
	 * @param iModelGroup
	 */
	public void addModel(QiModelGroup qiModelGroup);
	
	/**
	 * 这里修改型号
	 * 根据组合实体类id查询型号
	 * @param id
	 * @return
	 */
	public QiModelGroup findModel(int id);
	
	/**
	 * 更新 修改
	 * @param updateModel 
	 */
	public void updateModel(QiModelGroup qiModelGroup);
	
	/**
	 * 删除
	 * @param delModel mid
	 */
	public void delModel(int[] mid);
}
