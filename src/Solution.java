import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Solution {

	public Grid grid;

	public Solution(Grid gridi) {
		grid = gridi;
	}

	public void solve() throws IOException {
		logGrid();

		drawImage("before.jpg");
		savePointsToFile("before-punkty.txt");

		int ih;
		int iter;
		float F0 = 0;
		float Fplus = 0;
		for (iter = 0; iter < 4000; iter++) {
			// Log.i("MES", Integer.toString(iter)+". ");
			for (ih = 1; ih < grid.nh; ih++) {
				if (grid.nodes[ih].status == false) {

					F0 = getFunFromNode(ih);
					grid.nodes[ih].Ux += grid.dVel;
					Fplus = getFunFromNode(ih);
					// Log.i("MES2",
					// "ih="+Integer.toString(ih)+". "+Float.toString(F0)+"  "+Float.toString(Fplus));
					if (Fplus > F0)
						grid.nodes[ih].Ux -= 2 * grid.dVel;

					grid.nodes[ih].Uy += grid.dVel;
					Fplus = getFunFromNode(ih);
					if (Fplus > F0)
						grid.nodes[ih].Uy -= 2 * grid.dVel;

				}

				if (grid.nodes[ih].status == true) {
					F0 = getFunFromNode(ih);
					grid.nodes[ih].Ux += grid.dVel;
					Fplus = getFunFromNode(ih);
					if (Fplus > F0)
						grid.nodes[ih].Ux -= 2 * grid.dVel;
				}
			}
		}

		for (ih = 1; ih < grid.nh; ih++) {
			grid.nodes[ih].x = grid.nodes[ih].x + grid.nodes[ih].Ux;
			grid.nodes[ih].y = grid.nodes[ih].y + grid.nodes[ih].Uy;
		}

		logGrid();
		logU();

		drawImage("after.jpg");
		savePointsToFile("after-punkty.txt");
		saveUToFile("after-U.txt");
	}

	private void logU() {
		// Log.e("MES2 GRID", "/////////////////////////////////");
		System.out.print("\n/////////////////////////////////\n");
		for (int i = 1; i < grid.nh; i++) {
			System.out.print(Integer.toString(i) + ".  Ux = "
					+ Float.toString(grid.nodes[i].Ux) + "  Uy = "
					+ Float.toString(grid.nodes[i].Uy) + "\n");
		}
		System.out.print("/////////////////////////////////\n");
	}

	private void logGrid() {
		System.out.print("\n/////////////////////////////////\n");
		for (int i = 1; i < grid.nh; i++) {
			System.out.print(Integer.toString(i) + ".  x = "
					+ Float.toString(grid.nodes[i].x) + "  y = "
					+ Float.toString(grid.nodes[i].y) + "\n");
		}
		System.out.print("/////////////////////////////////\n");
	}

	private void savePointsToFile(String filename) throws IOException {

		BufferedWriter buff = new BufferedWriter(new FileWriter(filename));
		buff.write("\t\t---PUNKTY---"+System.getProperty("line.separator")+System.getProperty("line.separator"));
		buff.write("\tx\t\t\ty"+System.getProperty("line.separator"));
		buff.write("----------------------------------------------------"+System.getProperty("line.separator"));
		for (int i = 1; i < grid.nh; i++) {

			buff.write(Integer.toString(i) + ".\t"
					+Float.toString(grid.nodes[i].x) + "\t\t"
					+ Float.toString(grid.nodes[i].y)
					+ System.getProperty("line.separator"));
		}
		buff.close();
		
		System.out.print("\nZAPISANO PLIK: " + filename + "\n");

	}

	private void saveUToFile(String filename) throws IOException {

		BufferedWriter buff = new BufferedWriter(new FileWriter(filename));
		buff.write("\t\t---PRZEMIESZCZENIE---"+System.getProperty("line.separator")+System.getProperty("line.separator"));
		buff.write("\tUx\t\t\tUy"+System.getProperty("line.separator"));
		buff.write("----------------------------------------------------"+System.getProperty("line.separator"));
		for (int i = 1; i < grid.nh; i++) {

			buff.write(Integer.toString(i) + ".\t"
					+Float.toString(grid.nodes[i].Ux) + "\t\t"
					+ Float.toString(grid.nodes[i].Uy)
					+ System.getProperty("line.separator"));
		}
		buff.close();
		
		System.out.print("\nZAPISANO PLIK: " + filename + "\n");

	}

	public void drawImage(String filename) throws IOException {
		int transform = 5;
		int scale = 40;

		BufferedImage image = new BufferedImage(1380, 720,
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D) image.getGraphics();

		for (int i = 1; i < grid.nh; i++) {
			g2.setColor(Color.GRAY);
			// zaznaczanie punktów
			g2.drawOval((int) ((grid.nodes[i].x + transform) * scale) - 5,
					(int) ((grid.nodes[i].y + transform) * scale) - 5, 10, 10);
			g2.drawString(Integer.toString(i),
					(int) ((grid.nodes[i].x + transform) * scale) + 5,
					(int) ((grid.nodes[i].y + transform) * scale));

			// wypisywanie punktów
			g2.setColor(Color.MAGENTA);
			g2.drawString(
					Integer.toString(i) + ".    x = "
							+ Float.toString(grid.nodes[i].x) + "    y = "
							+ Float.toString(grid.nodes[i].y)
							+ System.getProperty("line.separator"), 800, 15 * i);

			// wypisywanie przesuniêæ
			g2.setColor(Color.GREEN);
			g2.drawString(
					Integer.toString(i) + ".    Ux = "
							+ Float.toString(grid.nodes[i].Ux) + "    Uy = "
							+ Float.toString(grid.nodes[i].Uy)
							+ System.getProperty("line.separator"), 1100,
					15 * i);
		}

		g2.setColor(Color.WHITE);

		for (int i = 0; i < grid.ne; i++) {
			g2.drawLine(
					(int) ((grid.elements[i].nodes[0].x + transform) * scale),
					(int) ((grid.elements[i].nodes[0].y + transform) * scale),
					(int) ((grid.elements[i].nodes[1].x + transform) * scale),
					(int) ((grid.elements[i].nodes[1].y + transform) * scale));
			g2.drawLine(
					(int) ((grid.elements[i].nodes[2].x + transform) * scale),
					(int) ((grid.elements[i].nodes[2].y + transform) * scale),
					(int) ((grid.elements[i].nodes[1].x + transform) * scale),
					(int) ((grid.elements[i].nodes[1].y + transform) * scale));
			g2.drawLine(
					(int) ((grid.elements[i].nodes[2].x + transform) * scale),
					(int) ((grid.elements[i].nodes[2].y + transform) * scale),
					(int) ((grid.elements[i].nodes[0].x + transform) * scale),
					(int) ((grid.elements[i].nodes[0].y + transform) * scale));
		}

		if(ImageIO.write(image, "jpg", new File(filename)))
			System.out.print("\nZAPISANO OBRAZ: " + filename + "\n");
		else System.out.print("\nZAPIS OBRAZU NIE POWIÓD£ SIÊ: " + filename + "\n");
	}

	private float getFunFromNode(int ih) {

		float Je = 0;
		float result = 0;
		for (int i = 0; i < grid.ne; i++) {
			if (grid.elements[i].hasNode(grid.nodes[ih])) {
				// Log.i("MES POSIADA", Integer.toString(i));
				Je = clcFunkconal(grid.elements[i]);
				result += Je;
			}
		}
		return result;

	}

	private float clcFunkconal(Element element) {
		float x[] = new float[3];
		float y[] = new float[3];
		float Ux[] = new float[3];
		float Uy[] = new float[3];
		float Ex;
		float Ey;
		float Exy;
		float Ei;
		float E0;
		float E;
		float k;
		float bi;
		float bj;
		float bk;
		float ci;
		float cj;
		float ck;
		float Ae;
		float Je;
		float L;
		boolean St[] = new boolean[3];
		float Uposl;
		float Jt;

		x[0] = element.nodes[0].x;
		x[1] = element.nodes[1].x;
		x[2] = element.nodes[2].x;

		y[0] = element.nodes[0].y;
		y[1] = element.nodes[1].y;
		y[2] = element.nodes[2].y;

		Ux[0] = element.nodes[0].Ux;
		Ux[1] = element.nodes[1].Ux;
		Ux[2] = element.nodes[2].Ux;

		Uy[0] = element.nodes[0].Uy;
		Uy[1] = element.nodes[1].Uy;
		Uy[2] = element.nodes[2].Uy;

		St[0] = element.nodes[0].status;
		St[1] = element.nodes[1].status;
		St[2] = element.nodes[2].status;

		L = 0;
		Uposl = 0;

		if (St[0] == true)
			if (St[1] == true) {
				L = Math.abs(x[1] - x[0]);
				Uposl = (Ux[1] + Ux[0]) / 2;
			}

		if (St[1] == true)
			if (St[2] == true) {
				L = Math.abs(x[1] - x[2]);
				Uposl = (Ux[1] + Ux[2]) / 2;
			}

		if (St[0] == true)
			if (St[2] == true) {
				L = Math.abs(x[0] - x[2]);
				Uposl = (Ux[0] + Ux[2]) / 2;
			}

		Jt = 0.1f * L * Uposl * Uposl;

		bi = y[1] - y[2];
		ci = x[2] - x[1];
		bj = y[2] - y[0];
		cj = x[0] - x[2];
		bk = y[0] - y[1];
		ck = x[1] - x[0];
		Ae = x[1] * y[2] + x[0] * y[1] + y[0] * x[2] - y[0] * x[1] - y[1]
				* x[2] - x[0] * y[2];

		Ex = (bi * Ux[0] + bj * Ux[1] + bk * Ux[2]) / (2 * Ae);
		Ey = (ci * Uy[0] + cj * Uy[1] + ck * Uy[2]) / (2 * Ae);
		Exy = (bi * Uy[0] + bj * Uy[1] + bk * Uy[2] + ci * Ux[0] + cj * Ux[1] + ck
				* Ux[2])
				/ (4 * Ae);
		Ei = (1.414213f / 3)
				* ((Ex - Ey) * (Ex - Ey) + Ex * Ex + Ey * Ey + 6 * Exy * Exy);
		E0 = (Ex + Ey) / 3;

		E = 1;
		k = 10;

		Je = E * Ei * Ei * Ae + k * E0 * E0 * Ae + Jt;

		return Je;
	}

}
