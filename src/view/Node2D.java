package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

import model.Node;

public class Node2D extends JComponent {
	private static final long serialVersionUID = 1L;
	private Node<String> node;

	public Node2D(Node<String> node) {
		super();
		this.node = node;
	}

	@Override
	public void paintComponents(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(getX(), getY(), getWidth(), getHeight());
		g.setColor(Color.BLACK);
		int centerY = getY() + getHeight() / 2;
		g.drawString(node.getValue(), getX() + getWidth() / 10, centerY + getHeight() / 10);
	}

	public Node<String> getNode() {
		return node;
	}

	public void setNode(Node<String> node) {
		this.node = node;
	}
}
