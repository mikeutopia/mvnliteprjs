package cz.mvn.db.mysql;

import java.io.ObjectInputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import cz.mvn.db.data.DeviceHistLoc;
import cz.mvn.db.util.ConnectionUtil;

public class DeseriesTest {
	static Connection conn;
	static String dayImei = "20141209imei10000000089";

	public static void main(String[] args) throws Exception {
		try {
			conn = ConnectionUtil.getMysqlConnection();
			conn.setAutoCommit(false);
			deseriesTest();
		} finally {
			conn.commit();
			conn.close();
		}
	}

	@SuppressWarnings("unchecked")
	static void deseriesTest() {
		java.sql.PreparedStatement queryStmt = null;
		java.sql.ResultSet rs = null;
		try {
			queryStmt = conn.prepareStatement("select recData from pgd_DeviceHistLocZip  where dayImei=? ");
			queryStmt.setString(1, dayImei);
			rs = queryStmt.executeQuery();
			List<DeviceHistLoc> list = null;
			if (rs.next()) {
				ObjectInputStream oips = new ObjectInputStream(rs.getBinaryStream("recData"));
				list = (ArrayList<DeviceHistLoc>) oips.readObject();
				System.out.println(list);
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (queryStmt != null) {
					queryStmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace(); // ignore
			}
		}

	}

}
