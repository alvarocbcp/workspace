package ejemplosClase;

import java.io.*;
import java.net.*;

public class Cliente {
	
	final static String IP="localhost";
	final static int PUERTO=6000;
	
	public static void main(String[] args) {
		
		try {
			Socket misocket = new Socket(IP, PUERTO);
			//Socket enlazado al puerto 6000 en la maquina "10.0.2.15"
			BufferedReader lectura;
			
			
			//Creamos el Buffer que nos permitira leer la informacion que nos llegue a traves del socket
			lectura = new BufferedReader(new InputStreamReader(misocket.getInputStream()));
			
			//Leemos lo que nos llega del servidor, y lo mostramos por la pantalla
			System.out.println("Mensaje del servidor: " + lectura.readLine());
			
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
