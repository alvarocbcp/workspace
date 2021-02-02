package ejercicios;

import javax.swing.JOptionPane;

public class Ejercicio1_6_Main {

	public static void main(String[] args) {
		
		int n1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el primer numero"));
		
		int n2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el segundo numero"));
		
		int suma;
		
		suma = n1 + n2;
		
		JOptionPane.showMessageDialog(null, "La suma de los numero dados es: " + suma);
		
	}

}
