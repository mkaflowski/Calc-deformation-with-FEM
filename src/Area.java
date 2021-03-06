

public class Area {

	// ===========================================================
	// Pola
	// ===========================================================
	/**
	 * Obszar prostokątny
	 * 
	 * @param x
	 *            - szerokość
	 * @param y
	 *            - wysokość
	 * @param nhX
	 *            - liczba elementów po szerokości
	 * @param nhY
	 *            - liczba elementów po wysokości
	 */
	float x;
	float y;

	int nhX;
	int nhY;

	// ===========================================================
	// Konstruktory
	// ===========================================================

	public Area(float x1, float y1, int nhX1, int nhY1) {
		x = x1;
		y = y1;

		nhX = nhX1;
		nhY = nhY1;
	}
}
