package com.g2sky.pgd.intf.thrift.impl;

import java.util.Map;

import org.apache.thrift.TException;

import com.g2sky.pgd.intf.thrift.AppSvrClient;
import com.g2sky.pgd.intf.thrift.common.AppCommandREQ;
import com.g2sky.pgd.intf.thrift.common.AppCommandRSP;
import com.g2sky.pgd.intf.thrift.common.CommCommandRSP;
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
	public void sendAsyncCommandREQ(AppCommandREQ req) throws TException {
		System.out.println(req.toString());
		AppCommandRSP rsp = new AppCommandRSP();
		rsp.setReqID(req.getReqID());
		rsp.setParameter(req.getParameter());
		AppSvrClient.sendAsyncCommandRSP(rsp);
		// TODO Auto-generated method stub

	}

	@Override
	public void sendAsyncCommandRSP(CommCommandRSP rsp) throws TException {
		// TODO Auto-generated method stub

	}

}
