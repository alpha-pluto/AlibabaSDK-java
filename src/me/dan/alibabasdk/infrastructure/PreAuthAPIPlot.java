package me.dan.alibabasdk.infrastructure;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import me.dan.alibabasdk.client.http.HttpHelper;

/**
 * @Title: AuthorizationAPIPlot.java
 * @Package me.dan.alibabasdk.infrastructure
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午11:30:29
 * @version 0.0.1
 */
public class PreAuthAPIPlot extends APIPlot {

	private String site;

	private String redirectUrl;

	private String state;

	public PreAuthAPIPlot(RequestPolicy requestPolicy) {

		super(requestPolicy,
				(requestPolicy.getSessionType() == SessionType.Product ? ApiHost.authorization_code.getHostProd()
						: ApiHost.authorization_code.getHostSandBox()));

		this.setRequestPolicy(requestPolicy);
	}

	/**
	 * @Title: AuthorizationAPIPlot.java
	 * @Description: TODO
	 * 
	 * @param clientId
	 * @param site
	 * @param redirectUrl
	 * @param state
	 */
	public PreAuthAPIPlot(String clientId, String site, String redirectUrl, String state) {
		super(new RequestPolicy());

		this.site = site;
		this.redirectUrl = redirectUrl;
		this.state = state;
		this.getRequestPolicy().setClientId(clientId);
		this.getRequestPolicy().setSessionType(SessionType.Product);
	}

	public String getAuthorizationUrl() throws IOException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("client_id", this.getRequestPolicy().getClientId());
		params.put("site", site);
		params.put("redirect_uri", redirectUrl);
		params.put("state", state);
		String queryString = HttpHelper.buildQuery(params);
		StringBuilder sbAuthorizationUrl = new StringBuilder();
		sbAuthorizationUrl.append(this.getRequestPolicy().getUriSchema().name());
		sbAuthorizationUrl.append("://");
		sbAuthorizationUrl.append(this.getRequestPolicy().getSessionType() == SessionType.Product
				? ApiHost.authorization_code.getHostProd()
				: ApiHost.authorization_code.getHostSandBox());
		sbAuthorizationUrl.append("/oauth/authorize?");
		sbAuthorizationUrl.append(queryString);
		return sbAuthorizationUrl.toString();
	}
}
