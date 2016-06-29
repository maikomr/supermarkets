package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class UniformCostSearch {

	public static <T> List<Edge<T>> execute(Graph<T> g, Node<T> source, Node<T> target) {
		g.resetCumulativeCosts();
		g.markAllUnvisited();
		PriorityQueue<Node<T>> frontier = new PriorityQueue<>();
		source.setCumulativeCost(0);
		frontier.add(source);
		while (!frontier.isEmpty()) {
			Node<T> current = frontier.remove();
			if (current == target) {
				return UniformCostSearch.getPath(current);
			}
			current.setVisited(true);
			
			List<Edge<T>> neighbors = current.getNeighbors();
			
			for (Edge<T> edge : neighbors) {
				Node<T> neighbour = edge.getNeighbourOf(current);

				if (!neighbour.isVisited()) {
					int newCumulativeCost = current.getCumulativeCost() + edge.getCost();

					if (!frontier.contains(neighbour)) {
						neighbour.setParent(edge);
						neighbour.setCumulativeCost(newCumulativeCost);
						frontier.add(neighbour);
					} else if (newCumulativeCost < neighbour.getCumulativeCost()) {
						neighbour.setParent(edge);
						neighbour.setCumulativeCost(newCumulativeCost);
					}
				}
			}
		}
		return null; // no path was found
	}

	private static <T> List<Edge<T>> getPath(Node<T> current) {
		List<Edge<T>> path = new ArrayList<>();

		Node<T> aux = current;
		while (aux.getParent() != null) {
			path.add(aux.getParent());
			Edge<T> edge = aux.getParent();
			aux = edge.getNeighbourOf(aux);
		}
		Collections.reverse(path);
		return path;
	}
}
