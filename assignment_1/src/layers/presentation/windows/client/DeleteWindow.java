package layers.presentation.windows.client;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import layers.logic.EmployeeOperations;
import layers.presentation.windows.Window;

public class DeleteWindow extends Window {

	private JTextField ssid;
	private JButton delete, clear;

	public DeleteWindow() {
		ssid = new JTextField();
		delete = new JButton("Delete");
		clear = new JButton("Clear");
		JLabel ssidLabel = new JLabel("Client ssid: ");

		ssidLabel.setBounds(40, 60, 130, 30);
		ssid.setBounds(180, 60, 140, 30);
		ssidLabel.setForeground(Color.black);
		delete.setBounds(120, 95, 70, 30);
		clear.setBounds(200, 95, 70, 30);

		addListeners();

		panel.add(ssid);
		panel.add(delete);
		panel.add(clear);
		panel.add(ssidLabel);
	}

	@Override
	protected void addListeners() {
		// TODO Auto-generated method stub

		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EmployeeOperations.removeClient(ssid.getText());
				JOptionPane.showMessageDialog(null, "Client deleted.");
			}
		});

		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ssid.setText("");
			}
		});

	}

	public JTextField getSsid() {
		return ssid;
	}

	public void setSsid(JTextField ssid) {
		this.ssid = ssid;
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
