package com.dlq.content.service;

import java.util.List;

import com.dlq.pojo.QioContent;
import com.dlq.pojo.QioContentCategory;

public interface QioContentService {
	
	
	/**
	 * @param cid
	 * 查询广告列表
	 * @return
	 */
	List<QioContent> getContentid(long cid);
	
}
