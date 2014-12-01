package com.g2sky.pgd.intf.thrift;

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import com.g2sky.pgd.intf.thrift.gen.DeviceLocation;
import com.g2sky.pgd.intf.thrift.gen.Location;
import com.g2sky.pgd.intf.thrift.gen.LocationService;

public class LocationClient {

	public static final String SERVER_IP = "localhost";
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
			LocationService.Client client = new LocationService.Client(protocol);
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

	/**
	 * @param args
	 * @throws TException
	 */
	public static void main(String[] args) throws TException {
		List<DeviceLocation> locs = buildLocas();
		startClient(locs);

	}

	private static List<DeviceLocation> buildLocas() {
		int n = 100;
		List<DeviceLocation> locs = new ArrayList<DeviceLocation>();
		long offset = System.currentTimeMillis() - n * 10000;
		for (int i = 0; i < n; i++) {
			DeviceLocation loc = new DeviceLocation();
			loc.setIMEI("imei002");
			loc.setTimestamp(offset + i * 10000);
			loc.setLocation(new Location((loc.getTimestamp() + 8D + i * 30) % 360 - 180,
					(loc.getTimestamp() + 7D + i * 40) % 360 - 180));
			locs.add(loc);
		}
		return locs;
	}
}
