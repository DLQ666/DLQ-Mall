package com.dlq.manager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dlq.pojo.QioUser;
import com.dlq.service.QioUserService;

@RestController
@RequestMapping("/ouser")
public class QioUserController {
	
	@Reference
	private QioUserService qioUserService;
	
	@RequestMapping("/seekUserAll")
	public List<QioUser> seekUserAll(){
		List<QioUser> userAll = qioUserService.seekUserAll();
		return userAll;
	}
	@RequestMapping("/seekUserSum")
	public Map seekUserSum(){
		int userNum = qioUserService.seekUserNum();
		Map map = new HashMap<>();
		map.put("usersum", userNum);
		return map;
	}
	

}
