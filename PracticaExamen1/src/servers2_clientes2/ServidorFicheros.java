package servers2_clientes2;

import java.net.*;
import java.io.*;

public class ServidorFicheros {
	
	public static String RUTA = "ficheros/";
	private static int PUERTO = 5500;

	public static void main(String[] args) {

		try {
			//Creo el ServerSocket
			ServerSocket servidor = new ServerSocket(PUERTO);
			
			//Creo el socket con el Cliente1
			System.out.println("Esperando la conexion del cliente ");
			Socket socket = servidor.accept();
			System.out.println("Recibida la conexion del cliente ");
			
			//Creo la entrada/salida con el Cliente1
			PrintWriter PW = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader BR = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//Recibo el fichero que quiero enviar y creo un FileReader para leerlo
			int numFichero = Integer.parseInt(BR.readLine());
			FileReader FR = new FileReader(RUTA + "prueba" + numFichero + ".txt");
			BufferedReader BRF = new BufferedReader(FR);
			
			String cadena="";
			
			while((cadena = BRF.readLine())!=null) {
				//Envio el contenido del archivo al Cliente1
				PW.println(cadena);
				System.out.println(cadena);
			}
			
			//Cierro el BufferedReader del fichero
			BRF.close();
			
			//Cierro los sockets
			servidor.close();
			socket.close();			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
