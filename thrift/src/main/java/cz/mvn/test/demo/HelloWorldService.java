package cz.mvn.test.demo;

import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TNonblockingTransport;

import cz.mvn.test.demo.client.TNonblockingClientDemo2.AsynCallback;

public class HelloWorldService {

	public static class sayHello_call {

		public Object getResult() {
			// TODO Auto-generated method stub
			return null;
		}

	}

	public static class AsyncClient {

		public AsyncClient(TProtocolFactory tprotocol, TAsyncClientManager clientManager,
				TNonblockingTransport transport) {
			// TODO Auto-generated constructor stub
		}

		public void sayHello(String userName, AsynCallback callBack) {
			// TODO Auto-generated method stub

		}

	}

	public interface Iface {

	}

	public static class Processor<T> implements TProcessor {

		public Processor(HelloWorldImpl helloWorldImpl) {
			// TODO Auto-generated constructor stub
		}

		@Override
		public boolean process(TProtocol arg0, TProtocol arg1) throws TException {
			// TODO Auto-generated method stub
			return false;
		}

	}

	public static class Client {

		public Client(TProtocol protocol) {
			// TODO Auto-generated constructor stub
		}

		public String sayHello(String userName) {
			// TODO Auto-generated method stub
			return null;
		}

	}

}
