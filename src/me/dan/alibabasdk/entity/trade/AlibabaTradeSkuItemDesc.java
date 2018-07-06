package me.dan.alibabasdk.entity.trade;

import java.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;

public class AlibabaTradeSkuItemDesc {

	private String name;

	/**
	 * @return 属性名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置属性名 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setName(String name) {
		this.name = name;
	}

	private String value;

	/**
	 * @return 属性值
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 设置属性值 *
	 * 参数示例：
	 * 
	 * <pre></pre>
	 * 
	 * 此参数必填
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
