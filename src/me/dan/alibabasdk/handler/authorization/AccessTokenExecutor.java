package me.dan.alibabasdk.handler.authorization;

import me.dan.alibabasdk.authorization.AuthorizationAPIPlot;
import me.dan.alibabasdk.entity.ResponseEntity;
import me.dan.alibabasdk.entity.client.AuthorizationToken;
import me.dan.alibabasdk.handler.ApiExecutor;
import me.dan.alibabasdk.infrastructure.GrantType;
import me.dan.alibabasdk.param.authorization.ParamsOfGetAccessToken;

/**
 * @Title: AccessTokenExecutor.java
 * @Package me.dan.alibabasdk.handler.authorization
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-06 下午9:43:51
 * @version 0.0.1
 */
public class AccessTokenExecutor extends
		ApiExecutor<AuthorizationAPIPlot, ResponseEntity<AuthorizationToken>, ParamsOfGetAccessToken, AuthorizationToken> {

	public AccessTokenExecutor(ParamsOfGetAccessToken param) {
		super();
		this.apiPlot = new AuthorizationAPIPlot();
		this.params = param;
		this.params.setGrant_type(GrantType.authorization_code);
	}

	/**
	 * @Title: AccessTokenExecutor.java
	 * @Description: TODO
	 * 
	 * @param clientId
	 * @param clientSecret
	 * @param redirectUrl
	 * @param preAuthCode
	 */
	public AccessTokenExecutor(String clientId, String clientSecret, String redirectUrl, String preAuthCode) {
		super();
		this.apiPlot = new AuthorizationAPIPlot();
		this.params = new ParamsOfGetAccessToken(clientId, clientSecret, redirectUrl, preAuthCode);
		this.params.setGrant_type(GrantType.authorization_code);
	}

	public ResponseEntity<AuthorizationToken> invoke() {
		ResponseEntity<AuthorizationToken> result = this.apiPlot.getAccessToken(this.params);
		return result;
	}

}
