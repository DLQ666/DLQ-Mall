package com.dlq.manager.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qiologin")
public class QioLoginController {
	
	@RequestMapping("/qiusername")
	public Map qiusername(){
		String qiusername = SecurityContextHolder.getContext().getAuthentication().getName();
		Map map = new HashMap<>();
		map.put("logusername", qiusername);
		return map;
	}

}
