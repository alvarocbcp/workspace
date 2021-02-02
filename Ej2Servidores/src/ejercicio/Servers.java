package ejercicio;

import java.io.*;
import java.net.*;

public class Servers {
	
	public static void main(String[] args) {
		ServerSocket servidorHora = null;
		ServerSocket servidorEco = null;
		

		try {
			servidor = new ServerSocket(Integer.parseInt(args[0]));
			
			int numCli = Lanzador1.getNumCli();
			int i = 1;
			
			
			do{
				if(numCli!=0){
					System.out.println("Esperando la conexion del cliente " + i);
					Socket socket = servidor.accept();
					System.out.println("Recibida la conexion del cliente " + i);
					Thread HiloCliente1 = new HiloCliente1(socket, i);
					HiloCliente1.start();
					numCli--;
					i++;
				}
			}while(true);			
			
		}catch(SocketException e) {
			System.err.println("Error en una operacion del socket");
		}catch(IOException e) {
			System.err.println("Error en una operacion de entrada/salida");
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			try {
				System.out.println("Cierre del servidor");
				servidor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
