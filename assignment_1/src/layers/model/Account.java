package layers.model;

import java.sql.Date;

public class Account {

	private String accountID, clientSSID, accountType;
	private Double accountMoney;
	private Date accountCreationDate;

	public Account(String accountID, String clientSSID, String accountType,
			Double accountMoney, Date accountCreationDate) {
		super();
		this.accountID = accountID;
		this.clientSSID = clientSSID;
		this.accountType = accountType;
		this.accountMoney = accountMoney;
		this.accountCreationDate = accountCreationDate;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getClientSSID() {
		return clientSSID;
	}

	public void setClientSSID(String clientSSID) {
		this.clientSSID = clientSSID;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getAccountMoney() {
		return accountMoney;
	}

	public void setAccountMoney(Double accountMoney) {
		this.accountMoney = accountMoney;
	}

	public Date getAccountCreationDate() {
		return accountCreationDate;
	}

	public void setAccountCreationDate(Date accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", clientSSID=" + clientSSID
				+ ", accountType=" + accountType + ", accountMoney="
				+ accountMoney + ", accountCreationDate=" + accountCreationDate
				+ "]";
	}

}
