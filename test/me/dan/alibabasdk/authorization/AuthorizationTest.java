package me.dan.alibabasdk.authorization;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import me.dan.alibabasdk.entity.ResponseEntity;
import me.dan.alibabasdk.entity.client.AuthorizationToken;
import me.dan.alibabasdk.handler.authorization.AccessTokenExecutor;
import me.dan.alibabasdk.infrastructure.GrantType;
import me.dan.alibabasdk.infrastructure.PreAuthAPIPlot;
import me.dan.alibabasdk.param.authorization.ParamsOfGetAccessToken;
import me.dan.alibabasdk.param.authorization.ParamsOfRefreshAccessToken;
import me.dan.alibabasdk.param.authorization.ParamsOfRenewRefreshAccessToken;

/**
 * @Title: AuthorizationTest.java
 * @Package me.dan.alibabasdk.authorization
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-05 下午4:16:56
 * @version 0.0.1
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class AuthorizationTest {

	@Test
	public void testGetPreAuthCode() throws Exception {
		PreAuthAPIPlot a = new PreAuthAPIPlot("******", "1688", "http://www.eastmall.vip/ali-pre-auth", "******");

		String url = a.getAuthorizationUrl();

		System.out.println(url);
	}

	@Test
	public void testGetAccessToken() throws Throwable {
		ParamsOfGetAccessToken p = new ParamsOfGetAccessToken();
		p.setClient_id("******");
		p.setClient_secret("******");
		p.setRedirect_uri("http://www.eastmall.vip/ali-pre-auth");
		p.setCode("292dab94-397b-4f7a-8d71-8bb6a0caec0d");
		p.setGrant_type(GrantType.authorization_code);
		AuthorizationAPIPlot ap = new AuthorizationAPIPlot();

		try {
			ResponseEntity<AuthorizationToken> result = ap.getAccessToken(p);
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testRefreshAccessToken() throws Exception {
		ParamsOfRefreshAccessToken p = new ParamsOfRefreshAccessToken();
		p.setClient_id("******");
		p.setClient_secret("******");
		p.setRefresh_token("41227eb4-520e-48e0-a432-7d17c870bf6c");

		AuthorizationAPIPlot ap = new AuthorizationAPIPlot();

		try {
			ResponseEntity<AuthorizationToken> result = ap.refreshAccessToken(p);
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRefresh() throws Exception {

		ParamsOfRenewRefreshAccessToken p = new ParamsOfRenewRefreshAccessToken();
		p.setClient_id("******");
		p.setClient_secret("******");
		p.setAccess_token("cf1c7c8b-5843-4311-835a-cd18d91063c0");
		p.setRefresh_token("41227eb4-520e-48e0-a432-7d17c870bf6c");

		AuthorizationAPIPlot ap = new AuthorizationAPIPlot();

		try {
			ResponseEntity<AuthorizationToken> result = ap.renewRefreshToken(p);
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
