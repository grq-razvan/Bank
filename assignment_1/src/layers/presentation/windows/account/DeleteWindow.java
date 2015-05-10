package layers.presentation.windows.account;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import layers.logic.EmployeeOperations;
import layers.presentation.windows.Window;

public class DeleteWindow extends Window {

	private JTextField accountID;
	private JButton delete, clear;

	public DeleteWindow() {
		accountID = new JTextField();
		JLabel idLabel = new JLabel("Account ID: ");
		delete = new JButton("Delete");
		clear = new JButton("Clear");

		idLabel.setBounds(40, 60, 130, 30);
		accountID.setBounds(180, 60, 140, 30);
		idLabel.setForeground(Color.black);
		delete.setBounds(120, 95, 70, 30);
		clear.setBounds(200, 95, 70, 30);

		addListeners();

		panel.add(accountID);
		panel.add(delete);
		panel.add(clear);
		panel.add(idLabel);

	}

	@Override
	protected void addListeners() {
		// TODO Auto-generated method stub
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EmployeeOperations.removeAccount(accountID.getText());
			}
		});
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				accountID.setText("");
			}
		});
	}

	public JTextField getAccountID() {
		return accountID;
	}

	public void setAccountID(JTextField accountID) {
		this.accountID = accountID;
	}

	public JButton getDelete() {
		return delete;
	}

	public void setDelete(JButton delete) {
		this.delete = delete;
	}

	public JButton getClear() {
		return clear;
	}

	public void setClear(JButton clear) {
		this.clear = clear;
	}

}
