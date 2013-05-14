package interview2013.questions.algo;

import interview2013.util.Question;

public class CycleInGraph extends Question {

	@Override
	public String getQuestion() {
		String str = "find a cycle in a graph\n";
		str += "For undirected graph, do DFS until see a visited node\n";
		str += "For Directed graph, http://en.wikipedia.org/wiki/Tarjan%27s_strongly_connected_components_algorithm\n";
		return str;
	}
	
	public void findCycleForUndirectedGrpah(){
		
	}

}
