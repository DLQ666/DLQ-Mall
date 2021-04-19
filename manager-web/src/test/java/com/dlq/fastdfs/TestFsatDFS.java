package com.dlq.fastdfs;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

public class TestFsatDFS {
	
	@Test
	public void uploadFile() throws Exception{
		
		ClientGlobal.init("D:\\Desktop\\gitmall\\Tao-Mall\\manager-web\\src\\main\\resources\\fastDFS\\fdfs_client.conf");
		
		TrackerClient trackerClient=new TrackerClient();
		TrackerServer trackerServer=trackerClient.getConnection();
		StorageServer storageServer=null;
		StorageClient storageClient=new StorageClient(trackerServer, storageServer);//C:\\Users\\86158\\Desktop\\a.jpg
		String[] strings = storageClient.upload_file("D:\\Desktop\\a.jpg", "jpg", null);
		for (String string: strings){
			System.out.println(string);
		}
	}
}
