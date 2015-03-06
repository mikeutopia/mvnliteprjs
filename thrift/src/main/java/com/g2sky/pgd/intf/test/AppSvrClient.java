package com.g2sky.pgd.intf.test;

import java.util.UUID;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import com.g2sky.pgd.intf.thrift.appservice.AppService;
import com.g2sky.pgd.intf.thrift.common.CmdType;
import com.g2sky.pgd.intf.thrift.common.CommandMsg;
import com.g2sky.pgd.intf.thrift.common.MsgType;

public class AppSvrClient {

	public static final String SERVER_IP = "127.0.0.1";

	public static final int SERVER_PORT = 8090;

	public static final int TIMEOUT = 3000;

	private static TTransport transport = null;

	private static TProtocol protocol = null;

	private static AppService.Client appClient = null;

	private static AppService.Client getAppClient() throws TTransportException {
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

	public static AppService.Client getAppClient1() throws TException {
		TTransport transport = null;
		try {
			transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
			// 协议要和服务端一致
			TProtocol protocol = new TBinaryProtocol(transport);
			// TProtocol protocol = new TCompactProtocol(transport);
			// TProtocol protocol = new TJSONProtocol(transport);
			AppService.Client client = new AppService.Client(protocol);
			transport.open();
			return client;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		testProcessAsyncCommand();
	}

	private static void testProcessAsyncCommand() throws TException {
		CommandMsg msg = new CommandMsg();
		msg.setMsgID(UUID.randomUUID().toString());
		msg.setCmdType(CmdType.COMMCMDREQ);
		msg.setMsgType(MsgType.CodeAuth);
		msg.setVer(1);
		msg.setBody("{\"imei\":\"jsdkf\"}");
		System.out.println("APPCLINET SEND:" + msg);
		getAppClient().processAsyncCommand(msg);

	}
}
