package com.dlq.service;

import com.dlq.common.pojo.QIResult;
import com.dlq.pojo.QioUser;

import java.util.List;


public interface QioUserService {
	
	public List<QioUser> seekUserAll();
	
	public int seekUserNum();

	public QIResult getUserByToken(String token);

}
