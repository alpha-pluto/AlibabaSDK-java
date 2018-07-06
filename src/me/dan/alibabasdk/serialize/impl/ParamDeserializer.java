package me.dan.alibabasdk.serialize.impl;

import me.dan.alibabasdk.infrastructure.Protocol;

/**
 * @Title: ParamDeserializer.java
 * @Package me.dan.alibabasdk.serialize.impl
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午3:58:07
 * @version 0.0.1
 */
public class ParamDeserializer extends JsonDeserializer {

	@Override
	public String supportedObjectFormat() {
		return Protocol.param.name();
	}

}
