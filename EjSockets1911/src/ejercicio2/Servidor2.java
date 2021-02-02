package ejercicio2;

import java.io.*;
import java.net.*;

public class Servidor2 {

	public static int PUERTO = 5000;

	public static void main (String[] args) {
		//Declaracion del serverSocket y del socket con el cliente
		Socket cliente = null;
		ServerSocket servidor = null;

		try {

			//Inicializacion del ServerSocket
			servidor = new ServerSocket(PUERTO);

			//Creamos un bucle infinito para mantener abierto el servidor siempre
			while(true) {
				//Esperamos la conexion del cliente
				System.out.println("Esperando la conexion de un cliente...");
				cliente = servidor.accept();
				System.out.println("Recibida la conexion de un cliente...");

				//Inicializacion del hilo en el que realizaremos todo el proceso para conseguir la concurrencia
				HiloCliente2 h = new HiloCliente2(cliente);
				new Thread(h).start();
			}



		}catch (SocketException e) {
			System.err.println("Error en una operacion de socket");
		}
		catch (IOException e) {
			System.err.println("Error en una operacion de entrada/salida");
		}finally {
			//Cerramos los sockets del cliente y el ServerSocket
			try {
				cliente.close();
				servidor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
