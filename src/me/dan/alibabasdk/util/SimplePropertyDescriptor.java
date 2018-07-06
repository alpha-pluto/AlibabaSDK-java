package me.dan.alibabasdk.util;

import java.lang.reflect.Method;

/**
 * @Title: SimplePropertyDescriptor.java
 * @Package me.dan.alibabasdk.util
 * @Description: 简化的类型模型
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午2:07:08
 * @version 0.0.1
 */
public class SimplePropertyDescriptor {

	private String name;

	private Method method;

	private Class<?> propertyType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public Class<?> getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(Class<?> propertyType) {
		this.propertyType = propertyType;
	}

}
