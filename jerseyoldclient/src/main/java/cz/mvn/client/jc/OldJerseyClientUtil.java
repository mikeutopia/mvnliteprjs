package cz.mvn.client.jc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class OldJerseyClientUtil {

	private static MediaType jsonMt = MediaType.APPLICATION_JSON_TYPE;

	private static Client client = null;

	private static Map<String, WebResource> webResourceMap = new ConcurrentHashMap<String, WebResource>();

	public static <S> String sendJsonReq(JsonReq<S> req) {
		String url = req.getAppUrl() + req.getUrlPath();
		WebResource rsc = webResourceMap.get(url);
		if (rsc == null) {
			synchronized (OldJerseyClientUtil.class) {
				if (rsc == null) {
					rsc = getClient().resource(url);
					webResourceMap.put(url, rsc);
				}
			}
		}
		Builder builder = rsc.accept(jsonMt).type(jsonMt);
		String resp = null;
		switch (req.getReqMethod()) {
		case GET:
			resp = builder.get(String.class);
			break;
		case PUT:
			resp = builder.put(String.class, req);
			break;
		case POST:
			resp = builder.post(String.class, req);
			break;
		case DELETE:
			resp = builder.delete(String.class);
			break;
		}
		return resp;
	}

	private static synchronized Client getClient() {
		if (client == null) {
			synchronized (OldJerseyClientUtil.class) {
				if (client == null) {
					ClientConfig cc = new DefaultClientConfig();
					cc.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
					client = Client.create(cc);
				}
			}
		}
		return client;
	}

}
