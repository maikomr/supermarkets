package controller;

import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.SwingUtilities;

import model.Graph;
import model.Node;
import view.GraphPanel;
import view.MainView;
import view.NewNodeDialog;
import view.ToolBar;

public class MainController {

	private Graph<String> graph;

	public MainController() {
		graph = new Graph<>();
		currentAction = Action.NONE;
	}

	private MainView mainView;
	private ToolBar toolBar;
	private GraphPanel graphPanel;
	private Action currentAction;
	private NewNodeDialog dialog;

	private void initMainView() {
		mainView = new MainView();
		toolBar = new ToolBar();
		ToolBarActionListener toolBarAL = new ToolBarActionListener(this);
		toolBar.addActionListener(toolBarAL);

		graphPanel = new GraphPanel();
		graphPanel.addMouseListener(new GraphPanelMouseListener(this));

		graphPanel.addNode(new Node<String>("Hipermaxi"), 300, 200);

		dialog = new NewNodeDialog(mainView);
		dialog.setLocationRelativeTo(mainView);
		dialog.setResizable(false);

		mainView.getContentPane().add(toolBar, BorderLayout.NORTH);
		mainView.getContentPane().add(graphPanel, BorderLayout.CENTER);
		mainView.repaint();
		mainView.pack();
		mainView.setVisible(true);
	}

	private void start() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				initMainView();
			}
		});
	}

	public static void main(String[] args) {
		MainController app = new MainController();
		app.start();
	}

	public void setCurrentAction(Action action) {
		this.currentAction = action;
	}

	public void search() {
		System.out.println("search");
	}

	public Action getCurrentAction() {
		return currentAction;
	}

	public void createNewNode(Point point) {
		dialog.setVisible(true);
	}
}
