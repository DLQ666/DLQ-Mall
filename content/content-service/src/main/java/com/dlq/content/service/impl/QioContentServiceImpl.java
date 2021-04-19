package com.dlq.content.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.dlq.common.pojo.QIResult;
import com.dlq.content.service.QioContentService;
import com.dlq.mapper.QioContentCategoryMapper;
import com.dlq.mapper.QioContentMapper;
import com.dlq.pojo.QioCategory;
import com.dlq.pojo.QioContent;
import com.dlq.pojo.QioContentCategory;
import com.dlq.pojo.QioContentExample;
import com.dlq.pojo.QioContentExample.Criteria;

@Service
public class QioContentServiceImpl implements QioContentService {

	@Autowired
	private QioContentMapper qioContentMapper;
	@Autowired
	private QioContentCategoryMapper qioContentCategoryMapper;
	
	/**
	 * 查询广告列表
	 */
	@Override
	public List<QioContent> getContentid(long cid) {
		
		QioContentExample example = new QioContentExample();
		
		Criteria criteria = example.createCriteria();
		
		criteria.andCategoryIdEqualTo(cid);
		//执行查询
		List<QioContent> list = qioContentMapper.selectByExample(example);
		
		return list;
	}

}
