package com.g2sky.pgd.intf.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import com.g2sky.pgd.intf.thrift.appservice.AppService;
import com.g2sky.pgd.intf.thrift.common.AppCommandRSP;
import com.g2sky.pgd.intf.thrift.common.CommCommandREQ;

public class AppSvrClient {

	public static final String SERVER_IP = "192.168.31.248";

	public static final int SERVER_PORT = 8090;

	public static final int TIMEOUT = 30000;

	private static TTransport transport = null;

	private static TProtocol protocol = null;

	private static AppService.Client appClient = null;

	private static AppService.Client getCommClient() throws TTransportException {
		if (appClient == null) {
			synchronized (AppSvrClient.class) {
				if (appClient == null) {
					appClient = new AppService.Client(getTProtocol());
				}
			}
		}
		return appClient;
	}

	private static TProtocol getTProtocol() throws TTransportException {
		if (protocol == null) {
			synchronized (AppSvrClient.class) {
				if (protocol == null) {
					protocol = new TBinaryProtocol(getTTransport());
				}
			}
		}
		return protocol;
	}

	private static TTransport getTTransport() throws TTransportException {
		if (transport == null) {
			synchronized (AppSvrClient.class) {
				if (transport == null) {
					transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
				}
			}
		}
		if (!transport.isOpen()) {
			transport.open();
		}
		return transport;
	}

	public static void sendAsyncCommandREQ(CommCommandREQ req) throws TException {
		try {
			getCommClient().sendAsyncCommandREQ(req);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TException(e);
		}

	}

	public static void sendAsyncCommandRSP(AppCommandRSP rsp) throws TException {
		try {
			getCommClient().sendAsyncCommandRSP(rsp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new TException(e);
		}
	}

}
