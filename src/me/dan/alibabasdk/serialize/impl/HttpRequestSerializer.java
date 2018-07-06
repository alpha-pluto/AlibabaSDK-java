package me.dan.alibabasdk.serialize.impl;

import me.dan.alibabasdk.infrastructure.Protocol;

/**
 * @Title: HttpRequestSerializer.java
 * @Package me.dan.alibabasdk.serialize.impl
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午4:03:42
 * @version 0.0.1
 */
public class HttpRequestSerializer extends AbstractParamRequestSerializer {

	@Override
	public String supportedObjectFormat() {
		return Protocol.http.name();
	}

	@Override
	protected String processUnsupportedParameter(Object value) {
		throw new RuntimeException("The param protocol does not support Complex parameters.");
	}

}
