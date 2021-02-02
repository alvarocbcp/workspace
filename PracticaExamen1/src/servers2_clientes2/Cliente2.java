package servers2_clientes2;

import java.io.*;
import java.net.*;

public class Cliente2 {

	private static String IP = "localhost";
	private static int PUERTO = 5600;

	public static void main(String[] args) {
		
		FileWriter FW = null;

		try {
			//Creo el socket con el ServidorComunicacion
			Socket miSocket = new Socket(IP, PUERTO);
			
			//Creo la entrada de datos del ServidorComunicacion
			BufferedReader BR = new BufferedReader(new InputStreamReader(miSocket.getInputStream()));

			//Creo la escritura del fichero
			FW = new FileWriter("final.txt");
			PrintWriter PW = new PrintWriter(FW);

			String msg = "";

			//Leo el fichero enviado por el ServidorComunicacion
			while((msg = BR.readLine())!=null) {
				//Mando el contenido al fichero final.txt
				PW.println(msg);
				System.out.println(msg);
			}
			
			miSocket.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				FW.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}


	}

}
