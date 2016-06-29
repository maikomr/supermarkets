package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import controller.GraphPanelMouseListener;
import model.Node;

public class GraphPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private List<Node2D> nodes;

	public GraphPanel() {
		super();
		nodes = new ArrayList<>();
		initComponent();
	}

	private void initComponent() {
		setBackground(Color.WHITE);
	}

	public void addNode(Node<String> node, int x, int y) {
		Node2D node2D = new Node2D(node);
		node2D.setBounds(x, y, 50, 50);
		nodes.add(node2D);
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
//		BufferedImage img = new BufferedImage(200, 100, BufferedImage.TYPE_INT_ARGB);
//		Graphics buffer = img.getGraphics();
		for (Node2D node : nodes) {
			node.paintComponents(g);
		}
//		g.drawImage(img, 0, 0, this);
	}
}
