package view;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MainView extends JFrame {
	private static final long serialVersionUID = 1L;

	public MainView() {
		super("Supermarket");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(600, 400));
		setLocationRelativeTo(null);
	}
}
