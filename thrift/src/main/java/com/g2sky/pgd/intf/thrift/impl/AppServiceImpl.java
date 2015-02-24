package com.g2sky.pgd.intf.thrift.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.thrift.TException;

import com.g2sky.pgd.intf.thrift.appservice.AppService.Iface;
import com.g2sky.pgd.intf.thrift.appservice.DeviceLocation;
import com.g2sky.pgd.intf.thrift.common.AppCommandRSP;
import com.g2sky.pgd.intf.thrift.common.CommCommandREQ;

public class AppServiceImpl implements Iface {
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

	@Override
	public List<DeviceLocation> pullAllLocationInfo() throws TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendAsyncCommandREQ(CommCommandREQ req) throws TException {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendAsyncCommandRSP(AppCommandRSP rsp) throws TException {
		// TODO Auto-generated method stub

	}
}
