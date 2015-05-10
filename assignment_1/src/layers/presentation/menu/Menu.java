package layers.presentation.menu;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import layers.logic.LoginUserRetriever;
import layers.presentation.frame.Frame;
import layers.presentation.windows.LoginWindow;

public class Menu {

	private JMenuBar menuBar;
	private JMenu client, account, services, otherOptions, admin;
	private JMenuItem clientAdd, clientUpdate, clientDelete, clientView,
			accountAdd, accountUpdate, accountDelete, accountView,
			servicesProcessBills, servicesGenerateRapport,
			servicesTransferMoney, employeeAdd, employeeView, employeeUpdate,
			employeeDelete, exit, logoff;

	public Menu(boolean isAdmin) {
		menuBar = new JMenuBar();
		client = new JMenu();
		account = new JMenu();
		services = new JMenu();
		otherOptions = new JMenu();
		admin = new JMenu();
		clientAdd = new JMenuItem();
		clientUpdate = new JMenuItem();
		clientDelete = new JMenuItem();
		clientView = new JMenuItem();
		accountAdd = new JMenuItem();
		accountUpdate = new JMenuItem();
		accountDelete = new JMenuItem();
		accountView = new JMenuItem();
		servicesProcessBills = new JMenuItem();
		servicesGenerateRapport = new JMenuItem();
		servicesTransferMoney = new JMenuItem();
		employeeAdd = new JMenuItem();
		employeeView = new JMenuItem();
		employeeUpdate = new JMenuItem();
		employeeDelete = new JMenuItem();
		exit = new JMenuItem();
		logoff = new JMenuItem();

		client.setText("Client");
		client.setMnemonic('c');

		account.setText("Account");
		account.setMnemonic('a');

		admin.setText("Administrators");
		admin.setMnemonic('i');

		services.setText("Services");
		services.setMnemonic('s');

		otherOptions.setText("Options");

		clientAdd.setText("Add");
		clientAdd.setMnemonic('a');
		clientUpdate.setText("Update");
		clientUpdate.setMnemonic('u');
		clientView.setText("View");
		clientView.setMnemonic('v');
		clientDelete.setText("Delete");
		clientDelete.setMnemonic('d');

		accountAdd.setText("Add");
		accountAdd.setMnemonic('a');
		accountUpdate.setText("Update");
		accountUpdate.setMnemonic('u');
		accountView.setText("View");
		accountView.setMnemonic('v');
		accountDelete.setText("Delete");
		accountDelete.setMnemonic('d');

		servicesProcessBills.setText("Process bills");
		servicesProcessBills.setMnemonic('b');
		servicesGenerateRapport.setText("Generate rapport");
		servicesGenerateRapport.setMnemonic('r');
		servicesTransferMoney.setText("Transfer money");
		servicesTransferMoney.setMnemonic('t');

		employeeAdd.setText("Add");
		employeeAdd.setMnemonic('a');
		employeeDelete.setText("Delete");
		employeeDelete.setMnemonic('d');
		employeeView.setText("View");
		employeeView.setMnemonic('v');
		employeeUpdate.setText("Update");
		employeeUpdate.setMnemonic('u');

		exit.setText("Exit");
		exit.setMnemonic('x');
		logoff.setText("Log off");
		logoff.setMnemonic('l');

		client.add(clientAdd);
		client.add(clientUpdate);
		client.add(clientView);
		client.add(clientDelete);
		account.add(accountAdd);
		account.add(accountUpdate);
		account.add(accountView);
		account.add(accountDelete);
		services.add(servicesProcessBills);
		services.add(servicesGenerateRapport);
		services.add(servicesTransferMoney);

		admin.add(employeeAdd);
		admin.add(employeeDelete);
		admin.add(employeeUpdate);
		admin.add(employeeView);

		otherOptions.add(exit);
		otherOptions.add(logoff);

		String text = "Logged in as: "
				+ LoginUserRetriever.getEmployee().getUsername();
		JMenu help = new JMenu(text);
		help.setEnabled(false);
		if (isAdmin) {
			help.setToolTipText("Administrator account");
		} else {
			help.setToolTipText("Clerk account");
		}
		addListeners();

		menuBar.add(client);
		menuBar.add(account);
		menuBar.add(services);
		menuBar.add(admin);
		menuBar.add(otherOptions);

		if (isAdmin) {
			client.setEnabled(false);
			account.setEnabled(false);
			servicesProcessBills.setEnabled(false);
			servicesTransferMoney.setEnabled(false);
			servicesGenerateRapport.setEnabled(true);
			admin.setEnabled(true);
		} else {
			client.setEnabled(true);
			account.setEnabled(true);
			servicesProcessBills.setEnabled(true);
			servicesTransferMoney.setEnabled(true);
			servicesGenerateRapport.setEnabled(false);
			admin.setEnabled(false);
		}

		menuBar.add(help);

	}

	private void addListeners() {
		addClientListeners();
		addAccountListeners();
		addServicesListeners();
		addAdminListeners();
		addOtherOptionsListeners();
	}

	private void addOtherOptionsListeners() {
		// TODO Auto-generated method stub
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

		logoff.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Container container = Frame.getFrame().getContentPane();
				container.removeAll();
				container.add(new LoginWindow().getPanel());
				container.repaint();
			}
		});

	}

	private void addAdminListeners() {
		// TODO Auto-generated method stub
		employeeAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Container container = Frame.getFrame().getContentPane();
				container.removeAll();
				container
						.add(new layers.presentation.windows.employee.CreateWindow()
								.getPanel());
				container.repaint();
			}
		});
		employeeDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Container container = Frame.getFrame().getContentPane();
				container.removeAll();
				container
						.add(new layers.presentation.windows.employee.DeleteWindow()
								.getPanel());
				container.repaint();
			}
		});
		employeeView.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Container container = Frame.getFrame().getContentPane();
				container.removeAll();
				container
						.add(new layers.presentation.windows.employee.ReadWindow()
								.getPanel());
				container.repaint();
			}
		});

		employeeUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Container container = Frame.getFrame().getContentPane();
				container.removeAll();
				container
						.add(new layers.presentation.windows.employee.UpdateWindow()
								.getPanel());
				container.repaint();
			}
		});
	}

	private void addServicesListeners() {
		// TODO Auto-generated method stub
		servicesGenerateRapport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Container container = Frame.getFrame().getContentPane();
				container.removeAll();
				container
						.add(new layers.presentation.windows.services.ReportWindow()
								.getPanel());
				container.repaint();
			}
		});
		servicesProcessBills.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Container container = Frame.getFrame().getContentPane();
				container.removeAll();
				container
						.add(new layers.presentation.windows.services.PaymentWindow()
								.getPanel());
				container.repaint();
			}
		});
		servicesTransferMoney.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Container container = Frame.getFrame().getContentPane();
				container.removeAll();
				container
						.add(new layers.presentation.windows.services.TransactionWindow()
								.getPanel());
				container.repaint();
			}
		});
	}

	private void addClientListeners() {
		clientAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Container container = Frame.getFrame().getContentPane();
				container.removeAll();
				container
						.add(new layers.presentation.windows.client.CreateWindow()
								.getPanel());
				container.repaint();
			}
		});

		clientUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Container container = Frame.getFrame().getContentPane();
				container.removeAll();
				container
						.add(new layers.presentation.windows.client.UpdateWindow()
								.getPanel());
				container.repaint();
			}
		});

		clientDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Container container = Frame.getFrame().getContentPane();
				container.removeAll();
				container
						.add(new layers.presentation.windows.client.DeleteWindow()
								.getPanel());
				container.repaint();
			}
		});

		clientView.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Container container = Frame.getFrame().getContentPane();
				container.removeAll();
				container
						.add(new layers.presentation.windows.client.ReadWindow()
								.getPanel());
				container.repaint();
			}
		});
	}

	private void addAccountListeners() {
		accountAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Container container = Frame.getFrame().getContentPane();
				container.removeAll();
				container
						.add(new layers.presentation.windows.account.CreateWindow()
								.getPanel());
				container.repaint();
			}
		});
		accountDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Container container = Frame.getFrame().getContentPane();
				container.removeAll();
				container
						.add(new layers.presentation.windows.account.DeleteWindow()
								.getPanel());
				container.repaint();
			}
		});
		accountView.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Container container = Frame.getFrame().getContentPane();
				container.removeAll();
				container
						.add(new layers.presentation.windows.account.ReadWindow()
								.getPanel());
				container.repaint();
			}
		});
		accountUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Container container = Frame.getFrame().getContentPane();
				container.removeAll();
				container
						.add(new layers.presentation.windows.account.UpdateWindow()
								.getPanel());
				container.repaint();
			}
		});
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public JMenu getClient() {
		return client;
	}

	public JMenu getAccount() {
		return account;
	}

	public JMenu getServices() {
		return services;
	}

	public JMenu getExit() {
		return otherOptions;
	}

	public JMenuItem getClientAdd() {
		return clientAdd;
	}

	public JMenuItem getClientUpdate() {
		return clientUpdate;
	}

	public JMenuItem getClientDelete() {
		return clientDelete;
	}

	public JMenuItem getClientView() {
		return clientView;
	}

	public JMenuItem getAccountAdd() {
		return accountAdd;
	}

	public JMenuItem getAccountUpdate() {
		return accountUpdate;
	}

	public JMenuItem getAccountDelete() {
		return accountDelete;
	}

	public JMenuItem getAccountView() {
		return accountView;
	}

	public JMenuItem getServicesProcessBills() {
		return servicesProcessBills;
	}

	public JMenuItem getServicesGenerateRapport() {
		return servicesGenerateRapport;
	}

	public JMenuItem getServicesTransferMoney() {
		return servicesTransferMoney;
	}

}
