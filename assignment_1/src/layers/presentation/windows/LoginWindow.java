package layers.presentation.windows;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import layers.logic.LoginUserRetriever;
import layers.logic.LoginValidator;
import layers.presentation.frame.Frame;
import layers.presentation.menu.Menu;

public class LoginWindow extends Window {

	private JTextField username;
	private JPasswordField password;
	private JButton submit, exit;

	public LoginWindow() {
		super();
		username = new JTextField();
		password = new JPasswordField();
		submit = new JButton("Connect");
		exit = new JButton("Close");

		JLabel usernameLabel = new JLabel("Username: ");
		JLabel passwordLabel = new JLabel("Password: ");
		JLabel imageLabel = new JLabel(new ImageIcon(this.getClass()
				.getResource("/gif3.gif")));

		JLabel applicationName = new JLabel(
				"<html><b><font size=5><u>Employee-Aid v1.01</u></font></b></html>");
		applicationName.setForeground(Color.BLACK);
		username.setBounds(680, 220, 140, 29);
		usernameLabel.setBounds(580, 220, 100, 29);
		usernameLabel.setForeground(Color.BLACK);
		password.setBounds(680, 265, 140, 29);
		passwordLabel.setBounds(580, 265, 140, 29);
		passwordLabel.setForeground(Color.BLACK);
		submit.setBounds(635, 325, 85, 30);
		exit.setBounds(745, 325, 85, 30);
		imageLabel.setBounds(0, 50, 500, 500);
		applicationName.setBounds(150, 0, 200, 50);

		addListeners();

		panel.add(usernameLabel);
		panel.add(passwordLabel);
		panel.add(imageLabel);
		panel.add(applicationName);
		panel.add(username);
		panel.add(password);
		panel.add(submit);
		panel.add(exit);
	}

	@Override
	protected void addListeners() {
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				Container container = Frame.getFrame().getContentPane();
				container.removeAll();
				StringBuilder word = new StringBuilder();
				for (char c : password.getPassword()) {
					word.append(c);
				}

				boolean isValidUsername = LoginValidator.isUserValid(
						username.getText(), word.toString());
				boolean isAdmin = LoginValidator.isUserAdmin(
						username.getText(), word.toString());
				if (isValidUsername) {
					// add welcome window
					LoginUserRetriever.fetchEmployee(username.getText(),
							word.toString());
					if (isAdmin) {
						// add menu with true argument
						Frame.getFrame().setJMenuBar(
								new Menu(true).getMenuBar());
					} else {
						// add menu with false arg
						Frame.getFrame().setJMenuBar(
								new Menu(false).getMenuBar());
					}
					container.add(new WelcomeWindow().getPanel());
					container.repaint();
					container.revalidate();
				} else {
					// dialog box with error
					JOptionPane.showMessageDialog(null,
							"Can't connect with this username!");
					System.exit(0);
				}
			}
		});
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}

	public JTextField getUsername() {
		return username;
	}

	public void setUsername(JTextField username) {
		this.username = username;
	}

	public JPasswordField getPassword() {
		return password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}

	public JButton getSubmit() {
		return submit;
	}

	public void setSubmit(JButton submit) {
		this.submit = submit;
	}

	public JButton getExit() {
		return exit;
	}

	public void setExit(JButton exit) {
		this.exit = exit;
	}

}
