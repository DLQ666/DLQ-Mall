package com.dlq.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.dlq.mapper.QioItemDescMapper;
import com.dlq.mapper.QioItemMapper;
import com.dlq.mapper.QioItemsMapper;
import com.dlq.pojo.QioItem;
import com.dlq.pojo.QioItemDesc;
import com.dlq.pojo.QioItems;
import com.dlq.pojo.QioItemsExample;
import com.dlq.pojogroup.QiItems;
import com.dlq.service.QioItemService;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;

/**
 * @author Qiqoo dai lian qi 2019年4月5日
 * @version v1.5
 * 
 *          查询商品列表json 实现类QioItemServiceImplements 方法名seekAll()
 */
@Service
public class QioItemServiceImpl implements QioItemService {

	@Autowired
	private QioItemMapper oItemMapper;

	@Autowired
	private QioItemDescMapper qioItemDescMapper;
	
	@Autowired
	private QioItemsMapper qioItemsMapper;
	

	/*
	 * (non-Javadoc) 查询商品数显示在控制面板
	 * 
	 * @see com.dlq.service.QioItemService#seekAll()
	 */
	@Override
	public int seekSum() {
		int countByExample = oItemMapper.countByExample(null);
		return countByExample;
	}

	/*
	 * (non-Javadoc) 添加商品
	 * 
	 * @see com.dlq.service.QioItemService#addProduct(com.dlq.pojo.QioItem)
	 */
	@Override
	public void addProduct(QiItems items) {
		QioItem qioItem = items.getQioItem();
		qioItem.setStatus((byte) 1);
		oItemMapper.insert(qioItem);
		
		QioItemDesc qioItemDesc = items.getQioItemDesc();
		qioItemDesc.setItemId(qioItem.getId());
		qioItemDescMapper.insert(qioItemDesc);
		
			
		QioItems qioItems = new QioItems();
		qioItems.setId(qioItem.getId());
		qioItems.setTitle(qioItem.getTitle());
		qioItems.setSellPoint(qioItem.getSellPoint());
		qioItems.setPrice(qioItem.getPrice());
		qioItems.setNum(qioItem.getNum());
		qioItems.setCid(qioItem.getCid());
		qioItems.setStatus(qioItem.getStatus());
		qioItems.setCreated(new Date());
		qioItems.setUpdated(new Date());
		
		List<Map> list = JSON.parseArray(qioItem.getImage(),Map.class);
		if(list.size()>0){
			qioItems.setImage((String)list.get(0).get("url"));
		}
		qioItemsMapper.insert(qioItems);
	}

	// @Override
	/**
	 * 查询全部商品json 方法seekAll
	 */
	@Override
	public List<QioItem> seekAll() {
		List<QioItem> list = oItemMapper.selectByExample(null);
		return list;
	}

	@Override
	public void delItem(Long[] gid) {
		for (Long id : gid) {
			oItemMapper.deleteByPrimaryKey(id);
			//更新详情
			qioItemDescMapper.deleteByPrimaryKey(id);
			//删除原有商品
			QioItemsExample example = new QioItemsExample();
			com.dlq.pojo.QioItemsExample.Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo(id);
			qioItemsMapper.deleteByExample(example);
			
		}

	}

	@Override
	public QiItems findProduct(Long id) {
		QiItems qiItems = new QiItems();
		//基本表
		QioItem qioItem = oItemMapper.selectByPrimaryKey(id);
		qiItems.setQioItem(qioItem);
		//描述表
		QioItemDesc qioItemDesc = qioItemDescMapper.selectByPrimaryKey(id);
		qiItems.setQioItemDesc(qioItemDesc);
		//最终表
		QioItemsExample example = new QioItemsExample();
		com.dlq.pojo.QioItemsExample.Criteria create = example.createCriteria();
		create.andIdEqualTo(qiItems.getQioItem().getId());
		List<QioItems> list = qioItemsMapper.selectByExample(example);
		qiItems.setQioItems(list);
		
		return qiItems;
	}

	@Override
	public void updateProduct(QiItems qiItems) {
		//更新基本信息
		oItemMapper.updateByPrimaryKey(qiItems.getQioItem());
		//更新详情
		qioItemDescMapper.updateByPrimaryKeyWithBLOBs(qiItems.getQioItemDesc());
		//删除原有商品
		QioItemsExample example = new QioItemsExample();
		com.dlq.pojo.QioItemsExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(qiItems.getQioItem().getId());
		qioItemsMapper.deleteByExample(example);
		
		//插入新的数据
		/*QioItem qioItem = qiItems.getQioItem();*/
		/*qioItem.setStatus((byte) 1);
		oItemMapper.insert(qioItem);*/
		
		/*QioItemDesc qioItemDesc = qiItems.getQioItemDesc();*/
		/*qioItemDesc.setItemId(qioItem.getId());*/
		/*qioItemDescMapper.insert(qioItemDesc);*/
		
		QioItems qioItems = new QioItems();
		qioItems.setId(qiItems.getQioItem().getId());
		qioItems.setTitle(qiItems.getQioItem().getTitle());
		qioItems.setSellPoint(qiItems.getQioItem().getSellPoint());
		qioItems.setPrice(qiItems.getQioItem().getPrice());
		qioItems.setNum(qiItems.getQioItem().getNum());
		qioItems.setCid(qiItems.getQioItem().getCid());
		qioItems.setStatus(qiItems.getQioItem().getStatus());
		qioItems.setCreated(new Date());
		qioItems.setUpdated(new Date());
		
		List<Map> list = JSON.parseArray(qiItems.getQioItem().getImage(),Map.class);
		if(list.size()>0){
			qioItems.setImage((String)list.get(0).get("url"));
		}
		qioItemsMapper.insert(qioItems);
	}

	@Override
	public QioItemDesc getItemDescById(long itemId) {
		QioItemDesc itemDesc = qioItemDescMapper.selectByPrimaryKey(itemId);
		// TODO Auto-generated method stub
		return itemDesc;
	}

	@Override
	public QioItems getItemId(long itemId) {
		QioItems qioItems = qioItemsMapper.selectByPrimaryKey(itemId);
		// TODO Auto-generated method stub
		return qioItems;
	}

}
