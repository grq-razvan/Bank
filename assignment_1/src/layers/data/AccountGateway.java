package layers.data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import layers.connection.SQLConnecter;

public class AccountGateway {

	private static final String DELETE_ACCOUNT = "DELETE FROM account WHERE accountID=?";
	private static final String FIND_BY_ACCOUNT_ID = "SELECT * FROM account WHERE accountID=?";
	private static final String FIND_ALL_ACCOUNTS = "SELECT * FROM account";
	private static final String FIND_BY_CLIENT_ID = "SELECT * FROM account WHERE clientSSID=?";
	private static final String UPDATE_BY_ACCOUNT_ID = "UPDATE account SET clientSSID=?,accountType=?,accountMoney=?,accountCreationDate=? WHERE accountID=?";
	private static final String INSERT_ACCOUNT = "INSERT INTO account(accountID,clientSSID,accountType,accountMoney,accountCreationDate) VALUES (?,?,?,?,?)";

	public static synchronized ResultSet fetchAccountsByID(String accountID)
			throws SQLException {
		PreparedStatement statement = SQLConnecter.getConnection()
				.prepareStatement(FIND_BY_ACCOUNT_ID);
		statement.setString(1, accountID);
		return (ResultSet) statement.executeQuery();
	}

	public synchronized ResultSet fetchAccounts() throws SQLException {
		PreparedStatement statement = SQLConnecter.getConnection()
				.prepareStatement(FIND_ALL_ACCOUNTS);
		return (ResultSet) statement.executeQuery();
	}

	public static synchronized ResultSet fetchAccountsByClientID(String clientID)
			throws SQLException {
		PreparedStatement statement = SQLConnecter.getConnection()
				.prepareStatement(FIND_BY_CLIENT_ID);
		statement.setString(1, clientID);
		return (ResultSet) statement.executeQuery();
	}

	public synchronized void update(String accountID, String clientSSID,
			String accountType, Double accountMoney, Date accountCreationDate)
			throws SQLException {
		PreparedStatement statement = SQLConnecter.getConnection()
				.prepareStatement(UPDATE_BY_ACCOUNT_ID);
		statement.setString(1, clientSSID);
		statement.setString(2, accountType);
		statement.setDouble(3, accountMoney.doubleValue());
		statement.setDate(4, accountCreationDate);
		statement.setString(5, accountID);
		statement.executeUpdate();

	}

	public synchronized void insert(String accountID, String clientSSID,
			String accountType, Double accountMoney, Date accountCreationDate)
			throws SQLException {
		PreparedStatement statement = SQLConnecter.getConnection()
				.prepareStatement(INSERT_ACCOUNT);
		statement.setString(1, accountID);
		statement.setString(2, clientSSID);
		statement.setString(3, accountType);
		statement.setDouble(4, accountMoney.doubleValue());
		statement.setDate(5, accountCreationDate);
		statement.executeUpdate();
	}

	public synchronized void delete(String accountID) throws SQLException {
		PreparedStatement statement = SQLConnecter.getConnection()
				.prepareStatement(DELETE_ACCOUNT);
		statement.setString(1, accountID);
		statement.executeUpdate();

	}

}
