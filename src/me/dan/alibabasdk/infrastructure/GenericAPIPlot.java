package me.dan.alibabasdk.infrastructure;

import me.dan.alibabasdk.client.AuthorizationTokenRepository;
import me.dan.alibabasdk.client.DefaultAuthorizationTokenRepository;
import me.dan.alibabasdk.client.http.AbstractClient;
import me.dan.alibabasdk.client.http.DefaultClient;
import me.dan.alibabasdk.client.http.DefaultHttpResponseBuilder;
import me.dan.alibabasdk.entity.client.AuthorizationToken;
import me.dan.alibabasdk.serialize.DefaultSerializerProvider;

/**
 * @Title: GenericAPIPlot.java
 * @Package me.dan.alibabasdk.infrastructure
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-05 上午11:52:29
 * @version 0.0.1
 */
public class GenericAPIPlot extends APIPlot {

	private Class<?> resultType;

	public GenericAPIPlot() {
		super(new RequestPolicy());
		this.tokenRepository = new DefaultAuthorizationTokenRepository();
		this.invokeClient = new DefaultClient(new DefaultSerializerProvider(), new DefaultHttpResponseBuilder());
	}

	private AuthorizationTokenRepository tokenRepository;

	private AbstractClient invokeClient;

	public AuthorizationTokenRepository getTokenRepository() {
		return tokenRepository;
	}

	public void setTokenRepository(AuthorizationTokenRepository tokenRepository) {
		this.tokenRepository = tokenRepository;
	}

	public AbstractClient getInvokeClient() {
		return invokeClient;
	}

	public void setInvokeClient(AbstractClient invokeClient) {
		this.invokeClient = invokeClient;
	}

	public Class<?> getResultType() {
		return resultType;
	}

	public void setResultType(Class<?> resultType) {
		this.resultType = resultType;
	}

	/*
	 * 
	 * 
	 */
	public void storeAuthorizationToken(String key, AuthorizationToken token) {
		this.getTokenRepository().storeAccessToken(key, token);
	}

}
