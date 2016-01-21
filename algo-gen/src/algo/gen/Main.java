package algo.gen;

public class Main {

	public static void main(String[] args) {
		PopManager popManager = new PopManager();
//		GraphEn minGraph = popManager.getMinEnergieGraph();
//		System.out.println("Min = " + minGraph);
//		System.out.println("Energie Min = " + minGraph.getGraphEnergie());
		popManager.selectTop10();
		
	}


}
