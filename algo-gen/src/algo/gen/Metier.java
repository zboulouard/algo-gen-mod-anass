package algo.gen;

import java.util.Collection;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.ui.graphicGraph.GraphPosLengthUtils;

public class Metier {
	
	// Distance entre deux noeuds
	private Double distance(Node n1, Node n2) {
		Double d = 0.0;
		Edge e = n1.getEdgeBetween(n2);
		if(e==null) {
			d = distEuc(n1, n2);
		} else {
			try {
				d = GraphPosLengthUtils.edgeLength(e);
			} catch (Exception e2) {}
		}
		return d;
	}
	
	// Distance Euclidienne
	private Double distEuc(Node n1, Node n2) {
		Double d = 0.0;
		Object[] n1Attributes = n1.getAttribute("xy");
		Double x1 = (Double) n1Attributes[0];
		Double y1 = (Double) n1Attributes[1];
		Object[] n2Attributes = n2.getAttribute("xy");
		Double x2 = (Double) n2Attributes[0];
		Double y2 = (Double) n2Attributes[1];
		d = Math.sqrt((Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
		return d;
	}
	
	// Calculer la fitness ou fonction objectif
	public Double costCalculate(GraphEn g) {
		Double cost = 0.0;
		Collection<Node> nodeList = g.getNodeSet();
		for (int i=0; i<nodeList.size(); i++) {
			for (int j=i+1; j<nodeList.size(); j++) {
				cost+=energie(g.getNode(i), g.getNode(j));
			}
		}
		return cost;
	}
	
	// Expression d'énérgie
	public Double energie(Node n1, Node n2) {
		Double energie = 0.0;
		int K = 1;
		Edge e = n1.getEdgeBetween(n2);
		if(e==null) {
			energie = -Math.pow(K, 2) * Math.log(distance(n1, n2));
		} else {
			try {
				energie = Math.pow(distEuc(n1, n2), 3) / (3 * K);
			} catch (Exception e2) {}
		}
		return energie;
	}
}
