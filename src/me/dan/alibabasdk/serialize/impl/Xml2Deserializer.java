package me.dan.alibabasdk.serialize.impl;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import me.dan.alibabasdk.entity.ObjectBox;
import me.dan.alibabasdk.entity.ResponseEntity;
import me.dan.alibabasdk.infrastructure.Protocol;
import me.dan.alibabasdk.serialize.DeSerializer;
import me.dan.alibabasdk.util.LoggerHelper;

/**
 * @Title: Xml2Deserializer.java
 * @Package me.dan.alibabasdk.serialize.impl
 * @Description: TODO
 * @date 2018-07-04 下午12:49:48
 */
public class Xml2Deserializer implements DeSerializer {

	@Override
	public String supportedObjectFormat() {
		return Protocol.xml2.name();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <T> ResponseEntity<T> deSerialize(InputStream is, Class<T> resultType, String charSet, ObjectBox content)
			throws IOException, ParseException {
		LoggerHelper.getClientLogger().info("Parse body by xml2.");
		try {

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(is);
			NodeList nodeList = document.getChildNodes();
			Node root = nodeList.item(0);

			if (Map.class.isAssignableFrom(resultType)) {

				Map result = new LinkedHashMap();
				deserializeMap(root, result);
				ResponseEntity<T> responseEntity = new ResponseEntity<T>();
				responseEntity.setResult((T) result);
				return responseEntity;

			} else if (List.class.isAssignableFrom(resultType)) {

				List result = new ArrayList();
				deserializeList(root, result);
				ResponseEntity<T> responseEntity = new ResponseEntity<T>();
				responseEntity.setResult((T) result);
				return responseEntity;

			} else {
				throw new RuntimeException(supportedObjectFormat() + " only supported Map and List");
			}

		} catch (Exception e) {
			throw new RuntimeException("Exception occured when parsing response.", e);
		}
	}

	@Override
	public Throwable buildException(InputStream inputStream, int statusCode, String charSet, ObjectBox content)
			throws IOException, ParseException {
		throw new java.lang.UnsupportedOperationException();
	}

	/*
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void deserializeMap(Node node, Map result) throws IOException, ParseException {
		NodeList childrenNodeList = node.getChildNodes();
		for (int i = 0; i < childrenNodeList.getLength(); i++) {
			Node child = childrenNodeList.item(i);
			Object object = deserialize(node);
			Object extObject = result.get(child.getLocalName());
			if (extObject != null) {
				if (extObject instanceof List) {
					List extOjbectList = (List) extObject;
					extOjbectList.add(object);
				} else {
					List extOjbectList = new ArrayList();
					extOjbectList.add(extObject);
					extOjbectList.add(object);
					result.put(child.getLocalName(), extOjbectList);
				}
			} else {
				result.put(child.getLocalName(), object);
			}

		}
	}

	/*
	 * 
	 */
	@SuppressWarnings("rawtypes")
	private Object deserialize(Node node) throws IOException, ParseException {
		if (node.hasChildNodes()) {
			Node child = node.getFirstChild();
			if (isLogicalXMLRootArray(child)) {
				List result = new ArrayList();
				deserializeList(node, result);
				return result;
			} else {
				Map result = new LinkedHashMap();
				deserializeMap(node, result);
				return result;
			}
		} else {
			String nodeValue = node.getNodeValue();
			return nodeValue;
		}
	}

	/*
	 * 
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	private void deserializeList(Node node, List result) throws IOException, ParseException {
		NodeList childrenNodeList = node.getChildNodes();
		for (int i = 0; i < childrenNodeList.getLength(); i++) {
			Node child = childrenNodeList.item(i);
			Object object = deserialize(node);
			result.add(object);
		}
	}

	/*
	 * 
	 */
	private boolean isLogicalXMLRootArray(Node node) {
		return "list".equals(node.getLocalName()) || "item".equals(node.getLocalName());
	}

}
