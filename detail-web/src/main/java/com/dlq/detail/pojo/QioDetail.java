package com.dlq.detail.pojo;

import com.dlq.pojo.QioItems;

public class QioDetail extends QioItems {
	
	public QioDetail(QioItems qioItems){
		//初始化属性
		this.setId(qioItems.getId());
		this.setTitle(qioItems.getTitle());
		this.setSellPoint(qioItems.getSellPoint());
		this.setPrice(qioItems.getPrice());
		this.setNum(qioItems.getNum());
		this.setImage(qioItems.getImage());
		this.setCid(qioItems.getCid());
		this.setStatus(qioItems.getStatus());
		this.setCreated(qioItems.getCreated());
		this.setUpdated(qioItems.getUpdated());
	}
	

	public String[] getImages() {
		if (this.getImage()!=null && !"".equals(this.getImage())) {
			String image2 = this.getImage();
			String[] strings = image2.split(",");
			return strings;
		}
		return null;
	}
}
