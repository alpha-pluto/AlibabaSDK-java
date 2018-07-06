package me.dan.alibabasdk.serialize;

import me.dan.alibabasdk.serialize.impl.HttpDeserializer;
import me.dan.alibabasdk.serialize.impl.HttpRequestSerializer;
import me.dan.alibabasdk.serialize.impl.Json2Deserializer;
import me.dan.alibabasdk.serialize.impl.JsonDeserializer;
import me.dan.alibabasdk.serialize.impl.Param2Deserializer;
import me.dan.alibabasdk.serialize.impl.Param2RequestSerializer;
import me.dan.alibabasdk.serialize.impl.ParamDeserializer;
import me.dan.alibabasdk.serialize.impl.ParamRequestSerializer;
import me.dan.alibabasdk.serialize.impl.Xml2Deserializer;

/**
 * @Title: DefaultSerializerProvider.java
 * @Package me.dan.alibabasdk.serialize
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午4:33:47
 * @version 0.0.1
 */
public class DefaultSerializerProvider extends SerializerProvider {

	public DefaultSerializerProvider() {

		register(new Xml2Deserializer());
		register(new JsonDeserializer());
		register(new ParamDeserializer());
		register(new Param2Deserializer());
		register(new Json2Deserializer());
		register(new HttpDeserializer());

		register(new HttpRequestSerializer());
		register(new ParamRequestSerializer());
		register(new Param2RequestSerializer());
	}

}
