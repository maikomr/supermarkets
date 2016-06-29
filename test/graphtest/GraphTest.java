package graphtest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Graph;
import model.Node;
import model.UniformCostSearch;

public class GraphTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGraph() {
		Graph<String> g = new Graph<>();
		Node<String> n1 = new Node<>("Hypermaxi 1");
		Node<String> n2 = new Node<>("Hypermaxi 2");
		Node<String> n3 = new Node<>("Hypermaxi 3");
		Node<String> n4 = new Node<>("IC Norte 1");
		Node<String> n5 = new Node<>("IC Norte 2");
		
		g.addEdge(n1, n2, 4);
		g.addEdge(n1, n4, 25);
		g.addEdge(n2, n3, 2);
		g.addEdge(n3, n4, 4);
		g.addEdge(n4, n5, 2);
		
		System.out.println(UniformCostSearch.execute(g, n1, n5));
	}
}
