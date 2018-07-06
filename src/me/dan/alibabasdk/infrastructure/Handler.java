package me.dan.alibabasdk.infrastructure;

import java.lang.reflect.Method;

/**
 * @Title: Handler.java
 * @Package me.dan.alibabasdk.infrastructure
 * @Description: 处理句柄
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午11:30:55
 * @version 0.0.1
 */
public interface Handler {

	public Object getHandler();

	public Method getMethod();

	public void setHandler(Object handler);

	public void setMethod(Method method);

	public Object invoke(Object handler, Object... params);
}
