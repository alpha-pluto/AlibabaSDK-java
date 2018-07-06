package me.dan.alibabasdk.authorization;

import java.util.Map;

import me.dan.alibabasdk.client.DefaultAuthorizationTokenRepository;
import me.dan.alibabasdk.entity.ResponseEntity;
import me.dan.alibabasdk.entity.client.AuthorizationToken;
import me.dan.alibabasdk.infrastructure.GenericAPIPlot;
import me.dan.alibabasdk.infrastructure.HttpMethod;
import me.dan.alibabasdk.infrastructure.Protocol;
import me.dan.alibabasdk.infrastructure.SessionType;
import me.dan.alibabasdk.infrastructure.UriSchema;
import me.dan.alibabasdk.param.authorization.ParamsOfGetAccessToken;
import me.dan.alibabasdk.param.authorization.ParamsOfRefreshAccessToken;
import me.dan.alibabasdk.param.authorization.ParamsOfRenewRefreshAccessToken;
import me.dan.alibabasdk.util.RequestParamModelToMap;

/**
 * @Title: AuthorizationAPIPlot.java
 * @Package me.dan.alibabasdk.authorization
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-05 下午2:40:03
 * @version 0.0.1
 */
public class AuthorizationAPIPlot extends GenericAPIPlot {

	/*
	 * 
	 */
	private void init() {
		this.getRequestPolicy().setRequestBodyCharset("UTF-8");
		this.getRequestPolicy().setHttpMethod(HttpMethod.POST);
		this.getRequestPolicy().setSessionType(SessionType.Product);
		this.getRequestPolicy().setUriSchema(UriSchema.https);
		this.getRequestPolicy().getApi().setApiRoot("openapi");
		this.getRequestPolicy().getApi().setApiNamespace("system.oauth2");
		this.getRequestPolicy().getApi().setApiVersion("1");
		this.getRequestPolicy().setRequestProtocol(Protocol.http);
		this.setTokenRepository(new DefaultAuthorizationTokenRepository());
	}

	/*
	 * 
	 * 
	 */
	public AuthorizationAPIPlot() {
		super();
		init();
	}

	/*
	* 
	* 
	*/
	public ResponseEntity<AuthorizationToken> getAccessToken(ParamsOfGetAccessToken param) {
		this.getRequestPolicy().setClientId(param.getClient_id());
		this.getRequestPolicy().setClientSecret(param.getClient_secret());
		this.getRequestPolicy().setAccessTokenOrPreAuthCode(param.getCode());
		this.getRequestPolicy().setValidateSignatureRequired(false);
		this.getRequestPolicy().getApi().setApiName("getToken");
		this.getRequestPolicy().setRequestProtocol(Protocol.param2);
		ResponseEntity<AuthorizationToken> result = null;

		Map<String, Object> mappedParam = RequestParamModelToMap.ConvertRequestParamModelToMap(param);
		this.setParams(mappedParam);
		this.setResultType(param.getResponseClass());

		try {
			result = this.getInvokeClient().request(this,
					this.getInvokeClient().getSerializerProvider().getSerializers(),
					this.getInvokeClient().getSerializerProvider().getDeSerializers());

		} catch (Exception e) {

			e.printStackTrace();
		}
		return result;
	}

	/*
	 * 
	 */
	public ResponseEntity<AuthorizationToken> refreshAccessToken(ParamsOfRefreshAccessToken param) {
		this.getRequestPolicy().setClientId(param.getClient_id());
		this.getRequestPolicy().setClientSecret(param.getClient_secret());
		this.getRequestPolicy().setAccessTokenOrPreAuthCode(param.getRefresh_token());
		this.getRequestPolicy().setValidateSignatureRequired(false);
		this.getRequestPolicy().getApi().setApiName("getToken");
		this.getRequestPolicy().setRequestProtocol(Protocol.param2);
		ResponseEntity<AuthorizationToken> result = null;

		Map<String, Object> mappedParam = RequestParamModelToMap.ConvertRequestParamModelToMap(param);
		this.setParams(mappedParam);
		this.setResultType(param.getResponseClass());

		try {
			result = this.getInvokeClient().request(this,
					this.getInvokeClient().getSerializerProvider().getSerializers(),
					this.getInvokeClient().getSerializerProvider().getDeSerializers());

		} catch (Exception e) {

			e.printStackTrace();
		}
		return result;
	}

	/*
	 * 
	 */
	public ResponseEntity<AuthorizationToken> renewRefreshToken(ParamsOfRenewRefreshAccessToken param) {
		this.getRequestPolicy().setClientId(param.getClient_id());
		this.getRequestPolicy().setClientSecret(param.getClient_secret());
		this.getRequestPolicy().setAccessTokenOrPreAuthCode(param.getRefresh_token());
		this.getRequestPolicy().setValidateSignatureRequired(false);
		this.getRequestPolicy().getApi().setApiName("postponeToken");
		this.getRequestPolicy().setRequestProtocol(Protocol.param2);
		ResponseEntity<AuthorizationToken> result = null;

		Map<String, Object> mappedParam = RequestParamModelToMap.ConvertRequestParamModelToMap(param);
		this.setParams(mappedParam);
		this.setResultType(param.getResponseClass());

		try {
			result = this.getInvokeClient().request(this,
					this.getInvokeClient().getSerializerProvider().getSerializers(),
					this.getInvokeClient().getSerializerProvider().getDeSerializers());

		} catch (Exception e) {

			e.printStackTrace();
		}
		return result;
	}
}
