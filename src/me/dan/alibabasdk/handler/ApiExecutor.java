package me.dan.alibabasdk.handler;

import static org.hamcrest.CoreMatchers.anything;

import java.lang.reflect.Method;

import me.dan.alibabasdk.entity.ResponseEntity;
import me.dan.alibabasdk.entity.client.AuthorizationToken;
import me.dan.alibabasdk.infrastructure.GenericAPIPlot;
import me.dan.alibabasdk.util.GenericUtils;

/**
 * @Title: ApiExecutor.java
 * @Package me.dan.alibabasdk.handler
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-06 下午9:15:26
 * @version 0.0.1
 */
public abstract class ApiExecutor<PlotType extends GenericAPIPlot, R extends ResponseEntity<T>, ParamType, T> {

	protected ResponseEntity<T> responseEntity;

	protected ParamType params;

	protected AuthorizationToken token;

	protected PlotType apiPlot;

	/*
	 * 处理重试的句柄
	 */
	protected ApiHandlerWrapper<PlotType> apiHandler;

	/*
	 * 指示是否在出错后重试一次
	 */
	protected boolean retryIfFail;

	public ParamType getParams() {
		return params;
	}

	public void setParams(ParamType params) {
		this.params = params;
	}

	public PlotType getApiPlot() {
		return apiPlot;
	}

	public void setApiPlot(PlotType apiPlot) {
		this.apiPlot = apiPlot;
	}

	public ResponseEntity<T> getResponseEntity() {
		return responseEntity;
	}

	public boolean isRetryIfFail() {
		return retryIfFail;
	}

	public void setRetryIfFail(boolean retryIfFail) {
		this.retryIfFail = retryIfFail;
	}

	/*
	 * 注入令牌刷新的后续处理句柄
	 * 要求，注入的方法必须是处理JSON.toJSON的令牌实体
	 */
	public void attachAfterAccessTokenRefreshHandler(Object object, String method) {
		if (null != object && !GenericUtils.isBlank(method)) {
			try {
				Method handlerMethod = object.getClass().getDeclaredMethod(method, Object.class);
				this.getApiPlot().getAfterAccessTokenRefreshHandler().setHandler(object);
				this.getApiPlot().getAfterAccessTokenRefreshHandler().setMethod(handlerMethod);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
