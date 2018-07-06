package me.dan.alibabasdk.entity.trade;

import java.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;

public class AlibabaInvoiceOrderInvoiceModel {

    private String invoiceCompanyName;

    /**
     * @return 发票公司名称(即发票抬头-title)
     */
    public String getInvoiceCompanyName() {
        return invoiceCompanyName;
    }

    /**
     * 设置发票公司名称(即发票抬头-title)     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setInvoiceCompanyName(String invoiceCompanyName) {
        this.invoiceCompanyName = invoiceCompanyName;
    }

    private Integer invoiceType;

    /**
     * @return 发票类型. 0：普通发票，1:增值税发票
     */
    public Integer getInvoiceType() {
        return invoiceType;
    }

    /**
     * 设置发票类型. 0：普通发票，1:增值税发票     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    private Long localInvoiceId;

    /**
     * @return 本地发票号
     */
    public Long getLocalInvoiceId() {
        return localInvoiceId;
    }

    /**
     * 设置本地发票号     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setLocalInvoiceId(Long localInvoiceId) {
        this.localInvoiceId = localInvoiceId;
    }

    private Long orderId;

    /**
     * @return 订单Id
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置订单Id     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    private String receiveCode;

    /**
     * @return (收件人)址区域编码
     */
    public String getReceiveCode() {
        return receiveCode;
    }

    /**
     * 设置(收件人)址区域编码     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setReceiveCode(String receiveCode) {
        this.receiveCode = receiveCode;
    }

    private String receiveCodeText;

    /**
     * @return (收件人) 省市区编码对应的文案(增值税发票信息)
     */
    public String getReceiveCodeText() {
        return receiveCodeText;
    }

    /**
     * 设置(收件人) 省市区编码对应的文案(增值税发票信息)     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setReceiveCodeText(String receiveCodeText) {
        this.receiveCodeText = receiveCodeText;
    }

    private String receiveMobile;

    /**
     * @return （收件者）发票收货人手机
     */
    public String getReceiveMobile() {
        return receiveMobile;
    }

    /**
     * 设置（收件者）发票收货人手机     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setReceiveMobile(String receiveMobile) {
        this.receiveMobile = receiveMobile;
    }

    private String receiveName;

    /**
     * @return （收件者）发票收货人
     */
    public String getReceiveName() {
        return receiveName;
    }

    /**
     * 设置（收件者）发票收货人     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    private String receivePhone;

    /**
     * @return （收件者）发票收货人电话
     */
    public String getReceivePhone() {
        return receivePhone;
    }

    /**
     * 设置（收件者）发票收货人电话     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    private String receivePost;

    /**
     * @return （收件者）发票收货地址邮编
     */
    public String getReceivePost() {
        return receivePost;
    }

    /**
     * 设置（收件者）发票收货地址邮编     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setReceivePost(String receivePost) {
        this.receivePost = receivePost;
    }

    private String receiveStreet;

    /**
     * @return (收件人) 街道地址(增值税发票信息)
     */
    public String getReceiveStreet() {
        return receiveStreet;
    }

    /**
     * 设置(收件人) 街道地址(增值税发票信息)     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setReceiveStreet(String receiveStreet) {
        this.receiveStreet = receiveStreet;
    }

    private String registerAccountId;

    /**
     * @return (公司)银行账号
     */
    public String getRegisterAccountId() {
        return registerAccountId;
    }

    /**
     * 设置(公司)银行账号     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setRegisterAccountId(String registerAccountId) {
        this.registerAccountId = registerAccountId;
    }

    private String registerBank;

    /**
     * @return (公司)开户银行
     */
    public String getRegisterBank() {
        return registerBank;
    }

    /**
     * 设置(公司)开户银行     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setRegisterBank(String registerBank) {
        this.registerBank = registerBank;
    }

    private String registerCode;

    /**
     * @return (注册)省市区编码
     */
    public String getRegisterCode() {
        return registerCode;
    }

    /**
     * 设置(注册)省市区编码     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setRegisterCode(String registerCode) {
        this.registerCode = registerCode;
    }

    private String registerCodeText;

    /**
     * @return (注册)省市区文本
     */
    public String getRegisterCodeText() {
        return registerCodeText;
    }

    /**
     * 设置(注册)省市区文本     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setRegisterCodeText(String registerCodeText) {
        this.registerCodeText = registerCodeText;
    }

    private String registerPhone;

    /**
     * @return （公司）注册电话
     */
    public String getRegisterPhone() {
        return registerPhone;
    }

    /**
     * 设置（公司）注册电话     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setRegisterPhone(String registerPhone) {
        this.registerPhone = registerPhone;
    }

    private String registerStreet;

    /**
     * @return (注册)街道地址
     */
    public String getRegisterStreet() {
        return registerStreet;
    }

    /**
     * 设置(注册)街道地址     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setRegisterStreet(String registerStreet) {
        this.registerStreet = registerStreet;
    }

    private String taxpayerIdentify;

    /**
     * @return 纳税人识别号
     */
    public String getTaxpayerIdentify() {
        return taxpayerIdentify;
    }

    /**
     * 设置纳税人识别号     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setTaxpayerIdentify(String taxpayerIdentify) {
        this.taxpayerIdentify = taxpayerIdentify;
    }

}