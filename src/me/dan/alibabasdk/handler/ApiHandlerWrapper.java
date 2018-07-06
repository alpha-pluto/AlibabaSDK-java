package me.dan.alibabasdk.handler;

import java.lang.reflect.Method;
import com.alibaba.fastjson.JSON;

import me.dan.alibabasdk.authorization.AuthorizationAPIPlot;
import me.dan.alibabasdk.client.AuthorizationTokenRepository;
import me.dan.alibabasdk.entity.ResponseEntity;
import me.dan.alibabasdk.entity.client.AuthorizationToken;
import me.dan.alibabasdk.infrastructure.GenericAPIPlot;
import me.dan.alibabasdk.infrastructure.Handler;
import me.dan.alibabasdk.param.authorization.ParamsOfRefreshAccessToken;
import me.dan.alibabasdk.util.LoggerHelper;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @Title: ApiHandlerWrapper.java
 * @Package me.dan.alibabasdk.handler
 * @Description: 调用api的外包装类，实现错误重试机制，在token刷新后，如果有检测到有注入的相关句柄就执行（比如发消息）
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-06 下午4:45:22
 * @version 0.0.1
 */
public class ApiHandlerWrapper<T extends GenericAPIPlot> implements MethodInterceptor {

	private String destMethodName;

	private Object target;

	private boolean retry = false;

	/**
	 * @Title: getInstance
	 * @Description: TODO
	 * @param target
	 * @param destinationMethod
	 * @param resoponseEitityType
	 * @param retryIfFail
	 * @return
	 * @return Object
	 * @throws
	 * 
	 */
	public Object getInstance(Object target, String destinationMethod, boolean retryIfFail) {
		this.target = target;
		this.retry = retryIfFail;
		this.destMethodName = destinationMethod;
		Enhancer enhancer = new Enhancer();

		Class<?> superClass = (Class<?>) this.target.getClass().getGenericSuperclass();
		if (superClass != GenericAPIPlot.class)
			throw new IllegalArgumentException("targeted object must assigned from " + GenericAPIPlot.class);
		enhancer.setSuperclass(this.target.getClass());
		// 回调方法
		enhancer.setCallback(this);
		// 创建代理对象
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		Object result = null;
		if (method.getName().equals(this.destMethodName)) {
			try {
				result = proxy.invokeSuper(obj, args);
				if (result.getClass().equals(ResponseEntity.class)) {
					int statusCode = ((ResponseEntity) result).getStatusCode();
					if (!(statusCode >= 200 && statusCode <= 299) && retry) {
						AuthorizationToken newToken = doRefreshAccessToken();
						doChangeAccessToken(newToken, args);
						retry = false;
						result = proxy.invokeSuper(obj, args);
						LoggerHelper.getClientLogger().info("tried again when error occured");
					}
				}
			} catch (Exception e) {
				if (retry) {
					AuthorizationToken newToken = doRefreshAccessToken();
					doChangeAccessToken(newToken, args);
					retry = false;
					result = proxy.invokeSuper(obj, args);
					LoggerHelper.getClientLogger().info("tried again when error occured");
				} else {
					throw e;
				}
			}
		} else {
			result = proxy.invokeSuper(obj, args);
		}

		return result;
	}

	private String getClientId() {
		String clientId = ((GenericAPIPlot) this.target).getRequestPolicy().getClientId();
		return clientId;
	}

	private String getClientSecret() {
		GenericAPIPlot plot = (GenericAPIPlot) this.target;
		String clientSecret = plot.getRequestPolicy().getClientSecret();
		return clientSecret;
	}

	private AuthorizationTokenRepository getAuthorizationRepository() {
		GenericAPIPlot plot = (GenericAPIPlot) this.target;
		return plot.getTokenRepository();
	}

	private AuthorizationToken getAuthorizationToken(String key) {
		AuthorizationToken token = new AuthorizationToken();
		AuthorizationTokenRepository repository = getAuthorizationRepository();
		if (null != repository) {
			token = repository.getAccessToken(key);
		}
		/*
		 * for (Map.Entry<String, Object> entity :
		 * repository.getCacheAuthTokenRepo().entrySet()) {
		 * System.out.println(entity.getKey() + " => " + entity.getValue());
		 * }
		 */
		return token;
	}

	private void storeAuthorizationToken(String key, AuthorizationToken token) {

		AuthorizationTokenRepository repository = getAuthorizationRepository();
		if (null == repository) {
			repository.storeAccessToken(key, token);
		}
	}

	private ResponseEntity<AuthorizationToken> refreshAccessToken(AuthorizationToken token) {
		ResponseEntity<AuthorizationToken> result = null;
		ParamsOfRefreshAccessToken p = new ParamsOfRefreshAccessToken();
		p.setClient_id(token.getClientId());
		p.setClient_secret(token.getClientSecret());
		p.setRefresh_token(token.getRefresh_token());

		AuthorizationAPIPlot ap = new AuthorizationAPIPlot();

		try {
			result = ap.refreshAccessToken(p);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	private AuthorizationToken doRefreshAccessToken() {
		String clientId = getClientId();
		String clientSecret = getClientSecret();
		String key = clientId + ":" + clientSecret;
		AuthorizationToken token = getAuthorizationToken(key);
		if (null != token) {
			try {
				ResponseEntity<AuthorizationToken> newTokenEntity = refreshAccessToken(token);
				AuthorizationToken newToken = newTokenEntity.getResult();
				token.setAccess_token(newToken.getAccess_token());
				token.setExpires_in(newToken.getExpires_in());
				storeAuthorizationToken(key, token);
				// 如果有注入令牌变更的动作句柄就执行
				Handler afterTokenUpdateHandler = (Handler) ((GenericAPIPlot) this.target)
						.getAfterAccessTokenRefreshHandler();
				Object handler = afterTokenUpdateHandler.getHandler();
				Method methodAfterTokenUpdate = afterTokenUpdateHandler.getMethod();
				if (handler != null && methodAfterTokenUpdate != null) {
					Object t = JSON.toJSON(token);
					methodAfterTokenUpdate.invoke(handler, t);
					LoggerHelper.getClientLogger().info("methodAfterTokenUpdate invoked =>" + t);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return token;
	}

	private void doChangeAccessToken(AuthorizationToken token, Object[] args) {
		for (Object arg : args) {
			if (arg.getClass().equals(AuthorizationToken.class)) {
				((AuthorizationToken) arg).setAccess_token(token.getAccess_token());
			}
		}
	}
}
