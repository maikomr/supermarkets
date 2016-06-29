package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ToolBarActionListener;

public class ToolBar extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton newNodeBtn;
	private JButton newEdgeBtn;
	private JButton setLocationBtn;
	private JButton setTargetBtn;
	private JButton searchBtn;

	public ToolBar() {
		super();
		initComponent();
	}

	private void initComponent() {
		setLayout(new FlowLayout());

		newNodeBtn = new JButton("Add Node");
		newNodeBtn.setName("newNodeBtn");

		newEdgeBtn = new JButton("Add Edge");
		newEdgeBtn.setName("newEdgeBtn");

		setLocationBtn = new JButton("Location");
		setLocationBtn.setName("setLocationBtn");

		setTargetBtn = new JButton("Target");
		setTargetBtn.setName("setTargetBtn");

		searchBtn = new JButton("Search");
		searchBtn.setName("searchBtn");

		add(newNodeBtn);
		add(newEdgeBtn);
		add(setLocationBtn);
		add(setTargetBtn);
		add(searchBtn);
	}

	public void addActionListener(ToolBarActionListener toolBarAL) {
		newNodeBtn.addActionListener(toolBarAL);
		newEdgeBtn.addActionListener(toolBarAL);
		setLocationBtn.addActionListener(toolBarAL);
		setTargetBtn.addActionListener(toolBarAL);
		searchBtn.addActionListener(toolBarAL);
	}

}
