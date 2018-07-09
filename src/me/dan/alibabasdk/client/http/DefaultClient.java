package me.dan.alibabasdk.client.http;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import me.dan.alibabasdk.entity.ObjectBox;
import me.dan.alibabasdk.entity.ResponseEntity;
import me.dan.alibabasdk.exception.AliSDKException;
import me.dan.alibabasdk.infrastructure.APIPlot;
import me.dan.alibabasdk.infrastructure.GenericAPIPlot;
import me.dan.alibabasdk.serialize.DeSerializer;
import me.dan.alibabasdk.serialize.SerializerProvider;

/**
 * @Title: DefaultClient.java
 * @Package me.dan.alibabasdk.client.http
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-05 下午1:20:32
 * @version 0.0.1
 */
public class DefaultClient extends AbstractClient {

	public DefaultClient(SerializerProvider serializerProvider, HttpResponseBuilder responseBuilder) {

		super(serializerProvider, responseBuilder);

	}

	@Override
	protected <T> ResponseEntity<T> doMultipartPost(URL url, Map<String, Object> parameters, GenericAPIPlot apiPlot,
			Collection<DeSerializer> deSerializers) throws IOException, AliSDKException {
		HttpURLConnection conn = null;
		ResponseEntity<T> response = null;
		ObjectBox content = new ObjectBox();
		String BOUNDARY = "---------------------------" + (new Date()).getTime();
		OutputStream out = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			Map<String, String> clientHttpHeader = HttpHelper.buildHttpHeader();
			for (Map.Entry<String, String> entry : clientHttpHeader.entrySet()) {
				conn.setRequestProperty(entry.getKey(), entry.getValue());
			}
			conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

			out = new DataOutputStream(conn.getOutputStream());

			StringBuffer strBuf = new StringBuffer();
			Iterator<Map.Entry<String, Object>> iter = parameters.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry<String, Object> entry = iter.next();
				String inputName = (String) entry.getKey();
				Object inputValue = entry.getValue();
				if (inputValue == null) {
					continue;
				}
				if (inputValue.getClass().isAssignableFrom(byte[].class)
						|| inputValue.getClass().isAssignableFrom(Byte[].class)) {
					strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
					strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"" + "\"\r\n");
					strBuf.append("Content-Type:" + "application/x-www-form-urlencoded" + "\r\n\r\n");
					out.write(strBuf.toString().getBytes());
					if (inputValue instanceof byte[]) {
						byte[] inputBytes = (byte[]) inputValue;
						out.write(inputBytes);
					}
					if (inputValue instanceof Byte[]) {
						Byte[] inputBytes = (Byte[]) inputValue;
						for (Byte b : inputBytes) {
							out.write(b.byteValue());
						}
					}
				} else {
					strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
					strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"\r\n\r\n");
					strBuf.append(inputValue);
					out.write(strBuf.toString().getBytes());
				}
			}
			int httpCode = conn.getResponseCode();
			String contentEncoding = conn.getContentEncoding();
			String contentType = conn.getContentType();
			InputStream inputStream = null;
			if (httpCode >= 200 && httpCode <= 299) {
				inputStream = conn.getInputStream();
			} else {
				inputStream = conn.getErrorStream();
			}
			response = this.getResponseBuilder().buildResponse(inputStream, httpCode, contentEncoding, contentType,
					apiPlot, deSerializers, content);
			response.setOriginData(content.object);
		} catch (IOException e) {
			throw e;
		} finally {
			if (out != null) {
				out.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return response;
	}

	@Override
	protected <T> ResponseEntity<T> doPost(URL url, Map<String, Object> parameters, GenericAPIPlot apiPlot,
			Collection<DeSerializer> deSerializers) throws IOException, AliSDKException {
		HttpURLConnection conn = null;
		OutputStream out = null;
		ResponseEntity<T> response = null;
		ObjectBox content = new ObjectBox();
		try {
			try {
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setDoInput(true);
				conn.setDoOutput(true);
				Map<String, String> clientHttpHeader = HttpHelper.buildHttpHeader();
				for (Map.Entry<String, String> entry : clientHttpHeader.entrySet()) {
					conn.setRequestProperty(entry.getKey(), entry.getValue());
				}
			} catch (IOException e) {
				throw e;
			}
			try {
				String query = HttpHelper.buildQuery(parameters);
				byte[] byteContent = {};
				if (query != null) {
					byteContent = query.getBytes(apiPlot.getRequestPolicy().getRequestBodyCharset());
				}
				out = conn.getOutputStream();
				out.write(byteContent);

				int httpCode = conn.getResponseCode();
				String contentEncoding = conn.getContentEncoding();
				String contentType = conn.getContentType();
				InputStream inputStream = null;
				if (httpCode >= 200 && httpCode <= 299) {
					inputStream = conn.getInputStream();
				} else {
					inputStream = conn.getErrorStream();
				}

				response = this.getResponseBuilder().buildResponse(inputStream, httpCode, contentEncoding, contentType,
						apiPlot, deSerializers, content);
				response.setOriginData(content.object);
			} catch (IOException e) {
				throw e;
			}
		} finally {
			if (out != null) {
				out.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return response;
	}

	@Override
	protected <T> ResponseEntity<T> doGet(URL url, Map<String, Object> parameters, GenericAPIPlot apiPlot,
			Collection<DeSerializer> deSerializers) throws IOException, AliSDKException {
		HttpURLConnection conn = null;
		OutputStream out = null;
		ResponseEntity<T> response = null;
		ObjectBox content = new ObjectBox();
		try {
			try {
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setDoInput(true);
				conn.setDoOutput(true);
				Map<String, String> clientHttpHeader = HttpHelper.buildHttpHeader();
				for (Map.Entry<String, String> entry : clientHttpHeader.entrySet()) {
					conn.setRequestProperty(entry.getKey(), entry.getValue());
				}
			} catch (IOException e) {
				throw e;
			}
			try {
				int httpCode = conn.getResponseCode();
				String contentEncoding = conn.getContentEncoding();
				String contentType = conn.getContentType();
				InputStream inputStream = null;
				if (httpCode >= 200 && httpCode <= 299) {
					inputStream = conn.getInputStream();
				} else {
					inputStream = conn.getErrorStream();
				}

				response = this.getResponseBuilder().buildResponse(inputStream, httpCode, contentEncoding, contentType,
						apiPlot, deSerializers, content);
				response.setOriginData(content.object);
			} catch (IOException e) {
				throw e;
			}
		} finally {
			if (out != null) {
				out.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return response;
	}

}
