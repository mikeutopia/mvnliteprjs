package com.g2sky.pgd.intf.thrift.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.thrift.TException;

import com.g2sky.pgd.intf.thrift.gen.DeviceLocation;
import com.g2sky.pgd.intf.thrift.gen.LocationService.Iface;

public class LocationServiceImpl implements Iface {
	// private static final Logger log =
	// Logger.getLogger(LocationServiceImpl.class);

	private static final Map<String, Integer> deviceMap = new ConcurrentHashMap<String, Integer>();

	@Override
	public boolean setSingleLocation(DeviceLocation loc) throws TException {
		// try {
		// DeviceHistLocEbo dhl = dealDeviceLocationData(loc);
		// PgdProxyUtil.getProxy().createDeviceHistLoc(dhl);
		// return true;
		// } catch (Exception e) {
		// log.error("deal deviceLocation error! data=" + loc, e);
		// // throw new TException("deal deviceLocation error!", e);
		// return false;
		// }
		System.out.println(loc.toString());
		return true;
	}

	@Override
	public boolean setBatchLocation(List<DeviceLocation> locs) throws TException {
		if (locs == null || locs.isEmpty()) {
			return false;// false or true?
		}
		for (DeviceLocation loc : locs) {
			System.out.println(loc.toString());
		}
		// try {
		// List<DeviceHistLocEbo> dhls = new ArrayList<DeviceHistLocEbo>();
		// for (DeviceLocation loc : locs) {
		// dhls.add(dealDeviceLocationData(loc));
		// }
		// PgdProxyUtil.getProxy().batchCreateDeviceHistLoc(dhls);
		// } catch (Exception e) {
		// log.error("deal deviceLocation error! datas=" + locs, e);
		// // throw new TException("deal deviceLocation error!", e);
		// return false;
		// }
		return true;
	}

	// private DeviceHistLocEbo dealDeviceLocationData(DeviceLocation loc)
	// throws Exception {
	// String deviceImei = loc.getIMEI();
	// Integer deviceOid = deviceMap.get(deviceImei);
	// if (deviceOid == null) {
	// deviceOid =
	// PgdProxyUtil.getProxy().getBaseDeviceByAppKey(deviceImei).getDeviceOid();
	// if (deviceOid == null) {
	// throw new TException("Can't find device by given imei:" + deviceImei);
	// }
	// deviceMap.put(deviceImei, deviceOid);
	// }
	// Location loca = loc.getLocation();
	// DeviceHistLocEbo dhl = new DeviceHistLocEbo();
	// dhl.setDeviceOid(deviceOid);
	// dhl.setLongitude(loca.longitude);
	// dhl.setLatitude(loca.getLatitude());
	// dhl.setGpsTime(new Date(loc.getTimestamp()));
	// return dhl;
	// }
}
