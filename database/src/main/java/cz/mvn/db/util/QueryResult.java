package cz.mvn.db.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QueryResult {
	public static <T> List<T> queryLocs(Connection conn, String sql, QueryCb<T> qcb, Object... params) throws Exception {
		java.sql.PreparedStatement statement = conn.prepareStatement(sql);
		setParams(statement, params);
		ResultSet resultSet = statement.executeQuery();
		// printColumnNames(resultSet);
		List<T> rtnList = new ArrayList<T>();
		while (resultSet.next()) {
			rtnList.add(qcb.dataToObj(resultSet));
		}
		resultSet.close();
		statement.close();
		return rtnList;
	}

	private static void printColumnNames(ResultSet resultSet) throws SQLException {
		java.sql.ResultSetMetaData md = resultSet.getMetaData();
		for (int i = 0; i < md.getColumnCount() - 1; i++) {
			System.out.println(md.getColumnClassName(i));
		}

	}

	private static void setParams(PreparedStatement statement, Object... params) throws SQLException {
		if (params == null || params.length == 0) {
			return;
		}
		int i = 0;
		for (Object obj : params) {
			i = i + 1;
			if (obj instanceof String) {
				statement.setString(i, obj.toString());
			} else if (obj instanceof Integer) {
				statement.setInt(i, (Integer) obj);
			} else if (obj instanceof Long) {
				statement.setLong(i, (Long) obj);
			} else if (obj instanceof Float) {
				statement.setFloat(1, (Float) obj);
			} else if (obj instanceof Double) {
				statement.setDouble(i, (Double) obj);
			} else if (obj instanceof Date) {
				long time = ((Date) obj).getTime();
				statement.setDate(i, new java.sql.Date(time));
			} else if (obj instanceof Timestamp) {
				statement.setTimestamp(i, (Timestamp) obj);
			}
		}
	}
}
