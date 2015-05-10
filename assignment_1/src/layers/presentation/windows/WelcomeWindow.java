package layers.presentation.windows;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import layers.logic.LoginUserRetriever;

public class WelcomeWindow extends Window {

	public WelcomeWindow() {
		JLabel imageLabel = new JLabel(new ImageIcon(this.getClass()
				.getResource("/basicImage.jpg")));
		imageLabel.setBounds(panel.getBounds());
		JLabel welcomeMessage = new JLabel("<html><font size=5></b>Welcome, "
				+ LoginUserRetriever.getEmployee().getUsername()
				+ "</b></font></html>");
		welcomeMessage.setBounds(150, 0, 200, 50);
		panel.add(imageLabel);
		panel.add(welcomeMessage);
	}

	@Override
	protected void addListeners() {
		// TODO Auto-generated method stub

	}

}
