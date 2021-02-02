package ejemplosClase;

import java.io.*;
import java.net.*;

public class Servidor {
	
	final static int NUMCLI = 3;
	final static int PUERTO = 6000;

	public static void main(String[] args) {
		
		try {
			//Creamos un Socket servidor
			ServerSocket servidor = new ServerSocket(PUERTO);
			PrintWriter salida;
			
			for(int i=0; i<NUMCLI; i++) {
				//Esperamos a que se conecte el cliente
				System.out.println("Esperando la conexion de un cliente...");
				
				Socket cliente = servidor.accept();
				
				System.out.println("Recibida la conexion del cliente " + i);
				
				//Creamos el buffer para enviar al cliente informacion a traves del Socket
				
				//salida = new PrintWriter(cliente.getOutputStream());
				salida = new PrintWriter(cliente.getOutputStream(), true);
				String msg = " Hola cliente " + i;
				
				salida.println(msg); //Mensaje hacia el cliente
				//salida.flush(); Necesario si no pongo el parametro autoflush a true
				
				cliente.close();	//Cerramos el socket asignado al cliente
			}
			servidor.close();		//Cerramos el soocket servidor
		}catch(SocketException e) {
			System.err.println("Error en una operacion del socket");
		}catch(IOException e) {
			System.err.println("Error en una operacion de entrada/salida");
		}catch(Exception e) {
			System.err.println("Error en la operacion");
		}

	}

}
