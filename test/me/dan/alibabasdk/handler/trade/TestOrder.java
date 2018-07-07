package me.dan.alibabasdk.handler.trade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import me.dan.alibabasdk.entity.ResponseEntity;
import me.dan.alibabasdk.entity.client.AuthorizationToken;
import me.dan.alibabasdk.entity.trade.AlibabaTradeGetSellerOrderListResult;
import me.dan.alibabasdk.entity.trade.AlibabaTradeGetSellerViewResult;
import me.dan.alibabasdk.param.trade.ParamsOfOrderDetailOnSellerView;
import me.dan.alibabasdk.param.trade.ParamsOfOrderListOnSellerView;

/**
 * @Title: TestOrder.java
 * @Package me.dan.alibabasdk.handler.trade
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-06 下午11:17:34
 * @version 0.0.1
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestOrder {

	@Test
	public void testOrderListOnSellerViewExecutor() throws Exception {

		AuthorizationToken token = new AuthorizationToken();
		token.setAccess_token("8f4b8fd6-d71b-4a25-8cc3-2ea3a4333f46");
		token.setAliId(123456789l);
		token.setMemberId("******");
		token.setClientId("******");
		token.setClientSecret("******");
		token.setExpires_in(35999);
		token.setRefresh_token("41227eb4-520e-48e0-a432-7d17c870bf6c");
		token.setRefresh_token_timeout("20181113172954000+0800");
		token.setResource_owner("zheming");

		ParamsOfOrderListOnSellerView param = new ParamsOfOrderListOnSellerView();
		param.setPage(1);
		param.setPageSize(20);

		// 如果失败，是否再试一次
		boolean retryIfFail = true;

		OrderListOnSellerViewExecutor executor = new OrderListOnSellerViewExecutor(token, param, retryIfFail);

		ResponseEntity<AlibabaTradeGetSellerOrderListResult> result = executor.invoke();

		System.out.println(result);

	}

	@Test
	public void testOrderOnSellerViewExecutor() throws Exception {

		AuthorizationToken token = new AuthorizationToken();
		token.setAccess_token("8f4b8fd6-d71b-4a25-8cc3-2ea3a4333f46");
		token.setAliId(1234546789l);
		token.setMemberId("*******");
		token.setClientId("******");
		token.setClientSecret("******");
		token.setExpires_in(35999);
		token.setRefresh_token("41227eb4-520e-48e0-a432-7d17c870bf6c");
		token.setRefresh_token_timeout("20181113172954000+0800");
		token.setResource_owner("zheming");

		ParamsOfOrderDetailOnSellerView param = new ParamsOfOrderDetailOnSellerView();
		param.setOrderId("159310337253103128");

		// 如果失败，是否再试一次
		boolean retryIfFail = true;

		OrderDetailOnSellerViewExecutor executor = new OrderDetailOnSellerViewExecutor(token, param, retryIfFail);

		ResponseEntity<AlibabaTradeGetSellerViewResult> result = executor.invoke();

		System.out.println(result);
	}

}
