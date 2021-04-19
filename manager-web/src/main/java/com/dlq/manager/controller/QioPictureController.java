package com.dlq.manager.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dlq.pojo.QioResult;

import javassist.bytecode.analysis.Util;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dlq.common.util.FastDFSClient;
import com.dlq.common.util.JsonUtils;





@RestController
public class QioPictureController {
	
	@Value("${FILE_SERVER_URL}")
	private String file_server_url;
	
	@RequestMapping("/uploadFile")
	public QioResult uploadFile(MultipartFile file){
		// 获得文件名:
		String originalFilename = file.getOriginalFilename();
		String extName = originalFilename.substring( originalFilename.lastIndexOf(".")+1 );
		try {
			// 创建工具类
			FastDFSClient client = new FastDFSClient("classpath:fastDFS/fdfs_client.conf");
			String fileId = client.uploadFile(file.getBytes(), extName); // group1/M00/
			
			String url = URLDecoder.decode(file_server_url+fileId,"UTF-8");
			return new QioResult(true, url);
		} catch (Exception e) {
			e.printStackTrace();
			return new QioResult(false, "上传失败！");
		}
		
		
	}
}
