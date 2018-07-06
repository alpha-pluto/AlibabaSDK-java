package me.dan.alibabasdk.infrastructure;

/**
 * @Title: Protocol.java
 * @Package me.dan.alibabasdk.infrastructure
 * @Description: 请求的协议或是参数传递（返回）的格式
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-03 下午4:36:36
 * @version 0.0.1
 */
public enum Protocol {

	param(1, "param", ""),

	/*
	 * 默认推荐的协议格式，同http请求的get/post请求格式
	 */
	param2(2, "param2", "默认推荐的协议格式，同http请求的get/post请求格式"),

	/*
	 * 请求参数通过json串的方式传递,默认格式_data_={\"key\":\"value\"}
	 */
	json(3, "json", "请求参数通过json串的方式传递,默认格式_data_={\"key\":\"value\"}"),

	/*
	 * 请求参数通过json串的方式传递,默认格式_data_={\"key\":\"value\"}
	 */
	json2(4, "json2", "请求参数通过json串的方式传递,默认格式_data_={\"key\":\"value\"}"),

	/*
	 * 请求参数通过xml的方式传递,默认格式_data_=&lt;test>data&lt;/test>
	 */
	xml(5, "xml", "请求参数通过xml的方式传递,默认格式_data_=&lt;test>data&lt;/test>"),

	/*
	 * 请求参数通过xml的方式传递,默认格式_data_=&lt;test>data&lt;/test>
	 */
	xml2(6, "xml2", "请求参数通过xml的方式传递,默认格式_data_=&lt;test>data&lt;/test>"),

	http(7, "http", ""),

	https(8, "https", "");

	private int protocolId;

	private String protocol;

	private String protocolDescription;

	private Protocol(int protocolId, String protocol, String protocolDescription) {
		this.protocolId = protocolId;
		this.protocol = protocol;
		this.protocolDescription = protocolDescription;
	}

	public int getProtocolId() {
		return protocolId;
	}

	public String getProtocol() {
		return protocol;
	}

	public String getProtocolDescription() {
		return protocolDescription;
	}

	public static Protocol protocolIdOf(int index) {
		for (Protocol protocol : values()) {
			if (protocol.getProtocolId() == index) {
				return protocol;
			}
		}
		return null;
	}

}
