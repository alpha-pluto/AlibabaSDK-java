package me.dan.alibabasdk.serialize.impl;

import me.dan.alibabasdk.infrastructure.Protocol;

/**
 * @Title: ParamRequestSerializer.java
 * @Package me.dan.alibabasdk.serialize.impl
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午1:42:16
 * @version 0.0.1
 */
public class ParamRequestSerializer extends AbstractParamRequestSerializer {

	@Override
	public String supportedObjectFormat() {
		return Protocol.param.name();
	}

	@Override
	protected String processUnsupportedParameter(Object value) {
		throw new RuntimeException("The param protocol does not support complex parameters.");
	}

}
