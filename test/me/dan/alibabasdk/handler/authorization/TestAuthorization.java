package me.dan.alibabasdk.handler.authorization;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import me.dan.alibabasdk.entity.ResponseEntity;
import me.dan.alibabasdk.entity.client.AuthorizationToken;
import me.dan.alibabasdk.infrastructure.PreAuthAPIPlot;

/**
 * @Title: TestAuthorization.java
 * @Package me.dan.alibabasdk.handler.authorization
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-06 下午10:07:14
 * @version 0.0.1
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestAuthorization {

	@Test
	public void testGetPreAuthUrl() throws Exception {
		PreAuthAPIPlot plot = new PreAuthAPIPlot("******", "1688", "http://www.eastmall.vip/ali-pre-auth", "******");
		String url = plot.getAuthorizationUrl();
		System.out.println(url);
	}

	@Test
	public void testAccessTokenExecutor() throws Exception {
		String clientId = "******";
		String clientSecret = "******";
		String redirectUrl = "http://www.eastmall.vip/ali-pre-auth";
		String preAuthCode = "2c823974-63c8-4e5c-b3d5-09a6bacd5057";
		AccessTokenExecutor executor = new AccessTokenExecutor(clientId, clientSecret, redirectUrl, preAuthCode);
		ResponseEntity<AuthorizationToken> result = executor.invoke();

		System.out.println(result);

	}

	@Test
	public void testRefreshTokenExecutor() throws Exception {
		String clientId = "******";
		String clientSecret = "******";
		String refreshToken = "41227eb4-520e-48e0-a432-7d17c870bf6c";
		RefreshTokenExecutor executor = new RefreshTokenExecutor(clientId, clientSecret, refreshToken);
		ResponseEntity<AuthorizationToken> result = executor.invoke();

		System.out.println(result);

	}

	@Test
	public void testRenewRefreshTokenExecutor() throws Exception {
		String clientId = "******";
		String clientSecret = "*******";
		String accessToken = "8f4b8fd6-d71b-4a25-8cc3-2ea3a4333f46";
		String refreshToken = "41227eb4-520e-48e0-a432-7d17c870bf6c";

		RenewRefreshTokenExecutor executor = new RenewRefreshTokenExecutor(clientId, clientSecret, accessToken,
				refreshToken);
		ResponseEntity<AuthorizationToken> result = executor.invoke();

		System.out.println(result);

	}

}
