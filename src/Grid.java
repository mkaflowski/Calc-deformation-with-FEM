
public class Grid {

	// ===========================================================
	// Pola
	// ===========================================================
	/**
	 * @param nh
	 *            - liczba wêz³ów
	 * @param ne
	 *            - liczba elementów (nh+1)
	 * @param elements
	 *            - tablica przechowuj¹ca siatkê elementów
	 */
	int nh, ne;
	Element[] elements;
	Node[] nodes;
	float dx, dy;
	float dVel;
	float Udown, Uup;

	// ===========================================================
	// Konstruktory
	// ===========================================================

	public Grid(Area area, int nei) {
		Udown = 1f;
		Uup = -1f;
		dVel = 0.0005f;

		nh = area.nhX * area.nhY + 1;
		ne = (area.nhX - 1) * (area.nhY - 1) * 2;
		dx = area.x / (area.nhX - 1);
		dy = area.y / (area.nhY - 1);

		elements = new Element[ne];
		nodes = new Node[nh + 1];

		genNodes(area);

		genElements(area);
	}

	// ===========================================================
	// Metody
	// ===========================================================

	private void genElements(Area area) {
		int id = 0;
		for (int j = 1; j <= area.nhY - 1; j++) {
			for (int i = 1; i <= area.nhX - 1; i++) {
				// ih = j + (i - 1) * (nhH - 1);

				// Log.i("MES2 checkpoint", "1");

				int n1 = j + (i - 1) * area.nhY + area.nhY + 1;
				int n2 = j + (i - 1) * area.nhY + 1;
				int n3 = j + (i - 1) * area.nhY;
				int n4 = j + (i - 1) * area.nhY + area.nhY;

				// Log.i("MES2 n2", Integer.toString(n2));
				elements[id] = new Element(nodes[n1], nodes[n3], nodes[n2], id);

				elements[id].nodes[0] = nodes[n1];
				elements[id].nodes[1] = nodes[n3];
				elements[id].nodes[2] = nodes[n2];

				elements[id + 1] = new Element(nodes[n1], nodes[n4], nodes[n3],
						id + 1);

				elements[id + 1].nodes[0] = nodes[n1];
				elements[id + 1].nodes[1] = nodes[n4];
				elements[id + 1].nodes[2] = nodes[n3];

				id += 2;
			}
		}
	}

	private void genNodes(Area area) {
		float y = 0;
		int id = 1;

		for (int i = 1; i <= area.nhY; i++) {
			// Log.i("MES2 checkpoint", "0");
			float x = 0;
			for (int j = 1; j <= area.nhX; j++) {

				nodes[id] = new Node(x, y, 0, 0, false);
				nodes[id].x = x;
				nodes[id].y = y;
				nodes[id].status = false;
				if (i == 1) {
					nodes[id].status = true;
					nodes[id].Ux = 0;
					nodes[id].Uy = Udown;
				}
				if (i == area.nhY) {
					nodes[id].status = true;
					nodes[id].Ux = 0;
					nodes[id].Uy = Uup;
				}
				x = x + dx;
				id += 1;

			}
			y = y + dy;
		}
	}

}
