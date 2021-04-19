package com.dlq.search.service;

import com.dlq.common.pojo.QIResult;
import com.dlq.common.pojo.SearchResult;

public interface QioSolrService {
	
	SearchResult search(String queryString, int page, int rows) throws Exception;

	QIResult getUserByToken(String token);
}
