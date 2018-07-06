package me.dan.alibabasdk.serialize.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import me.dan.alibabasdk.entity.ObjectBox;
import me.dan.alibabasdk.entity.ResponseEntity;
import me.dan.alibabasdk.serialize.DeSerializer;
import me.dan.alibabasdk.util.DateUtil;
import me.dan.alibabasdk.util.LoggerHelper;

/**
 * @Title: AbstractJsonDeserializer.java
 * @Package me.dan.alibabasdk.serialize.impl
 * @Description: TODO
 * @date 2018-07-04 下午2:40:18
 */
public abstract class AbstractJsonDeserializer implements DeSerializer {

	@Override
	public <T> ResponseEntity<T> deSerialize(InputStream istream, Class<T> resultType, String charSet,
			ObjectBox content) throws IOException, ParseException {
		LoggerHelper.getClientLogger().finer("Parse response body by json. deSerialize");
		String strContent = getStreamAsString(istream, charSet);
		content.object = strContent;
		return deSerialize(strContent, resultType);
	}

	public abstract <T> ResponseEntity<T> deSerialize(String content, Class<T> resultType);

	public abstract Throwable buildException(String content, int statusCode);

	@Override
	public Throwable buildException(InputStream inputStream, int statusCode, String charSet, ObjectBox content)
			throws IOException, ParseException {
		LoggerHelper.getClientLogger().info("Parse response body by json. buildException");
		String strContent = getStreamAsString(inputStream, charSet);
		content.object = strContent;
		return buildException(strContent, statusCode);
	}

	protected <T> T parseResult(JSONObject json, Class<T> resultType) {
		LoggerHelper.getClientLogger().finer("Parse response body by json.");
		T result = JSON.toJavaObject(json, resultType);
		return result;
	}

	/*
	 * 从inputstream中按charset将io流转换成字符串
	 */
	private String getStreamAsString(InputStream stream, String charset) throws IOException {

		Reader reader = new InputStreamReader(stream, charset);
		StringBuilder response = new StringBuilder();

		final char[] buff = new char[1024];
		int read = 0;
		while ((read = reader.read(buff)) > 0) {
			response.append(buff, 0, read);
		}
		return response.toString();

	}
}
