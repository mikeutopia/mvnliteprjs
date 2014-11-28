package com.g2sky.pgd.intf.thrift.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;

import com.g2sky.pgd.intf.thrift.gen.DeviceLocation;
import com.g2sky.pgd.intf.thrift.gen.LocationService.AsyncIface;

public class LocationServiceAsyncImpl implements AsyncIface {

	@Override
	public void setSingleLocation(DeviceLocation loc, AsyncMethodCallback resultHandler) throws TException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBatchLocation(List<DeviceLocation> locs, AsyncMethodCallback resultHandler) throws TException {
		// TODO Auto-generated method stub

	}

}
