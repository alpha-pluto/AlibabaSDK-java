package me.dan.alibabasdk.client;

import java.util.Map;

import me.dan.alibabasdk.entity.client.AuthorizationToken;

/**
 * @Title: AuthorizationTokenRepository.java
 * @Package me.dan.alibabasdk.client
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午5:31:06
 * @version 0.0.1
 */
public interface AuthorizationTokenRepository {
	/*
	 * 
	 */

	public void removeToken(String key);

	/*
	 * 
	 */
	public void storeAccessToken(String key, AuthorizationToken token);

	/*
	 * 
	 */
	public AuthorizationToken getAccessToken(String key);

	/*
	 * 
	 */
	public Map<String, Object> getCacheAuthTokenRepo();

	/*
	 * 
	 */
	public void setCacheAuthTokenRepo(Map<String, Object> cacheAuthTokenRepo);
}
