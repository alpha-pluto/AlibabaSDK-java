package me.dan.alibabasdk.infrastructure;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Title: HandlerContainer.java
 * @Package me.dan.alibabasdk.infrastructure
 * @Description: 代理类容器
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 上午11:27:04
 * @version 0.0.1
 */
public class HandlerContainer implements Handler {

	/*
	 * 句柄类
	 */
	private Object handler;

	/*
	 * 方法
	 */
	private Method method;

	@Override
	public Object getHandler() {
		return handler;
	}

	@Override
	public void setHandler(Object handler) {
		this.handler = handler;
	}

	@Override
	public Method getMethod() {
		return method;
	}

	@Override
	public void setMethod(Method method) {
		this.method = method;
	}

	public HandlerContainer() {
		super();
	}

	public HandlerContainer(Object handler, Method method) {
		super();
		this.handler = handler;
		this.method = method;
	}

	@Override
	public Object invoke(Object target, Object... params) {
		if (handler != null && method != null)
			try {
				return method.invoke(handler, params);
			} catch (IllegalAccessException e) {

				e.printStackTrace();
			} catch (IllegalArgumentException e) {

				e.printStackTrace();
			} catch (InvocationTargetException e) {

				e.printStackTrace();
			}
		return null;

	}

}
