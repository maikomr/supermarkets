package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import model.Edge;
import model.Node;

public class GraphPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private List<Node2D> nodes;
	private List<Edge2D> edges;

	public GraphPanel() {
		super();
		nodes = new ArrayList<>();
		edges = new ArrayList<>();
		initComponent();
	}

	private void initComponent() {
		setBackground(Color.WHITE);
	}

	public void addNode(Node<String> node, int x, int y) {
		Node2D node2D = new Node2D(node);
		node2D.setBounds(x, y, 50, 50);
		add(node2D);
		nodes.add(node2D); // TODO try to eliminate this row
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (Node2D node : nodes) {
			node.paintComponent(g);
		}
		for (Edge2D edge : edges) {
			edge.paintComponent(g);
		}
	}

	public void addEdge(Edge<String> edge) {
		Node<String> from = edge.getFirstEndPoint();
		Node<String> to = edge.getSecondEndPoint();
		Node2D from2D = null, to2D = null;
		for (Node2D node : nodes) {
			if (node.getNode() == from)
				from2D = node;
		}
		for (Node2D node : nodes) {
			if (node.getNode() == to)
				to2D = node;
		}
		if (from2D != null & to2D != null && from2D != to2D) {
			Edge2D edge2D = new Edge2D(from2D, to2D, edge.getCost());
			edges.add(edge2D);
		}
	}
}
