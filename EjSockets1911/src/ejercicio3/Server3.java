package ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server3 {

	public static void main(String[] args) {
		try {
			ServerSocket servidor = new ServerSocket(Integer.parseInt(args[0]));
			PrintWriter salida1;
			BufferedReader lectura1;
			PrintWriter salida2;
			BufferedReader lectura2;
			Socket socket1;
			Socket socket2;
			String msg1="";
			String msg2="";


			System.out.println("Esperando la conexion de un cliente...");
			socket1 = servidor.accept();
			System.out.println("Recibida la conexion del cliente 1");
			System.out.println("------------------------------------------");
			System.out.println("Esperando la conexion de un cliente...");
			socket2 = servidor.accept();
			System.out.println("Recibida la conexion del cliente 2");
			
			salida1 = new PrintWriter(socket1.getOutputStream(), true);
			lectura1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
			salida2 = new PrintWriter(socket2.getOutputStream(), true);
			lectura2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
			
			while(!msg1.equalsIgnoreCase("FIN")) {
				msg1 = lectura1.readLine();
				if(!msg1.equalsIgnoreCase("FIN")) {
					salida2.println(msg1);
					msg2 = lectura2.readLine();
					salida1.println(msg2);
				}
				else {
					salida2.println(msg1);
				}
			}	
			
			System.out.println("Cierre del socket 1");
			socket1.close();
			System.out.println("Cierre del socket 2");
			socket2.close();
			System.out.println("Cierre del servidor");
			servidor.close();
		}catch(SocketException e) {
			System.err.println("Error en una operacion del socket");
		}catch(IOException e) {
			System.err.println("Error en una operacion de entrada/salida");
		}catch(Exception e) {
			System.err.println(e);
		}
	}

}
