package ejemplos;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

public class ImageViewerMain {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ImageViewer();
				}catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});

	}

}
