package servers2_clientes2;

import java.io.*;
import java.net.*;
import javax.swing.*;

public class Cliente1 {
	
	private static String IP = "localhost";
	private static int PUERTO1 = 5500;
	private static int PUERTO2 = 5600;

	public static void main(String[] args) {
		
		try {
			int numFichero = Integer.parseInt(JOptionPane.showInputDialog("Introduce que fichero quieres coger del servidor:\n"
					+ "1. prueba1.txt\n"
					+ "2. prueba2.txt\n"
					+ "3. prueba3.txt"));
			
			//Creo el socket con el servidorFicheros
			Socket miSocket1 = new Socket(IP, PUERTO1);
			
			//Creo la salida y la entrada de datos con el servidorFicheros
			PrintWriter PW1 = new PrintWriter(miSocket1.getOutputStream(), true);
			BufferedReader BR1 = new BufferedReader(new InputStreamReader(miSocket1.getInputStream()));
			
			//Creo el socket con el servidorComunicacion
			Socket miSocket2 = new Socket(IP, PUERTO2);
			
			//Creo la salida y la entrada de datos con el servidorFicheros
			PrintWriter PW2 = new PrintWriter(miSocket2.getOutputStream(), true);
			BufferedReader BR2 = new BufferedReader(new InputStreamReader(miSocket2.getInputStream()));
			
			//Le mando al servidorFicheros el fichero que quiero recibir
			PW1.println(numFichero);
			
			String msg = "";
			
			//Leo el contenido del fichero que recibo y lo mando como mensaje al servidorComunicacion
			while((msg = BR1.readLine())!=null) {
				PW2.println(msg);
				System.out.println(msg);
			}
			
			//Cierro los sockets
			miSocket1.close();
			miSocket2.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
