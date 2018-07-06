package me.dan.alibabasdk.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import com.alibaba.fastjson.JSON;

import me.dan.alibabasdk.entity.ResponseStatus;

/**
 * @Title: GenericUtils.java
 * @Package me.dan.alibabasdk.util
 * @Description:
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-03 下午6:22:39
 * @version 0.0.1
 */
public final class GenericUtils {

	private GenericUtils() {

	}

	/************* 字符串相关 start **************/

	public static boolean isBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(str.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}

	/*
	 * 首字母大写
	 */
	public static String capitalizeFirstLetter(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return str;
		}
		return new StringBuffer(strLen).append(Character.toTitleCase(str.charAt(0))).append(str.substring(1))
				.toString();
	}

	/************* 字符串相关 end **************/

	public static boolean isNumeric(String str) {
		if (str == null) {
			return false;
		}
		int sz = str.length();
		for (int i = 0; i < sz; i++) {
			if (Character.isDigit(str.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 通过反射,获得定义Class时声明的父类的范型参数的类型.
	 * 如public BookManager extends GenricManager<Book>
	 * 
	 * @param clazz
	 *            The class to introspect
	 * @return the first generic declaration, or <code>Object.class</code> if cannot
	 *         be determined
	 */
	@SuppressWarnings("rawtypes")
	public static Class getSuperClassGenricType(Class clazz) {
		return getSuperClassGenricType(clazz, 0);
	}

	/**
	 * 通过反射,获得定义Class时声明的父类的范型参数的类型.
	 * 如public BookManager extends GenricManager<Book>
	 * 
	 * @param clazz
	 *            clazz The class to introspect
	 * @param index
	 *            the Index of the generic ddeclaration,start from 0.
	 */
	@SuppressWarnings("rawtypes")
	public static Class getSuperClassGenricType(Class clazz, int index) throws IndexOutOfBoundsException {

		Type genType = clazz.getGenericSuperclass();

		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		if (index >= params.length || index < 0) {
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[index];
	}

	/*
	 * 
	 * 
	 */
	public static String getStreamAsString(InputStream stream, String charset) throws IOException {

		Reader reader = new InputStreamReader(stream, charset);
		StringBuilder response = new StringBuilder();

		final char[] buff = new char[1024];
		int read = 0;
		while ((read = reader.read(buff)) > 0) {
			response.append(buff, 0, read);
		}
		return response.toString();

	}

	public static ResponseStatus buildResponseStatus(String content) {
		Map result = JSON.parseObject(content, Map.class);
		Map<String, Object> m = result;

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
		// errorMesage = StringEscapeUtils.unescapeHtml(errorMesage);
		ResponseStatus responseStatus = new ResponseStatus();
		responseStatus.setCode(errorCodeStr);
		responseStatus.setMessage(errorMesage);
		return responseStatus;
	}
}
