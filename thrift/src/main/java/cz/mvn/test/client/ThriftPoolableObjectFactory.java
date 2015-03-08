package cz.mvn.test.client;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import com.g2sky.pgd.intf.test.ThriftUtils;
import com.g2sky.pgd.intf.thrift.appservice.AppService;

public class ThriftPoolableObjectFactory implements PooledObjectFactory<AppService.Client> {
	public ThriftPoolableObjectFactory() {
	}

	@Override
	public PooledObject<AppService.Client> makeObject() throws Exception {
		TTransport transport = null;
		try {
			transport = new TSocket(ThriftUtils.APP_SVR_IP, ThriftUtils.APP_SVR_PORT, ThriftUtils.CLENT_TIMEOUT);
			TProtocol protocol = new TBinaryProtocol(transport);
			AppService.Client client = new AppService.Client(protocol);
			transport.open();
			return new DefaultPooledObject<AppService.Client>(client);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void destroyObject(PooledObject<AppService.Client> p) throws Exception {
		try {
			p.getObject().getOutputProtocol().getTransport().close();
		} catch (Exception e) {
			e.printStackTrace();
			// ignore
		}
	}

	@Override
	public boolean validateObject(PooledObject<AppService.Client> p) {
		return p.getObject().getOutputProtocol().getTransport().isOpen();
	}

	@Override
	public void activateObject(PooledObject<AppService.Client> p) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void passivateObject(PooledObject<AppService.Client> p) throws Exception {
		// TODO Auto-generated method stub
	}
}
