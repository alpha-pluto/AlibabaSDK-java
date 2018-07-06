package me.dan.alibabasdk.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @Title: DefaultPropertyUtils.java
 * @Package me.dan.alibabasdk.util
 * @Description:
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午2:10:27
 * @version 0.0.1
 */
public class DefaultPropertyUtils {

	@SuppressWarnings("rawtypes")
	private static HashMap<Class, SimplePropertyDescriptor[]> descriptorsCache = new HashMap<Class, SimplePropertyDescriptor[]>();

	/**
	 * @Title: getPropertyDescriptors
	 * @Description:
	 * @param beanClass
	 * @return
	 * @return SimplePropertyDescriptor[]
	 * @throws
	 * 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static SimplePropertyDescriptor[] getPropertyDescriptors(Class beanClass) {

		if (beanClass == null) {
			return new SimplePropertyDescriptor[0];
		}
		SimplePropertyDescriptor[] descriptors = null;
		descriptors = (SimplePropertyDescriptor[]) descriptorsCache.get(beanClass);
		if (descriptors != null) {
			return (descriptors);
		}
		Field[] fields = beanClass.getDeclaredFields();
		if (fields == null) {
			descriptors = new SimplePropertyDescriptor[0];

		} else {
			descriptors = new SimplePropertyDescriptor[fields.length];
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				SimplePropertyDescriptor simplePropertyDescriptor = new SimplePropertyDescriptor();
				simplePropertyDescriptor.setName(field.getName());
				simplePropertyDescriptor.setPropertyType(field.getType());
				try {
					Method readMethod = beanClass
							.getMethod("get" + GenericUtils.capitalizeFirstLetter(field.getName()));
					simplePropertyDescriptor.setMethod(readMethod);
				} catch (Exception ex) {
					// do nothing if readMethod is not support.
				}
				descriptors[i] = simplePropertyDescriptor;
			}
		}
		descriptorsCache.put(beanClass, descriptors);
		return (descriptors);

	}
}
