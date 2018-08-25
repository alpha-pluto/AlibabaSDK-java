package me.dan.alibabasdk.infrastructure;

/**
 * @Title: UriSchema.java
 * @Package me.dan.alibabasdk.infrastructure
 * @Description: 访问外部资源的协议（方式）
 * @author daniel
 * @email daniel.zhang.china#hotmail.com
 * @date 2018-07-03 下午5:04:03
 * @version 0.0.1
 */
public enum UriSchema {

	file(1, "file", 0, "The resource is a file on the local computer"),

	ftp(2, "ftp", 21, "The resource is accessed through FTP"),

	gopher(3, "gopher", 70, "The resource is accessed through the Gopher protocol"),

	http(4, "http", 80, "The resource is accessed through HTTP"),

	https(5, "https", 443, "The resource is accessed through SSL-encrypted HTTP"),

	ldap(6, "ldap", 389, "The resource is accessed through the LDAP protocol"),

	mailto(7, "mailto", 25, "The resource is an e-mail address and accessed through the SMTP protocol"),

	net_pipe(8, "net.pipe", 0, "The resource is accessed through a named pipe"),

	net_tcp(9, "net.tcp", 0, "The resource is accessed from TCP endpoint"),

	news(10, "news", 119, "The resource is accessed through the NNTP protocol"),

	nntp(11, "nntp", 119, "The resource is accessed through the NNTP protocol"),

	telnet(12, "telnet", 23, "The resource is accessed through the TELNET protocol"),

	uuid(13, "uuid", 0,
			"The resource is accessed through a unique UUID endpoint name for communicating with a service");

	private int schemaId;

	private String schema;

	private int schemaPort;

	private String schemaDescription;

	private UriSchema(int schemaId, String schema, int schemaPort, String schemaDescription) {
		this.schemaId = schemaId;
		this.schema = schema;
		this.schemaPort = schemaPort;
		this.schemaDescription = schemaDescription;
	}

	public int getSchemaId() {
		return schemaId;
	}

	public String getSchema() {
		return schema;
	}

	public String getSchemaDescription() {
		return schemaDescription;
	}

	public int getSchemaPort() {
		return schemaPort;
	}

	public static UriSchema schemaIdOf(int index) {
		for (UriSchema uriSchema : values()) {
			if (uriSchema.getSchemaId() == index) {
				return uriSchema;
			}
		}
		return null;
	}
}
