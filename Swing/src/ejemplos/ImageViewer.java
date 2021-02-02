package ejemplos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class ImageViewer {

	private JFrame frame;

	public ImageViewer() {
		makeFrame();
	}
/*
	private void openFile() {
		System.out.println("Open file");
	}
	private void quit() {
		System.exit(0);
	}
*/
	private void makeFrame() {
		frame = new JFrame("ImageViewer");

		JLabel label = new JLabel("I am a label. I can display some text.");

		frame.add(label);
		label.setText("Nuevo mensaje en la etiqueta");
		/*
		JButton b = new JButton("boton");

		frame.add(b);
		 */
		frame.pack();
		frame.setVisible(true);	//Obligatorio para poder ver la ventana
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.out.println("Datos guardados");
				System.exit(0);
		}
		});
	}
/*
	private void makeMenuBar(JFrame frame) {
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);

		JMenu fileMenu = new JMenu("File");
		menubar.add(fileMenu);

		JMenuItem openItem = new JMenuItem("Open");
		openItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){ openFile();
			}
		});
		fileMenu.add(openItem);
		
		JMenuItem quitItem = new JMenuItem("Quit");
		quitItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){ quit();
			}
		});
		fileMenu.add(quitItem);
		
	}
*/
}
