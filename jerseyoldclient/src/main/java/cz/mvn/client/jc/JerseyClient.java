package cz.mvn.client.jc;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class JerseyClient {
	public static void main(String[] args) {
		final Client c = Client.create();
		WebResource r = c.resource("http://127.0.0.1:8080/test/hello");
		String resStr = r.accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
		System.out.println(resStr);
		try {
			for (int i = 0; i < 20; i++) {
				final int k = i;
				new Thread() {
					@Override
					public void run() {
						WebResource r = c.resource("http://127.0.0.1:8080/test/hello");
						String resStr = r.accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
						System.out.println(k + ":  " + resStr);
					};
				}.start();

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
