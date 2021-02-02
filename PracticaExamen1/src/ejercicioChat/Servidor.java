package ejercicioChat;

import java.io.*;
import java.net.*;

public class Servidor {
	
	final static int PUERTO = 5000;

	public static void main(String[] args) {
		
		Socket socket1 = null;
		Socket socket2 = null;
		ServerSocket servidor = null;
		
		try {
			servidor = new ServerSocket(PUERTO);
			
			System.out.println("Esperando a la conexion del primer cliente");
			socket1 = servidor.accept();
			System.out.println("Primer cliente conectado");
			
			System.out.println("Esperando a la conexion del segundo cliente");
			socket2 = servidor.accept();
			System.out.println("Segundo cliente conectado");
			
			//Cuando ambos clientes esten conectados, creo los flujos de entradas y salidas con ambos.
			BufferedReader BR1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));	//Entrada de datos del primer cliente
			PrintWriter PW1 = new PrintWriter(socket1.getOutputStream(), true);							//Salida de datos del primer cliente
			
			BufferedReader BR2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));	//Entrada de datos del segundo cliente
			PrintWriter PW2 = new PrintWriter(socket2.getOutputStream(), true);							//Salida de datos del segundo cliente
			
			String mensaje1 = "";
			String mensaje2 = "";
			
			while(true) {
				if((mensaje1 = BR1.readLine())!=null && (mensaje2 = BR2.readLine())!=null) {
					PW2.println("Mensaje del cliente1: " + BR1.readLine());
					PW1.println("Mensaje del cliente2: " + BR2.readLine());
				}
				else if((mensaje1 = BR1.readLine())!=null){
					PW2.println("Mensaje del cliente1: " + BR1.readLine());
				}
				else if((mensaje2 = BR2.readLine())!=null) {
					PW1.println("Mensaje del cliente2: " + BR2.readLine());
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				//Cerramos por ultimo todos los canales de flujo de datos
				socket1.close();
				socket2.close();
				servidor.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
