package me.dan.alibabasdk.entity;

/**
 * @Title: ResponseEntity.java
 * @Package me.dan.alibabasdk.entity
 * @Description: TODO
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-04 下午12:03:58
 * @version 0.0.1
 */
public class ResponseEntity<T> extends ResponseEntityBase<T> {

	@Override
	public String toString() {

		StringBuilder sbResponseEntity = new StringBuilder();
		sbResponseEntity.append("ResponseEntity={");
		sbResponseEntity.append("statusCode=" + this.getStatusCode() + ", ");
		sbResponseEntity.append("requestTime='" + this.getRequestTime() + "', ");
		sbResponseEntity.append("invokeDuration=" + this.getInvokeDuration() + ", ");
		sbResponseEntity.append("responseStatus={" + this.getResponseStatus() + "}, ");
		sbResponseEntity.append("encoding='" + this.getEncoding() + "', ");
		sbResponseEntity.append("result={" + this.getResult() + "}, ");
		sbResponseEntity.append("originData={" + this.getOriginData() + "}, ");
		sbResponseEntity.append("signature='" + this.getSignature() + "'  ");
		sbResponseEntity.append("}");

		return sbResponseEntity.toString();
	}

}
