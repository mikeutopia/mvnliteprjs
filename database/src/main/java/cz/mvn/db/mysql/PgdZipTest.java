package cz.mvn.db.mysql;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cz.mvn.db.data.DeviceHistLoc;
import cz.mvn.db.util.ConnectionUtil;
import cz.mvn.db.util.QueryCbs;
import cz.mvn.db.util.QueryResult;

public class PgdZipTest {
	static long dayTime = 24 * 3600 * 1000;
	static Connection conn;

	public static void main(String[] args) throws Exception {
		try {
			conn = ConnectionUtil.getMysqlConnection();
			conn.setAutoCommit(false);

			java.sql.Statement dltAllSt = conn.createStatement();
			dltAllSt.execute("delete from pgd_DeviceHistLocZip");
			dltAllSt.close();
			Date day = new Date((System.currentTimeMillis() / dayTime - 2) * dayTime);
			List<String> dImeis = queryIemis(day);
			System.out.println(dImeis);
			int batchSize = 3;
			List<String> iemis = new ArrayList<String>(batchSize);
			for (String imei : dImeis) {
				iemis.add(imei);
				if (iemis.size() == batchSize) {
					batchZipOldDeviceHistLocDatas(day, iemis);
					iemis.clear();
				}
			}
			if (!iemis.isEmpty()) {
				batchZipOldDeviceHistLocDatas(day, iemis);
				iemis.clear();
			}
		} finally {
			conn.commit();
			conn.close();
		}
	}

	public static void batchZipOldDeviceHistLocDatas(Date recDay, List<String> imeis) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTime(recDay);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		String dayStr = (cal.get(Calendar.YEAR) * 10000 + cal.get(Calendar.MONTH) * 100 + 100 + cal
				.get(Calendar.DAY_OF_MONTH)) + "";

		Timestamp fromTime = new Timestamp(cal.getTimeInMillis());
		java.sql.Date dday = new java.sql.Date(cal.getTimeInMillis());
		cal.add(Calendar.DAY_OF_YEAR, 1);
		Timestamp toTime = new Timestamp(cal.getTimeInMillis());

		String qSql = "select e.* from pgd_DeviceHistLoc e where e.deviceImei=? and e.gpsTime>=? and e.gpsTime<? order by e.gpsTime desc  ";

		String insertSql = "INSERT INTO pgd_DeviceHistLocZip (dayKey,recDay,deviceImei,recData) VALUES(?,?,?,?)";
		String deleteSql = "DELETE FROM pgd_DeviceHistLoc where deviceImei=? and gpsTime<?";

		java.sql.PreparedStatement istStmt = null;
		java.sql.PreparedStatement dtlStmt = null;
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;
		try {
			dtlStmt = conn.prepareStatement(deleteSql);
			istStmt = conn.prepareStatement(insertSql);
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			for (String imei : imeis) {
				System.out.println(imei);
				List<DeviceHistLoc> locs = QueryResult.queryLocs(conn, qSql, QueryCbs.toDeviceHistLoc(), imei,
						fromTime, toTime);
				if (locs == null || locs.isEmpty()) {
					continue;
				}
				System.out.println("********" + imei);
				istStmt.setString(1, dayStr + imei);
				istStmt.setDate(2, dday);
				istStmt.setString(3, imei);
				baos.reset();
				oos.reset();
				oos.writeObject(locs);
				byte[] locsAsBytes = baos.toByteArray();
				// System.out.println(locsAsBytes.length / (8 * 1024));
				ByteArrayInputStream bais = new ByteArrayInputStream(locsAsBytes);
				istStmt.setBinaryStream(4, bais, locsAsBytes.length);
				istStmt.addBatch();

				dtlStmt.setString(1, imei);
				dtlStmt.setTimestamp(2, toTime);
				dtlStmt.addBatch();
			}
			istStmt.executeBatch();
			dtlStmt.executeBatch();
			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (baos != null) {
					baos.close();
				}
				if (oos != null) {
					oos.close();
				}
				if (istStmt != null) {
					istStmt.close();
				}
				if (dtlStmt != null) {
					dtlStmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
				// ignore
			}
		}
	}

	static List<String> queryIemis(Date day) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTime(day);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		Timestamp fromTime = new Timestamp(cal.getTimeInMillis());
		cal.add(Calendar.DAY_OF_YEAR, 1);
		Timestamp toTime = new Timestamp(cal.getTimeInMillis());

		String sql = "select distinct deviceImei from pgd_DeviceHistLoc where gpsTime>=? and gpsTime<? and historyOid<8";
		return QueryResult.queryLocs(conn, sql, QueryCbs.transToString("deviceImei"), fromTime, toTime);
	}
}
