package layers.presentation.main;

import javax.swing.SwingUtilities;

import layers.presentation.frame.Frame;
import layers.presentation.windows.LoginWindow;

public class EntryPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				new Frame();
				Frame.getFrame().add(new LoginWindow().getPanel());
			}
		});
		System.out.printf("%d Hello, world!", 5);

	}

}
