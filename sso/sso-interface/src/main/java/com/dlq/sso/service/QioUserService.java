package com.dlq.sso.service;

import com.dlq.common.pojo.QIResult;
import com.dlq.pojo.QioUser;
import com.dlq.pojo.QioUserAddress;

public interface QioUserService {
	
	QIResult checkData(String data,int type);
	
	QIResult register(QioUser qioUser);
	
	QIResult login(String custname, String custpassword);
	
	QIResult getUserByToken(String token);
	
	QioUserAddress selectByPrimaryKey(Integer id);
	
	QioUser getUserById(Integer id);
	
	void updateUserById(QioUser qioUser);
}
