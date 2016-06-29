package view;

import java.awt.Graphics;

import javax.swing.JComponent;

public class Edge2D extends JComponent {

	private static final long serialVersionUID = 1L;
	private Node2D from;
	private Node2D to;
	private int cost;

	public Edge2D(Node2D from, Node2D to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawLine(from.getX() + 25, from.getY() + 25, to.getX() + 25, to.getY() + 25);
		int x, y;
		if (from.getX() < to.getX()) {
			x = from.getX() + (to.getX() - from.getX()) / 2;
			x += 25;
		} else {
			x = from.getX() - (from.getX() - to.getX()) / 2;
			x -= 25;
		}
		if (from.getY() < to.getY()) {
			y = from.getY() + (to.getY() - from.getY()) / 2;
			y += 25;
		} else {
			y = from.getY() - (from.getY() - to.getY()) / 2;
			y -= 25;
		}
		g.drawString(String.valueOf(cost), x, y);
	}
}
