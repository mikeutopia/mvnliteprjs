package cz.mvn.client.jc.data;

import java.io.Serializable;

public class TestVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String msgId;
	private String msgContet;

	public TestVo(String msgId, String msgContet) {
		super();
		this.msgId = msgId;
		this.msgContet = msgContet;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgContet() {
		return msgContet;
	}

	public void setMsgContet(String msgContet) {
		this.msgContet = msgContet;
	}

	public String dbgStr() {
		StringBuilder dbg = new StringBuilder(TestVo.class + ":" + this.hashCode());
		dbg.append("[msgId:").append(msgId).append("; msgContet:").append(msgContet).append("]");
		return dbg.toString();
	}
}
