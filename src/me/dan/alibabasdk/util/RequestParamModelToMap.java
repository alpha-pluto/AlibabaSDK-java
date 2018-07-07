package me.dan.alibabasdk.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
					/*
					 * try {
					 * String method = "get" + GenericUtils.capitalizeFirstLetter(key);
					 * if (field.getType().isAssignableFrom(boolean.class))
					 * method = "is" + GenericUtils.capitalizeFirstLetter(key);
					 * Method readMethod = paramType.getMethod(method);
					 * Object value = readMethod.invoke(paraModel);
					 * if (null != value)
					 * map.put(key, value);
					 * } catch (Exception ex) {
					 * ex.printStackTrace();
					 * }
					 */
					field.setAccessible(true);
					Object value = field.get(paraModel);
					if (null != value)
						map.put(key, value);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	/**
	 * @Title: ConvertObjectToMap
	 * @Description: 将类型转换为map
	 * @param targer
	 * @return
	 * @return Map<String,Object>
	 * @throws
	 * 
	 */
	public static Map<String, Object> ConvertObjectToMap(Object targer) {
		Class<?> paramType = targer.getClass();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Field[] fields = paramType.getDeclaredFields();
			for (Field field : fields) {
				String key = field.getName();
				field.setAccessible(true);
				Object value = field.get(targer);
				if (field.getClass().isPrimitive()) {
					map.put(key, value);
				} else {
					Map<String, Object> subMap = ConvertObjectToMap(value);
					map.put(key, subMap);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public static String ConvertMapToString(Map<String, Object> map) {
		StringBuilder sbMap = new StringBuilder();
		sbMap.append("{");
		for (Entry<String, Object> entry : map.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if (!Map.class.isAssignableFrom(value.getClass())) {
				sbMap.append(key + " = " + value.toString());
			} else {
				sbMap.append(key + " = {");
				String subString = ConvertMapToString((Map<String, Object>) value);
				sbMap.append(subString);
				sbMap.append(" }");
			}
		}
		sbMap.append("}");
		return sbMap.toString();
	}

}
