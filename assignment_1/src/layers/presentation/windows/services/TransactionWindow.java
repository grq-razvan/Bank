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

public class TransactionWindow extends Window {

	private JTextField source, destination, amount;
	private JButton transact, clear;
	private JLabel amountLabel;

	public TransactionWindow() {
		// TODO Auto-generated constructor stub
		source = new JTextField();
		destination = new JTextField();
		amount = new JTextField();
		amountLabel = new JLabel();
		JLabel sourceLabel = new JLabel("Source Account ID: ");
		JLabel destinationLabel = new JLabel("Destination Account ID: ");
		JLabel amountLabelSmall = new JLabel("Amount");
		transact = new JButton("Send");
		clear = new JButton("Clear");

		sourceLabel.setBounds(40, 60, 170, 30);
		destinationLabel.setBounds(40, 95, 170, 30);
		amountLabelSmall.setBounds(365, 60, 90, 30);
		source.setBounds(200, 60, 130, 30);
		destination.setBounds(200, 95, 130, 30);
		amount.setBounds(465, 60, 100, 30);
		amountLabel.setBounds(450, 100, 300, 50);
		sourceLabel.setForeground(Color.black);
		destinationLabel.setForeground(Color.black);
		amountLabel.setForeground(Color.black);
		amountLabelSmall.setForeground(Color.black);
		transact.setBounds(180, 155, 100, 30);
		clear.setBounds(320, 155, 100, 30);

		addListeners();

		panel.add(source);
		panel.add(destination);
		panel.add(amount);
		panel.add(amountLabel);
		panel.add(amountLabelSmall);
		panel.add(sourceLabel);
		panel.add(destinationLabel);
		panel.add(transact);
		panel.add(clear);
	}

	@Override
	protected void addListeners() {
		// TODO Auto-generated method stub
		transact.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				amountLabel.setText("<html><font size=5> Last transaction: "
						+ amount.getText() + " M.U.</font></html>");
				EmployeeOperations.transact(source.getText(),
						destination.getText(), amount.getText());
				JOptionPane.showMessageDialog(null, "Transaction complete!");
			}
		});
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				amount.setText("");
				amountLabel.setText("");
				source.setText("");
				destination.setText("");
			}
		});
	}

	public JTextField getSource() {
		return source;
	}

	public void setSource(JTextField source) {
		this.source = source;
	}

	public JTextField getDestination() {
		return destination;
	}

	public void setDestination(JTextField destination) {
		this.destination = destination;
	}

	public JTextField getAmount() {
		return amount;
	}

	public void setAmount(JTextField amount) {
		this.amount = amount;
	}

	public JButton getTransact() {
		return transact;
	}

	public void setTransact(JButton transact) {
		this.transact = transact;
	}

	public JButton getClear() {
		return clear;
	}

	public void setClear(JButton clear) {
		this.clear = clear;
	}

	public JLabel getAmountLabel() {
		return amountLabel;
	}

	public void setAmountLabel(JLabel amountLabel) {
		this.amountLabel = amountLabel;
	}

}
