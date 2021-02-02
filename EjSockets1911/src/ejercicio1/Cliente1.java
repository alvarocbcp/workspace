package ejercicio1;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

public class Cliente1 {
	
	final static String RUTA = "ficheros1/";
	
	public static void main(String[] args) {
		
		try {
			Socket misocket = new Socket(args[0], Integer.parseInt(args[1]));
			BufferedReader lecturaServer = new BufferedReader(new InputStreamReader(misocket.getInputStream()));
			PrintWriter salidaServer = new PrintWriter(misocket.getOutputStream(), true);
			
			String cadena;
			String archivo="";
			int seleccion = 0;
			
			while(seleccion>3 || seleccion<1) {
				seleccion = Integer.parseInt(JOptionPane.showInputDialog("Introduce un fichero a enviar\n1. primero.txt\n2. segundo.txt\n3. tercero.txt"));
			}
			
			switch(seleccion) {
			case 1:
				archivo="primero.txt";
				break;
			case 2:
				archivo="segundo.txt";
				break;
			case 3:
				archivo="tercero.txt";
				break;
			}
			
			FileReader f = new FileReader(RUTA+archivo);
		    BufferedReader b = new BufferedReader(f);
		    
		    while((cadena = b.readLine())!=null) {
		          salidaServer.println(cadena);
		          System.out.println(cadena);
		      }
			b.close();
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
