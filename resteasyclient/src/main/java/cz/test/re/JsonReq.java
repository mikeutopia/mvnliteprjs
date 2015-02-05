package cz.test.re;

import cz.test.re.HttpClientUtil.ReqMethod;

public class JsonReq<S> {
	private String appUrl = "http://127.0.0.1:8080/";
	private String urlPath;
	private ReqMethod reqMethod;
	private S jsonObj;

	public JsonReq(String appUrl, String urlPath, ReqMethod reqMethod) {
		super();
		this.appUrl = appUrl;
		this.urlPath = urlPath;
		this.reqMethod = reqMethod;
	}

	public JsonReq(String urlPath, ReqMethod reqMethod) {
		super();
		this.urlPath = urlPath;
		this.reqMethod = reqMethod;
	}

	public JsonReq() {
		// TODO Auto-generated constructor stub
	}

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}

	public ReqMethod getReqMethod() {
		return reqMethod;
	}

	public void setReqMethod(ReqMethod reqMethod) {
		this.reqMethod = reqMethod;
	}

	public S getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(S jsonObj) {
		this.jsonObj = jsonObj;
	}

}
