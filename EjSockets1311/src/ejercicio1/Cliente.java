package ejercicio1;

import java.io.*;
import java.net.*;
import javax.swing.*;

public class Cliente {
	
	final static String IP="localhost";
	final static int PUERTO = 6000;

	public static void main(String[] args) {
		
		String msg = "";
		PrintWriter salida;
		
		try {
			Socket misocket = new Socket(IP, PUERTO);
			do {
				msg = JOptionPane.showInputDialog("Escribe una frase para transformar");
				
				
				salida = new PrintWriter(misocket.getOutputStream(), true);
				
				salida.println(msg);
				
				
				BufferedReader lectura;
				lectura = new BufferedReader(new InputStreamReader(misocket.getInputStream()));
				System.out.println("Mensaje del servidor: " + lectura.readLine());
			}while(!msg.equalsIgnoreCase("."));
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
