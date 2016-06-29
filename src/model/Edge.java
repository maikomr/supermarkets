package model;

public class Edge<T> implements Comparable<Edge<T>> {

	private Node<T> firstEndPoint;
	private Node<T> secondEndPoint;
	private int cost;

	public Edge(Node<T> firstEndPoint, Node<T> secondEndPoint, int cost) {
		this.firstEndPoint = firstEndPoint;
		this.secondEndPoint = secondEndPoint;
		this.cost = cost;
	}

	public Node<T> getNeighbourOf(Node<T> endPoint) {
		return endPoint == firstEndPoint ? secondEndPoint : firstEndPoint;
	}

	public Node<T> getFirstEndPoint() {
		return firstEndPoint;
	}

	public void setFirstEndPoint(Node<T> firstEndPoint) {
		this.firstEndPoint = firstEndPoint;
	}

	public Node<T> getSecondEndPoint() {
		return secondEndPoint;
	}

	public void setSecondEndPoint(Node<T> secondEndPoint) {
		this.secondEndPoint = secondEndPoint;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return String.format("%s->%s (%d)", firstEndPoint.getValue(), secondEndPoint.getValue(), cost);
	}

	@Override
	public int compareTo(Edge<T> other) {
		return Integer.compare(this.cost, other.cost);
	}
}
