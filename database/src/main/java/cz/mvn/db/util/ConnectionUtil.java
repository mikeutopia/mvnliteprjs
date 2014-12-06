package cz.mvn.db.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
	public static Connection getMysqlConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String dbUrl = "jdbc:mysql://localhost:3306/pgy";
		String uname = "sky";
		String passwd = "sky";
		return DriverManager.getConnection(dbUrl, uname, passwd);
	}
}
