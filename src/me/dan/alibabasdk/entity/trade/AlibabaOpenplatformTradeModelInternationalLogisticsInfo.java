package me.dan.alibabasdk.entity.trade;

import java.util.*;

import com.alibaba.fastjson.annotation.JSONField;

import me.dan.alibabasdk.util.DateUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;

public class AlibabaOpenplatformTradeModelInternationalLogisticsInfo {

	private String address;

	/**
	 * @return 详细地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置详细地址 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	private String allDeliveredTime;

	/**
	 * @return 完全发货时间
	 */
	public String getAllDeliveredTime() {
		return allDeliveredTime;
	}

	public Date getAllDeliveredTimeDate() {
		try {
			return DateUtil.parse(allDeliveredTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 设置完全发货时间 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setAllDeliveredTime(String allDeliveredTime) {
		this.allDeliveredTime = allDeliveredTime;
	}

	private String alternateAddress;

	/**
	 * @return 备用地址
	 */
	public String getAlternateAddress() {
		return alternateAddress;
	}

	/**
	 * 设置备用地址 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setAlternateAddress(String alternateAddress) {
		this.alternateAddress = alternateAddress;
	}

	private String carrier;

	/**
	 * @return 承运商
	 */
	public String getCarrier() {
		return carrier;
	}

	/**
	 * 设置承运商 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	private String city;

	/**
	 * @return 城市
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 设置城市 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setCity(String city) {
		this.city = city;
	}

	private String cityCode;

	/**
	 * @return 城市编号
	 */
	public String getCityCode() {
		return cityCode;
	}

	/**
	 * 设置城市编号 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	private String contactPerson;

	/**
	 * @return 联系人姓名
	 */
	public String getContactPerson() {
		return contactPerson;
	}

	/**
	 * 设置联系人姓名 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	private String country;

	/**
	 * @return 国家
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 设置国家 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	private String countryCode;

	/**
	 * @return 国家编号
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * 设置国家编号 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	private String fax;

	/**
	 * @return 传真
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * 设置传真 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	private String faxArea;

	/**
	 * @return 传真地区区号
	 */
	public String getFaxArea() {
		return faxArea;
	}

	/**
	 * 设置传真地区区号 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setFaxArea(String faxArea) {
		this.faxArea = faxArea;
	}

	private String faxCountry;

	/**
	 * @return 传真国家编号
	 */
	public String getFaxCountry() {
		return faxCountry;
	}

	/**
	 * 设置传真国家编号 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setFaxCountry(String faxCountry) {
		this.faxCountry = faxCountry;
	}

	private BigDecimal insuranceFee;

	/**
	 * @return 物流保险费
	 */
	public BigDecimal getInsuranceFee() {
		return insuranceFee;
	}

	/**
	 * 设置物流保险费 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setInsuranceFee(BigDecimal insuranceFee) {
		this.insuranceFee = insuranceFee;
	}

	private String logisticsCode;

	/**
	 * @return 委托单号
	 */
	public String getLogisticsCode() {
		return logisticsCode;
	}

	/**
	 * 设置委托单号 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setLogisticsCode(String logisticsCode) {
		this.logisticsCode = logisticsCode;
	}

	private BigDecimal logisticsFee;

	/**
	 * @return 物流费用
	 */
	public BigDecimal getLogisticsFee() {
		return logisticsFee;
	}

	/**
	 * 设置物流费用 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setLogisticsFee(BigDecimal logisticsFee) {
		this.logisticsFee = logisticsFee;
	}

	private String mobile;

	/**
	 * @return 手机
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 设置手机 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	private String mobileArea;

	/**
	 * @return 移动电话地区区号
	 */
	public String getMobileArea() {
		return mobileArea;
	}

	/**
	 * 设置移动电话地区区号 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setMobileArea(String mobileArea) {
		this.mobileArea = mobileArea;
	}

	private String mobileCountry;

	/**
	 * @return 移动电话国家编号
	 */
	public String getMobileCountry() {
		return mobileCountry;
	}

	/**
	 * 设置移动电话国家编号 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setMobileCountry(String mobileCountry) {
		this.mobileCountry = mobileCountry;
	}

	private String port;

	/**
	 * @return 港口
	 */
	public String getPort() {
		return port;
	}

	/**
	 * 设置港口 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setPort(String port) {
		this.port = port;
	}

	private String portCode;

	/**
	 * @return 港口编号
	 */
	public String getPortCode() {
		return portCode;
	}

	/**
	 * 设置港口编号 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setPortCode(String portCode) {
		this.portCode = portCode;
	}

	private String province;

	/**
	 * @return 省份
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * 设置省份 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	private String provinceCode;

	/**
	 * @return 省份编号
	 */
	public String getProvinceCode() {
		return provinceCode;
	}

	/**
	 * 设置省份编号 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	private String shipmentAbsoluteDate;

	/**
	 * @return 绝对时间
	 */
	public String getShipmentAbsoluteDate() {
		return shipmentAbsoluteDate;
	}

	public Date getShipmentAbsoluteDateDate() {
		try {
			return DateUtil.parse(shipmentAbsoluteDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 设置绝对时间 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setShipmentAbsoluteDate(String shipmentAbsoluteDate) {
		this.shipmentAbsoluteDate = shipmentAbsoluteDate;
	}

	private String shipmentAbsoluteZone;

	/**
	 * @return 买家时区
	 */
	public String getShipmentAbsoluteZone() {
		return shipmentAbsoluteZone;
	}

	/**
	 * 设置买家时区 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setShipmentAbsoluteZone(String shipmentAbsoluteZone) {
		this.shipmentAbsoluteZone = shipmentAbsoluteZone;
	}

	private String shipmentDateType;

	/**
	 * @return 倒计时类型。absolute(绝对),relative(相对)
	 */
	public String getShipmentDateType() {
		return shipmentDateType;
	}

	/**
	 * 设置倒计时类型。absolute(绝对),relative(相对) *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setShipmentDateType(String shipmentDateType) {
		this.shipmentDateType = shipmentDateType;
	}

	private String shipmentMethod;

	/**
	 * @return 发货方式。AIR(空运),SEA(海运),EXPRESS(快递),LAND(陆运),UNKNOWN(未知)
	 */
	public String getShipmentMethod() {
		return shipmentMethod;
	}

	/**
	 * 设置发货方式。AIR(空运),SEA(海运),EXPRESS(快递),LAND(陆运),UNKNOWN(未知) *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setShipmentMethod(String shipmentMethod) {
		this.shipmentMethod = shipmentMethod;
	}

	private String shipmentRelativeDuration;

	/**
	 * @return 相对时间长度
	 */
	public String getShipmentRelativeDuration() {
		return shipmentRelativeDuration;
	}

	/**
	 * 设置相对时间长度 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setShipmentRelativeDuration(String shipmentRelativeDuration) {
		this.shipmentRelativeDuration = shipmentRelativeDuration;
	}

	private String shipmentRelativeField;

	/**
	 * @return 相对时间单位。day(天),hour(时),second(秒)
	 */
	public String getShipmentRelativeField() {
		return shipmentRelativeField;
	}

	/**
	 * 设置相对时间单位。day(天),hour(时),second(秒) *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setShipmentRelativeField(String shipmentRelativeField) {
		this.shipmentRelativeField = shipmentRelativeField;
	}

	private String shipmentRelativeStart;

	/**
	 * @return 相对时间的开始点。pre_amount(预付款到帐),final_amount(尾款到帐)
	 */
	public String getShipmentRelativeStart() {
		return shipmentRelativeStart;
	}

	/**
	 * 设置相对时间的开始点。pre_amount(预付款到帐),final_amount(尾款到帐) *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setShipmentRelativeStart(String shipmentRelativeStart) {
		this.shipmentRelativeStart = shipmentRelativeStart;
	}

	private String telephone;

	/**
	 * @return 电话
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * 设置电话 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	private String telephoneArea;

	/**
	 * @return 电话地区区号
	 */
	public String getTelephoneArea() {
		return telephoneArea;
	}

	/**
	 * 设置电话地区区号 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setTelephoneArea(String telephoneArea) {
		this.telephoneArea = telephoneArea;
	}

	private String telephoneCountryv;

	/**
	 * @return 电话国家编号
	 */
	public String getTelephoneCountryv() {
		return telephoneCountryv;
	}

	/**
	 * 设置电话国家编号 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setTelephoneCountryv(String telephoneCountryv) {
		this.telephoneCountryv = telephoneCountryv;
	}

	private String tradeTerm;

	/**
	 * @return 贸易条款说明
	 */
	public String getTradeTerm() {
		return tradeTerm;
	}

	/**
	 * 设置贸易条款说明 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setTradeTerm(String tradeTerm) {
		this.tradeTerm = tradeTerm;
	}

}
