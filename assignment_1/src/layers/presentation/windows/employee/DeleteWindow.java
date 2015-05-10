package layers.presentation.windows.employee;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import layers.logic.EmployeeAdministratorOperations;
import layers.presentation.windows.Window;

public class DeleteWindow extends Window {

	private JTextField id;
	private JButton delete, clear;

	public DeleteWindow() {
		id = new JTextField();
		JLabel idLabel = new JLabel("Employee ID: ");
		delete = new JButton("Delete");
		clear = new JButton("Clear");

		idLabel.setBounds(40, 60, 130, 30);
		id.setBounds(180, 60, 140, 30);
		idLabel.setForeground(Color.black);
		delete.setBounds(120, 95, 70, 30);
		clear.setBounds(200, 95, 70, 30);

		addListeners();

		panel.add(id);
		panel.add(idLabel);
		panel.add(delete);
		panel.add(clear);
	}

	@Override
	protected void addListeners() {
		// TODO Auto-generated method stub
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EmployeeAdministratorOperations.deleteEmployee(id.getText());
				JOptionPane.showMessageDialog(null, "Employee deleted.");
			}
		});

		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				id.setText("");
			}
		});
	}

}
