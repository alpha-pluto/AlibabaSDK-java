package me.dan.alibabasdk.entity.trade;

import java.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;

public class AlibabaTradeOrderReceiverInfo {

    private String toFullName;

    /**
     * @return 收件人
     */
    public String getToFullName() {
        return toFullName;
    }

    /**
     * 设置收件人     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setToFullName(String toFullName) {
        this.toFullName = toFullName;
    }

    private String toDivisionCode;

    /**
     * @return 收货人地址区域编码
     */
    public String getToDivisionCode() {
        return toDivisionCode;
    }

    /**
     * 设置收货人地址区域编码     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setToDivisionCode(String toDivisionCode) {
        this.toDivisionCode = toDivisionCode;
    }

    private String toMobile;

    /**
     * @return 收件人移动电话
     */
    public String getToMobile() {
        return toMobile;
    }

    /**
     * 设置收件人移动电话     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setToMobile(String toMobile) {
        this.toMobile = toMobile;
    }

    private String toPhone;

    /**
     * @return 收件人电话
     */
    public String getToPhone() {
        return toPhone;
    }

    /**
     * 设置收件人电话     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setToPhone(String toPhone) {
        this.toPhone = toPhone;
    }

    private String toPost;

    /**
     * @return 邮编
     */
    public String getToPost() {
        return toPost;
    }

    /**
     * 设置邮编     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setToPost(String toPost) {
        this.toPost = toPost;
    }

    private String toTownCode;

    /**
     * @return 收货人街道或镇区域编码，可能为空
     */
    public String getToTownCode() {
        return toTownCode;
    }

    /**
     * 设置收货人街道或镇区域编码，可能为空     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setToTownCode(String toTownCode) {
        this.toTownCode = toTownCode;
    }

    private String toArea;

    /**
     * @return 收货地址
     */
    public String getToArea() {
        return toArea;
    }

    /**
     * 设置收货地址     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setToArea(String toArea) {
        this.toArea = toArea;
    }

}
