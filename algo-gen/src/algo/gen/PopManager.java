package algo.gen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.graphstream.graph.Node;

import algo.gen.GraphEn;
import algo.gen.Metier;

public class PopManager {
	
	private List<GraphEn> listGraph;
	private List<GraphEn> generationTop10;

	public PopManager() {
		listGraph = new ArrayList<GraphEn>();
		generationTop10 = new ArrayList<GraphEn>();
		generate(100);
	}
	
	public PopManager(int nombre) {
		listGraph = new ArrayList<GraphEn>();
		generationTop10 = new ArrayList<GraphEn>();
		generate(nombre);
	}
	
	public List<GraphEn> getListGraph() {
		return listGraph;
	}

	public void setListGraph(List<GraphEn> listGraph) {
		this.listGraph = listGraph;
	}
	
	public List<GraphEn> getGenerationTop10() {
		return generationTop10;
	}

	public void setGenerationTop10(List<GraphEn> generationTop10) {
		this.generationTop10 = generationTop10;
	}
	
	public void selectTop10() {
		List<GraphEn> forSorting = listGraph;
		Collections.sort(forSorting, new Comparator<GraphEn>() {
			@Override
			public int compare(GraphEn o1, GraphEn o2) {
				return Double.compare(o1.getGraphEnergie(), o2.getGraphEnergie());
			}
		});
		Collections.sort(forSorting, Collections.reverseOrder());
		List<GraphEn> top10 = forSorting.subList(0, 10);
		System.out.println("--------");
		System.out.println("Top 10 :");
		System.out.println("--------");
		for (GraphEn graphEn : top10) {
			System.out.println(graphEn + " : " + graphEn.getGraphEnergie());
			generationTop10.add(graphEn);
		}
	}

	public GraphEn getMinEnergieGraph() {
		GraphEn minGraph = null;
		Metier metier = new Metier();
		Double min = 0.0;
		for (GraphEn graph : listGraph) {
			Double cost = metier.costCalculate(graph);
			graph.setGraphEnergie(cost);
			if(min == 0) {
				min = cost;
				minGraph = graph;
			}
			if(min >= cost) {
				min = cost;
				minGraph = graph;
			}
		}
		return minGraph;
	}

	private void generate(int nombre) {
		for (int i = 0; i < nombre; i++) {
			Random random = new Random();
			random = random == null ? new Random(System.currentTimeMillis()) : random;
			GraphEn graph = new GraphEn("Graph " + i);
			Node a = graph.addNode("A");
			a.addAttribute("xy", random.nextDouble(), random.nextDouble());
			Node b = graph.addNode("B");
			b.addAttribute("xy", random.nextDouble(), random.nextDouble());
			Node c = graph.addNode("C");
			c.addAttribute("xy", random.nextDouble(), random.nextDouble());
			Node d = graph.addNode("D");
			d.addAttribute("xy", random.nextDouble(), random.nextDouble());
			Node e = graph.addNode("E");
			e.addAttribute("xy", random.nextDouble(), random.nextDouble());
			Node f = graph.addNode("F");
			f.addAttribute("xy", random.nextDouble(), random.nextDouble());
			Node g = graph.addNode("G");
			g.addAttribute("xy", random.nextDouble(), random.nextDouble());
			Node h = graph.addNode("H");
			h.addAttribute("xy", random.nextDouble(), random.nextDouble());
			Node ii = graph.addNode("I");
			ii.addAttribute("xy", random.nextDouble(), random.nextDouble());
			Node j = graph.addNode("J");
			j.addAttribute("xy", random.nextDouble(), random.nextDouble());
			Node k = graph.addNode("K");
			k.addAttribute("xy", random.nextDouble(), random.nextDouble());
			graph.addEdge("AC", a, c);
			graph.addEdge("CD", c, d);
			graph.addEdge("CE", c, e);
			graph.addEdge("DB", d, b);
			graph.addEdge("IJ", ii, j);
			graph.addEdge("IK", ii, k);
			graph.addEdge("KJ", k, j);
			graph.addEdge("FG", f, g);
			graph.addEdge("GH", g, h);
			Metier metier = new Metier();
			Double graphEnergie = metier.costCalculate(graph);
			graph.setGraphEnergie(graphEnergie);
			listGraph.add(graph);
		}
	}
	
}
