package me.dan.alibabasdk.serialize;

import java.util.Map;

/**
 * @Title: Serializer.java
 * @Package me.dan.alibabasdk.serialize
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午12:32:03
 * @version 0.0.1
 */
public interface Serializer {

	public String supportedObjectFormat();

	public Map<String, Object> serialize(Object serializer);

}
