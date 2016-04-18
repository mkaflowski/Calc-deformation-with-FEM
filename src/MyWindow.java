import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class MyWindow extends JFrame {
	
	Grid grid;
	Area area;
	
	JLabel JLxNodes, JLyNodes;
	JTextArea JTxNodes, JTyNodes;
	
	public MyWindow(){
		super("MES2PC");
		setSize(420, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		setVisible(true);
		// inicjalizacja: =============================================
		JLxNodes = new JLabel("Liczba wêz³ów poziomo: ");
		JTxNodes = new JTextArea("6");

		JLyNodes = new JLabel("Liczba wêz³ów pionowo: ");
		JTyNodes = new JTextArea("6");
		
		
		// dodawanie na ekran: =========================================
		add(JLxNodes);
		add(JTxNodes);
		add(JLyNodes);
		
		calc();
		
	}

	private void calc() {
		System.out.println("ROZPOCZYNAM OBLICZENIA:\n"); // Display the string.
		area = new Area(10, 10, Integer.parseInt(JTxNodes.getText()), 6);
		grid = new Grid(area, 32);
		//grid = new Grid();
		Solution solution = new Solution(grid);
		try {
			solution.solve();
		} catch (IOException e) {
			System.out.print("\n\n!!!!!BLAD ZAPISU!!!!!\n\n");
			e.printStackTrace();
		}
		System.out.print("\nKONIEC OBLICZEN");
	}

}
