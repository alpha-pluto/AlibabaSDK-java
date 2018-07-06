package me.dan.alibabasdk.serialize;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Title: SerializerProvider.java
 * @Package me.dan.alibabasdk.serialize
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午12:39:38
 * @version 0.0.1
 */
public abstract class SerializerProvider {

	private static Map<String, Serializer> serializerRepository = new LinkedHashMap<String, Serializer>();

	public Serializer getSerializer(String objectFormat) {
		return serializerRepository.get(objectFormat);
	}

	public void register(Serializer serializer) {
		serializerRepository.put(serializer.supportedObjectFormat(), serializer);
	}

	public Collection<Serializer> getSerializers() {
		return serializerRepository.values();
	}

	private static Map<String, DeSerializer> deSerializerRepository = new LinkedHashMap<String, DeSerializer>();

	public DeSerializer getDeSerializer(String objectFormat) {
		return deSerializerRepository.get(objectFormat);
	}

	public void register(DeSerializer deSerializer) {
		deSerializerRepository.put(deSerializer.supportedObjectFormat(), deSerializer);
	}

	public Collection<DeSerializer> getDeSerializers() {

		return deSerializerRepository.values();
	}

}
