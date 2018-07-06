package me.dan.alibabasdk.entity.client;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @Title: AuthorizationToken.java
 * @Package me.dan.alibabasdk.entity.client
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午5:25:52
 * @version 0.0.1
 */
public class AuthorizationToken implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 * 
	 */
	private static final long serialVersionUID = -67772527947183939L;

	private String access_token;
	private String refresh_token;
	private long expires_in;
	private String expires_time;
	private String refresh_token_timeout;
	private String resource_owner;
	private String uid;
	private long aliId;
	private String memberId;
	private String clientId;
	private String clientSecret;

	public AuthorizationToken() {
	}

	public AuthorizationToken(String accessToken, long accessTokenTimeout, String resourceOwnerId, long aliId) {
		this(accessToken, accessTokenTimeout, null, null, resourceOwnerId, null, aliId, null);
	}

	public AuthorizationToken(String accessToken, long accessTokenTimeout, String resourceOwnerId, String uid,
			long aliId, String memberId) {
		this(accessToken, accessTokenTimeout, null, null, resourceOwnerId, uid, aliId, memberId);
	}

	public AuthorizationToken(String accessToken, long accessTokenTimeout, String refreshToken,
			String refreshTokenTimeout, String resourceOwnerId, long aliId, String memberId) {
		this(accessToken, accessTokenTimeout, refreshToken, refreshTokenTimeout, resourceOwnerId, null, aliId,
				memberId);
	}

	public AuthorizationToken(String accessToken, long accessTokenTimeout, String refreshToken,
			String refreshTokenTimeout, String resourceOwnerId, String uid, long aliId, String memberId) {
		this.access_token = accessToken;
		this.expires_in = accessTokenTimeout;
		this.refresh_token = refreshToken;
		this.refresh_token_timeout = refreshTokenTimeout;
		this.resource_owner = resourceOwnerId;
		this.uid = uid;
		this.aliId = aliId;
		this.memberId = memberId;
	}

	public AuthorizationToken(String accessToken, long accessTokenTimeout, String refreshToken,
			String refreshTokenTimeout, String resourceOwnerId, String uid, long aliId, String memberId,
			String clientId, String clientSecret) {
		this.access_token = accessToken;
		this.expires_in = accessTokenTimeout;
		this.refresh_token = refreshToken;
		this.refresh_token_timeout = refreshTokenTimeout;
		this.resource_owner = resourceOwnerId;
		this.uid = uid;
		this.aliId = aliId;
		this.memberId = memberId;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
	}

	/**
	 * 获取access_token
	 * 
	 * @return the accessToken
	 */
	public String getAccess_token() {
		return access_token;
	}

	/**
	 * 获取access_token过期时间
	 * 
	 * @return the accessTokenTimeout
	 */
	public long getExpires_in() {
		return expires_in;
	}

	/**
	 * 获取refresh_token
	 * 
	 * @return the refreshToken
	 */
	public String getRefresh_token() {
		return refresh_token;
	}

	/**
	 * 获取refresh_token过期时间
	 * 
	 * @return the refreshTokenTimeout
	 */
	public String getRefresh_token_timeout() {
		return refresh_token_timeout;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	/**
	 * 获取resource_owner
	 * 
	 * @return the resourceOwnerId
	 */
	public String getResource_owner() {
		return resource_owner;
	}

	/**
	 * 获取uid
	 * 
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * 获取aliId
	 * 
	 * @return the aliId
	 */
	public long getAliId() {
		return aliId;
	}

	public void setAccess_token(String accessToken) {
		this.access_token = accessToken;
	}

	public void setRefresh_token(String refreshToken) {
		this.refresh_token = refreshToken;
	}

	public void setExpires_in(long accessTokenTimeout) {
		this.expires_in = accessTokenTimeout;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, (int) expires_in);
		// this.expires_time = cal.getTime();
	}

	public void setRefresh_token_timeout(String refresh_token_timeout) {
		this.refresh_token_timeout = refresh_token_timeout;
	}

	public void setResource_owner(String resourceOwnerId) {
		this.resource_owner = resourceOwnerId;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setAliId(long aliId) {
		this.aliId = aliId;
	}

	/**
	 * 获取access_token过期时间,Date格式
	 * 
	 * @return the accessTokenTimeout
	 */
	public String getExpires_time() {
		return expires_time;
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("AuthorizationToken{\t");
		sb.append("access_token='" + access_token + "',\t");
		sb.append("refresh_token='" + refresh_token + "',\t");
		sb.append("expires_in=" + expires_in + ",\t");
		sb.append("expires_time='" + expires_time + "',\t");
		sb.append("refresh_token_timeout='" + refresh_token_timeout + "',\t");
		sb.append("resource_owner='" + resource_owner + "',\t");
		sb.append("uid='" + uid + "',\t");
		sb.append("aliId='" + aliId + "',\t");
		sb.append("memberId='" + memberId + "',\t");
		sb.append("clientId='" + clientId + "',\t");
		sb.append("clientSecret='" + clientSecret + "',\t");
		sb.append("}");
		return sb.toString();
	}

}
