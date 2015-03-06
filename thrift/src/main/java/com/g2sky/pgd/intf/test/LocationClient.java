package com.g2sky.pgd.intf.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import com.g2sky.pgd.intf.thrift.appservice.AppService;
import com.g2sky.pgd.intf.thrift.common.DeviceLocation;

public class LocationClient {
	public static final String SERVER_IP = "10.100.8.248";
	public static final int SERVER_PORT = 8090;
	public static final int TIMEOUT = 3000;
	private static final long now = System.currentTimeMillis();
	public static final int[] MOCK_DAYS = { ThriftUtils.dayToInt(new Date(now - 3 * ThriftUtils.DAY_MILLIS)),
			ThriftUtils.dayToInt(new Date(now - 2 * ThriftUtils.DAY_MILLIS)),
			ThriftUtils.dayToInt(new Date(now - ThriftUtils.DAY_MILLIS)), ThriftUtils.dayToInt(new Date()) };

	private static final int mockDayCnt = MOCK_DAYS.length;

	public static void startClient(List<DeviceLocation> locs) throws TException {
		TTransport transport = null;
		try {
			transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
			// 协议要和服务端一致
			TProtocol protocol = new TBinaryProtocol(transport);
			// TProtocol protocol = new TCompactProtocol(transport);
			// TProtocol protocol = new TJSONProtocol(transport);
			AppService.Client client = new AppService.Client(protocol);
			transport.open();
			boolean result = client.setBatchLocation(locs);
			System.out.println("Thrify client result =: " + result);
		} catch (TTransportException e) {
			e.printStackTrace();
		} finally {
			if (null != transport) {
				transport.close();
			}
		}
	}

	public static void batchSendDatas() throws TException {
		TTransport transport = null;
		try {
			transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
			// 协议要和服务端一致
			TProtocol protocol = new TBinaryProtocol(transport);
			// TProtocol protocol = new TCompactProtocol(transport);
			// TProtocol protocol = new TJSONProtocol(transport);
			AppService.Client client = new AppService.Client(protocol);
			transport.open();
			int secs = 10;
			long startTime = System.currentTimeMillis();
			int bc = 10;// secCnt=bc*10
			long allCnt = 0L;
			for (int i = 0; i < secs; i++) {
				for (int j = 0; j < 10;) {
					allCnt += bc;
					client.setBatchLocation(buildLocas(1, bc, startTime + i * j));
					Thread.sleep(100L);
				}
				System.out.println(String.format("TOTAL CNT:%10d", allCnt));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != transport) {
				transport.close();
			}
		}
	}

	/**
	 * @param args
	 * @throws TException
	 */
	public static void main(String[] args) throws TException {
		batchSendDatas();
	}

	private static List<DeviceLocation> buildLocas(int from, int to, long time) {
		List<DeviceLocation> locs = new ArrayList<DeviceLocation>();
		for (int i = from; i <= to; i++) {
			DeviceLocation loc = new DeviceLocation();
			loc.setImsi("imsi000000000" + ((i % 100) + 10));
			loc.setTimestamp(MOCK_DAYS[i % mockDayCnt] * 1000000L + i);
			loc.setOriginalMsgBody(UUID.randomUUID().toString().getBytes());
			locs.add(loc);
		}
		return locs;
	}
}
