package com.dlq.pojo;

import java.io.Serializable;

public class QioUser implements Serializable{
    private Integer id;

    private String custname;

    private String custpassword;

    private String custcall;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname == null ? null : custname.trim();
    }

    public String getCustpassword() {
        return custpassword;
    }

    public void setCustpassword(String custpassword) {
        this.custpassword = custpassword == null ? null : custpassword.trim();
    }

    public String getCustcall() {
        return custcall;
    }

    public void setCustcall(String custcall) {
        this.custcall = custcall == null ? null : custcall.trim();
    }
}
