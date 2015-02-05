package cz.mvn.client.jc.pgd.data;

import java.io.Serializable;

public class CmdReq implements Serializable {
	private static final long serialVersionUID = 1L;

	private String imei;

	private String cmdKey;

	private Integer maxDelay;

	private String cmd;

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public Integer getMaxDelay() {
		if (maxDelay == null || maxDelay < 1) {
			maxDelay = 5 * 1000;// default delay 5 seconds;
		}
		return maxDelay;
	}

	public void setMaxDelay(Integer maxDelay) {
		this.maxDelay = maxDelay;
	}

	public String getCmdKey() {
		return cmdKey;
	}

	public void setCmdKey(String cmdKey) {
		this.cmdKey = cmdKey;
	}

	public String dbgStr() {
		StringBuilder dbg = new StringBuilder(CmdReq.class + ":" + this.hashCode());
		dbg.append("[imei:").append(imei).append("; cmdKey:").append(cmdKey).append("; maxDelay:").append(maxDelay)
				.append("; cmd:").append(cmd).append("]");
		return dbg.toString();
	}

}
