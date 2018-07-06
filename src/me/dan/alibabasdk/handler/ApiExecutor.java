package me.dan.alibabasdk.handler;

import me.dan.alibabasdk.entity.Params;
import me.dan.alibabasdk.entity.ResponseEntity;
import me.dan.alibabasdk.entity.client.AuthorizationToken;
import me.dan.alibabasdk.infrastructure.GenericAPIPlot;

/**
 * @Title: ApiExecutor.java
 * @Package me.dan.alibabasdk.handler
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-06 下午9:15:26
 * @version 0.0.1
 */
public abstract class ApiExecutor<PlotType, R extends ResponseEntity<T>, ParamType, T> {

	protected ResponseEntity<T> responseEntity;

	protected ParamType params;

	protected AuthorizationToken token;

	protected PlotType apiPlot;

	/*
	 * 处理重试的句柄
	 */
	protected ApiHandlerWrapper apiHandler;

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

}
