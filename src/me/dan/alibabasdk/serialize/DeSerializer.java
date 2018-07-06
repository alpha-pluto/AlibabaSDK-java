package me.dan.alibabasdk.serialize;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

import me.dan.alibabasdk.entity.ObjectBox;
import me.dan.alibabasdk.entity.ResponseEntity;

/**
 * @Title: DeSerializer.java
 * @Package me.dan.alibabasdk.serialize
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午12:35:14
 * @version 0.0.1
 */
public interface DeSerializer {

	public String supportedObjectFormat();

	public <T> ResponseEntity<T> deSerialize(InputStream istream, Class<T> resultType, String charSet,
			ObjectBox content) throws IOException, ParseException;

	/**
	 * 
	 * @param inputStream
	 * @param statusCode
	 * @param charSet
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public Throwable buildException(InputStream inputStream, int statusCode, String charSet, ObjectBox content)
			throws IOException, ParseException;

}
