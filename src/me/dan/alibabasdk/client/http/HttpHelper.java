package me.dan.alibabasdk.client.http;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import me.dan.alibabasdk.exception.AliSDKException;
import me.dan.alibabasdk.infrastructure.APIPlot;
import me.dan.alibabasdk.infrastructure.HttpMethod;
import me.dan.alibabasdk.infrastructure.RequestPolicy;
import me.dan.alibabasdk.util.DateUtil;
import me.dan.alibabasdk.util.GenericUtils;
import me.dan.alibabasdk.util.SignatureUtil;

/**
 * @Title: HttpHelper.java
 * @Package me.dan.alibabasdk.client.http
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午7:11:18
 * @version 0.0.1
 */
public final class HttpHelper {

	public static final String PARAM_NAME_SIGNATURE = "_aop_signature";
	public static final String PARAM_NAME_TIMESTAMP = "_aop_timestamp";
	public static final String PARAM_NAME_DATEPATTERN = "_aop_datePattern";
	public static final String PARAM_NAME_RESPONSE_FORMAT = "_aop_responseFormat";
	public static final String PARAM_NAME_ACCESS_TOKEY = "access_token";

	/*
	 * 
	 */
	public static String buildQuery(Map<String, Object> params) throws IOException {
		if (params == null || params.isEmpty()) {
			return "";
		}
		StringBuilder query = new StringBuilder();
		Set<Entry<String, Object>> entries = params.entrySet();
		for (Entry<String, Object> entry : entries) {
			String name = entry.getKey();
			Object value = entry.getValue();
			if (value != null) {

				query.append("&");

				query.append(name).append("=").append(URLEncoder.encode(String.valueOf(value), "utf-8"));
			}
		}
		return query.toString().substring(1);
	}

	public final static Map<String, String> buildHttpHeader() {
		Map<String, String> header = new LinkedHashMap<String, String>();
		header.put("Accept", "text/xml,text/javascript,application/json");
		header.put("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36");
		return header;
	}

	public static URL buildRequestUrl(APIPlot plot, Map<String, Object> params) throws AliSDKException, IOException {
		StringBuilder pathApiPassToBuild = new StringBuilder();
		String query = "";
		String protocol = plot.getRequestPolicy().getUriSchema().name();
		String host = plot.getHost();
		int port = plot.getRequestPolicy().getUriSchema().getSchemaPort();
		String pathApi = plot.getRequestPolicy().getApiRequestPath();

		pathApiPassToBuild.append(pathApi);

		if (plot.getRequestPolicy().getHttpMethod().equals(HttpMethod.GET)) {
			query = buildQuery(params);
			if (!GenericUtils.isBlank(query)) {
				pathApiPassToBuild.append("?");
				pathApiPassToBuild.append(query);
			}
		} else if (plot.getRequestPolicy().getHttpMethod().equals(HttpMethod.POST)) {

		}

		return new URL(protocol, host, port, pathApiPassToBuild.toString());
	}

	public static void signature(RequestPolicy requestPolicy, Map<String, Object> params) throws AliSDKException {
		if (!requestPolicy.isValidateSignatureRequired())
			return;
		if (GenericUtils.isBlank(requestPolicy.getClientId())
				|| GenericUtils.isBlank(requestPolicy.getClientSecret())) {
			return;
		}

		byte[] sign = SignatureUtil.hmacSha1(requestPolicy.getApiSignaturePath(), params,
				requestPolicy.getClientSecret());

		String signedContent = SignatureUtil.encodeHexStr(sign);
		params.put(PARAM_NAME_SIGNATURE, signedContent);

	}

	public static void attachAccessToken(RequestPolicy requestPolicy, Map<String, Object> params)
			throws AliSDKException {
		String accessToken = requestPolicy.getAccessTokenOrPreAuthCode();
		if (!GenericUtils.isBlank(accessToken)) {
			params.put(PARAM_NAME_ACCESS_TOKEY, accessToken);
		}
		return;
	}

	public static void forceOceanDateFormat(RequestPolicy requestPolicy, Map<String, Object> params)
			throws AliSDKException {

		params.put(PARAM_NAME_DATEPATTERN, DateUtil.DEFAULT_DATE_FORMAT_STR);

		return;
	}

	public static String parseResponseCharset(RequestPolicy requestPolicy, String ctype) {
		String charset = requestPolicy.getRequestBodyCharset();

		if (!GenericUtils.isBlank(ctype)) {
			String[] params = ctype.split(";");
			for (String param : params) {
				param = param.trim();
				if (param.startsWith("charset")) {
					String[] pair = param.split("=", 2);
					if (pair.length == 2) {
						if (!GenericUtils.isBlank(pair[1])) {
							charset = pair[1].trim();
						}
					}
					break;
				}
			}
		}
		return charset;
	}

}
