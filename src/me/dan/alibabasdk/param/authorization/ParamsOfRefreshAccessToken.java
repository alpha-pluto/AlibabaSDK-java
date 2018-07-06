package me.dan.alibabasdk.param.authorization;

import java.io.Serializable;

import me.dan.alibabasdk.entity.Params;
import me.dan.alibabasdk.entity.client.AuthorizationToken;
import me.dan.alibabasdk.infrastructure.GrantType;

/**
 * @Title: ParamsOfRefreshAccessToken.java
 * @Package me.dan.alibabasdk.entity.authorization
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-06 上午10:12:27
 * @version 0.0.1
 */
public class ParamsOfRefreshAccessToken extends Params<AuthorizationToken> implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 * 
	 */
	private static final long serialVersionUID = 9096507481528178023L;

	private GrantType grant_type;

	private String client_id;

	private String client_secret;

	private String refresh_token;

	public ParamsOfRefreshAccessToken() {
		super();
		this.grant_type = GrantType.refresh_token;
	}

	public ParamsOfRefreshAccessToken(String client_id, String client_secret, String refresh_token) {
		super();
		this.grant_type = GrantType.refresh_token;
		this.client_id = client_id;
		this.client_secret = client_secret;
		this.refresh_token = refresh_token;
	}

	public ParamsOfRefreshAccessToken(GrantType grant_type, String client_id, String client_secret,
			String refresh_token) {
		super();
		this.grant_type = grant_type;
		this.client_id = client_id;
		this.client_secret = client_secret;
		this.refresh_token = refresh_token;
	}

	public GrantType getGrant_type() {
		return grant_type;
	}

	public void setGrant_type(GrantType grant_type) {
		this.grant_type = grant_type;
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

}
