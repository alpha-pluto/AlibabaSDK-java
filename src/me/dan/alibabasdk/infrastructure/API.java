package me.dan.alibabasdk.infrastructure;

import java.io.Serializable;

import me.dan.alibabasdk.exception.AliSDKException;
import me.dan.alibabasdk.util.GenericUtils;

/**
 * @Title: API.java
 * @Package me.dan.alibabasdk.infrastructure
 * @Description: API的实体，由root,version等组成
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-03 下午6:18:44
 * @version 0.0.1
 */
public class API implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 * 
	 */
	private static final long serialVersionUID = 3407390666121988614L;

	/*
	 * api的根目录
	 */
	private String apiRoot = "openapi";

	/*
	 * api的版本
	 */
	private String apiVersion = "1";

	/*
	 * api的命名空间
	 */
	private String apiNamespace = "";

	/*
	 * api的名称
	 */
	private String apiName = "";

	private boolean accessPrivateApi = false;

	public API() {
		super();
	}

	public API(String apiRoot, String apiVersion, String apiNamespace, String apiName) {
		super();
		this.apiRoot = apiRoot;
		this.apiVersion = apiVersion;
		this.apiNamespace = apiNamespace;
		this.apiName = apiName;
	}

	public String getApiRoot() {
		return apiRoot;
	}

	public void setApiRoot(String apiRoot) {
		this.apiRoot = apiRoot;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getApiNamespace() {
		return apiNamespace;
	}

	public void setApiNamespace(String apiNamespace) {
		this.apiNamespace = apiNamespace;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public boolean isAccessPrivateApi() {
		return accessPrivateApi;
	}

	public void setAccessPrivateApi(boolean accessPrivateApi) {
		this.accessPrivateApi = accessPrivateApi;
		if (accessPrivateApi)
			this.apiRoot = "api";
		else
			this.apiRoot = "openapi";
	}

	/*
	 * api所需要的参数是否已经准备好
	 */
	public boolean isApiReady() {
		return !(GenericUtils.isBlank(apiRoot) || GenericUtils.isBlank(apiVersion) || GenericUtils.isBlank(apiNamespace)
				|| GenericUtils.isBlank(apiName));
	}

	/*
	 * 组合api的参数为访问地址
	 */
	public String getApiAddress() throws AliSDKException {

		if (!isApiReady()) {
			throw new AliSDKException("api参数不完整");
		}

		StringBuilder sbApiAddress = new StringBuilder();
		/// {apiRoot}/{protocol.ToString()}/{apiVersion}/{apiNamespace}/{apiName}/{clientId}
		sbApiAddress.append("/");
		sbApiAddress.append(getApiRoot());
		sbApiAddress.append("/{$protocol}");
		sbApiAddress.append("/");
		sbApiAddress.append(getApiVersion());
		sbApiAddress.append("/");
		sbApiAddress.append(getApiNamespace());
		sbApiAddress.append("/");
		sbApiAddress.append(getApiName());
		sbApiAddress.append("/{$clientId}");
		return sbApiAddress.toString();
	}

	/*
	 * 送去签名的path
	 */
	public String getApiSignatureAddress() throws AliSDKException {
		if (!isApiReady()) {
			throw new AliSDKException("api参数不完整");
		}

		StringBuilder sbApiAddress = new StringBuilder();
		/// {apiRoot}/{protocol.ToString()}/{apiVersion}/{apiNamespace}/{apiName}/{clientId}

		sbApiAddress.append("{$protocol}");
		sbApiAddress.append("/");
		sbApiAddress.append(getApiVersion());
		sbApiAddress.append("/");
		sbApiAddress.append(getApiNamespace());
		sbApiAddress.append("/");
		sbApiAddress.append(getApiName());
		sbApiAddress.append("/{$clientId}");
		return sbApiAddress.toString();
	}
}
