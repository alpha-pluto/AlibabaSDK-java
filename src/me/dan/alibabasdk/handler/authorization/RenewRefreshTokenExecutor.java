package me.dan.alibabasdk.handler.authorization;

import me.dan.alibabasdk.authorization.AuthorizationAPIPlot;
import me.dan.alibabasdk.entity.ResponseEntity;
import me.dan.alibabasdk.entity.client.AuthorizationToken;
import me.dan.alibabasdk.handler.ApiExecutor;
import me.dan.alibabasdk.param.authorization.ParamsOfRefreshAccessToken;
import me.dan.alibabasdk.param.authorization.ParamsOfRenewRefreshAccessToken;

/**
 * @Title: RenewRefreshTokenExecutor.java
 * @Package me.dan.alibabasdk.handler.authorization
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-06 下午10:24:33
 * @version 0.0.1
 */
public class RenewRefreshTokenExecutor extends
		ApiExecutor<AuthorizationAPIPlot, ResponseEntity<AuthorizationToken>, ParamsOfRenewRefreshAccessToken, AuthorizationToken> {

	public RenewRefreshTokenExecutor(AuthorizationToken token, ParamsOfRenewRefreshAccessToken param) {
		super();
		this.apiPlot = new AuthorizationAPIPlot();
		this.params = param;
		this.apiPlot.storeAuthorizationToken(token.getClientId() + ":" + token.getClientSecret(), token);

	}

	public RenewRefreshTokenExecutor(String clientId, String cleintSecret, String accessToken, String refreshToken) {
		super();
		this.apiPlot = new AuthorizationAPIPlot();
		this.params = new ParamsOfRenewRefreshAccessToken(clientId, cleintSecret, refreshToken, accessToken);
		this.apiPlot.storeAuthorizationToken(clientId + ":" + cleintSecret,
				new AuthorizationToken(accessToken, 35999, refreshToken, null, null, 0, null));

	}

	public ResponseEntity<AuthorizationToken> invoke() {
		ResponseEntity<AuthorizationToken> result = this.apiPlot.renewRefreshToken(this.params);
		return result;
	}
}
