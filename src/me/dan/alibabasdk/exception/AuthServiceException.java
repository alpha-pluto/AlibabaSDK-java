package me.dan.alibabasdk.exception;

/**
 * @Title: AuthServiceException.java
 * @Package me.dan.alibabasdk.exception
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午3:32:28
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class AuthServiceException extends AliSDKClientException {

	protected void initDefaultErrorCode() {
		errorCode = "401";
	}

	public AuthServiceException() {
	}

	/**
	 * @param message
	 */
	public AuthServiceException(String message) {
		super("auth service exception:" + message);
		initDefaultErrorCode();
	}

	/**
	 * @param cause
	 */
	public AuthServiceException(Throwable cause) {
		super(cause);
		initDefaultErrorCode();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AuthServiceException(String message, Throwable cause) {
		super(message, cause);
		initDefaultErrorCode();
	}

}
