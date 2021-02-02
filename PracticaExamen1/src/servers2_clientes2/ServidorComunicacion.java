package servers2_clientes2;

import java.io.*;
import java.net.*;

public class ServidorComunicacion {
	
	private static int PUERTO = 5600;

	public static void main(String[] args) {
		
		try {
			//Creo el serverSocket
			ServerSocket servidor = new ServerSocket(PUERTO);
			
			//Creo el socket con el Cliente1
			System.out.println("Esperando la conexion del cliente ");
			Socket socket1 = servidor.accept();
			System.out.println("Recibida la conexion del cliente ");
			
			//Creo el socket con el Cliente2
			System.out.println("Esperando la conexion del cliente ");
			Socket socket2 = servidor.accept();
			System.out.println("Recibida la conexion del cliente ");
			
			//Creo la entrada de datos del Cliente1
			BufferedReader BR1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
			
			//Creo la salida de datos del Cliente2
			PrintWriter PW2 = new PrintWriter(socket2.getOutputStream(), true);
			
			String msg = "";
			
			//Leo el fichero enviado por el Cliente1
			while((msg = BR1.readLine())!=null) {
				//Mando el contenido del fichero al Cliente2
				PW2.println(msg);
				System.out.println(msg);
			}
			
			//Cierro los sockets
			socket1.close();
			socket2.close();
			servidor.close();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
