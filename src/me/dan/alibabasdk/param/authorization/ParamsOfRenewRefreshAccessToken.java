package me.dan.alibabasdk.param.authorization;

import java.io.Serializable;

import me.dan.alibabasdk.entity.Params;
import me.dan.alibabasdk.entity.client.AuthorizationToken;

/**
 * @Title: ParamsOfRenewRefreshAccessToken.java
 * @Package me.dan.alibabasdk.entity.authorization
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-06 上午10:40:11
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class ParamsOfRenewRefreshAccessToken extends Params<AuthorizationToken> implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 * 
	 */
	private static final long serialVersionUID = 7523200417158723944L;

	private String client_id;

	private String client_secret;

	private String refresh_token;

	private String access_token;

	public ParamsOfRenewRefreshAccessToken() {
		super();
	}

	public ParamsOfRenewRefreshAccessToken(String client_id, String client_secret, String refresh_token,
			String access_token) {
		super();
		this.client_id = client_id;
		this.client_secret = client_secret;
		this.refresh_token = refresh_token;
		this.access_token = access_token;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getClient_secret() {
		return client_secret;
	}

	public void setClient_secret(String client_secret) {
		this.client_secret = client_secret;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

}
