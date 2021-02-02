package layouts;
import java.awt.*;
import javax.swing.*;

/**
 * Ejemplo de GridLayout.
 * 
 */
public class GridLayoutExample
{
	private JFrame frame;

	/**
	 * Constructor for objects of class GridLayoutExample
	 */
	public GridLayoutExample()
	{
		makeFrame();
	}

	/**
	 * Create a 3x2 grid and place five components within it.
	 */
	private void makeFrame()
	{
		frame = new JFrame("GridLayout Example");

		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new GridLayout(3, 2)); // 3 filas por 2 columnas
		contentPane.add(new JButton("first"));
		contentPane.add(new JButton("second"));
		contentPane.add(new JButton("the third string is very long"));
		contentPane.add(new JButton("fourth"));
		contentPane.add(new JButton("fifth"));

		// Añadido
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.pack();
		frame.setVisible(true);
	}

	// Añadido

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					new GridLayoutExample();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}