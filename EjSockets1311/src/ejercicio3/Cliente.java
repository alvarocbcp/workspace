package ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Cliente {

	public static void main(String[] args) {
		
		String simbolo = "";
		float resultado = 0;
		
		try {
			Socket misocket = new Socket(args[0], Integer.parseInt(args[1]));
			BufferedReader lectura = new BufferedReader(new InputStreamReader(misocket.getInputStream()));
			PrintWriter salida = new PrintWriter(misocket.getOutputStream(), true);
			
			do {
				do {
					simbolo = JOptionPane.showInputDialog("Introduce el simbolo *, /, +, - o $");
				}while(!simbolo.equalsIgnoreCase("*") && !simbolo.equalsIgnoreCase("/") && !simbolo.equalsIgnoreCase("-") && !simbolo.equalsIgnoreCase("+") && !simbolo.equalsIgnoreCase("$"));
				if(simbolo.equalsIgnoreCase("$")) {
					JOptionPane.showMessageDialog(null, "HASTA PRONTO");
					salida.println(simbolo);
				}
				else {
					float num1 = Float.parseFloat(JOptionPane.showInputDialog("Introduce el primer numero"));
					float num2 = Float.parseFloat(JOptionPane.showInputDialog("Introduce el segundo numero"));
					salida.println(simbolo);
					salida.println(num1);
					salida.println(num2);
					JOptionPane.showMessageDialog(null, lectura.readLine());
				}
			}while(!simbolo.equalsIgnoreCase("$"));
			misocket.close();
		}catch(UnknownHostException e) {
			System.err.println("Nombre de maquina servidora desconocida");
		}catch(ConnectException e) {
			System.err.println("El servidor no esta conectado");
		}catch(SocketException e) {
			System.err.println("Error en una operacion del Socket");
		}catch(IOException e) {
			System.err.println("Error en la lectura/escritura");
		}catch(Exception e) {
			System.err.println("Error en la operacion");
		}
	}

}
