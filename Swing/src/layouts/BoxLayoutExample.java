package layouts;
import java.awt.*;
import javax.swing.*;

/**
 *  Ejemplo de BoxLayout.
 * 
 */

public class BoxLayoutExample
{
	private JFrame frame;

	/**
	 * Constructor for objects of class BoxLayoutExample
	 */
	public BoxLayoutExample()
	{
		makeFrame();
	}

	/**
	 * Create a BoxLayout and place five components within it.
	 */
	private void makeFrame()
	{
		frame = new JFrame("BoxLayout Example");

		Container contentPane = frame.getContentPane();
		//contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		contentPane.add(new JButton("first"));
		contentPane.add(new JButton("second"));
		contentPane.add(new JButton("the third string is very long"));
		contentPane.add(new JButton("fourth"));
		contentPane.add(new JButton("fifth"));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.pack();
		// Si no hacemos pack, tenemos que establecer el tamaño para que se ajusten los componentes
		//frame.setBounds(10, 10, 200, 200);
		frame.setVisible(true);
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					new BoxLayoutExample();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
