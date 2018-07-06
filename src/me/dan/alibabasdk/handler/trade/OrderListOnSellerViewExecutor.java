package me.dan.alibabasdk.handler.trade;

import me.dan.alibabasdk.entity.ResponseEntity;
import me.dan.alibabasdk.entity.client.AuthorizationToken;
import me.dan.alibabasdk.entity.trade.AlibabaTradeGetSellerOrderListResult;
import me.dan.alibabasdk.handler.ApiExecutor;
import me.dan.alibabasdk.handler.ApiHandlerWrapper;
import me.dan.alibabasdk.param.trade.ParamsOfOrderListOnSellerView;
import me.dan.alibabasdk.trade.TradeOrderSellerViewAPIPlot;

/**
 * @Title: OrderListOnSellerViewExecutor.java
 * @Package me.dan.alibabasdk.handler.trade
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-06 下午10:44:23
 * @version 0.0.1
 */
public class OrderListOnSellerViewExecutor extends
		ApiExecutor<TradeOrderSellerViewAPIPlot, ResponseEntity<AlibabaTradeGetSellerOrderListResult>, ParamsOfOrderListOnSellerView, AlibabaTradeGetSellerOrderListResult> {

	/**
	 * @Title: OrderListOnSellerViewExecutor.java
	 * @Description: TODO
	 * 
	 * @param token
	 * @param params
	 * @param retry
	 *            失败后 是否重试一次
	 */
	public OrderListOnSellerViewExecutor(AuthorizationToken token, ParamsOfOrderListOnSellerView params,
			boolean retry) {
		super();
		this.apiPlot = new TradeOrderSellerViewAPIPlot();
		this.apiHandler = new ApiHandlerWrapper<TradeOrderSellerViewAPIPlot>();
		this.params = params;
		this.apiPlot.storeAuthorizationToken(token.getClientId() + ":" + token.getClientSecret(), token);
		this.token = token;
		/******** 重要步骤 *********/
		this.apiPlot.storeAuthorizationToken(token.getClientId() + ":" + token.getClientSecret(), token);
		this.apiPlot.getRequestPolicy().setClientId(token.getClientId());
		this.apiPlot.getRequestPolicy().setClientSecret(token.getClientSecret());
		this.retryIfFail = retry;
	}

	public ResponseEntity<AlibabaTradeGetSellerOrderListResult> invoke() {
		TradeOrderSellerViewAPIPlot proxyPlot = (TradeOrderSellerViewAPIPlot) apiHandler.getInstance(this.apiPlot,
				"orderListOnSellerViewRetrieve", this.retryIfFail);

		ResponseEntity<AlibabaTradeGetSellerOrderListResult> result = proxyPlot
				.orderListOnSellerViewRetrieve(this.token, this.params);

		return result;
	}

}
