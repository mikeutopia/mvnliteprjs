package cz.test.re.pgd;

import cz.test.re.HttpClientUtil.ReqMethod;
import cz.test.re.JsonReq;

public class PgdConst {
	public static final String APP_URL = "http://127.0.0.1:6500/pgdiweb/";

	public static <T> JsonReq<T> getJsonReq(String path, ReqMethod method) {
		JsonReq<T> jr = new JsonReq<T>(path, method);
		jr.setAppUrl(APP_URL);
		return jr;
	}
}
