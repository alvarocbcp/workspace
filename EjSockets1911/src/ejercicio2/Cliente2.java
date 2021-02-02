package ejercicio2;

import java.io.*;
import java.net.*;

public class Cliente2 {
	
	public static int NBYTES = 2048;
	
	public static String IP = "localhost";
	public static int PUERTO = 5000;
	
	public static void main(String[] args){
		
		//Creacion de la entrada y salida de datos del archivo binario
		BufferedInputStream BIS = null;
		BufferedOutputStream BOS = null;
		
		//Creacion del socket con el servidor
		Socket miSocket = null;
		
		try {
			//Inicializacion del socket
			miSocket = new Socket(IP, PUERTO);
			
			String nombreFich = "Invierno.jpg";
			
			//Inicializacion de la entrada y salida de datos del archivo binario y del socket
			BIS = new BufferedInputStream(new FileInputStream(nombreFich));
			BOS = new BufferedOutputStream(miSocket.getOutputStream());
			
			//Declaracion del array con el que voy a leer los datos del fichero
			byte[] array = new byte[NBYTES];
			
			int leidos = BIS.read(array);
			
			//Bucle para recorrer el fichero leyendolo y escribiendolo por el socket al mismo tiempo
			while(leidos>0) {
				BOS.write(array, 0, leidos);
				leidos = BIS.read(array);
			}
			
		}catch (UnknownHostException e) {
			System.err.println("Nombre de maquina servidora desconocida");
		} catch (ConnectException e) {
			System.err.println("El servidor no esta conectado en " + IP);
		} catch (SocketException e) {
			System.err.println("Error en una operacion del socket");
		} catch (IOException e) {
			System.err.println("Error en la lectura/escritura");
		}finally {
			try {
				BIS.close();
				BOS.close();
				miSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
