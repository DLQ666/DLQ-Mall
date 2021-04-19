package com.dlq.pojo;

import java.io.Serializable;
/**
 * <a>是返回结果实体类
 * @author Qiqoo dai lian qi
 *     2019年4月16日
 *  @version v1.5
 */
public class QioResult implements Serializable{
	/**
	 * <a>是否成功
	 */
	private boolean success;
	
	/**
	 * <a>返回信息
	 */
	private String message;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public QioResult(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	
	
}
