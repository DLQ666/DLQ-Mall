package com.dlq.pojogroup;

import com.dlq.pojo.QioItem;
import com.dlq.pojo.QioItemDesc;
import com.dlq.pojo.QioItems;

import java.io.Serializable;
import java.util.Date;
import java.util.List;




/**
 * @author Qiqoo dai lian qi
 * 组合实体类
 *  @version v1.5
 */
public class QiItems implements Serializable{
	
	private QioItem qioItem;
	private QioItemDesc qioItemDesc;
	private List<QioItems> qioItems;

	

	public List<QioItems> getQioItems() {
		return qioItems;
	}

	public void setQioItems(List<QioItems> qioItems) {
		this.qioItems = qioItems;
	}

	public QioItem getQioItem() {
		return qioItem;
	}

	public void setQioItem(QioItem qioItem) {
		this.qioItem = qioItem;
	}

	public QioItemDesc getQioItemDesc() {
		return qioItemDesc;
	}

	public void setQioItemDesc(QioItemDesc qioItemDesc) {
		this.qioItemDesc = qioItemDesc;
	}



}
