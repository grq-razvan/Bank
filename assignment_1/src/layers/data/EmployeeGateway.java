package layers.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import layers.connection.SQLConnecter;

public class EmployeeGateway {

	private static final String FIND_BY_ID = "SELECT * FROM employee WHERE employeeID=?";
	private static final String FIND_ALL = "SELECT * FROM employee";
	private static final String FIND_BY_CREDENTIALS = "SELECT * FROM employee WHERE username=? and password=?";
	private static final String UPDATE = "UPDATE employee SET name=?,address=?,admin=?,username=?,password=? WHERE employeeID=?";
	private static final String INSERT = "INSERT INTO employee(employeeID,name,address,admin,username,password) VALUES (?,?,?,?,?,?)";
	private static final String DELETE = "DELETE FROM employee WHERE employeeID=?";

	public static synchronized ResultSet fetchEmployeesByID(Integer employeeID)
			throws SQLException {

		PreparedStatement statement = SQLConnecter.getConnection()
				.prepareStatement(FIND_BY_ID);
		statement.setInt(1, employeeID);
		return (ResultSet) statement.executeQuery();
	}

	public synchronized ResultSet fetchEmployees() throws SQLException {

		PreparedStatement statement = SQLConnecter.getConnection()
				.prepareStatement(FIND_ALL);
		return (ResultSet) statement.executeQuery();
	}

	public static synchronized ResultSet fetchEmployeeByCredentials(
			String username, String password) {

		PreparedStatement statement = null;
		try {
			statement = SQLConnecter.getConnection().prepareStatement(
					FIND_BY_CREDENTIALS);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();

			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public synchronized void update(Integer employeeID, String employeeName,
			String employeeAddress, String employeeUsername,
			String employeePassword, boolean isAdmin) throws SQLException {

		PreparedStatement statement = SQLConnecter.getConnection()
				.prepareStatement(UPDATE);
		statement.setString(1, employeeName);
		statement.setString(2, employeeAddress);
		statement.setBoolean(3, isAdmin);
		statement.setString(4, employeeUsername);
		statement.setString(5, employeePassword);
		statement.setInt(6, employeeID);
		statement.executeUpdate();

	}

	public synchronized void insert(Integer employeeID, String employeeName,
			String employeeAddress, boolean isAdmin, String employeeUsername,
			String employeePassword) throws SQLException {

		PreparedStatement statement = SQLConnecter.getConnection()
				.prepareStatement(INSERT);
		statement.setInt(1, employeeID);
		statement.setString(2, employeeName);
		statement.setString(3, employeeAddress);
		statement.setBoolean(4, isAdmin);
		statement.setString(5, employeeUsername);
		statement.setString(6, employeePassword);
		statement.executeUpdate();
	}

	public synchronized void delete(Integer employeeID) throws SQLException {

		PreparedStatement statement = SQLConnecter.getConnection()
				.prepareStatement(DELETE);
		statement.setInt(1, employeeID);
		statement.executeUpdate();

	}

}
