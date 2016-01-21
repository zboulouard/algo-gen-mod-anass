package algo.gen;

import org.graphstream.graph.implementations.MultiGraph;

public class GraphEn extends MultiGraph implements Comparable<GraphEn> {
	
	private Double graphEnergie;
	
	public GraphEn(String id) {
		super(id);
	}

	public GraphEn(String id, boolean strictChecking, boolean autoCreate, int initialNodeCapacity,
			int initialEdgeCapacity) {
		super(id, strictChecking, autoCreate, initialNodeCapacity, initialEdgeCapacity);
	}

	public GraphEn(String id, boolean strictChecking, boolean autoCreate) {
		super(id, strictChecking, autoCreate);
	}

	public Double getGraphEnergie() {
		return graphEnergie;
	}

	public void setGraphEnergie(Double graphEnergie) {
		this.graphEnergie = graphEnergie;
	}

	@Override
	public int compareTo(GraphEn o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
