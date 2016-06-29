package view;

import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class NewNodeDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField inputNodeName;
	private JOptionPane optionPane;

	public NewNodeDialog(Frame owner) {
		super(owner, "New Node", true);
		initComponent();
	}

	private void initComponent() {
		String message = "Enter the name of the new node.";
		inputNodeName = new JTextField(15);
		Object[] array = { message, inputNodeName };
		optionPane = new JOptionPane(array, JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_NO_OPTION);
		setContentPane(optionPane);
		setMinimumSize(new Dimension(250, 150));
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
	}
}
