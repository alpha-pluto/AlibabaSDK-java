package me.dan.alibabasdk.param.trade;

import java.io.Serializable;

import me.dan.alibabasdk.entity.Params;
import me.dan.alibabasdk.entity.trade.AlibabaTradeGetSellerViewResult;

/**
 * @Title: ParamsOfOrderDetailOnSellerView.java
 * @Package me.dan.alibabasdk.param.trade
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-06 下午4:30:04
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class ParamsOfOrderDetailOnSellerView extends Params<AlibabaTradeGetSellerViewResult> implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 * 
	 */
	private static final long serialVersionUID = -3080423085105272849L;

	private String webSite;

	/**
	 * @return 站点信息，指定调用的API是属于国际站（alibaba）还是1688网站（1688）
	 */
	public String getWebSite() {
		return webSite;
	}

	/**
	 * 设置站点信息，指定调用的API是属于国际站（alibaba）还是1688网站（1688） *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	private String orderId;

	/**
	 * @return 交易的订单id
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * 设置交易的订单id *
	 * 参数示例：
	 * 
	 * <pre>
	 * 123456
	 * </pre>
	 * 
	 * 此参数必填
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/*
	 * 查询结果中包含的域，GuaranteesTerms：保障条款，NativeLogistics：物流信息，RateDetail：评价详情，
	 * OrderInvoice：发票信息。默认返回GuaranteesTerms、NativeLogistics、OrderInvoice。
	 * GuaranteesTerms,NativeLogistics,RateDetail,OrderInvoice
	 * GuaranteesTerms,NativeLogistics,OrderInvoice
	 */
	private String includeFields;

	public String getIncludeFields() {
		return includeFields;
	}

	public void setIncludeFields(String includeFields) {
		this.includeFields = includeFields;
	}

	public ParamsOfOrderDetailOnSellerView() {

		super();
		this.webSite = "1688";
		this.orderId = "0";
		this.includeFields = "GuaranteesTerms,NativeLogistics,RateDetail,OrderInvoice";
		// TODO Auto-generated constructor stub
	}

}
