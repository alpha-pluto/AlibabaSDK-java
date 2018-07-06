package me.dan.alibabasdk.trade;

import java.util.Map;

import me.dan.alibabasdk.client.DefaultAuthorizationTokenRepository;
import me.dan.alibabasdk.entity.ResponseEntity;
import me.dan.alibabasdk.entity.client.AuthorizationToken;
import me.dan.alibabasdk.entity.trade.AlibabaTradeGetSellerOrderListResult;
import me.dan.alibabasdk.entity.trade.AlibabaTradeGetSellerViewResult;
import me.dan.alibabasdk.infrastructure.GenericAPIPlot;
import me.dan.alibabasdk.infrastructure.HttpMethod;
import me.dan.alibabasdk.infrastructure.Protocol;
import me.dan.alibabasdk.infrastructure.SessionType;
import me.dan.alibabasdk.infrastructure.UriSchema;
import me.dan.alibabasdk.param.trade.ParamsOfOrderDetailOnSellerView;
import me.dan.alibabasdk.param.trade.ParamsOfOrderListOnSellerView;
import me.dan.alibabasdk.util.RequestParamModelToMap;

/**
 * @Title: TradeOrderSellerViewAPIPlot.java
 * @Package me.dan.alibabasdk.trade
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-06 下午1:28:43
 * @version 0.0.1
 */
public class TradeOrderSellerViewAPIPlot extends GenericAPIPlot {

	/*
	 * 
	 */
	private void init() {
		this.getRequestPolicy().setRequestBodyCharset("UTF-8");
		this.getRequestPolicy().setHttpMethod(HttpMethod.POST);
		this.getRequestPolicy().setSessionType(SessionType.Product);
		this.getRequestPolicy().setUriSchema(UriSchema.https);
		this.getRequestPolicy().getApi().setApiRoot("openapi");
		this.getRequestPolicy().getApi().setApiNamespace("com.alibaba.trade");
		this.getRequestPolicy().getApi().setApiVersion("1");
		this.getRequestPolicy().setRequestProtocol(Protocol.param2);
		this.getRequestPolicy().setValidateSignatureRequired(true);
		this.setTokenRepository(new DefaultAuthorizationTokenRepository());
	}

	public TradeOrderSellerViewAPIPlot() {

		super();
		init();
	}

	/**
	 * @Title: OrderListOnSellerViewRetrieve
	 * @Description: TODO
	 * @param token
	 * @param param
	 * @return
	 * @return ResponseEntity<AlibabaTradeGetSellerOrderListResult>
	 * @throws
	 * 
	 */
	public ResponseEntity<AlibabaTradeGetSellerOrderListResult> orderListOnSellerViewRetrieve(AuthorizationToken token,
			ParamsOfOrderListOnSellerView param) {

		this.getRequestPolicy().setClientId(token.getClientId());
		this.getRequestPolicy().setClientSecret(token.getClientSecret());
		this.getRequestPolicy().setAccessTokenOrPreAuthCode(token.getAccess_token());
		this.getRequestPolicy().setValidateSignatureRequired(true);
		this.getRequestPolicy().getApi().setApiName("alibaba.trade.getSellerOrderList");
		this.getRequestPolicy().setRequestProtocol(Protocol.param2);

		ResponseEntity<AlibabaTradeGetSellerOrderListResult> result = null;

		Map<String, Object> mappedParam = RequestParamModelToMap.ConvertRequestParamModelToMap(param);
		this.setParams(mappedParam);
		this.setResultType(param.getResponseClass());

		try {
			result = this.getInvokeClient().request(this,
					this.getInvokeClient().getSerializerProvider().getSerializers(),
					this.getInvokeClient().getSerializerProvider().getDeSerializers());

		} catch (Exception e) {

			e.printStackTrace();
		}

		return result;
	}

	public ResponseEntity<AlibabaTradeGetSellerViewResult> orderDetailOnSellerViewRetrieve(AuthorizationToken token,
			ParamsOfOrderDetailOnSellerView param) {
		this.getRequestPolicy().setClientId(token.getClientId());
		this.getRequestPolicy().setClientSecret(token.getClientSecret());
		this.getRequestPolicy().setAccessTokenOrPreAuthCode(token.getAccess_token());
		this.getRequestPolicy().setValidateSignatureRequired(true);
		this.getRequestPolicy().getApi().setApiName("alibaba.trade.get.sellerView");
		this.getRequestPolicy().setRequestProtocol(Protocol.param2);

		ResponseEntity<AlibabaTradeGetSellerViewResult> result = null;

		Map<String, Object> mappedParam = RequestParamModelToMap.ConvertRequestParamModelToMap(param);
		this.setParams(mappedParam);
		this.setResultType(param.getResponseClass());

		try {
			result = this.getInvokeClient().request(this,
					this.getInvokeClient().getSerializerProvider().getSerializers(),
					this.getInvokeClient().getSerializerProvider().getDeSerializers());

		} catch (Exception e) {

			e.printStackTrace();
		}

		return result;

	}
}
