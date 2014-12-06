package cz.mvn.db.data;

import java.io.Serializable;
import java.util.Date;

public class DeviceHistLoc implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer historyOid;
	private String deviceImei;
	private Double lontitude;
	private Double latitude;
	private Date gpsTime;

	public Integer getHistoryOid() {
		return historyOid;
	}

	public void setHistoryOid(Integer historyOid) {
		this.historyOid = historyOid;
	}

	public String getDeviceImei() {
		return deviceImei;
	}

	public void setDeviceImei(String deviceImei) {
		this.deviceImei = deviceImei;
	}

	public Double getLontitude() {
		return lontitude;
	}

	public void setLontitude(Double lontitude) {
		this.lontitude = lontitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Date getGpsTime() {
		return gpsTime;
	}

	public void setGpsTime(Date gpsTime) {
		this.gpsTime = gpsTime;
	}

	@Override
	public String toString() {
		StringBuilder dbgSb = new StringBuilder("[");
		dbgSb.append("historyOid=").append(historyOid).append(",");
		dbgSb.append("deviceImei=").append(deviceImei).append(",");
		dbgSb.append("lontitude=").append(lontitude).append(",");
		dbgSb.append("latitude=").append(latitude).append(",");
		dbgSb.append("gpsTime=").append(gpsTime).append("]");
		return dbgSb.toString();
	}
}
