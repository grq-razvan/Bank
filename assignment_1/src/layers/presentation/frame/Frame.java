package layers.presentation.frame;

import javax.swing.JFrame;

public class Frame {

	private static JFrame frame;

	public Frame() {
		frame = new JFrame();
		frame.setLayout(null);
		frame.setSize(960, 640);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bankassist");

	}

	public static JFrame getFrame() {
		return frame;
	}

}
