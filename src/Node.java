

public class Node {

	// ===========================================================
	// Pola
	// ===========================================================

	/**
	 * @param x
	 *            - po³o¿enie x
	 * @param y
	 *            - po³o¿enie y
	 * @param Uy
	 *            - todo
	 */
	float x, y;
	float Ux, Uy;
	boolean status;
	
	//gówno do testów funkcji profesora
	int sizeLOK;
	int LOK[];

	// ===========================================================
	// Konstruktory
	// ===========================================================

	public Node(float xi, float yi, int Uxi, int Uyi, boolean statusi) {
		x = xi;
		y = yi;
		Ux = Uxi;
		Uy = Uyi;
		status = statusi;
	}
	
	

}
