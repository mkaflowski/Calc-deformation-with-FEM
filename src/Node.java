

public class Node {

	// ===========================================================
	// Pola
	// ===========================================================

	/**
	 * @param x
	 *            - po�o�enie x
	 * @param y
	 *            - po�o�enie y
	 * @param Uy
	 *            - todo
	 */
	float x, y;
	float Ux, Uy;
	boolean status;
	
	//g�wno do test�w funkcji profesora
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
