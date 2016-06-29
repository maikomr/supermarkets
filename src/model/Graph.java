package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple graph representation in form of a bidirectional adjacency list.
 * 
 * @author Maiko Morales
 *
 * @param <T>
 *            Value data type related to the graph's nodes.
 */
public class Graph<T> {

	private List<Node<T>> nodes;

	public Graph() {
		nodes = new ArrayList<>();
	}

	public void addNode(Node<T> node) {
		if (!nodes.contains(node))
			nodes.add(node);
	}

	public void addEdge(Node<T> firstEndPoint, Node<T> secondEndPoint, int cost) {
		addNode(firstEndPoint);
		addNode(secondEndPoint);
		Edge<T> edge = new Edge<>(firstEndPoint, secondEndPoint, cost);
		firstEndPoint.addNeighbour(edge);
		secondEndPoint.addNeighbour(edge);
	}

	@Override
	public String toString() {
		StringBuilder nodesStr = new StringBuilder();
		for (Node<T> node : nodes) {
			nodesStr.append(node.toString() + '\n');
		}
		return nodesStr.toString();
	}

	public void markAllUnvisited() {
		for (Node<T> node : nodes)
			node.setVisited(false);
	}

	public void resetCumulativeCosts() {
		for (Node<T> node : nodes)
			node.setCumulativeCost(Integer.MAX_VALUE);
	}
}
