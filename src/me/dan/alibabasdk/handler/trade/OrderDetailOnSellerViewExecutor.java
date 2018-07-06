package me.dan.alibabasdk.handler.trade;

import me.dan.alibabasdk.entity.ResponseEntity;
import me.dan.alibabasdk.entity.client.AuthorizationToken;
import me.dan.alibabasdk.entity.trade.AlibabaTradeGetSellerViewResult;
import me.dan.alibabasdk.handler.ApiExecutor;
import me.dan.alibabasdk.handler.ApiHandlerWrapper;
import me.dan.alibabasdk.param.trade.ParamsOfOrderDetailOnSellerView;
import me.dan.alibabasdk.trade.TradeOrderSellerViewAPIPlot;

/**
 * @Title: OrderDetailOnSellerViewExecutor.java
 * @Package me.dan.alibabasdk.handler.trade
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-06 下午11:31:41
 * @version 0.0.1
 */
public class OrderDetailOnSellerViewExecutor extends
		ApiExecutor<TradeOrderSellerViewAPIPlot, ResponseEntity<AlibabaTradeGetSellerViewResult>, ParamsOfOrderDetailOnSellerView, AlibabaTradeGetSellerViewResult> {

	public OrderDetailOnSellerViewExecutor(AuthorizationToken token, ParamsOfOrderDetailOnSellerView params,
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

	public ResponseEntity<AlibabaTradeGetSellerViewResult> invoke() {
		TradeOrderSellerViewAPIPlot proxyPlot = (TradeOrderSellerViewAPIPlot) apiHandler.getInstance(this.apiPlot,
				"orderDetailOnSellerViewRetrieve", this.retryIfFail);

		ResponseEntity<AlibabaTradeGetSellerViewResult> result = proxyPlot.orderDetailOnSellerViewRetrieve(this.token,
				this.params);

		return result;
	}
}
