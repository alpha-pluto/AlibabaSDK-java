package me.dan.alibabasdk.entity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Title: ResponseEntityBase.java
 * @Package me.dan.alibabasdk.entity
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-05 下午8:00:04
 * @version 0.0.1
 */
public abstract class ResponseEntityBase<T> {

	private int statusCode;

	private String requestTime;

	private long invokeDuration;

	private ResponseStatus responseStatus;

	private String encoding;

	private Throwable exception;

	private T result;

	private Object originData;

	private String signature;

	public Class<T> getResponseClass() {
		// return GenericUtils.getSuperClassGenricType(this.getClass(), 0);
		Type persistentClass = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		return null;
	}

	public ResponseEntityBase() {
		super();
		this.responseStatus = new ResponseStatus();
	}

	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	public long getInvokeDuration() {
		return invokeDuration;
	}

	public void setInvokeDuration(long invokeDuration) {
		this.invokeDuration = invokeDuration;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public Throwable getException() {
		return exception;
	}

	public void setException(Throwable exception) {
		this.exception = exception;
	}

	public ResponseStatus getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(ResponseStatus responseStatus) {
		this.responseStatus = responseStatus;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public Object getOriginData() {
		return originData;
	}

	public void setOriginData(Object originData) {
		this.originData = originData;
	}

}
