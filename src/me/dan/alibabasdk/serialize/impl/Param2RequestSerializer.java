package me.dan.alibabasdk.serialize.impl;

import com.alibaba.fastjson.JSON;

import me.dan.alibabasdk.infrastructure.Protocol;

/**
 * @Title: Param2RequestSerializer.java
 * @Package me.dan.alibabasdk.serialize.impl
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午3:59:32
 * @version 0.0.1
 */
public class Param2RequestSerializer extends AbstractParamRequestSerializer {

	@Override
	public String supportedObjectFormat() {
		return Protocol.param2.name();
	}

	@Override
	protected String processUnsupportedParameter(Object value) {
		return JSON.toJSONString(value);
	}

}
