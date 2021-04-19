package com.dlq.service.impl;

import java.util.List;

import com.dlq.common.pojo.QIResult;
import com.dlq.common.util.JsonUtils;
import com.dlq.jedis.JedisClient;
import com.dlq.mapper.QioUserMapper;
import com.dlq.pojo.QioUser;
import com.dlq.service.QioUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.alibaba.dubbo.config.annotation.Service;

@Service
public class QioUserServiceImpl implements QioUserService {

	
	@Autowired
	private QioUserMapper qioUserMapper;
	
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${USER_SESSION}")
	private String USER_SESSION;
	
	@Value("${SESSION_EXPIRE}")
	private Integer SESSION_EXPIRE;
	
	
	@Override
	public List<QioUser> seekUserAll() {
		List<QioUser> userlist = qioUserMapper.selectByExample(null);
		// TODO Auto-generated method stub
		return userlist;
	}

	@Override
	public int seekUserNum() {
		int usernum = qioUserMapper.countByExample(null);
		return usernum;
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
