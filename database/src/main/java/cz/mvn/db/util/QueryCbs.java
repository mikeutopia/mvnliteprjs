package cz.mvn.db.util;

import java.sql.ResultSet;

import cz.mvn.db.data.DeviceHistLoc;

public class QueryCbs {

	public static QueryCb<DeviceHistLoc> toDeviceHistLoc() {
		return new QueryCb<DeviceHistLoc>() {
			@Override
			public DeviceHistLoc dataToObj(ResultSet rs) throws Exception {
				DeviceHistLoc loc = new DeviceHistLoc();
				loc.setHistoryOid(rs.getInt("historyOid"));
				loc.setDeviceImei(rs.getString("deviceImei"));
				loc.setLontitude(rs.getDouble("longitude"));
				loc.setLatitude(rs.getDouble("latitude"));
				loc.setGpsTime(rs.getTimestamp("gpsTime"));
				return loc;
			}
		};
	}

	public static QueryCb<String> transToString(final String filedName) {
		return new QueryCb<String>() {
			@Override
			public String dataToObj(ResultSet rs) throws Exception {
				return rs.getString(filedName);
			}
		};
	}

}
