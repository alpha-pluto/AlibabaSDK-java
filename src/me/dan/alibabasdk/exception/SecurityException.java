package me.dan.alibabasdk.exception;

/**
 * @Title: SecurityException.java
 * @Package me.dan.alibabasdk.exception
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午3:21:27
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class SecurityException extends AliSDKClientException {

	@Override
	protected void initDefaultErrorCode() {
		errorCode = "400";
	}

	public SecurityException() {

	}

	/*
	 * 
	 */
	public SecurityException(String message) {
		super("security exception:" + message);
		initDefaultErrorCode();
	}

	/**
	 * @param cause
	 */
	public SecurityException(Throwable cause) {
		super(cause);
		initDefaultErrorCode();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SecurityException(String message, Throwable cause) {
		super(message, cause);
		initDefaultErrorCode();
	}

}
