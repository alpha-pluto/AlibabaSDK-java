package me.dan.alibabasdk.client.http;

import java.io.InputStream;
import java.util.Collection;

import me.dan.alibabasdk.entity.ObjectBox;
import me.dan.alibabasdk.entity.ResponseEntity;
import me.dan.alibabasdk.infrastructure.APIPlot;
import me.dan.alibabasdk.infrastructure.GenericAPIPlot;
import me.dan.alibabasdk.infrastructure.RequestPolicy;
import me.dan.alibabasdk.serialize.DeSerializer;

/**
 * @Title: HttpResponseBuilder.java
 * @Package me.dan.alibabasdk.client.http
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-05 下午12:47:13
 * @version 0.0.1
 */
public interface HttpResponseBuilder {

	public <T> ResponseEntity<T> buildResponse(InputStream istream, int httpCode, String contentEncoding,
			String contentType, GenericAPIPlot apiPlot, Collection<DeSerializer> deSerializers, ObjectBox content);

}
