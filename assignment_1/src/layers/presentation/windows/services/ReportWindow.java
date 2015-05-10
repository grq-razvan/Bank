package layers.presentation.windows.services;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import layers.logic.EmployeeAdministratorOperations;
import layers.presentation.windows.Window;

public class ReportWindow extends Window {

	private JTextField id, start, end;
	private JButton generate, clear;
	private JCheckBox masterReport;

	public ReportWindow() {
		id = new JTextField();
		start = new JTextField();
		end = new JTextField();
		generate = new JButton("Generate");
		clear = new JButton("Clear");
		masterReport = new JCheckBox();
		JLabel master = new JLabel("Master report? ");
		JLabel startLabel = new JLabel("Start date: ");
		JLabel endLabel = new JLabel("End date: ");
		JLabel idLabel = new JLabel("Employee ID: ");

		idLabel.setBounds(40, 65, 130, 30);
		startLabel.setBounds(40, 100, 130, 30);
		endLabel.setBounds(40, 135, 130, 30);
		master.setBounds(350, 65, 130, 30);
		idLabel.setForeground(Color.black);
		startLabel.setForeground(Color.black);
		endLabel.setForeground(Color.black);
		master.setForeground(Color.black);
		id.setBounds(170, 65, 150, 30);
		start.setBounds(170, 100, 130, 30);
		end.setBounds(170, 135, 130, 30);
		masterReport.setBounds(480, 65, 50, 30);
		generate.setBounds(140, 180, 95, 30);
		clear.setBounds(245, 180, 75, 30);

		addListeners();

		panel.add(id);
		panel.add(start);
		panel.add(end);
		panel.add(master);
		panel.add(generate);
		panel.add(startLabel);
		panel.add(masterReport);
		panel.add(idLabel);
		panel.add(endLabel);
		panel.add(clear);
	}

	@Override
	protected void addListeners() {
		// TODO Auto-generated method stub
		generate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (masterReport.isSelected()) {
					EmployeeAdministratorOperations.generateReport(id.getText());
				} else {
					EmployeeAdministratorOperations.generateReport(
							id.getText(), start.getText(), end.getText());
				}
				JOptionPane.showMessageDialog(null,
						"Report generated.Check files.");
			}
		});
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				id.setText("");
				start.setText("");
				end.setText("");
			}
		});

	}

	public JTextField getId() {
		return id;
	}

	public void setId(JTextField id) {
		this.id = id;
	}

	public JTextField getStart() {
		return start;
	}

	public void setStart(JTextField start) {
		this.start = start;
	}

	public JTextField getEnd() {
		return end;
	}

	public void setEnd(JTextField end) {
		this.end = end;
	}

	public JButton getGenerate() {
		return generate;
	}

	public void setGenerate(JButton generate) {
		this.generate = generate;
	}

	public JButton getClear() {
		return clear;
	}

	public void setClear(JButton clear) {
		this.clear = clear;
	}

}
