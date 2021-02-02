package layouts;
import java.awt.*;
import javax.swing.*;


/**
 * Ejemplo de BorderLayout.
 * 
 */
public class BorderLayoutExample
{
	private JFrame frame;

	/**
	 * Constructor for objects of class BorderLayoutExample
	 */
	public BorderLayoutExample()
	{
		makeFrame();
	}

	/**
	 * Place five components in the available regions.
	 */
	private void makeFrame()
	{
		frame = new JFrame("BorderLayout Example");

		Container contentPane = frame.getContentPane();

		contentPane.setLayout(new BorderLayout());

		contentPane.add(new JButton("north"), BorderLayout.NORTH);
		contentPane.add(new JButton("south"), BorderLayout.SOUTH);
		contentPane.add(new JButton("center"), BorderLayout.CENTER);
		contentPane.add(new JButton("west"), BorderLayout.WEST);
		contentPane.add(new JButton("east"), BorderLayout.EAST);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {					
	//					new BorderLayoutExample();
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	public static void main(String[] args) {


		new BorderLayoutExample();

	}
}
