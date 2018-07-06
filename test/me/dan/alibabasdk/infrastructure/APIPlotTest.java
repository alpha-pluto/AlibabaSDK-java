package me.dan.alibabasdk.infrastructure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * @Title: APIPlotTest.java
 * @Package me.dan.alibabasdk.infrastructure
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-05 上午11:35:13
 * @version 0.0.1
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class APIPlotTest {

	@Test
	public void testAPIAuthorizationPlot() throws Exception {

		PreAuthAPIPlot a = new PreAuthAPIPlot("******", "1688", "http://www.eastmall.vip/ali-pre-auth", "******");

		String url = a.getAuthorizationUrl();

		System.out.println(url);
	}
}
