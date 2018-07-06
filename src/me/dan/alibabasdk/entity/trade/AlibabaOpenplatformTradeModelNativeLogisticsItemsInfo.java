package me.dan.alibabasdk.entity.trade;

import java.util.*;

import com.alibaba.fastjson.annotation.JSONField;

import me.dan.alibabasdk.util.DateUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;

public class AlibabaOpenplatformTradeModelNativeLogisticsItemsInfo {

	private String deliveredTime;

	/**
	 * @return 发货时间
	 */
	public String getDeliveredTime() {
		return deliveredTime;
	}

	public Date getDeliveredTimeDate() {
		try {
			return DateUtil.parse(deliveredTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 设置发货时间 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setDeliveredTime(String deliveredTime) {
		this.deliveredTime = deliveredTime;
	}

	private String logisticsCode;

	/**
	 * @return 物流编号
	 */
	public String getLogisticsCode() {
		return logisticsCode;
	}

	/**
	 * 设置物流编号 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setLogisticsCode(String logisticsCode) {
		this.logisticsCode = logisticsCode;
	}

	private String type;

	/**
	 * @return SELF_SEND_GOODS("0")自行发货，在线发货ONLINE_SEND_GOODS("1"，不需要物流的发货
	 *         NO_LOGISTICS_SEND_GOODS("2")
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置SELF_SEND_GOODS("0")自行发货，在线发货ONLINE_SEND_GOODS("1"，不需要物流的发货
	 * NO_LOGISTICS_SEND_GOODS("2") *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setType(String type) {
		this.type = type;
	}

	private Long id;

	/**
	 * @return 主键id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置主键id *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setId(Long id) {
		this.id = id;
	}

	private String status;

	/**
	 * @return 状态
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 设置状态 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	private String gmtModified;

	/**
	 * @return 修改时间
	 */
	public String getGmtModified() {
		return gmtModified;
	}

	public Date getGmtModifiedDate() {
		try {
			return DateUtil.parse(gmtModified);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 设置修改时间 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setGmtModified(String gmtModified) {
		this.gmtModified = gmtModified;
	}

	private String gmtCreate;

	/**
	 * @return 创建时间
	 */
	public String getGmtCreate() {
		return gmtCreate;
	}
	
	public Date getGmtCreateDate() {
		try {
			return DateUtil.parse(gmtCreate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 设置创建时间 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setGmtCreate(String gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	private BigDecimal carriage;

	/**
	 * @return 运费(单位为元)
	 */
	public BigDecimal getCarriage() {
		return carriage;
	}

	/**
	 * 设置运费(单位为元) *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setCarriage(BigDecimal carriage) {
		this.carriage = carriage;
	}

	private String fromProvince;

	/**
	 * @return 发货省
	 */
	public String getFromProvince() {
		return fromProvince;
	}

	/**
	 * 设置发货省 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setFromProvince(String fromProvince) {
		this.fromProvince = fromProvince;
	}

	private String fromCity;

	/**
	 * @return 发货市
	 */
	public String getFromCity() {
		return fromCity;
	}

	/**
	 * 设置发货市 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	private String fromArea;

	/**
	 * @return 发货区
	 */
	public String getFromArea() {
		return fromArea;
	}

	/**
	 * 设置发货区 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setFromArea(String fromArea) {
		this.fromArea = fromArea;
	}

	private String fromAddress;

	/**
	 * @return 发货街道地址
	 */
	public String getFromAddress() {
		return fromAddress;
	}

	/**
	 * 设置发货街道地址 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	private String fromPhone;

	/**
	 * @return 发货联系电话
	 */
	public String getFromPhone() {
		return fromPhone;
	}

	/**
	 * 设置发货联系电话 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setFromPhone(String fromPhone) {
		this.fromPhone = fromPhone;
	}

	private String fromMobile;

	/**
	 * @return 发货联系手机
	 */
	public String getFromMobile() {
		return fromMobile;
	}

	/**
	 * 设置发货联系手机 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setFromMobile(String fromMobile) {
		this.fromMobile = fromMobile;
	}

	private String fromPost;

	/**
	 * @return 发货地址邮编
	 */
	public String getFromPost() {
		return fromPost;
	}

	/**
	 * 设置发货地址邮编 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setFromPost(String fromPost) {
		this.fromPost = fromPost;
	}

	private Long logisticsCompanyId;

	/**
	 * @return 物流公司Id
	 */
	public Long getLogisticsCompanyId() {
		return logisticsCompanyId;
	}

	/**
	 * 设置物流公司Id *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setLogisticsCompanyId(Long logisticsCompanyId) {
		this.logisticsCompanyId = logisticsCompanyId;
	}

	private String logisticsCompanyNo;

	/**
	 * @return 物流公司编号
	 */
	public String getLogisticsCompanyNo() {
		return logisticsCompanyNo;
	}

	/**
	 * 设置物流公司编号 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setLogisticsCompanyNo(String logisticsCompanyNo) {
		this.logisticsCompanyNo = logisticsCompanyNo;
	}

	private String logisticsCompanyName;

	/**
	 * @return 物流公司名称
	 */
	public String getLogisticsCompanyName() {
		return logisticsCompanyName;
	}

	/**
	 * 设置物流公司名称 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setLogisticsCompanyName(String logisticsCompanyName) {
		this.logisticsCompanyName = logisticsCompanyName;
	}

	private String logisticsBillNo;

	/**
	 * @return 物流公司运单号
	 */
	public String getLogisticsBillNo() {
		return logisticsBillNo;
	}

	/**
	 * 设置物流公司运单号 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setLogisticsBillNo(String logisticsBillNo) {
		this.logisticsBillNo = logisticsBillNo;
	}

	private String subItemIds;

	/**
	 * @return 商品明细条目id，如有多个以,分隔
	 */
	public String getSubItemIds() {
		return subItemIds;
	}

	/**
	 * 设置商品明细条目id，如有多个以,分隔 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setSubItemIds(String subItemIds) {
		this.subItemIds = subItemIds;
	}

	private String toProvince;

	/**
	 * @return 收货省
	 */
	public String getToProvince() {
		return toProvince;
	}

	/**
	 * 设置收货省 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setToProvince(String toProvince) {
		this.toProvince = toProvince;
	}

	private String toCity;

	/**
	 * @return 收货市
	 */
	public String getToCity() {
		return toCity;
	}

	/**
	 * 设置收货市 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	private String toArea;

	/**
	 * @return 收货区
	 */
	public String getToArea() {
		return toArea;
	}

	/**
	 * 设置收货区 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setToArea(String toArea) {
		this.toArea = toArea;
	}

	private String toAddress;

	/**
	 * @return 收货街道地址
	 */
	public String getToAddress() {
		return toAddress;
	}

	/**
	 * 设置收货街道地址 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	private String toPhone;

	/**
	 * @return 收货联系电话
	 */
	public String getToPhone() {
		return toPhone;
	}

	/**
	 * 设置收货联系电话 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setToPhone(String toPhone) {
		this.toPhone = toPhone;
	}

	private String toMobile;

	/**
	 * @return 收货联系手机
	 */
	public String getToMobile() {
		return toMobile;
	}

	/**
	 * 设置收货联系手机 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setToMobile(String toMobile) {
		this.toMobile = toMobile;
	}

	private String toPost;

	/**
	 * @return 收货地址邮编
	 */
	public String getToPost() {
		return toPost;
	}

	/**
	 * 设置收货地址邮编 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setToPost(String toPost) {
		this.toPost = toPost;
	}

}