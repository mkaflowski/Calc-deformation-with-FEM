

public class Area {

	// ===========================================================
	// Pola
	// ===========================================================
	/**
	 * Obszar prostok�tny
	 * 
	 * @param x
	 *            - szeroko��
	 * @param y
	 *            - wysoko��
	 * @param nhX
	 *            - liczba element�w po szeroko�ci
	 * @param nhY
	 *            - liczba element�w po wysoko�ci
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
