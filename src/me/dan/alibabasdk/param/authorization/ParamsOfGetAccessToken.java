package me.dan.alibabasdk.param.authorization;

import java.io.Serializable;

import me.dan.alibabasdk.entity.Params;
import me.dan.alibabasdk.entity.client.AuthorizationToken;
import me.dan.alibabasdk.infrastructure.GrantType;

/**
 * @Title: ParamsOfGetAccessToken.java
 * @Package me.dan.alibabasdk.entity.authorization
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-05 下午3:06:37
 * @version 0.0.1
 */
public class ParamsOfGetAccessToken extends Params<AuthorizationToken> implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 * 
	 */
	private static final long serialVersionUID = 7218303818894382553L;

	private GrantType grant_type;

	private boolean need_refresh_token;

	private String client_id;

	private String client_secret;

	private String redirect_uri;

	private String code;

	public ParamsOfGetAccessToken() {

		super();
		this.grant_type = GrantType.get_token;
		this.need_refresh_token = true;
	}

	public ParamsOfGetAccessToken(String client_id, String client_secret, String redirect_uri, String code) {
		super();
		this.grant_type = GrantType.get_token;
		this.need_refresh_token = true;
		this.client_id = client_id;
		this.client_secret = client_secret;
		this.redirect_uri = redirect_uri;
		this.code = code;
	}

	public GrantType getGrant_type() {
		return grant_type;
	}

	public void setGrant_type(GrantType grant_type) {
		this.grant_type = grant_type;
	}

	public boolean isNeed_refresh_token() {
		return need_refresh_token;
	}

	public void setNeed_refresh_token(boolean need_refresh_token) {
		this.need_refresh_token = need_refresh_token;
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

	public String getRedirect_uri() {
		return redirect_uri;
	}

	public void setRedirect_uri(String redirect_uri) {
		this.redirect_uri = redirect_uri;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
