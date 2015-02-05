package cz.test.re.pgd;

import cz.test.re.HttpClientUtil;
import cz.test.re.HttpClientUtil.ReqMethod;
import cz.test.re.JsonReq;
import cz.test.re.pgd.data.CmdReq;

public class TestRscTest {

	public static void main(String[] args) {
		String resp = null;
		resp = HttpClientUtil.sendJsonReq(PgdConst.getJsonReq("api/test/get", ReqMethod.GET));
		// System.out.println(resp);
		for (int i = 0; i < 10; i++) {
			final int k = i;
			new Thread() {
				@Override
				public void run() {
					JsonReq<CmdReq> jr = PgdConst.getJsonReq("api/cmd/issue", ReqMethod.POST);
					CmdReq req = new CmdReq();
					req.setImei("imei-" + k);
					req.setMaxDelay(k * 1000);
					req.setCmd("alals" + k);
					jr.setJsonObj(req);
					String resp = HttpClientUtil.sendJsonReq(jr);
					System.out.println(resp);
				}
			}.start();
		}
	}
}
