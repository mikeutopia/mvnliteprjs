package com.g2sky.pgd.intf.thrift;

import org.apache.thrift.server.TServer;

public class ThriftServerStatusTest {
	public static void main(String[] args) throws Exception {
		final TServer server = LocationServer.getInstance();
		System.out.println("aaaaaaaaaaaaaaaaaa");
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("start server...");
				server.serve();
			}
		}).start();

		System.out.println("start stopp...");
		long starTime = System.currentTimeMillis();
		server.stop();

		System.out.println("stop success. time=" + (System.currentTimeMillis() - starTime));
	}
}
