package me.dan.alibabasdk.entity;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Title: Params.java
 * @Package me.dan.alibabasdk.entity
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-05 下午8:09:03
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public abstract class Params<TResponse> implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 * 
	 */
	private static final long serialVersionUID = -3015386325466104382L;

	@SuppressWarnings("unchecked")
	public Class<TResponse> getResponseClass() {
		// Type type = this.getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
		return (Class<TResponse>) (parameterizedType.getActualTypeArguments()[0]);
	}

}
