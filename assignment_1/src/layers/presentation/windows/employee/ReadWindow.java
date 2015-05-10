package layers.presentation.windows.employee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import layers.logic.EmployeeAdministratorOperations;
import layers.presentation.windows.Window;

public class ReadWindow extends Window {

	private JTextField id;
	private JButton find, clear;

	public ReadWindow() {
		// TODO Auto-generated constructor stub
		id = new JTextField();
		find = new JButton("Find");
		clear = new JButton("Clear");
		JLabel idLabel = new JLabel("Client SSID:");

		idLabel.setBounds(40, 65, 130, 30);
		id.setBounds(180, 65, 130, 30);
		find.setBounds(120, 110, 70, 30);
		clear.setBounds(200, 110, 70, 30);

		addListeners();

		panel.add(id);
		panel.add(find);
		panel.add(clear);
		panel.add(idLabel);
	}

	@Override
	protected void addListeners() {
		// TODO Auto-generated method stub

		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				id.setText("");
			}
		});

		find.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTextArea text = new JTextArea();
				text.setEditable(false);
				text.setBounds(560, 280, 300, 100);
				text.setLineWrap(true);
				text.setText(EmployeeAdministratorOperations.viewEmployee(id
						.getText()));
				panel.add(text);
				panel.repaint();
				panel.revalidate();
				clear.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						id.setText("");
						text.setText("");
					}
				});
			}
		});
	}

}
