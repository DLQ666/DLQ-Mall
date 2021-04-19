package com.dlq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.dlq.mapper.QioModelMapper;
import com.dlq.mapper.QioModelOptionMapper;
import com.dlq.pojo.QioModel;
import com.dlq.pojo.QioModelOption;
import com.dlq.pojo.QioModelOptionExample;
import com.dlq.pojo.QioModelOptionExample.Criteria;
import com.dlq.pojogroup.QiModelGroup;
import com.dlq.service.QioModelService;

@Service
public class QioModelServiceImpl implements QioModelService {

	@Autowired
	private QioModelMapper oModelMapper;
	
	@Autowired
	private QioModelOptionMapper oModelOptionMapper;
	
	
	/* (non-Javadoc)
	 * 查询全部
	 * @see com.dlq.service.QioModelService#seekModelAll()
	 */
	@Override
	public List<QioModel> seekModelAll() {
		// TODO Auto-generated method stub
		List<QioModel> exa = oModelMapper.selectByExample(null);
		return exa;
	}


	/* (non-Javadoc)
	 * 增加
	 * @see com.dlq.service.QioModelService#addModel(com.dlq.pojogroup.QiModelGroup)
	 */
	@Override
	public void addModel(QiModelGroup qiModelGroup) {
		// TODO Auto-generated method stub
	 QioModel qioModel = qiModelGroup.getoModel(); 
	 oModelMapper.insert(qioModel);
	 
	 List<QioModelOption> oModelOptionList = qiModelGroup.getoModelOptionList();
	 for( QioModelOption model:oModelOptionList){
		 //设置id
		 model.setSpecId(qioModel.getId());
		 //新增
		 oModelOptionMapper.insert(model);
	 }
	 
	}


	/* (non-Javadoc)
	 * 修改时查询到修改的型号
	 * @see com.dlq.service.QioModelService#findModel(int)
	 */
	@Override
	public QiModelGroup findModel(int id) {
		// TODO Auto-generated method stub
		QiModelGroup qiModelGroup = new QiModelGroup();
		qiModelGroup.setoModel(oModelMapper.selectByPrimaryKey(id));
		 
		QioModelOptionExample example = new QioModelOptionExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andSpecIdEqualTo(id);
		List<QioModelOption> list = oModelOptionMapper.selectByExample(example);
		qiModelGroup.setoModelOptionList(list);
		return qiModelGroup;
	}


	@Override
	public void updateModel(QiModelGroup qiModelGroup) {
		//获取型号名称
		QioModel qioModel = qiModelGroup.getoModel(); 
		oModelMapper.updateByPrimaryKey(qioModel);
		//更新功能：删除规格，重新添加
		QioModelOptionExample optionexample = new QioModelOptionExample();
		Criteria criteria = optionexample.createCriteria();
		criteria.andSpecIdEqualTo(qioModel.getId());
		oModelOptionMapper.deleteByExample(optionexample);
		//获取规格
		List<QioModelOption> oModelOptionList = qiModelGroup.getoModelOptionList();
		for( QioModelOption model:oModelOptionList){
			 //设置id
			model.setSpecId(qioModel.getId());
			 //新增
			oModelOptionMapper.insert(model);
		}
		// TODO Auto-generated method stub
	}


	@Override
	public void delModel(int[] mid) {
		// TODO Auto-generated method stub
		//先删除规格名称，然后连带着规格选项一起删除
		for(int id:mid){
			oModelMapper.deleteByPrimaryKey(id);
		
			QioModelOptionExample example = new QioModelOptionExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andSpecIdEqualTo(id); 
			oModelOptionMapper.deleteByExample(example);
		}

	}
}
