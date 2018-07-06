package me.dan.alibabasdk.exception;

/**
 * @Title: InvokeTimeoutException.java
 * @Package me.dan.alibabasdk.exception
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午3:38:29
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class InvokeTimeoutException extends APIInvokeException {

	protected void initDefaultErrorCode() {
		errorCode = "504";
	}

	public InvokeTimeoutException() {
	}

	/**
	 * @param message
	 */
	public InvokeTimeoutException(String message) {
		super("invoke timeout exception:" + message);
		initDefaultErrorCode();
	}

	/**
	 * @param cause
	 */
	public InvokeTimeoutException(Throwable cause) {
		super(cause);
		initDefaultErrorCode();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvokeTimeoutException(String message, Throwable cause) {
		super(message, cause);
		initDefaultErrorCode();
	}

}
