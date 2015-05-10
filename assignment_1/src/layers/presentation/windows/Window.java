package layers.presentation.windows;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public abstract class Window {

	protected JPanel panel;
	@SuppressWarnings("unused")
	private BufferedImage image;

	protected Window() {
		panel = new JPanel() {

			/**
			 * Slight variation on the traditional JPanel; it will load an image
			 */
			private static final long serialVersionUID = 1L;
			/*
			 * @Override protected void paintComponent(Graphics g) {
			 * super.paintComponent(g); g.drawImage(image, 0, 0, null); }
			 */
		};
		panel.setBackground(new Color(77, 79, 76));
		panel.setBounds(0, 0, 960, 640);
		panel.setVisible(true);
		panel.setLayout(null);
	}

	protected abstract void addListeners();

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

}
