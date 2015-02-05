package cz.mvn.client.jc;

import cz.mvn.client.jc.JsonReq.ReqMethod;
import cz.mvn.client.jc.data.TestVo;

public class TestRscTest {
	private static final String appUrl = "http://127.0.0.1:8080/";

	public static void main(String[] args) {
		String resp = null;
		resp = OldJerseyClientUtil.sendJsonReq(new JsonReq<String>(appUrl, "test/get", ReqMethod.GET));
		System.out.println(resp);
		JsonReq<TestVo> jr = new JsonReq<TestVo>(appUrl, "test/post", ReqMethod.POST);
		jr.setJsonObj(new TestVo("aaa", "bbb"));
		resp = OldJerseyClientUtil.sendJsonReq(jr);
		System.out.println(resp);
	}
}
