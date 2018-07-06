package me.dan.alibabasdk.infrastructure;

/**
 * @Title: ApiHost.java
 * @Package me.dan.alibabasdk.infrastructure
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-05 上午11:00:06
 * @version 0.0.1
 */
public enum ApiHost {

	authorization_code(0, "auth.1688.com", "auth.1688.com"),

	request(1, "gw.open.1688.com", "gw.open.1688.com");

	private int apiHostId;

	private String hostSandBox;

	private String hostProd;

	private ApiHost(int apiHostId, String hostSandBox, String hostProd) {
		this.apiHostId = apiHostId;
		this.hostSandBox = hostSandBox;
		this.hostProd = hostProd;
	}

	public int getApiHostId() {
		return apiHostId;
	}

	public String getHostSandBox() {
		return hostSandBox;
	}

	public String getHostProd() {
		return hostProd;
	}

	public static ApiHost apiHostIdOf(int index) {
		for (ApiHost host : values()) {
			if (host.getApiHostId() == index)
				return host;
		}
		return null;
	}
}
