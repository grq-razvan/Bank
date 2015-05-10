package layers.presentation.windows.services;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import layers.logic.EmployeeOperations;
import layers.presentation.windows.Window;

public class PaymentWindow extends Window {

	private JTextField id, amount;
	private JLabel amountLabel;
	private JButton clear, pay;

	public PaymentWindow() {
		// TODO Auto-generated constructor stub
		amount = new JTextField();
		id = new JTextField();
		amountLabel = new JLabel();
		JLabel idLabel = new JLabel("Account ID: ");
		pay = new JButton("Pay");
		clear = new JButton("Clear");

		amountLabel.setBounds(340, 65, 300, 75);
		idLabel.setBounds(40, 60, 130, 30);
		id.setBounds(130, 60, 140, 30);
		idLabel.setForeground(Color.black);
		amount.setBounds(130, 95, 140, 30);
		JLabel amountLabelSmall = new JLabel("Amount: ");
		amountLabelSmall.setBounds(40, 95, 130, 30);
		amountLabelSmall.setForeground(Color.black);

		pay.setBounds(80, 150, 70, 30);
		clear.setBounds(160, 150, 70, 30);

		addListeners();

		panel.add(pay);
		panel.add(clear);
		panel.add(id);
		panel.add(idLabel);
		panel.add(amount);
		panel.add(amountLabel);
		panel.add(amountLabelSmall);
	}

	@Override
	protected void addListeners() {
		// TODO Auto-generated method stub
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				amount.setText("");
				id.setText("");
				amountLabel.setText("");
			}
		});

		pay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				amountLabel.setText("<html><font size=6> Last payment: "
						+ amount.getText() + " M.U.</font></html>");
				amountLabel.setForeground(Color.black);
				EmployeeOperations.payBills(id.getText(), amount.getText());
				JOptionPane.showMessageDialog(null, "Payment successful!");
			}
		});

	}

	public JTextField getId() {
		return id;
	}

	public void setId(JTextField id) {
		this.id = id;
	}

	public JTextField getAmount() {
		return amount;
	}

	public void setAmount(JTextField amount) {
		this.amount = amount;
	}

	public JLabel getAmountLabel() {
		return amountLabel;
	}

	public void setAmountLabel(JLabel amountLabel) {
		this.amountLabel = amountLabel;
	}

	public JButton getClear() {
		return clear;
	}

	public void setClear(JButton clear) {
		this.clear = clear;
	}

	public JButton getPay() {
		return pay;
	}

	public void setPay(JButton pay) {
		this.pay = pay;
	}

}
