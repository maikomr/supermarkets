package model;

import java.util.ArrayList;
import java.util.List;

public class Node<T> implements Comparable<Node<T>> {

	private T value;
	private List<Edge<T>> neighbors;
	private boolean visited;
	private int cumulativeCost;
	private Edge<T> parent;

	public Node(T value) {
		this.value = value;
		neighbors = new ArrayList<>();
		visited = false;
		cumulativeCost = Integer.MAX_VALUE;
	}

	public void addNeighbour(Edge<T> neighbour) {
		this.neighbors.add(neighbour);
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public List<Edge<T>> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(List<Edge<T>> neighbors) {
		this.neighbors = neighbors;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public int getCumulativeCost() {
		return cumulativeCost;
	}

	public void setCumulativeCost(int cumulativeCost) {
		this.cumulativeCost = cumulativeCost;
	}

	@Override
	public String toString() {
		return value.toString() + " -> " + neighbors;
	}

	@Override
	public int compareTo(Node<T> other) {
		return Integer.compare(this.cumulativeCost, other.cumulativeCost);
	}

	public void setParent(Edge<T> parent) {
		this.parent = parent;
	}

	public Edge<T> getParent() {
		return parent;
	}
}
