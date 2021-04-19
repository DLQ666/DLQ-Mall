package com.dlq.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.dlq.common.pojo.QIResult;
import com.dlq.common.util.JsonUtils;
import com.dlq.jedis.JedisClient;
import com.dlq.mapper.QioUserAddressMapper;
import com.dlq.mapper.QioUserMapper;
import com.dlq.pojo.QioUser;
import com.dlq.pojo.QioUserAddress;
import com.dlq.pojo.QioUserExample;
import com.dlq.pojo.QioUserExample.Criteria;
import com.dlq.sso.service.QioUserService;

@Service
public class QioUserServiceImpl implements QioUserService {

	@Autowired
	private QioUserMapper qioUserMapper;
	@Autowired
	private QioUserAddressMapper qioUserAddressMapper;
	
	@Autowired
	private JedisClient  jedisClient;
	
	@Value("${USER_SESSION}")
	private String USER_SESSION;
	
	@Value("${SESSION_EXPIRE}")
	private Integer SESSION_EXPIRE;
	
	@Override
	public QIResult checkData(String data, int type) {
		
		QioUserExample example = new QioUserExample();
		Criteria criteria = example.createCriteria();
		//判断1 用户名是否可用
		if(type==1){
			criteria.andCustnameEqualTo(data);
		//判断2手机是否可用
		}else if (type==2) {
			criteria.andCustcallEqualTo(data);
		}else{
			return QIResult.build(400, "包含非法数据");
		}
		//查询
		List<QioUser> list = qioUserMapper.selectByExample(example);
		if(list !=null && list.size() > 0){
			//查询数据，返回false
			return QIResult.ok(false);
		}
		return QIResult.ok(true);
	}

	@Override
	public QIResult register(QioUser qioUser) {
		//判断数据
		if(org.apache.commons.lang3.StringUtils.isBlank(qioUser.getCustname())){
			return QIResult.build(400, "用户名不能为空");
		}
		QIResult result = checkData(qioUser.getCustname(),1);
		if (!(boolean) result.getData()) {
			return QIResult.build(400, "用户名重复");
		}
		if(org.apache.commons.lang3.StringUtils.isBlank(qioUser.getCustpassword())){
			return QIResult.build(400, "密码不能为空");
		}
		if(org.apache.commons.lang3.StringUtils.isNotBlank(qioUser.getCustcall())){
			result = checkData(qioUser.getCustcall(), 2);
			if (!(boolean) result.getData()) {
				return QIResult.build(400, "电话号码重复");
			}
		}
		
		//将密码进行MD5加密
		String md5DigestAsHex = DigestUtils.md5DigestAsHex(qioUser.getCustpassword().getBytes());
		qioUser.setCustpassword(md5DigestAsHex);
		//插入数据
		qioUserMapper.insert(qioUser);
		//返回注册成功
		return QIResult.ok();
	}

	@Override
	public QIResult login(String custname, String custpassword) {
		//判断数据是否正确
		QioUserExample example = new QioUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andCustnameEqualTo(custname);
		List<QioUser> list = qioUserMapper.selectByExample(example);
		if(list == null || list.size() == 0){
			//返回登录失败
			return QIResult.build(400, "用户名或密码不正确");
		}
		//取user中第一条数据
		QioUser user = list.get(0);
		//密码进行MD5加密然后校验
		if(!DigestUtils.md5DigestAsHex(custpassword.getBytes()).equals(user.getCustpassword())){
			//返回登录失败
			return QIResult.build(400, "用户名或密码不正确");
			
		}
		//生成token 使用UUID
		String token = UUID.randomUUID().toString();
		//清空密码
		user.setCustpassword(null);
		//将用户数据存到redis 
		jedisClient.set(USER_SESSION +":"+ token,JsonUtils.objectToJson(user));
		// 设置过期时间
		jedisClient.expire(USER_SESSION +":"+ token,SESSION_EXPIRE);
		//返回登陆成功。把token返回
		return QIResult.ok(token);
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
		/*return QIResult.ok(json);*/
	}

	@Override
	public QioUserAddress selectByPrimaryKey(Integer id) {
		QioUserAddress qioUserAddress = qioUserAddressMapper.selectByPrimaryKey(id);
		return qioUserAddress;
	}

	@Override
	public QioUser getUserById(Integer id) {
		QioUser qioUser = qioUserMapper.selectByPrimaryKey(id);
		return qioUser;
	}

	@Override
	public void updateUserById(QioUser qioUser) {
		int updateByPrimaryKey = qioUserMapper.updateByPrimaryKey(qioUser);
		System.out.println("修改成功"+updateByPrimaryKey);
		
	}
	
	

}
