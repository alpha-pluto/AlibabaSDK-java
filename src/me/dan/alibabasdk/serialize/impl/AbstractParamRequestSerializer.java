package me.dan.alibabasdk.serialize.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import me.dan.alibabasdk.serialize.Serializer;
import me.dan.alibabasdk.util.DateUtil;
import me.dan.alibabasdk.util.DefaultPropertyUtils;
import me.dan.alibabasdk.util.GenericUtils;
import me.dan.alibabasdk.util.SimplePropertyDescriptor;

/**
 * @Title: AbstractParamRequestSerializer.java
 * @Package me.dan.alibabasdk.serialize.impl
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午1:38:40
 * @version 0.0.1
 */
public abstract class AbstractParamRequestSerializer implements Serializer {

	@Override
	public String supportedObjectFormat() {
		// TODO Auto-generated method stub
		return null;
	}

	abstract protected String processUnsupportedParameter(Object value);

	@Override
	public Map<String, Object> serialize(Object serializer) {
		if (serializer == null) {
			return new LinkedHashMap<String, Object>();
		}
		Map<String, Object> params = new LinkedHashMap<String, Object>();
		SimplePropertyDescriptor[] propertyDescriptors = DefaultPropertyUtils
				.getPropertyDescriptors(serializer.getClass());

		for (SimplePropertyDescriptor propertyDescriptor : propertyDescriptors) {
			String name = propertyDescriptor.getName();
			// 忽略名称为class的字段
			if (name.equals("class")) {
				continue;
			}
			try {
				Method method = propertyDescriptor.getMethod();
				if (method == null) {
					if (Boolean.class.isAssignableFrom(propertyDescriptor.getPropertyType())) {
						Method booleanMethod = null;
						try {
							booleanMethod = serializer.getClass()
									.getMethod("is" + GenericUtils.capitalizeFirstLetter(name));
						} catch (NoSuchMethodException e) {
						} catch (SecurityException e) {
						}
						method = booleanMethod;
					}
				}
				if (method == null) {
					throw new RuntimeException(
							"Could not parse the property[" + name + "] of " + serializer.getClass().getSimpleName());
				}

				// 获取serializer中的某字段
				Object value = method.invoke(serializer);

				if (value != null) {
					Class<?> valueType = value.getClass();
					String valueStr;
					// 如果值类型为原始类型或是继承于 String char[] number boolean 之类的类型
					if (valueType.isPrimitive() || CharSequence.class.isAssignableFrom(valueType)
							|| Number.class.isAssignableFrom(valueType) || Boolean.class.equals(valueType)
							|| Character.class.equals(valueType)) {
						valueStr = value.toString();

					} else if (Date.class.isAssignableFrom(valueType)) {
						valueStr = DateUtil.format((Date) value);
					} else {
						valueStr = processUnsupportedParameter(value);
					}
					params.put(name, valueStr);
				}

			} catch (InvocationTargetException e) {
				throw new IllegalArgumentException("illegal argument " + name + ", error:" + e.getMessage(), e);
			} catch (IllegalAccessException e) {
				throw new IllegalArgumentException("illegal argument " + name + ", error:" + e.getMessage(), e);
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException("illegal argument " + name + ", error:" + e.getMessage(), e);
			}
		}

		return params;
	}

}
