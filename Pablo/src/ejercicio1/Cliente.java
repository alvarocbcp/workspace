package ejercicio1;

import java.io.*;
import java.net.*;
import javax.swing.*;

public class Cliente {
	
	final static String IP = "localhost";
	final static int PUERTO = 6000;

	public static void main(String[] args) {
		
		String nomFich="";
		File fichero;
		BufferedReader br;
		
		try {
			Socket miSocket = new Socket(IP,PUERTO);
			PrintWriter salida;
			
			nomFich = JOptionPane.showInputDialog("Introduzca el nombre del fichero que quiere transmitir: ");
			
			salida = new PrintWriter(miSocket.getOutputStream(),true);
			fichero = new File("ficherosClientes\\"+nomFich+".txt");
			br = new BufferedReader(new FileReader(fichero));
			
			String linea;
			
			while((linea=br.readLine())!=null) {
				salida.println(linea);
			}
			System.out.println("Fichero copiado en el servidor con exito.");
			
			br.close();
			miSocket.close();
		}catch(UnknownHostException e) {
			System.err.println("Nombre de la maquina servidora desconocida");
		}catch(ConnectException e) {
			System.err.println("El servidor no esta conectado");
		}catch(SocketException e) {
			System.err.println("Error en una operacion del socket");
		}catch(IOException e) {
			System.err.println("Error en la lectura/escritura");
		}catch(Exception e) {
			System.err.println("Error en la operacion");
		}

	}

}
