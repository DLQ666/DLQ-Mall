package com.dlq.service.impl;

import java.util.Date;
import java.util.List;

import com.dlq.mapper.QioContentCategoryMapper;
import com.dlq.mapper.QioContentMapper;
import com.dlq.pojo.QioContent;
import com.dlq.pojo.QioContentCategory;
import com.dlq.service.QioContentService;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

@Service
public class QioContentSeviceImpl implements QioContentService {

	@Autowired
	private QioContentMapper qioContentMapper;
	@Autowired
	private QioContentCategoryMapper qioContentCategoryMapper;
	
	@Override
	public List<QioContent> seekContentAll() {
		List<QioContent> contentlist = qioContentMapper.selectByExample(null);
		return contentlist;
	}

	@Override
	public void addContent(QioContent qioContent) {
		qioContent.setCreated(new Date());
		qioContent.setUpdated(new Date());
		qioContentMapper.insert(qioContent);
	}

	@Override
	public void delContent(Long[] cid) {
		for(Long id:cid){
			qioContentMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public QioContent findContent(Long id) {
		QioContent qioContentid = qioContentMapper.selectByPrimaryKey(id);
		return qioContentid;
	}

	@Override
	public void updateContent(QioContent qioContent) {
		qioContent.setUpdated(new Date());
		qioContentMapper.updateByPrimaryKey(qioContent);
		
	}

	@Override
	public int seekContentSum() {
		int contentnum = qioContentMapper.countByExample(null);
		return contentnum;
	}

	@Override
	public List<QioContentCategory> findAll() {
		return qioContentCategoryMapper.selectByExample(null);
	}
	


}
