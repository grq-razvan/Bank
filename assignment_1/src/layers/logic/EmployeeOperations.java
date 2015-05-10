package layers.logic;

import java.sql.Date;

import layers.data.AccountMapper;
import layers.model.Account;
import layers.model.Client;

public class EmployeeOperations {

	public static void addClient(String id, String name, String address) {
		Client newClient = new Client(id, name, address);
		newClient.getData().insert();
	}

	public static void addAccount(String id, String clientID, String type,
			String money, String created) {
		Account newAccount = new Account(id, clientID, type,
				Double.parseDouble(money), Date.valueOf(created));
		AccountMapper mapper = new AccountMapper();
		mapper.insertAccount(newAccount);
		String info = LoggingHelper.logInfo(newAccount, LoggingHelper.CREATE);
		LoggingHelper.log(info);
	}

	public static void removeClient(String id) {
		Client client = new Client(id);
		client.getData().delete();
		Account clientAccount = AccountMapper.fetchByClientID(id);
		if (clientAccount != null) {
			AccountMapper mapper = new AccountMapper();
			mapper.deleteAccount(clientAccount);
			String info = LoggingHelper.logInfo(clientAccount,
					LoggingHelper.DELETE_CLIENT);
			LoggingHelper.log(info);
		}
	}

	public static void removeAccount(String id) {
		Account account = AccountMapper.fetchByAccountID(id);
		AccountMapper mapper = new AccountMapper();
		mapper.deleteAccount(account);
		String info = LoggingHelper.logInfo(account, LoggingHelper.DELETE);
		LoggingHelper.log(info);
	}

	public static void updateClient(String id, String name, String address) {
		Client client = new Client(id, name, address);
		client.getData().update();
		Account clientAccount = AccountMapper.fetchByClientID(id);
		if (clientAccount != null) {
			String info = LoggingHelper.logInfo(clientAccount,
					LoggingHelper.UPDATE_CLIENT);
			LoggingHelper.log(info);
		}
	}

	public static void updateAccount(String id, String clientID, String type,
			String amount, String creationDate) {
		Account account = new Account(id, clientID, type,
				Double.parseDouble(amount), Date.valueOf(creationDate));
		AccountMapper mapper = new AccountMapper();
		mapper.updateAccount(account);
		String info = LoggingHelper.logInfo(account, LoggingHelper.UPDATE);
		LoggingHelper.log(info);
	}

	public static void transact(String source, String destination, String amount) {
		Account sourceAccount = AccountMapper.fetchByAccountID(source);
		Account destAccount = AccountMapper.fetchByAccountID(destination);
		if (Double.parseDouble(amount) > sourceAccount.getAccountMoney()) {
			destAccount.setAccountMoney(destAccount.getAccountMoney()
					+ sourceAccount.getAccountMoney());
			sourceAccount.setAccountMoney(0.0);

		} else {
			sourceAccount.setAccountMoney(sourceAccount.getAccountMoney()
					- Double.parseDouble(amount));

			destAccount.setAccountMoney(destAccount.getAccountMoney()
					+ Double.parseDouble(amount));
		}

		AccountMapper mapper = new AccountMapper();
		mapper.updateAccount(sourceAccount);
		mapper.updateAccount(destAccount);
		String info = LoggingHelper.logInfo(sourceAccount, destAccount,
				Double.parseDouble(amount));
		LoggingHelper.log(info);

	}

	public static void payBills(String source, String amount) {
		Account temporary = AccountMapper.fetchByAccountID(source);
		temporary.setAccountMoney(temporary.getAccountMoney()
				- Double.parseDouble(amount));
		AccountMapper mapper = new AccountMapper();
		mapper.updateAccount(temporary);
		String info = LoggingHelper.logInfo(temporary, LoggingHelper.PAYMENT);
		LoggingHelper.log(info);

	}

	public static void viewAllAccounts() {

	}

	public static void viewAllClients() {

	}

	public static String viewClient(String id) {
		StringBuilder result = new StringBuilder();
		Client c = new Client(id);
		result.append("Client - ID: " + c.getClientID() + "\nNAME: "
				+ c.getClientName() + "\nADDRESS: " + c.getClientAddress());
		return result.toString();
	}

	public static String viewAccount(String id) {
		StringBuilder result = new StringBuilder();
		Account a = AccountMapper.fetchByAccountID(id);
		Client c = new Client(a.getClientSSID());
		result.append("Account - ID: " + a.getAccountID() + "\nTYPE: "
				+ a.getAccountType() + "\nMONEY: " + a.getAccountMoney()
				+ "\nOWNED BY: " + c.getClientName() + "\nCREATED ON: "
				+ a.getAccountCreationDate());
		return result.toString();
	}

}
