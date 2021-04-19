package com.dlq.pojo;

import java.io.Serializable;
import java.util.Date;

public class QioPortal implements Serializable{
    private Integer itempr;

    private Integer brandpr;

	public Integer getItempr() {
		return itempr;
	}

	public void setItempr(Integer itempr) {
		this.itempr = itempr;
	}

	public Integer getBrandpr() {
		return brandpr;
	}

	public void setBrandpr(Integer brandpr) {
		this.brandpr = brandpr;
	}

	public QioPortal(Integer itempr, Integer brandpr) {
		super();
		this.itempr = itempr;
		this.brandpr = brandpr;
	}

	

}
