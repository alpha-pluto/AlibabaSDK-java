package me.dan.alibabasdk.entity;

/**
 * @Title: ResponseStatus.java
 * @Package me.dan.alibabasdk.entity
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午3:46:37
 * @version 0.0.1
 */
public class ResponseStatus {
	private String code;

	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {

		return "ResponseStatus={code='" + code + "', message='" + message + "'}";
	}
}
