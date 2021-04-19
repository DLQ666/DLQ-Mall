package com.dlq.search.service.impl;

import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.dlq.common.pojo.QIResult;
import com.dlq.common.pojo.SearchItem;
import com.dlq.search.mapper.SearchMapper;
import com.dlq.search.service.QioSearchService;

@Service
public class QioSearchItemServiceImpl implements QioSearchService {

	@Autowired
	private SearchMapper searchMapper;
	
	@Autowired
	private SolrServer solrServer;
	
	
	@Override
	public QIResult importItemsIndex() {
		try {
			// 查询商品所有数据 遍历 创建文档对象 将文档写入索引库
			List<SearchItem> itemList = searchMapper.getItemList();
			
			for (SearchItem searchItem : itemList) {
				
				SolrInputDocument document=new SolrInputDocument();
				document.addField("id", searchItem.getId());
				document.addField("item_title", searchItem.getTitle());
				document.addField("item_sell_point", searchItem.getSell_point());
				document.addField("item_price", searchItem.getPrice());
				document.addField("item_image", searchItem.getImage());
				document.addField("item_category_name", searchItem.getCategory_name());
				document.addField("item_desc", searchItem.getItem_desc());
				
				solrServer.add(document);
			}
			solrServer.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			QIResult.build(500, "数据导入失败");
			// TODO: handle exception
		}
		
		
		
		return QIResult.ok();
	}

}
