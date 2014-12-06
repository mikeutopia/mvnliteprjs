package cz.mvn.db.mysql;

import java.sql.Connection;

import cz.mvn.db.util.ConnectionUtil;

public class TestBatch {

	static Connection conn;

	public static void main(String[] args) throws Exception {
		String insertSql = "INSERT INTO pgd_DeviceHistLocZip (dayKey,recDay,deviceImei) VALUES(?,?,?)";
		conn = ConnectionUtil.getMysqlConnection();
		java.sql.PreparedStatement istStmt = null;
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		try {
			istStmt = conn.prepareStatement(insertSql);
			for (int i = 0; i < 10; i++) {
				istStmt.setString(1, "key000" + i);
				istStmt.setDate(2, date);
				istStmt.setString(3, "imei--" + i);
				istStmt.addBatch();
			}
			istStmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (istStmt != null) {
				istStmt.close();
			}
			conn.close();
		}

	}
}
