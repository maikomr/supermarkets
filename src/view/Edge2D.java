package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import model.Edge;

public class Edge2D extends JComponent {

	private static final long serialVersionUID = 1L;
	private Node2D from;
	private Node2D to;
	Edge<String> edge;
	private Color color;

	public Edge2D(Node2D from, Node2D to, Edge<String> edge) {
		this.from = from;
		this.to = to;
		this.edge = edge;
		color = Color.BLACK;
	}

	@Override
	protected void paintComponent(Graphics g) {
		if(color == Color.BLUE) {
			Graphics2D g2D = (Graphics2D) g;
			g2D.setStroke(new BasicStroke(3));
		}			
		g.setColor(color);
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
		
		if(color == Color.BLUE) {
			Graphics2D g2D = (Graphics2D) g;
			g2D.setStroke(new BasicStroke(1));
		}
		
		g.drawString(String.valueOf(edge.getCost()), x, y);
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Edge<String> getEdge() {
		return edge;
	}
}
