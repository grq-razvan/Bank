package layers.presentation.windows.employee;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import layers.logic.EmployeeAdministratorOperations;
import layers.logic.InputValidator;
import layers.presentation.windows.Window;

public class CreateWindow extends Window {

	private JTextField id, name, address, username;
	private JPasswordField password, passwordRetype;
	private JCheckBox admin;
	private JButton add, clear;

	public CreateWindow() {

		id = new JTextField();
		name = new JTextField();
		address = new JTextField();
		username = new JTextField();
		password = new JPasswordField();
		passwordRetype = new JPasswordField();
		add = new JButton("Add");
		clear = new JButton("Clear");
		admin = new JCheckBox();

		JLabel idLabel = new JLabel("Employee ID: ");
		JLabel nameLabel = new JLabel("Employee name: ");
		JLabel addressLabel = new JLabel("Employee address: ");
		JLabel adminLabel = new JLabel("Administrator: ");
		JLabel usernameLabel = new JLabel("Username: ");
		JLabel passwordLabel = new JLabel("Password: ");
		JLabel passwordRetypeLabel = new JLabel("Password (check): ");

		idLabel.setBounds(40, 60, 130, 30);
		nameLabel.setBounds(40, 95, 130, 30);
		addressLabel.setBounds(40, 130, 130, 30);
		usernameLabel.setBounds(40, 165, 130, 30);
		passwordLabel.setBounds(40, 200, 150, 30);
		passwordRetypeLabel.setBounds(40, 235, 150, 30);
		adminLabel.setBounds(40, 270, 150, 30);

		idLabel.setForeground(Color.BLACK);
		nameLabel.setForeground(Color.black);
		addressLabel.setForeground(Color.black);
		usernameLabel.setForeground(Color.black);
		passwordLabel.setForeground(Color.black);
		passwordLabel.setForeground(Color.black);
		adminLabel.setForeground(Color.black);

		id.setBounds(200, 60, 150, 30);
		name.setBounds(200, 95, 150, 30);
		address.setBounds(200, 130, 150, 30);
		username.setBounds(200, 165, 150, 30);
		password.setBounds(200, 200, 150, 30);
		passwordRetype.setBounds(200, 235, 150, 30);
		admin.setBounds(200, 270, 30, 30);

		add.setBounds(120, 305, 85, 30);
		clear.setBounds(220, 305, 70, 30);

		addListeners();

		panel.add(idLabel);
		panel.add(nameLabel);
		panel.add(addressLabel);
		panel.add(adminLabel);
		panel.add(usernameLabel);
		panel.add(passwordLabel);
		panel.add(passwordRetypeLabel);
		panel.add(id);
		panel.add(name);
		panel.add(address);
		panel.add(add);
		panel.add(password);
		panel.add(admin);
		panel.add(username);
		panel.add(passwordRetype);
	}

	@Override
	protected void addListeners() {
		// TODO Auto-generated method stub
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (InputValidator.isPasswordTypedWell(password.getPassword(),
						passwordRetype.getPassword())) {
					StringBuilder word = new StringBuilder();
					for (char c : password.getPassword()) {
						word.append(c);
					}
					EmployeeAdministratorOperations.addEmployee(id.getText(),
							name.getText(), address.getText(),
							username.getText(), word.toString(),
							admin.isSelected());
					JOptionPane.showMessageDialog(null, "Employee added.");
				} else {
					JOptionPane.showMessageDialog(null, "Wrong password");
					id.setText("");
					name.setText("");
					address.setText("");
					admin.setSelected(false);
					username.setText("");
					password.setText("");
					passwordRetype.setText("");
				}
			}
		});
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				id.setText("");
				name.setText("");
				address.setText("");
				admin.setSelected(false);
				username.setText("");
				password.setText("");
				passwordRetype.setText("");
			}
		});

	}

	public JTextField getId() {
		return id;
	}

	public void setId(JTextField id) {
		this.id = id;
	}

	public JTextField getName() {
		return name;
	}

	public void setName(JTextField name) {
		this.name = name;
	}

	public JTextField getAddress() {
		return address;
	}

	public void setAddress(JTextField address) {
		this.address = address;
	}

	public JTextField getUsername() {
		return username;
	}

	public void setUsername(JTextField username) {
		this.username = username;
	}

	public JTextField getPassword() {
		return password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}

	public JTextField getPasswordRetype() {
		return passwordRetype;
	}

	public void setPasswordRetype(JPasswordField passwordRetype) {
		this.passwordRetype = passwordRetype;
	}

	public JCheckBox getAdmin() {
		return admin;
	}

	public void setAdmin(JCheckBox admin) {
		this.admin = admin;
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
