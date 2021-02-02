package gui_ucm;

import javax.swing.*;
import java.awt.*;

public class Gui02 extends JFrame {
	private static final long serialVersionUID = 1L;
	Container panel;

	public Gui02() {
		super("Ejemplo de Layout");
		// Configurar componentes ;
		panel = this.getContentPane();
		// Configurar layout ;
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

		for (int i = 1; i <= 10; i++)
			panel.add(new JButton("Componente " + i));

		//setSize(200, 200);
		setVisible(true);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		Gui02 ventana = new Gui02();
	}
}