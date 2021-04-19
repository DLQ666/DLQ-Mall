package com.dlq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.dlq.mapper.QioCategoryMapper;
import com.dlq.pojo.QioCategory;
import com.dlq.pojo.QioCategoryExample;
import com.dlq.pojo.QioCategoryExample.Criteria;
import com.dlq.service.QioCategoryService;

@Service
public class QioCategoryServiceImpl implements QioCategoryService {
	
	@Autowired
	private QioCategoryMapper qioCategoryMapper;

	@Override
	public List<QioCategory> seekFirstid(int firstId) {
		QioCategoryExample example = new QioCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andFirstIdEqualTo(firstId);
		List<QioCategory> list = qioCategoryMapper.selectByExample(example);
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<QioCategory> seekCategoryAll() {
		// TODO Auto-generated method stub
		List<QioCategory> list = qioCategoryMapper.selectByExample(null);
		return list;
	}

	@Override
	public QioCategory findCategory(int id) {
		// TODO Auto-generated method stub
		QioCategory findqioCategory = qioCategoryMapper.selectByPrimaryKey(id);
		return findqioCategory;
	}

	@Override
	public void addCategory(QioCategory qioCategory) {
		 qioCategoryMapper.insert(qioCategory);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delCategory(int[] firstId) {
		for(int id:firstId){
			qioCategoryMapper.deleteByPrimaryKey(id);
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCategory(QioCategory qioCategory) {
		qioCategoryMapper.updateByPrimaryKey(qioCategory);
		// TODO Auto-generated method stub
		
	}

}
