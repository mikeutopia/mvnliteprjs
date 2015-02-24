package com.g2sky.pgd.intf.thrift;

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import com.g2sky.pgd.intf.thrift.appservice.AppService;
import com.g2sky.pgd.intf.thrift.appservice.DeviceLocation;
import com.g2sky.pgd.intf.thrift.appservice.Location;

public class LocationClient {

	public static final String SERVER_IP = "192.168.31.248";
	public static final int SERVER_PORT = 8090;
	public static final int TIMEOUT = 30000;

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
			int secCnt = 4000;
			int secs = 180;
			long startTime = System.currentTimeMillis() - 10000L * secs;
			int bc = 2000;
			for (int i = 0; i <= secs; i++) {
				for (int j = 0; j <= secCnt;) {
					int st = j;
					j += bc;
					boolean result = client.setBatchLocation(buildLocas(st, j, startTime + i * 10000));
					System.out.println("Thrify client result =: " + result);
					Thread.sleep(1000L * bc / secCnt);
				}

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
		for (int i = from; i < to; i++) {
			DeviceLocation loc = new DeviceLocation();
			loc.setIMEI("imei" + (100000 + i));
			loc.setTimestamp(time);
			loc.setLocation(new Location((time + 8D + i * 30) % 360 - 180, (time + 7D + i * 40) % 360 - 180));
			locs.add(loc);
		}
		return locs;
	}
}
