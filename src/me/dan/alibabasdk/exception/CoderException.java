package me.dan.alibabasdk.exception;

/**
 * @Title: CoderException.java
 * @Package me.dan.alibabasdk.exception
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午5:01:50
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class CoderException extends Exception {

	public CoderException() {
		super();

	}

	public CoderException(String message, Throwable cause) {
		super(message, cause);

	}

	public CoderException(String message) {
		super(message);

	}

	public CoderException(Throwable cause) {
		super(cause);
	}

}
