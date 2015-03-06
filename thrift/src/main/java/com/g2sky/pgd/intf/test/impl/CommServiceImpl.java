package com.g2sky.pgd.intf.test.impl;

import java.util.List;
import java.util.Map;

import org.apache.thrift.TException;

import com.g2sky.pgd.intf.thrift.common.CommandMsg;
import com.g2sky.pgd.intf.thrift.common.Fileinfo;
import com.g2sky.pgd.intf.thrift.commservice.CommService.Iface;

public class CommServiceImpl implements Iface {

	@Override
	public boolean ping() throws TException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getDebugLevel() throws TException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDebugLevel(int newDebugLevel) throws TException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isIntfLogEnable() throws TException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean enableIntfLog(boolean enable) throws TException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setTraceFilterKeys(Map<String, Integer> filterKeys) throws TException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Integer> getTraceFilterKeys() throws TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean shutdown() throws TException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setInterfaceFilterKeys(String name, Map<String, Integer> filterKeys) throws TException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Integer> getInterfaceFilterKeys(String name) throws TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInterfaceLoggerNames() throws TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setAllFirmwareFilesInfo(List<Fileinfo> fileinfolist) throws TException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void processAsyncCommand(CommandMsg command) throws TException {
		System.out.println(command);
		// TODO Auto-generated method stub

	}

}
