package me.dan.alibabasdk.infrastructure;

/**
 * @Title: SessionType.java
 * @Package me.dan.alibabasdk.infrastructure
 * @Description: 访问资源的对话标识 (沙盒环境，正式环境)
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-03 下午5:17:21
 * @version 0.0.1
 */
public enum SessionType {

	/*
	 * 沙盒环境，用于开发，测试
	 */
	SandBox(0, "sandbox", "沙盒环境"),

	Product(1, "product", "正式环境");

	private int sessionTypeId;

	private String sessionType;

	private String sessionTypeDescription;

	private SessionType(int sessionTypeId, String sessionType, String sessionTypeDescription) {
		this.sessionTypeId = sessionTypeId;
		this.sessionType = sessionType;
		this.sessionTypeDescription = sessionTypeDescription;
	}

	public int getSessionTypeId() {
		return sessionTypeId;
	}

	public String getSessionType() {
		return sessionType;
	}

	public String getSessionTypeDescription() {
		return sessionTypeDescription;
	}

	public static SessionType sessionTypeIdOf(int index) {
		for (SessionType sessionType : values()) {
			if (sessionType.getSessionTypeId() == index) {
				return sessionType;
			}
		}
		return null;
	}

}
