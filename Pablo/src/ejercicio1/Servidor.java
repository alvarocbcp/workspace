package ejercicio1;

import java.net.*;

import java.io.*;

public class Servidor {

	final static int PUERTO = 6000;

	public static void main(String[] args) {

		ServerSocket servidor=null;
		int cont=0;
		int contFich=1;

		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println("***SERVIDOR ARRANCADO!***");

			while(true) {
				Socket cliente = servidor.accept();
				System.out.println("Cliente "+(cont+1)+" conectado");
				cont++;

				Thread hiloParaTratarElCliente = new HiloParaTratarElCliente(cliente,contFich);
				hiloParaTratarElCliente.start();
				contFich++;
			}
		}catch(SocketException e) {
			System.err.println("Error en una operacion de socket.");
		}catch(IOException e) {
			System.err.println("Error en una operacion de entrada/salida.");
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			try {
				servidor.close();
			} catch (IOException e) {
				System.out.println(e);
			}
		}

	}

}
