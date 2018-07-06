package me.dan.alibabasdk.serialize.impl;

import me.dan.alibabasdk.infrastructure.Protocol;

/**
 * @Title: Param2Deserializer.java
 * @Package me.dan.alibabasdk.serialize.impl
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午4:01:25
 * @version 0.0.1
 */
public class Param2Deserializer extends Json2Deserializer {

	@Override
	public String supportedObjectFormat() {
		return Protocol.param2.name();
	}

}
