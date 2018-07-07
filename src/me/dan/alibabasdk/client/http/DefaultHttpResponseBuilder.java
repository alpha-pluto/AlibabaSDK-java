package me.dan.alibabasdk.client.http;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.text.ParseException;
import java.util.Collection;
import java.util.zip.GZIPInputStream;

import me.dan.alibabasdk.entity.ObjectBox;
import me.dan.alibabasdk.entity.ResponseEntity;
import me.dan.alibabasdk.entity.ResponseStatus;
import me.dan.alibabasdk.infrastructure.GenericAPIPlot;
import me.dan.alibabasdk.infrastructure.Protocol;
import me.dan.alibabasdk.serialize.DeSerializer;
import me.dan.alibabasdk.util.GenericUtils;
import me.dan.alibabasdk.util.LoggerHelper;

/**
 * @Title: DefaultHttpResponseBuilder.java
 * @Package me.dan.alibabasdk.client.http
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-05 下午3:43:08
 * @version 0.0.1
 */
public class DefaultHttpResponseBuilder implements HttpResponseBuilder {

	protected static final String CONTENT_ENCODING_GZIP = "gzip";

	@SuppressWarnings("unchecked")
	protected <T> T parseBody(InputStream istream, GenericAPIPlot apiPlot, String charset,
			Collection<DeSerializer> deSerializers, ObjectBox content) throws IOException, ParseException {
		Class<T> resultType = (Class<T>) apiPlot.getResultType();
		Protocol protocol = apiPlot.getRequestPolicy().getRequestProtocol();
		DeSerializer deSerializer = apiPlot.getInvokeClient().getSerializerProvider().getDeSerializer(protocol.name());
		ResponseEntity<T> responseEntity = deSerializer.deSerialize(istream, resultType, charset, content);
		return (T) responseEntity.getResult();
	}

	public Throwable buildException(InputStream istream, int statusCode, GenericAPIPlot apiPlot, String charset,
			Collection<DeSerializer> deSerializers, ObjectBox content) throws IOException, ParseException {
		Protocol protocol = apiPlot.getRequestPolicy().getRequestProtocol();
		DeSerializer deSerializer = apiPlot.getInvokeClient().getSerializerProvider().getDeSerializer(protocol.name());
		if (deSerializer == null) {
			throw new RuntimeException(
					"The Protocol[" + protocol.name() + "] is not supported when parse the response.");
		}

		Throwable rhrowable = deSerializer.buildException(istream, statusCode, charset, content);
		return rhrowable;
	}

	@Override
	public <T> ResponseEntity<T> buildResponse(InputStream istream, int httpCode, String contentEncoding,
			String contentType, GenericAPIPlot apiPlot, Collection<DeSerializer> deSerializers, ObjectBox content) {

		// LoggerHelper.getClientLogger().info("--Start init Response--");

		ResponseEntity<T> response = new ResponseEntity<T>();
		response.setStatusCode(httpCode);
		if (contentEncoding != null) {
			response.setEncoding(contentEncoding);
		}
		if (contentType == null) {
			response.setException(new IllegalStateException("response need content type"));
		} else {
			String charset = HttpHelper.parseResponseCharset(apiPlot.getRequestPolicy(), contentType);
			response.setEncoding(charset);

		}
		try {
			if (CONTENT_ENCODING_GZIP.equalsIgnoreCase(response.getEncoding())) {
				// LoggerHelper.getClientLogger().info(" translate InputStream to
				// GZIPInputStream ");
				istream = new GZIPInputStream(istream);
			}
			// LoggerHelper.getClientLogger().info("Response status code :" +
			// response.getStatusCode());

			if (response.getStatusCode() >= 200 && response.getStatusCode() <= 299) {
				Object result = parseBody(istream, apiPlot, response.getEncoding(), deSerializers, content);
				response.setResult((T) result);
				ResponseStatus responseStatus = new ResponseStatus();
				responseStatus.setCode(String.valueOf(httpCode));
				responseStatus.setMessage("status : " + response.getStatusCode());
				response.setResponseStatus(responseStatus);
			} else {

				Throwable exception = buildException(istream, response.getStatusCode(), apiPlot, response.getEncoding(),
						deSerializers, content);
				ResponseStatus responseStatus = GenericUtils.buildResponseStatus((String) content.object);
				response.setException(exception);
				response.setResponseStatus(responseStatus);
			}
		} catch (IOException e) {
			e.printStackTrace();
			response.setException(e);
			response.getResponseStatus().setCode("exception");
			response.getResponseStatus().setMessage(e.getMessage());
		} catch (RuntimeException e) {
			e.printStackTrace();
			response.setException(e);
			response.getResponseStatus().setCode("exception");
			response.getResponseStatus().setMessage(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			response.setException(e);
			response.getResponseStatus().setCode("exception");
			response.getResponseStatus().setMessage(e.getMessage());
		}
		return response;
	}

}
