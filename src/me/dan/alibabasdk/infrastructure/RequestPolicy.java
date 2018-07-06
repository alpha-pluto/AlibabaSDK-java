package me.dan.alibabasdk.infrastructure;

import me.dan.alibabasdk.exception.AliSDKException;

/**
 * @Title: RequestPolicy.java
 * @Package me.dan.alibabasdk.infrastructure
 * @Description: 请求api时的环境参数集成基类
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-03 下午7:01:58
 * @version 0.0.1
 */
public class RequestPolicy {

	/*
	 * 对应的appKey
	 */
	private String clientId;

	/*
	 * 对应的appSecret
	 */
	private String clientSecret;

	/*
	 * accesstoken或是预授权码
	 */
	private String accessTokenOrPreAuthCode;

	/*
	 * api的相关信息 由root,version等组成
	 */
	private API api;

	/*
	 * 请求的协议
	 * 注是 Api地址 的组成部分
	 * 具体取值要查看open.1688.com上的文档
	 */
	private Protocol requestProtocol = Protocol.param2;

	/*
	 * 返回类型
	 */
	private Protocol responseProtocol = Protocol.json2;

	/*
	 * 请求环境
	 * sandbox 沙盒
	 * product 生产
	 */
	private SessionType sessionType = SessionType.Product;

	/*
	 * 请求api 的 协议
	 */
	private UriSchema uriSchema = UriSchema.https;

	/*
	 * 是否要示签名验证
	 */
	private boolean validateSignatureRequired = false;

	/*
	 * 内容字符编码
	 */
	private String requestBodyCharset = "UTF-8";

	/*
	 * 请求方式
	 */
	private HttpMethod httpMethod = HttpMethod.POST;

	public RequestPolicy() {
		super();
		this.api = new API();
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getAccessTokenOrPreAuthCode() {
		return accessTokenOrPreAuthCode;
	}

	public void setAccessTokenOrPreAuthCode(String accessTokenOrPreAuthCode) {
		this.accessTokenOrPreAuthCode = accessTokenOrPreAuthCode;
	}

	public API getApi() {
		return api;
	}

	public void setApi(API api) {
		this.api = api;
	}

	public Protocol getRequestProtocol() {
		return requestProtocol;
	}

	public void setRequestProtocol(Protocol protocol) {
		this.requestProtocol = protocol;
	}

	public SessionType getSessionType() {
		return sessionType;
	}

	public void setSessionType(SessionType sessionType) {
		this.sessionType = sessionType;
	}

	public UriSchema getUriSchema() {
		return uriSchema;
	}

	public void setUriSchema(UriSchema uriSchema) {
		this.uriSchema = uriSchema;
	}

	public boolean isValidateSignatureRequired() {
		return validateSignatureRequired;
	}

	public void setValidateSignatureRequired(boolean validateSignatureRequired) {
		this.validateSignatureRequired = validateSignatureRequired;
	}

	public Protocol getResponseProtocol() {
		return responseProtocol;
	}

	public void setResponseProtocol(Protocol responseProtocol) {
		this.responseProtocol = responseProtocol;
	}

	public HttpMethod getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(HttpMethod httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getRequestBodyCharset() {
		return requestBodyCharset;
	}

	public void setRequestBodyCharset(String requestBodyCharset) {
		this.requestBodyCharset = requestBodyCharset;
	}

	public String getApiRequestPath() throws AliSDKException {
		String apiProtocol = getRequestProtocol().name();
		String clientId = getClientId();
		String apiRequestPath = getApi().getApiAddress();
		apiRequestPath = apiRequestPath.replaceAll("(?i)\\{\\$protocol\\}", apiProtocol);
		apiRequestPath = apiRequestPath.replaceAll("(?i)\\{\\$clientId\\}", clientId);
		return apiRequestPath;
	}

	public String getApiSignaturePath() throws AliSDKException {
		String apiProtocol = getRequestProtocol().name();
		String clientId = getClientId();
		String apiRequestPath = getApi().getApiSignatureAddress();
		apiRequestPath = apiRequestPath.replaceAll("(?i)\\{\\$protocol\\}", apiProtocol);
		apiRequestPath = apiRequestPath.replaceAll("(?i)\\{\\$clientId\\}", clientId);
		return apiRequestPath;
	}
}
