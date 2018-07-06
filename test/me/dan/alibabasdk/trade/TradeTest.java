package me.dan.alibabasdk.trade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import me.dan.alibabasdk.entity.ResponseEntity;
import me.dan.alibabasdk.entity.client.AuthorizationToken;
import me.dan.alibabasdk.entity.trade.AlibabaTradeGetSellerOrderListResult;
import me.dan.alibabasdk.entity.trade.AlibabaTradeGetSellerViewResult;
import me.dan.alibabasdk.handler.ApiHandlerWrapper;
import me.dan.alibabasdk.param.trade.ParamsOfOrderDetailOnSellerView;
import me.dan.alibabasdk.param.trade.ParamsOfOrderListOnSellerView;

/**
 * @Title: TradeTest.java
 * @Package me.dan.alibabasdk.trade
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-06 下午2:49:20
 * @version 0.0.1
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TradeTest {

	@Test
	public void testOrderListOnSellerViewRetrieve() throws Exception {

		AuthorizationToken token = new AuthorizationToken();
		token.setAccess_token("8d00b990-b8dd-428d-9fa5-2a53a33f60e7");
		token.setAliId(3941413940l);
		token.setMemberId("b2b-******");
		token.setClientId("******");
		token.setClientSecret("******");
		token.setExpires_in(35999);
		token.setRefresh_token("41227eb4-520e-48e0-a432-7d17c870bf6c");
		token.setRefresh_token_timeout("20181113172954000+0800");
		token.setResource_owner("zheming");

		ParamsOfOrderListOnSellerView param = new ParamsOfOrderListOnSellerView();
		param.setPage(1);
		param.setPageSize(20);

		TradeOrderSellerViewAPIPlot plot = new TradeOrderSellerViewAPIPlot();

		try {
			ResponseEntity<AlibabaTradeGetSellerOrderListResult> result = plot.orderListOnSellerViewRetrieve(token,
					param);

			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testOrderOnSellerViewRetrieve() throws Exception {

		AuthorizationToken token = new AuthorizationToken();
		token.setAccess_token("8d00b990-b8dd-428d-9fa5-2a53a33f60e7");
		token.setAliId(123456789l);
		token.setMemberId("b2b-******");
		token.setClientId("******");
		token.setClientSecret("******");
		token.setExpires_in(35999);
		token.setRefresh_token("41227eb4-520e-48e0-a432-7d17c870bf6c");
		token.setRefresh_token_timeout("20181113172954000+0800");
		token.setResource_owner("zheming");

		ParamsOfOrderDetailOnSellerView param = new ParamsOfOrderDetailOnSellerView();
		param.setOrderId("159310337253103128");
		TradeOrderSellerViewAPIPlot plot = new TradeOrderSellerViewAPIPlot();

		try {
			ResponseEntity<AlibabaTradeGetSellerViewResult> result = plot.orderDetailOnSellerViewRetrieve(token, param);

			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
