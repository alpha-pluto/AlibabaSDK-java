package me.dan.alibabasdk.util;

import java.io.IOException;
import java.util.Map;

import me.dan.alibabasdk.exception.AliSDKException;
import me.dan.alibabasdk.exception.AuthServiceException;
import me.dan.alibabasdk.exception.InvokeConnectException;
import me.dan.alibabasdk.exception.InvokeTimeoutException;
import me.dan.alibabasdk.exception.UnsupportAPIException;

/**
 * @Title: ExceptionParser.java
 * @Package me.dan.alibabasdk.util
 * @Description: TODO
 * @date 2018-07-04 下午2:56:05
 * @version 0.0.1
 */
public class ExceptionParser {

	/**
	 * for Protocol.Json2
	 * 
	 * @param exption
	 * @return the new exception
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 * @throws IOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Throwable buildException4Json2(Map exption) {
		Map<String, Object> m = exption;

		String errorCodeStr = (String) m.get("error_code");
		String errorMesage = (String) m.get("error_message");

		if (GenericUtils.isBlank(errorCodeStr)) {
			errorCodeStr = (String) m.get("error");
		}

		if (GenericUtils.isBlank(errorMesage)) {
			errorMesage = (String) m.get("error_description");
		}
		// if null ,then just return the result
		if (GenericUtils.isBlank(errorMesage)) {
			errorMesage = "Unknow message defined in response.";
		}

		if (GenericUtils.isBlank(errorCodeStr) || !GenericUtils.isNumeric(errorCodeStr)) {
			return buildException(errorCodeStr, errorMesage);
		} else {
			int errorCode = Integer.parseInt(errorCodeStr);
			return buildException(errorCode, errorMesage);
		}
	}

	@SuppressWarnings("unchecked")
	public static Throwable buildException4OAuth2(Object exption) {
		Map<String, Object> m = (Map<String, Object>) exption;
		int errorCode = 401;
		String errorMesage = (String) m.get("error_description");
		return buildException(errorCode, errorMesage);
	}

	private static Throwable buildException(int errorCode, String errorMesage) {

		switch (errorCode) {
		case 400:
			return new SecurityException(errorMesage);
		case 401:
			return new AuthServiceException(errorMesage);
		case 404:
			return new UnsupportAPIException(errorMesage);
		case 502:
			return new InvokeConnectException(errorMesage);
		case 504:
			return new InvokeTimeoutException(errorMesage);
		}
		return new AliSDKException(String.valueOf(errorCode), errorMesage);
	}

	private static Throwable buildException(String errorCode, String errorMesage) {
		return new AliSDKException(errorCode, errorMesage);
	}
}
