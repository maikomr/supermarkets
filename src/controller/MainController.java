package controller;

import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import model.Edge;
import model.Graph;
import model.Node;
import view.GraphPanel;
import view.MainView;
import view.Node2D;
import view.ToolBar;

public class MainController {

	private Graph<String> graph;
	private MainView mainView;
	private ToolBar toolBar;
	private GraphPanel graphPanel;
	private Action currentAction;
	private int clickCount;
	private Point firstEndPoint;
	private Point secondEndPoint;

	public MainController() {
		graph = new Graph<>();
		currentAction = Action.NONE;
		this.clickCount = 0;
	}

	private void initMainView() {
		mainView = new MainView();
		toolBar = new ToolBar();
		ToolBarActionListener toolBarAL = new ToolBarActionListener(this);
		toolBar.addActionListener(toolBarAL);

		graphPanel = new GraphPanel();
		graphPanel.addMouseListener(new GraphPanelMouseListener(this));

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

	public void createNewNodeActionPerformed(Point point) {
		String name = JOptionPane.showInputDialog("Enter the node name");
		if (name != null && !name.isEmpty()) {
			Node<String> node = new Node<>(name);
			graph.addNode(node);
			graphPanel.addNode(node, point.x, point.y);
		}
	}

	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}

	public int getClickCount() {
		return clickCount;
	}

	public void setFirstEndPoint(Point point) {
		firstEndPoint = point;
	}

	public void setSecondEndPoint(Point point) {
		secondEndPoint = point;
	}

	public void createNewEdgeActionPerformed() {
		if (firstEndPoint != null && secondEndPoint != null) {
			System.out.println(firstEndPoint + ", " + secondEndPoint);
			Node2D firstEP = (Node2D) graphPanel.getComponentAt(firstEndPoint);
			Node2D secondEP = (Node2D) graphPanel.getComponentAt(secondEndPoint);
			if (firstEP != null && secondEP != null) {
				String costStr = JOptionPane.showInputDialog("Enter the edge cost");
				int cost = Integer.parseInt(costStr);
				Edge<String> edge = graph.addEdge(firstEP.getNode(), secondEP.getNode(), cost);
				graphPanel.addEdge(edge);
				graphPanel.repaint();
			}
		}
	}
}
