package layers.logic;

import java.util.HashMap;
import java.util.Map;

import layers.model.Account;
import layers.model.Employee;

public class LoggingHelper {
	public static final int CREATE = 0;
	public static final int UPDATE = 1;
	public static final int DELETE = 2;
	public static final int PAYMENT = 3;
	public static final int DELETE_CLIENT = 4;
	public static final int UPDATE_CLIENT = 5;
	public static final int CREATE_CLIENT = 6;

	private static Map<Integer, String> log = new HashMap<Integer, String>();;

	public LoggingHelper() {

	}

	public static void log(String info) {
		Employee currentUser = LoginUserRetriever.getEmployee();
		String content = log.get(currentUser.getEmployeeID());
		if (content == null) {
			log.put(currentUser.getEmployeeID(), info);
		} else {
			log.put(currentUser.getEmployeeID(), content.concat(info));
		}
	}

	public static String logInfo(Account account, int action) {
		StringBuilder info = new StringBuilder();
		info.append(account.getAccountCreationDate()).append(" : ")
				.append("Account ").append(account.getAccountID() + " ");
		switch (action) {
		case CREATE:
			info.append("was created.\n");
			break;
		case DELETE:
			info.append("was deleted.\n");
			break;
		case UPDATE:
			info.append("was updated.\n");
			break;
		case PAYMENT:
			info.append("has payed bills.\n");
			break;
		case DELETE_CLIENT:
			info.append("was deleted due to deletion of client "
					+ account.getClientSSID() + ".\n");
			break;
		case UPDATE_CLIENT:
			info.append("was updated due to update of client "
					+ account.getClientSSID() + " .\n");
			break;
		case CREATE_CLIENT:
			break;
		}
		return info.toString();
	}

	public static String logInfo(Account account, Account otherAccount,
			double amount) {
		StringBuilder info = new StringBuilder();
		info.append(account.getAccountCreationDate()).append(" : ")
				.append("Account ").append(account.getAccountID() + " ")
				.append("payed " + amount + " currency")
				.append("to Account " + otherAccount.getAccountID() + "\n");
		return info.toString();

	}

	public static String getLogOfEmployeeByDate(Employee e, String from,
			String to) {
		return log.get(e.getEmployeeID()).substring(
				log.get(e.getEmployeeID()).indexOf(from),
				log.get(e.getEmployeeID()).lastIndexOf(to));
	}

	public static String getMasterLogOfEmployee(Employee e) {
		return log.get(e.getEmployeeID());
	}

	public static Map<Integer, String> getLog() {
		return log;
	}

}
