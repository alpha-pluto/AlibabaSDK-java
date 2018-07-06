package me.dan.alibabasdk.infrastructure;

/**
 * @Title: GrantType.java
 * @Package me.dan.alibabasdk.infrastructure
 * @Description: 获取授权的方式
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-03 下午5:26:19
 * @version 0.0.1
 */
public enum GrantType {

	authorization_code(0, "authorization_code", "获取令牌"),

	get_token(1, "get_token", "获取令牌"),

	refresh_token(2, "refresh_token", "刷新令牌");

	private int grantTypeId;

	private String grantType;

	private String grantTypeDescription;

	private GrantType(int grantTypeId, String grantType, String grantTypeDescription) {
		this.grantTypeId = grantTypeId;
		this.grantType = grantType;
		this.grantTypeDescription = grantTypeDescription;
	}

	public int getGrantTypeId() {
		return grantTypeId;
	}

	public String getGrantType() {
		return grantType;
	}

	public String getGrantTypeDescription() {
		return grantTypeDescription;
	}

	public static GrantType grantTypeIdOf(int index) {
		for (GrantType grantType : values()) {
			if (grantType.getGrantTypeId() == index)
				return grantType;
		}

		return null;
	}
}
