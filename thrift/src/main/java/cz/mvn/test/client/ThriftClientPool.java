package cz.mvn.test.client;

import org.apache.commons.pool2.impl.GenericObjectPool;

import com.g2sky.pgd.intf.thrift.appservice.AppService;

public class ThriftClientPool {
	private static ThriftClientPool instance = new ThriftClientPool();
	private final GenericObjectPool<AppService.Client> pool;

	private ThriftClientPool() {
		pool = new GenericObjectPool<AppService.Client>(new ThriftPoolableObjectFactory());
		pool.setMaxTotal(10);
		// TODO configurations
	}

	private static ThriftClientPool getInstance() {
		return instance;
	}

	public static AppService.Client getClinet() throws Exception {
		return getInstance().pool.borrowObject();
	}

}
