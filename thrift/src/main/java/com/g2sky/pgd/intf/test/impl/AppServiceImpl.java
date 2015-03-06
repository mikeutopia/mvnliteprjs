package com.g2sky.pgd.intf.test.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.thrift.TException;

import com.g2sky.pgd.intf.thrift.appservice.AppService.Iface;
import com.g2sky.pgd.intf.thrift.common.CommandMsg;
import com.g2sky.pgd.intf.thrift.common.DeviceInfo;
import com.g2sky.pgd.intf.thrift.common.DeviceLocation;
import com.g2sky.pgd.intf.thrift.common.DeviceTimeStamp;
import com.g2sky.pgd.intf.thrift.common.Fileinfo;
import com.g2sky.pgd.intf.thrift.common.RegisterInfo;

public class AppServiceImpl implements Iface {
	// private static final Logger log =
	// Logger.getLogger(LocationServiceImpl.class);

	private static final Map<String, Integer> deviceMap = new ConcurrentHashMap<String, Integer>();

	@Override
	public boolean setSingleLocation(DeviceLocation loc) throws TException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setBatchLocation(List<DeviceLocation> locs) throws TException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<DeviceLocation> pullAllLocationInfo() throws TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setDeviceAddress(String imsi, String ip, int port) throws TException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setEncryptionFactor(String imsi, byte encryptionFactor) throws TException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setTimeStamp(List<DeviceTimeStamp> timestamplist) throws TException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<DeviceInfo> getAllDevicesInfo() throws TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fileinfo> getAllFirmwareFilesInfo() throws TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean registerDevice(RegisterInfo info) throws TException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void processAsyncCommand(CommandMsg command) throws TException {
		// TODO Auto-generated method stub

	}

}
