package me.dan.alibabasdk.infrastructure;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import me.dan.alibabasdk.param.authorization.ParamsOfGetAccessToken;
import me.dan.alibabasdk.util.RequestParamModelToMap;

/**
 * @Title: ProtocolTest.java
 * @Package me.dan.alibabasdk.infrastructure
 * @Description: ����
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-03 ����4:49:12
 * @version 0.0.1
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class EnumTest {

	@Test
	public void testProtocol() throws Exception {

		Protocol p = Protocol.param2;
		System.out.println(p.getProtocolDescription());
	}

	@Test
	public void testUriSchema() throws Exception {

		UriSchema u = UriSchema.https;
		System.out.println(u.getSchemaDescription());
	}

	@Test
	public void testSessionType() throws Exception {
		SessionType s = SessionType.SandBox;
		System.out.println(s.getSessionTypeDescription());
	}

	@Test
	public void testGrantType() throws Exception {
		GrantType g = GrantType.get_token;
		System.out.println(g.getGrantTypeDescription());
		System.out.println(g.name());
	}

	@Test
	public void testApi() throws Exception {
		String pathApi = "/apiroot/{$Protocol}/alibabl";
		pathApi = pathApi.replaceAll("(?i)\\{\\$protocol\\}", "d909090");
		System.out.println(pathApi);
	}

	@Test
	public void testApiHost() throws Exception {
		ApiHost s = ApiHost.request;
		System.out.println(s.getHostProd());
	}

	@Test
	public void testParamsOfGetAccessToken() throws Exception {

		ParamsOfGetAccessToken p = new ParamsOfGetAccessToken();

		p.setClient_id("client-id-00009");

		Map<String, Object> m = RequestParamModelToMap.ConvertRequestParamModelToMap(p);

		System.out.println(m);

	}
}
