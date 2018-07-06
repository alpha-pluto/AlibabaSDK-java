package me.dan.alibabasdk.trade;

import me.dan.alibabasdk.entity.ResponseEntity;
import me.dan.alibabasdk.entity.client.AuthorizationToken;
import me.dan.alibabasdk.entity.trade.AlibabaTradeGetSellerOrderListResult;
import me.dan.alibabasdk.handler.ApiHandlerWrapper;
import me.dan.alibabasdk.infrastructure.Protocol;
import me.dan.alibabasdk.param.trade.ParamsOfOrderListOnSellerView;

/**
 * @Title: ApiHandlerTest.java
 * @Package me.dan.alibabasdk.trade
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-06 下午5:36:46
 * @version 0.0.1
 */
public class ApiHandlerTest {

	public static void main(String[] args) {
		try {

			AuthorizationToken token = new AuthorizationToken();
			token.setAccess_token("8d00b990-b8dd-00000-9fa5-2a53a33f60e7");
			token.setAliId(123456789l);
			token.setMemberId("b2b-*****");
			token.setClientId("******");
			token.setClientSecret("******");
			token.setExpires_in(35999);
			token.setRefresh_token("41227eb4-520e-48e0-a432-7d17c870bf6c");
			token.setRefresh_token_timeout("20181113172954000+0800");
			token.setResource_owner("zheming");

			ParamsOfOrderListOnSellerView param = new ParamsOfOrderListOnSellerView();
			param.setPage(1);
			param.setPageSize(20);

			ApiHandlerWrapper apiHandler = new ApiHandlerWrapper();
			TradeOrderSellerViewAPIPlot plot = new TradeOrderSellerViewAPIPlot();

			/******** 重要步骤 *********/
			plot.storeAuthorizationToken(token.getClientId() + ":" + token.getClientSecret(), token);
			plot.getRequestPolicy().setClientId(token.getClientId());
			plot.getRequestPolicy().setClientSecret(token.getClientSecret());

			TradeOrderSellerViewAPIPlot proxyPlot = (TradeOrderSellerViewAPIPlot) apiHandler.getInstance(plot,
					"orderListOnSellerViewRetrieve", true);

			ResponseEntity<AlibabaTradeGetSellerOrderListResult> result = proxyPlot.orderListOnSellerViewRetrieve(token,
					param);
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
