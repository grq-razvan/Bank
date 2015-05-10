package layers.data;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import layers.model.Account;

public class AccountMapper {

	private AccountGateway accountTableGateway;
	private static final String ID = "accountID";
	private static final String SSID = "clientSSID";
	private static final String TYPE = "accountType";
	private static final String MONEY = "accountMoney";
	private static final String DATE = "accountCreationDate";

	public AccountMapper() {
		super();
		this.accountTableGateway = new AccountGateway();
	}

	public synchronized static Account fetchByAccountID(String accountID) {
		ResultSet accounts = null;
		try {
			accounts = AccountGateway.fetchAccountsByID(accountID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (accounts.next()) {
				String account = accounts.getString(ID);
				String clientSSID = accounts.getString(SSID);
				String accountType = accounts.getString(TYPE);
				Double accountMoney = accounts.getDouble(MONEY);
				Date accountCreation = accounts.getDate(DATE);
				return new Account(account, clientSSID, accountType,
						accountMoney, accountCreation);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public synchronized static Account fetchByClientID(String clientID) {
		ResultSet accounts = null;
		try {
			accounts = AccountGateway.fetchAccountsByClientID(clientID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (accounts.next()) {
				String account = accounts.getString(ID);
				String clientSSID = accounts.getString(SSID);
				String accountType = accounts.getString(TYPE);
				Double accountMoney = accounts.getDouble(MONEY);
				Date accountCreation = accounts.getDate(DATE);
				return new Account(account, clientSSID, accountType,
						accountMoney, accountCreation);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public synchronized void updateAccount(Account account) {

		try {
			accountTableGateway
					.update(account.getAccountID(), account.getClientSSID(),
							account.getAccountType(),
							account.getAccountMoney(),
							account.getAccountCreationDate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void deleteAccount(Account account) {
		try {
			accountTableGateway.delete(account.getAccountID());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void insertAccount(Account account) {
		try {
			accountTableGateway
					.insert(account.getAccountID(), account.getClientSSID(),
							account.getAccountType(),
							account.getAccountMoney(),
							account.getAccountCreationDate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public AccountGateway getAccountTableGateway() {
		return accountTableGateway;
	}

}
