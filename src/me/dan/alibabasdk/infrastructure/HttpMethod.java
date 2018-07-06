package me.dan.alibabasdk.infrastructure;

/**
 * @Title: HttpMethod.java
 * @Package me.dan.alibabasdk.infrastructure
 * @Description: 访问方式
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-03 下午8:50:34
 * @version 0.0.1
 */
public enum HttpMethod {

	POST(1, "POST", ""),

	GET(2, "GET", ""),

	PUT(3, "PUT", ""),

	DELTE(4, "DELTE", "");

	private int httpMethodId;

	private String httpMethod;

	private String httpMethodDescription;

	private HttpMethod(int httpMethodId, String httpMethod, String httpMethodDescription) {
		this.httpMethodId = httpMethodId;
		this.httpMethod = httpMethod;
		this.httpMethodDescription = httpMethodDescription;
	}

	public int getHttpMethodId() {
		return httpMethodId;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public String getHttpMethodDescription() {
		return httpMethodDescription;
	}

	public static HttpMethod httpMethodIdOf(int index) {
		for (HttpMethod httpMethod : values()) {
			if (httpMethod.getHttpMethodId() == index)
				return httpMethod;
		}
		return null;
	}

}
