package com.g2sky.pgd.intf.thrift;

import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;

import com.g2sky.pgd.intf.thrift.commservice.CommService;
import com.g2sky.pgd.intf.thrift.commservice.CommService.Iface;
import com.g2sky.pgd.intf.thrift.impl.CommServiceImpl;

public class CommServer {
	private static final int serverPort = 8090;
	private static TServer tServer = null;

	private static AtomicBoolean started = new AtomicBoolean(false);

	private CommServer() {

	}

	public static void main(String[] args) throws Exception {
		startServer();
	}

	public static void startServer() throws Exception {
		// log.info("LocationServer Starting...");
		try {
			if (!started.getAndSet(true)) {
				getInstance().serve();// if failed?
			}
			// log.info("LocationServer Started.");
		} catch (Exception e) {
			e.printStackTrace();
			// log.error("LocationServer Start Failed!", e);
			started.set(false);
		}
	}

	public static void stopServer() throws Exception {
		if (started.getAndSet(false)) {
			getInstance().stop();// if failed?
		}
	}

	public static TServer getInstance() throws Exception {
		if (tServer == null) {
			synchronized (AppServer.class) {
				if (tServer == null) {
					TProcessor tprocessor = new CommService.Processor<Iface>(new CommServiceImpl());
					TServerSocket serverTransport = new TServerSocket(serverPort);
					TThreadPoolServer.Args ttpsArgs = new TThreadPoolServer.Args(serverTransport);
					ttpsArgs.processor(tprocessor);
					ttpsArgs.protocolFactory(new TBinaryProtocol.Factory());

					tServer = new TThreadPoolServer(ttpsArgs);
				}
			}
		}
		return tServer;
	}
}
