package resource.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ResourceManager {

	private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final static String JDBC_URL = "jdbc:mysql://localhost:3306/slimsoft";
	private final static String JDBC_USER = "root";
	private final static String JDBC_PASS = "1234";

	private static ResourceManager instance;
	private Connection conn;

	private ResourceManager() {
		try {
			if (conn == null) {
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ResourceManager getInstance() {
		if (instance == null) {
			instance = new ResourceManager();
		}

		return instance;
	}

	public Connection getConnection() {
		return conn;
	}
}
