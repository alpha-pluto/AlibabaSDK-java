package me.dan.alibabasdk.exception;

/**
 * @Title: AliSDKClientException.java
 * @Package me.dan.alibabasdk.exception
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午3:23:52
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class AliSDKClientException extends AliSDKException {

	protected void initDefaultErrorCode() {
		errorCode = "400";
	}

	public AliSDKClientException() {
		super();
	}

	public AliSDKClientException(String message) {
		super(message);
		initDefaultErrorCode();
	}

	public AliSDKClientException(Throwable cause) {
		super(cause);
		initDefaultErrorCode();
	}

	public AliSDKClientException(String message, Throwable cause) {
		super(message, cause);
		initDefaultErrorCode();
	}
}