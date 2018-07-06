package me.dan.alibabasdk.serialize.impl;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import me.dan.alibabasdk.entity.ResponseEntity;
import me.dan.alibabasdk.entity.ResponseStatus;
import me.dan.alibabasdk.infrastructure.Protocol;
import me.dan.alibabasdk.util.ExceptionParser;

/**
 * @Title: JsonDeserializer.java
 * @Package me.dan.alibabasdk.serialize.impl
 * @Description: TODO
 * @date 2018-07-04 下午2:47:15
 * @version 0.0.1
 */
public class JsonDeserializer extends AbstractJsonDeserializer {

	@Override
	public String supportedObjectFormat() {
		return Protocol.json.name();
	}

	@Override
	public <T> ResponseEntity<T> deSerialize(String content, Class<T> resultType) {
		ResponseEntity<T> responseEntity = new ResponseEntity<T>();
		responseEntity.setOriginData(content);
		JSONObject rootJson = JSON.parseObject(content);
		responseEntity.setRequestTime(rootJson.getString("InvokeStartTime"));
		responseEntity.setInvokeDuration(rootJson.getLongValue("InvokeCostTime"));
		JSONObject statusJson = rootJson.getJSONObject("Status");
		ResponseStatus responseStatus = this.parseResult(statusJson, ResponseStatus.class);
		responseEntity.setResponseStatus(responseStatus);

		JSONArray jsonResponseArray = rootJson.getJSONArray("Responses");
		JSONObject jsonResponseObject = jsonResponseArray.getJSONObject(0);

		T result = this.parseResult(jsonResponseObject, resultType);
		responseEntity.setResult(result);

		return responseEntity;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Throwable buildException(String content, int statusCode) {
		Map result = JSON.parseObject(content, Map.class);
		return ExceptionParser.buildException4Json2(result);
	}

}
