

public class Area {

	// ===========================================================
	// Pola
	// ===========================================================
	/**
	 * Obszar prostok¹tny
	 * 
	 * @param x
	 *            - szerokoœæ
	 * @param y
	 *            - wysokoœæ
	 * @param nhX
	 *            - liczba elementów po szerokoœci
	 * @param nhY
	 *            - liczba elementów po wysokoœci
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
