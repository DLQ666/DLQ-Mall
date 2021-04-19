package com.dlq.pojo;

import java.io.Serializable;

public class QioCategory implements Serializable{
    private Integer id;

    private Integer firstId;

    private String categoryNam;

    private Integer typeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFirstId() {
        return firstId;
    }

    public void setFirstId(Integer firstId) {
        this.firstId = firstId;
    }

    public String getCategoryNam() {
        return categoryNam;
    }

    public void setCategoryNam(String categoryNam) {
        this.categoryNam = categoryNam == null ? null : categoryNam.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
