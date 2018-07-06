package me.dan.alibabasdk.util;

import java.util.logging.Logger;

/**
 * @Title: LoggerHelper.java
 * @Package me.dan.alibabasdk.util
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午1:04:33
 * @version 0.0.1
 */
public final class LoggerHelper {

	private static Logger logger = Logger.getLogger("me.dan.aalibabasdk");

	public static Logger getClientLogger() {
		return logger;
	}

	private LoggerHelper() {
	}
}