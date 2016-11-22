/*
	BinaryPayloadIssue.java
	
	0.5 (11/22/2016)
	
	Custom Burp Scan Issue for a successful Java Deserialization Remote Code Execution exploit when submitting the serialized object without the use of any encoding.
*/

package burp;

import java.util.Properties;

public class BinaryPayloadIssue extends DeserializationRCEExploitIssue {
	private String issueDetail;
	
	private static final String DETAIL_TEMPLATE = "The application is vulnerable to Java Deserialization Remote Code Execution. An exploit payload containing the system command <b>[COMMAND]</b>, which was intended to cause the target system to access[UPLOAD1] the [NODE_TYPE] at <b>[NODE_LOCATION]</b>, was created using the <b>[TECHNIQUE]</b> ysoserial payload type. A request was sent to the target URL containing the exploit payload in clear-text in the request body, and at <b>[TIME]</b> the [NODE_TYPE] received an HTTP request from <b>[SOURCE]</b>[UPLOAD2].<br><br>Based on the system command that was included in the exploit payload, the target system appears to be running <b>[PLATFORM]</b> on <b>[OS]</b>.";
	
	public BinaryPayloadIssue(IBurpExtenderCallbacks cb,IHttpRequestResponse exploitRR,IHttpRequestResponse nodeRR,Properties issueProps) {
		super(cb,exploitRR,nodeRR);
		issueDetail = constructIssueDetail(DETAIL_TEMPLATE,issueProps);
	}
	
	@Override
	public String getIssueDetail() {
		return issueDetail;
	}
}
