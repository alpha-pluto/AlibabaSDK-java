package me.dan.alibabasdk.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title: RequestParamModelToMap.java
 * @Package me.dan.alibabasdk.util
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午6:27:57
 * @version 0.0.1
 */
public class RequestParamModelToMap {

	public static Map<String, Object> ConvertRequestParamModelToMap(Object paraModel) {
		Class<?> paramType = paraModel.getClass();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Field[] fields = paramType.getDeclaredFields();
			for (Field field : fields) {
				String key = field.getName();
				int modifier = field.getModifiers();
				if (!Modifier.isStatic(modifier)) {
					try {
						String method = "get" + GenericUtils.capitalizeFirstLetter(key);
						if (field.getType().isAssignableFrom(boolean.class))
							method = "is" + GenericUtils.capitalizeFirstLetter(key);
						Method readMethod = paramType.getMethod(method);
						Object value = readMethod.invoke(paraModel);
						if (null != value)
							map.put(key, value);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}
}
