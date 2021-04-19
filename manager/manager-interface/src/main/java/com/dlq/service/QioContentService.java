package com.dlq.service;

import com.dlq.pojo.QioContent;
import com.dlq.pojo.QioContentCategory;

import java.util.List;


public interface QioContentService {
	
	public List<QioContent> seekContentAll();
	
	public void addContent(QioContent qioContent);
	
	
	public void delContent(Long[] cid);
	
	public QioContent findContent(Long id);
	
	public void updateContent(QioContent qioContent);
	
	public int seekContentSum();
	
	public List<QioContentCategory> findAll();

}
