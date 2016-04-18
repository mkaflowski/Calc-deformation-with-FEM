


public class Element {

	// ===========================================================
	// Pola
	// ===========================================================
	Node[] nodes;
	int Nop;
	
	int nop[];

	// ===========================================================
	// Konstruktory
	// ===========================================================
	
	public Element(Node node1, Node node2, Node node3, int Nopi){
		nodes = new Node[3];
		nodes[0] = node1;
		nodes[1] = node2;
		nodes[2] = node3;
		Nop = Nopi;
		
		nop = new int[3];
	}
	
	//sprawdza czy element posiada wêze³
	public boolean hasNode(Node node){
		for (int i = 0; i < nodes.length; i++) {
			if(nodes[i] == node){
				//Log.i("MES2 GRID", "NIE SASIAD");
				return true;}
		}
		//Log.i("MES2 GRID", "NIE SASIAD");
		return false;
	}
}
