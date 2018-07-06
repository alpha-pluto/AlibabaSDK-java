package me.dan.alibabasdk.infrastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: APIPlot.java
 * @Package me.dan.alibabasdk.infrastructure
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午11:12:30
 * @version 0.0.1
 */
public abstract class APIPlot {

	private Map<String, Object> params;

	private RequestPolicy requestPolicy;

	/*
	 * 主机
	 */
	private String host = "gw.open.1688.com";

	/*
	 * 访问令牌更新后的代理句柄
	 */
	private Handler afterAccessTokenRefreshHandler = new HandlerContainer();

	/*
	 * 访问生产环境的api
	 */
	private SessionType sessionType = SessionType.Product;

	private void inti() {
		this.params = new HashMap<String, Object>();

	}

	public APIPlot() {
		super();
		inti();
		this.requestPolicy = new RequestPolicy();
	}

	public APIPlot(RequestPolicy requestPolicy) {
		super();
		inti();
		this.requestPolicy = requestPolicy;
	}

	public APIPlot(RequestPolicy requestPolicy, String host) {
		super();
		inti();
		this.requestPolicy = requestPolicy;
		this.host = host;
	}

	public APIPlot(RequestPolicy requestPolicy, String host, Handler afterAccessTokenRefreshHandler) {
		super();
		inti();
		this.requestPolicy = requestPolicy;
		this.host = host;
		this.afterAccessTokenRefreshHandler = afterAccessTokenRefreshHandler;
	}

	public APIPlot(RequestPolicy requestPolicy, String host, Handler afterAccessTokenRefreshHandler,
			SessionType sessionType) {
		super();
		inti();
		this.requestPolicy = requestPolicy;
		this.host = host;
		this.afterAccessTokenRefreshHandler = afterAccessTokenRefreshHandler;
		this.sessionType = sessionType;
	}

	public RequestPolicy getRequestPolicy() {
		return requestPolicy;
	}

	public void setRequestPolicy(RequestPolicy requestPolicy) {
		this.requestPolicy = requestPolicy;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Handler getAfterAccessTokenRefreshHandler() {
		return afterAccessTokenRefreshHandler;
	}

	public void setAfterAccessTokenRefreshHandler(Handler afterAccessTokenRefreshHandler) {
		this.afterAccessTokenRefreshHandler = afterAccessTokenRefreshHandler;
	}

	public SessionType getSessionType() {
		return sessionType;
	}

	public void setSessionType(SessionType sessionType) {
		this.sessionType = sessionType;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

}
