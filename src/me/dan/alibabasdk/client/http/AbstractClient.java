package me.dan.alibabasdk.client.http;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import me.dan.alibabasdk.entity.ResponseEntity;
import me.dan.alibabasdk.exception.AliSDKException;
import me.dan.alibabasdk.infrastructure.GenericAPIPlot;
import me.dan.alibabasdk.infrastructure.HttpMethod;
import me.dan.alibabasdk.infrastructure.Protocol;
import me.dan.alibabasdk.serialize.DeSerializer;
import me.dan.alibabasdk.serialize.Serializer;
import me.dan.alibabasdk.serialize.SerializerProvider;

/**
 * @Title: AbstractClient.java
 * @Package me.dan.alibabasdk.client.http
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-05 下午12:12:55
 * @version 0.0.1
 */
public abstract class AbstractClient {

	private SerializerProvider serializerProvider;

	private HttpResponseBuilder responseBuilder;

	public AbstractClient(SerializerProvider serializerProvider, HttpResponseBuilder responseBuilder) {
		super();
		this.serializerProvider = serializerProvider;
		this.responseBuilder = responseBuilder;
	}

	public void setSerializerProvider(SerializerProvider serializerProvider) {
		this.serializerProvider = serializerProvider;
	}

	public void setResponseBuilder(HttpResponseBuilder responseBuilder) {
		this.responseBuilder = responseBuilder;
	}

	public SerializerProvider getSerializerProvider() {
		return serializerProvider;
	}

	public HttpResponseBuilder getResponseBuilder() {
		return responseBuilder;
	}

	protected abstract <T> ResponseEntity<T> doMultipartPost(URL url, Map<String, Object> parameters,
			GenericAPIPlot apiPlot, Collection<DeSerializer> deSerializers) throws IOException, AliSDKException;

	protected abstract <T> ResponseEntity<T> doPost(URL url, Map<String, Object> parameters, GenericAPIPlot apiPlot,
			Collection<DeSerializer> deSerializers) throws IOException, AliSDKException;

	protected abstract <T> ResponseEntity<T> doGet(URL url, Map<String, Object> parameters, GenericAPIPlot apiPlot,
			Collection<DeSerializer> deSerializers) throws IOException, AliSDKException;

	public <T> ResponseEntity<T> request(GenericAPIPlot apiPlot, Collection<Serializer> serializers,
			Collection<DeSerializer> deSerializers) throws IOException, AliSDKException {
		Protocol protocol = apiPlot.getRequestPolicy().getRequestProtocol();
		Serializer serializer = serializerProvider.getSerializer(protocol.name());
		ResponseEntity<T> response = new ResponseEntity<T>();

		HttpHelper.forceOceanDateFormat(apiPlot.getRequestPolicy(), apiPlot.getParams());

		HttpHelper.attachAccessToken(apiPlot.getRequestPolicy(), apiPlot.getParams());
		// signature the request
		HttpHelper.signature(apiPlot.getRequestPolicy(), apiPlot.getParams());

		if (HttpMethod.GET.equals(apiPlot.getRequestPolicy().getHttpMethod())) {
			URL getURL = HttpHelper.buildRequestUrl(apiPlot, apiPlot.getParams());
			response = this.doGet(getURL, apiPlot.getParams(), apiPlot, deSerializers);
			return response;
		} else {
			URL postURL = HttpHelper.buildRequestUrl(apiPlot, apiPlot.getParams());
			for (Map.Entry<String, Object> entity : apiPlot.getParams().entrySet()) {
				Object inputValue = entity.getValue();
				// System.out.println(entry.getKey() + "===>" + inputValue);
				if (inputValue.getClass().isAssignableFrom(byte[].class)
						|| inputValue.getClass().isAssignableFrom(Byte[].class)) {
					return this.doMultipartPost(postURL, apiPlot.getParams(), apiPlot, deSerializers);
				}
			}
			response = this.doPost(postURL, apiPlot.getParams(), apiPlot, deSerializers);
			return response;
		}
	}

}
