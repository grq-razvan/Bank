package layers.presentation.windows.account;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import layers.logic.EmployeeOperations;
import layers.presentation.windows.Window;

public class CreateWindow extends Window {

	private JTextField accountID, clientID, accountType, accountMoney,
			accountCreationDate;

	private JButton add, clear;

	public CreateWindow() {
		accountID = new JTextField();
		clientID = new JTextField();
		accountType = new JTextField();
		accountMoney = new JTextField();
		accountCreationDate = new JTextField();
		add = new JButton("Add");
		clear = new JButton("Clear");
		JLabel accountIDLabel = new JLabel("Account ID: ");
		JLabel clientIDLabel = new JLabel("Client ID: ");
		JLabel accountTypeLabel = new JLabel("Account Type: ");
		JLabel accountMoneyLabel = new JLabel("Account Money: ");
		JLabel accountCreationDateLabel = new JLabel(
				"Account\n Creation Date: ");

		accountIDLabel.setBounds(40, 60, 130, 30);
		clientIDLabel.setBounds(40, 95, 130, 30);
		accountTypeLabel.setBounds(40, 130, 130, 30);
		accountMoneyLabel.setBounds(40, 165, 130, 30);
		accountCreationDateLabel.setBounds(40, 200, 150, 30);

		accountIDLabel.setForeground(Color.BLACK);
		clientIDLabel.setForeground(Color.black);
		accountTypeLabel.setForeground(Color.black);
		accountMoneyLabel.setForeground(Color.black);
		accountCreationDateLabel.setForeground(Color.black);

		accountID.setBounds(200, 60, 150, 30);
		clientID.setBounds(200, 95, 150, 30);
		accountType.setBounds(200, 130, 150, 30);
		accountMoney.setBounds(200, 165, 150, 30);
		accountCreationDate.setBounds(200, 200, 150, 30);

		add.setBounds(120, 260, 70, 30);
		clear.setBounds(200, 260, 70, 30);

		addListeners();

		panel.add(accountID);
		panel.add(accountIDLabel);
		panel.add(clientID);
		panel.add(clientIDLabel);
		panel.add(accountType);
		panel.add(accountTypeLabel);
		panel.add(accountMoney);
		panel.add(accountMoneyLabel);
		panel.add(accountCreationDate);
		panel.add(accountCreationDateLabel);
		panel.add(add);
		panel.add(clear);
	}

	@Override
	protected void addListeners() {
		// TODO Auto-generated method stub
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EmployeeOperations.addAccount(accountID.getText(),
						clientID.getText(), accountType.getText(),
						accountMoney.getText(), accountCreationDate.getText());
				JOptionPane.showMessageDialog(null, "Account added.");
			}
		});

		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				accountID.setText("");
				clientID.setText("");
				accountType.setText("");
				accountMoney.setText("");
				accountCreationDate.setText("");
			}
		});
	}

	public JTextField getAccountID() {
		return accountID;
	}

	public void setAccountID(JTextField accountID) {
		this.accountID = accountID;
	}

	public JTextField getClientID() {
		return clientID;
	}

	public void setClientID(JTextField clientID) {
		this.clientID = clientID;
	}

	public JTextField getAccountType() {
		return accountType;
	}

	public void setAccountType(JTextField accountType) {
		this.accountType = accountType;
	}

	public JTextField getAccountMoney() {
		return accountMoney;
	}

	public void setAccountMoney(JTextField accountMoney) {
		this.accountMoney = accountMoney;
	}

	public JTextField getAccountCreationDate() {
		return accountCreationDate;
	}

	public void setAccountCreationDate(JTextField accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}

	public JButton getAdd() {
		return add;
	}

	public void setAdd(JButton add) {
		this.add = add;
	}

	public JButton getClear() {
		return clear;
	}

	public void setClear(JButton clear) {
		this.clear = clear;
	}

}
