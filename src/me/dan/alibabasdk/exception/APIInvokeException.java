package me.dan.alibabasdk.exception;

/**
 * @Title: APIInvokeException.java
 * @Package me.dan.alibabasdk.exception
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午3:35:17
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class APIInvokeException extends AliSDKException {

	protected void initDefaultErrorCode() {
		errorCode = "500";
	}

	/**
	 * 
	 */
	public APIInvokeException() {
	}

	/**
	 * @param message
	 */
	public APIInvokeException(String message) {
		super(message);
		initDefaultErrorCode();
	}

	/**
	 * @param cause
	 */
	public APIInvokeException(Throwable cause) {
		super(cause);
		initDefaultErrorCode();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public APIInvokeException(String message, Throwable cause) {
		super(message, cause);
		initDefaultErrorCode();
	}
}
