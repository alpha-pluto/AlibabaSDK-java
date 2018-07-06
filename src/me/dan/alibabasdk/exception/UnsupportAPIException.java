package me.dan.alibabasdk.exception;

/**
 * @Title: UnsupportAPIException.java
 * @Package me.dan.alibabasdk.exception
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午3:33:54
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class UnsupportAPIException extends AliSDKClientException {

	protected void initDefaultErrorCode() {
		errorCode = "404";
	}

	public UnsupportAPIException() {
	}

	/**
	 * @param message
	 */
	public UnsupportAPIException(String message) {
		super("unsupport api:" + message);
		initDefaultErrorCode();
	}

	/**
	 * @param cause
	 */
	public UnsupportAPIException(Throwable cause) {
		super(cause);
		initDefaultErrorCode();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UnsupportAPIException(String message, Throwable cause) {
		super(message, cause);
		initDefaultErrorCode();
	}

}
