package ejercicio1;

import java.io.*;
import java.net.*;

public class Servidor {

	final static int PUERTO = 6000;

	public static void main(String[] args) {

		try {
			ServerSocket servidor = new ServerSocket(PUERTO);
			PrintWriter salida;
			String msg = "";
			Socket socket = null;
			
			System.out.println("Esperando la conexion de un cliente...");

			socket = servidor.accept();

			System.out.println("Recibida la conexion del cliente ");
			
			do {
				BufferedReader lectura;
				lectura = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				msg = lectura.readLine();
				
				msg = msg.toUpperCase();
				
				salida = new PrintWriter(socket.getOutputStream(), true);
				
				salida.println(msg);
			}while(!msg.equalsIgnoreCase("."));
			
			socket.close();
			servidor.close();
		

		}catch(SocketException e) {
			System.err.println("Error en una operacion del socket");
		}catch(IOException e) {
			System.err.println("Error en una operacion de entrada/salida");
		}catch(Exception e) {
			System.err.println("Error en la operacion");
		}

	}

}
