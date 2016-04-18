import java.awt.EventQueue;
import java.io.IOException;


class MES2PC {
	static Grid grid;
	static Area area;

	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new MyWindow();
			}
		});
	}
}
