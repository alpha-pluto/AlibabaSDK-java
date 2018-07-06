package me.dan.alibabasdk.exception;

/**
 * @Title: AliSDKException.java
 * @Package me.dan.alibabasdk.exception
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-03 下午6:47:08
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class AliSDKException extends Exception {

	protected String errorCode;

	protected String errorMessage;

	public AliSDKException() {
		super();
	}

	public AliSDKException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public AliSDKException(Throwable cause) {
		super(cause);
	}

	public AliSDKException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public AliSDKException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
		this.errorMessage = errorMessage;
	}

}
