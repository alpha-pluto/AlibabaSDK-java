package me.dan.alibabasdk.client;

import java.util.HashMap;
import java.util.Map;

import me.dan.alibabasdk.entity.client.AuthorizationToken;

/**
 * @Title: DefaultAuthorizationTokenRepository.java
 * @Package me.dan.alibabasdk.client
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午5:38:11
 * @version 0.0.1
 */
public class DefaultAuthorizationTokenRepository implements AuthorizationTokenRepository {

	private Map<String, Object> cacheAuthTokenRepo = new HashMap<String, Object>();

	@Override
	public void removeToken(String key) {
		cacheAuthTokenRepo.remove(key);
	}

	@Override
	public void storeAccessToken(String key, AuthorizationToken token) {
		cacheAuthTokenRepo.put(key, token);
	}

	@Override
	public AuthorizationToken getAccessToken(String key) {
		return (AuthorizationToken) cacheAuthTokenRepo.get(key);
	}

	@Override
	public Map<String, Object> getCacheAuthTokenRepo() {
		return cacheAuthTokenRepo;
	}

	@Override
	public void setCacheAuthTokenRepo(Map<String, Object> cacheAuthTokenRepo) {
		this.cacheAuthTokenRepo = cacheAuthTokenRepo;
	}

	public DefaultAuthorizationTokenRepository() {

		super();
		// TODO Auto-generated constructor stub
	}

}
