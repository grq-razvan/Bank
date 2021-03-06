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

public class CreateWindow extends Window {

	private JTextField ssid, name, address;
	private JButton add, clear;

	public CreateWindow() {
		ssid = new JTextField();
		name = new JTextField();
		address = new JTextField();
		add = new JButton("Add");
		clear = new JButton("Clear");

		JLabel ssidLabel = new JLabel("Client SSID: ");
		JLabel nameLabel = new JLabel("Client name: ");
		JLabel addressLabel = new JLabel("Client address: ");

		ssidLabel.setBounds(40, 60, 130, 30);
		nameLabel.setBounds(40, 95, 130, 30);
		addressLabel.setBounds(40, 130, 130, 30);

		ssidLabel.setForeground(Color.BLACK);
		nameLabel.setForeground(Color.black);
		addressLabel.setForeground(Color.black);

		ssid.setBounds(200, 60, 150, 30);
		name.setBounds(200, 95, 150, 30);
		address.setBounds(200, 130, 150, 30);

		add.setBounds(120, 260, 70, 30);
		clear.setBounds(200, 260, 70, 30);

		addListeners();

		panel.add(ssid);
		panel.add(name);
		panel.add(address);
		panel.add(ssidLabel);
		panel.add(nameLabel);
		panel.add(addressLabel);
		panel.add(add);
		panel.add(clear);
	}

	@Override
	protected void addListeners() {
		// TODO Auto-generated method stub
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				EmployeeOperations.addClient(ssid.getText(), name.getText(),
						address.getText());
				JOptionPane.showMessageDialog(null, "Client added.");
			}
		});

		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ssid.setText("");
				name.setText("");
				address.setText("");
			}
		});
	}

	public JTextField getSsid() {
		return ssid;
	}

	public JTextField getName() {
		return name;
	}

	public JTextField getAddress() {
		return address;
	}

	public JButton getAdd() {
		return add;
	}

	public JButton getClear() {
		return clear;
	}

	public void setSsid(JTextField ssid) {
		this.ssid = ssid;
	}

	public void setName(JTextField name) {
		this.name = name;
	}

	public void setAddress(JTextField address) {
		this.address = address;
	}

	public void setAdd(JButton add) {
		this.add = add;
	}

	public void setClear(JButton clear) {
		this.clear = clear;
	}

}
