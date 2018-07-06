package me.dan.alibabasdk.exception;

/**
 * @Title: InvokeConnectException.java
 * @Package me.dan.alibabasdk.exception
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午3:36:35
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class InvokeConnectException extends APIInvokeException {

	protected void initDefaultErrorCode() {
		errorCode = "502";
	}

	public InvokeConnectException() {
	}

	/**
	 * @param message
	 */
	public InvokeConnectException(String message) {
		super("invoke connect exception:" + message);
		initDefaultErrorCode();
	}

	/**
	 * @param cause
	 */
	public InvokeConnectException(Throwable cause) {
		super(cause);
		initDefaultErrorCode();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvokeConnectException(String message, Throwable cause) {
		super(message, cause);
		initDefaultErrorCode();
	}
}
