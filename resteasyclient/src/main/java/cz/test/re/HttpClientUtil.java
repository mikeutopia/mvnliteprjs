package cz.test.re;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.engines.ApacheHttpClient4Engine;

public class HttpClientUtil {
	public static enum ReqMethod {
		GET, PUT, POST, DELETE
	}

	private static MediaType jsonMt = MediaType.APPLICATION_JSON_TYPE;
	private static Client client;
	private static Map<String, WebTarget> webTargetMap = new ConcurrentHashMap<String, WebTarget>();

	private static WebTarget getWebTarget(String url) {
		WebTarget target = webTargetMap.get(url);
		if (target == null) {
			synchronized (HttpClientUtil.class) {
				if (client == null) {
					client = initThreadSafeClient();
				}
				target = client.target(url);
				webTargetMap.put(url, target);
			}
		}
		return target;
	}

	private static synchronized Client initThreadSafeClient() {
		PoolingClientConnectionManager cm = new PoolingClientConnectionManager();
		HttpClient httpClient = new DefaultHttpClient(cm);
		ApacheHttpClient4Engine engine = new ApacheHttpClient4Engine(httpClient);
		return new ResteasyClientBuilder().httpEngine(engine).build();
	}

	public static <S> String sendJsonReq(JsonReq<S> req) {
		WebTarget target = getWebTarget(req.getAppUrl()).path(req.getUrlPath());
		javax.ws.rs.client.Invocation.Builder builder = target.request(jsonMt).accept(jsonMt);
		String resp = null;
		switch (req.getReqMethod()) {
		case GET:
			resp = builder.get(String.class);
			break;
		case PUT:
			resp = builder.put(Entity.entity(req.getJsonObj(), jsonMt), String.class);
			break;
		case POST:
			resp = builder.post(Entity.entity(req.getJsonObj(), jsonMt), String.class);
			break;
		case DELETE:
			resp = builder.delete(String.class);
			break;
		}
		return resp;
	}
}
