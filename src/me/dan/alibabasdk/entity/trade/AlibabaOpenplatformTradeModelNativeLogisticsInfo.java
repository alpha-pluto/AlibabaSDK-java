package me.dan.alibabasdk.entity.trade;

import java.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;

public class AlibabaOpenplatformTradeModelNativeLogisticsInfo {

    private String address;

    /**
     * @return 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置详细地址     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setAddress(String address) {
        this.address = address;
    }

    private String area;

    /**
     * @return 县，区
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置县，区     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setArea(String area) {
        this.area = area;
    }

    private String areaCode;

    /**
     * @return 省市区编码
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 设置省市区编码     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    private String city;

    /**
     * @return 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setCity(String city) {
        this.city = city;
    }

    private String contactPerson;

    /**
     * @return 联系人姓名
     */
    public String getContactPerson() {
        return contactPerson;
    }

    /**
     * 设置联系人姓名     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    private String fax;

    /**
     * @return 传真
     */
    public String getFax() {
        return fax;
    }

    /**
     * 设置传真     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    private String mobile;

    /**
     * @return 手机
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    private String province;

    /**
     * @return 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setProvince(String province) {
        this.province = province;
    }

    private String telephone;

    /**
     * @return 电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置电话     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    private String zip;

    /**
     * @return 邮编
     */
    public String getZip() {
        return zip;
    }

    /**
     * 设置邮编     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    private AlibabaOpenplatformTradeModelNativeLogisticsItemsInfo[] logisticsItems;

    /**
     * @return 运单明细
     */
    public AlibabaOpenplatformTradeModelNativeLogisticsItemsInfo[] getLogisticsItems() {
        return logisticsItems;
    }

    /**
     * 设置运单明细     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setLogisticsItems(AlibabaOpenplatformTradeModelNativeLogisticsItemsInfo[] logisticsItems) {
        this.logisticsItems = logisticsItems;
    }

    private String townCode;

    /**
     * @return 镇，街道地址码
     */
    public String getTownCode() {
        return townCode;
    }

    /**
     * 设置镇，街道地址码     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setTownCode(String townCode) {
        this.townCode = townCode;
    }

    private String town;

    /**
     * @return 镇，街道
     */
    public String getTown() {
        return town;
    }

    /**
     * 设置镇，街道     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setTown(String town) {
        this.town = town;
    }

}