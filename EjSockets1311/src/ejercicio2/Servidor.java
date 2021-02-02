package ejercicio2;

import java.io.*;
import java.net.*;

public class Servidor {

	public static void main(String[] args) {
		
		try {
			ServerSocket servidor = new ServerSocket(Integer.parseInt(args[0]));
			PrintWriter salida;
			BufferedReader lectura;
			String msg="";
			Socket socket;
			int numero;
			int cuadrado;
			
			System.out.println("Esperando la conexion de un cliente...");
			socket = servidor.accept();
			System.out.println("Recibida la conexion del cliente ");
			salida = new PrintWriter(socket.getOutputStream(), true);
			lectura = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			for(int i=0; i<Cliente.getNumElementos(); i++) {
				msg = lectura.readLine();
				numero = Integer.parseInt(msg);
				cuadrado = (int) Math.pow(numero, 2);
				System.out.println("Numero: " + numero + " Cuadrado: " + cuadrado);
				
				salida.println(cuadrado);
			}
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
