package com.dlq.search.service.impl;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.alibaba.dubbo.config.annotation.Service;
import com.dlq.common.pojo.QIResult;
import com.dlq.common.pojo.SearchResult;
import com.dlq.common.util.JsonUtils;
import com.dlq.jedis.JedisClient;
import com.dlq.pojo.QioUser;
import com.dlq.search.dao.SearchDao;
import com.dlq.search.service.QioSolrService;

@Service
public class QioSolrServiceImpl implements QioSolrService {

	@Autowired
	private SearchDao searchDao;
	
	@Autowired
	private JedisClient  jedisClient;
	
	@Value("${USER_SESSION}")
	private String USER_SESSION;
	
	@Value("${SESSION_EXPIRE}")
	private Integer SESSION_EXPIRE;
	
	@Override
	public SearchResult search(String queryString, int page, int rows) throws Exception {
		//根据查询条件拼装查询对象
		//创建一个SolrQuery对象
		SolrQuery query = new SolrQuery();
		//设置查询条件
		query.setQuery(queryString);
		//设置分页条件
		if (page < 1) page =1;
		query.setStart((page - 1) * rows);
		if (rows < 1) rows = 10;
		query.setRows(rows);
		//设置默认搜索域
		query.set("df", "item_title");
		//设置高亮显示
		query.setHighlight(true);
		query.addHighlightField("item_title");
		query.setHighlightSimplePre("<font color='red'>");
		query.setHighlightSimplePost("</font>");
		//调用dao执行查询
		SearchResult searchResult = searchDao.search(query);
		//计算查询结果的总页数
		long recordCount = searchResult.getRecordCount();
		long pages =  recordCount / rows;
		if (recordCount % rows > 0) {
			pages++;
		}
		searchResult.setTotalPages(pages);
		//返回结果
		return searchResult;
	}
	
	@Override
	public QIResult getUserByToken(String token) {
		
		String json = jedisClient.get(USER_SESSION +":"+ token);
		if(org.apache.commons.lang3.StringUtils.isBlank(json)){
			return QIResult.build(400, "用户登录已经过期");
		}
		
		jedisClient.expire(USER_SESSION +":"+ token, SESSION_EXPIRE);
		//把json转换user对象
		QioUser user = JsonUtils.jsonToPojo(json, QioUser.class);
		return QIResult.ok(user);
		// TODO Auto-generated method stub
	}
	

}
