package me.dan.alibabasdk.entity.trade;

import java.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;

public class AlibabaOpenplatformTradeKeyValuePair {

    private String key;

    /**
     * @return 键
     */
    public String getKey() {
        return key;
    }

    /**
     * 设置键     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setKey(String key) {
        this.key = key;
    }

    private String value;

    /**
     * @return 值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置值     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setValue(String value) {
        this.value = value;
    }

    private String description;

    /**
     * @return 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
