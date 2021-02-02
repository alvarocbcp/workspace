package ejercicioChat;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {

	final static String IP="localhost";
	final static int PUERTO = 5000;

	public static void main(String[] args) {

		try {
			//Creo el socket de conexion con el Servidor
			Socket miSocket = new Socket(IP, PUERTO);

			//Creo la entrada y salida de datos del cliente con el servidor
			BufferedReader BR = new BufferedReader(new InputStreamReader(miSocket.getInputStream()));	//entrada de datos
			PrintWriter PW = new PrintWriter(miSocket.getOutputStream(), true);							//salida de datos

			String msg="";
			
			do {
				msg = mandarMensaje();
			}while(msg!=null);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String mandarMensaje() {
		System.out.println("Introduce un mensaje para enviar");
		Scanner sc = new Scanner(System.in);
		String msg="";
		msg = sc.nextLine();
		return msg;
	}

}
