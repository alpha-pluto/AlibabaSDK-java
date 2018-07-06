package me.dan.alibabasdk.serialize.impl;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import me.dan.alibabasdk.entity.ResponseEntity;
import me.dan.alibabasdk.infrastructure.Protocol;
import me.dan.alibabasdk.util.ExceptionParser;

/**
 * @Title: Json2Deserializer.java
 * @Package me.dan.alibabasdk.serialize.impl
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午3:53:19
 * @version 0.0.1
 */
public class HttpDeserializer extends AbstractJsonDeserializer {

	@Override
	public String supportedObjectFormat() {
		return Protocol.http.name();
	}

	@Override
	public <T> ResponseEntity<T> deSerialize(String content, Class<T> resultType) {
		JSONObject json = JSON.parseObject(content);
		T result = this.parseResult(json, resultType);
		ResponseEntity<T> responseEntity = new ResponseEntity<T>();
		responseEntity.setResult(result);
		return responseEntity;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Throwable buildException(String content, int statusCode) {
		Map result = JSON.parseObject(content, Map.class);
		return ExceptionParser.buildException4Json2(result);
	}

}
