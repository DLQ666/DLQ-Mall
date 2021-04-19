package com.dlq.service.impl;

import java.util.List;

import com.dlq.mapper.QioBrandMapper;
import com.dlq.pojo.QioBrand;
import com.dlq.service.QioBrandService;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

@Service
public class QioBrandServiceImpl implements QioBrandService {

	@Autowired
	private QioBrandMapper qioBrandMapper;
	
	
	@Override
	public List<QioBrand> seekBrandAll() {
		List<QioBrand> exa= qioBrandMapper.selectByExample(null);
		return exa;
	}
	
	/**
	 * 这里添加品牌
	 * 首先要查找到
	 * 然后更新保存
	 */
	@Override
	public void addBrand(QioBrand qioBrand) {
		
		qioBrandMapper.insert(qioBrand);
		
	}

	@Override
	public QioBrand findcBrand(int id) {
		QioBrand qioBrand = qioBrandMapper.selectByPrimaryKey(id);
		return qioBrand;
	}

	@Override
	public void updateBrand(QioBrand qioBrand) {
		qioBrandMapper.updateByPrimaryKey(qioBrand);
	}

	/**
	 * 这里删除品牌
	 * @param bid
	 */
	@Override
	public void delBrand(int[] bid) {
		
		for(int id:bid){
			qioBrandMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public int seekBrandSum() {
		int countByBrand = qioBrandMapper.countByExample(null);
		return countByBrand;
	}

}
