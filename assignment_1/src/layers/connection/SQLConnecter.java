package layers.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class serves as my first layer of my N-Tier architecture; it is used to
 * communicate with the database;
 * 
 * @author rzvn
 *
 */
public class SQLConnecter {

	private static final String URL = "jdbc:mysql://localhost/assig1";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "";
	private static Connection connection;

	/**
	 * Method used to connect to a database given by the constants
	 * <<URL>>,<<USER_NAME>> and <<PASSWORD>>
	 * 
	 * @return the connecton to the database
	 */
	public static void connect() {
		connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			System.err
					.println("An Exception occured during JDBC Driver loading."
							+ " Details are provided below:");
			ex.printStackTrace(System.err);
		}
		try {
			connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("connect-r");
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public static Connection getConnection() {
		connect();
		return connection;

	}

}
