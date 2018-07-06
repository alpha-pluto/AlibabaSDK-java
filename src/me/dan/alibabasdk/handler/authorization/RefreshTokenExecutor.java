package me.dan.alibabasdk.handler.authorization;

import me.dan.alibabasdk.authorization.AuthorizationAPIPlot;
import me.dan.alibabasdk.entity.ResponseEntity;
import me.dan.alibabasdk.entity.client.AuthorizationToken;
import me.dan.alibabasdk.handler.ApiExecutor;
import me.dan.alibabasdk.param.authorization.ParamsOfRefreshAccessToken;

/**
 * @Title: RefreshTokenExecutor.java
 * @Package me.dan.alibabasdk.handler.authorization
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-06 下午10:08:55
 * @version 0.0.1
 */
public class RefreshTokenExecutor extends
		ApiExecutor<AuthorizationAPIPlot, ResponseEntity<AuthorizationToken>, ParamsOfRefreshAccessToken, AuthorizationToken> {

	public RefreshTokenExecutor(AuthorizationToken token, ParamsOfRefreshAccessToken param) {
		super();
		this.apiPlot = new AuthorizationAPIPlot();
		this.params = param;
		this.apiPlot.storeAuthorizationToken(token.getClientId() + ":" + token.getClientSecret(), token);

	}

	public RefreshTokenExecutor(String clientId, String clientSecret, String refreshToken) {
		super();
		this.apiPlot = new AuthorizationAPIPlot();
		this.params = new ParamsOfRefreshAccessToken(clientId, clientSecret, refreshToken);
	}

	public ResponseEntity<AuthorizationToken> invoke() {
		ResponseEntity<AuthorizationToken> result = this.apiPlot.refreshAccessToken(this.params);
		return result;
	}
}
