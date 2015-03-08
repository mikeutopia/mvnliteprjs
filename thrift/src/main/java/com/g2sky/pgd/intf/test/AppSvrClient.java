package com.g2sky.pgd.intf.test;

import java.util.UUID;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.g2sky.pgd.intf.thrift.appservice.AppService;
import com.g2sky.pgd.intf.thrift.appservice.AppService.Client;
import com.g2sky.pgd.intf.thrift.common.CmdType;
import com.g2sky.pgd.intf.thrift.common.CommandMsg;
import com.g2sky.pgd.intf.thrift.common.MsgType;

public class AppSvrClient {
	private static final Logger logger = LoggerFactory.getLogger(AppSvrClient.class);
	public static final String SERVER_IP = "127.0.0.1";

	public static final int SERVER_PORT = 8090;

	public static final int TIMEOUT = 3000;

	private static SimplePool<AppService.Client> pool = new SimplePool<AppService.Client>(getPoolObjFactory());

	private static PoolObjFactory<Client> getPoolObjFactory() {
		return new PoolObjFactory<Client>() {
			@Override
			public Client createObj() throws Exception {
				TTransport transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
				TProtocol protocol = new TBinaryProtocol(transport);
				AppService.Client client = new AppService.Client(protocol);
				transport.open();
				return client;
			}

			@Override
			public void destroyObj(Client t) throws Exception {
				t.getOutputProtocol().getTransport().close();
			}

		};
	}

	public static void main(String[] args) throws Exception {
		logger.debug("KAKAKKAKAK");
		testProcessAsyncCommand();
	}

	private static void testProcessAsyncCommand() throws Exception {
		CommandMsg msg = new CommandMsg();
		msg.setMsgID(UUID.randomUUID().toString());
		msg.setCmdType(CmdType.COMMCMDREQ);
		msg.setMsgType(MsgType.CodeAuth);
		msg.setVer(1);
		msg.setBody("{\"imei\":\"jsdkf\"}");
		System.out.println("APPCLINET SEND:" + msg);
		Client client = pool.borrowObj();
		try {
			client.processAsyncCommand(msg);
		} finally {
			pool.returnObj(client);
		}

	}

}
