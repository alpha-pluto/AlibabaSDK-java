package me.dan.alibabasdk.infrastructure;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import me.dan.alibabasdk.entity.client.AuthorizationToken;
import me.dan.alibabasdk.util.DateUtil;
import me.dan.alibabasdk.util.RequestParamModelToMap;

/**
 * @Title: ClassToMapTest.java
 * @Package me.dan.alibabasdk.infrastructure
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午6:19:33
 * @version 0.0.1
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class ClassToMapTest {

	@Test
	public void testClassToMap() throws Exception {

		AuthorizationToken tk = new AuthorizationToken();
		tk.setAccess_token("access_token");
		tk.setAliId(123);
		tk.setExpires_in(1000);
		tk.setMemberId("ali-member");
		tk.setRefresh_token("ssss--erer");
		tk.setRefresh_token_timeout(new Date().toLocaleString());
		tk.setResource_owner("resourceOwnerId");
		tk.setUid("uid");

		RequestPolicy p = new RequestPolicy();

		Map<String, Object> m = RequestParamModelToMap.ConvertRequestParamModelToMap(p);

		System.out.println(m);

	}

	@Test
	public void testDateParse() throws Exception {
		String date = "20181113172954000+0800";
		Date d = DateUtil.parse(date, DateUtil.DEFAULT_DATE_FORMAT_STR);
		System.out.println(d);
	}
}
