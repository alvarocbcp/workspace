package ejercicio2;

import java.io.*;
import java.net.*;

public class Cliente {
	public static int numElementos=4;

	public static void main(String[] args) {
		int numero;
		
		BufferedReader lectura;
		PrintWriter salida;
		try {
			Socket misocket = new Socket(args[0], Integer.parseInt(args[1]));
			lectura = new BufferedReader(new InputStreamReader(misocket.getInputStream()));
			
			for(int i=2; i<args.length; i++) {
				numero = Integer.parseInt(args[i]);
				salida = new PrintWriter(misocket.getOutputStream(), true);
				salida.println(numero);
				System.out.print("Numero: " + numero);
				System.out.println(" Cuadrado: " + lectura.readLine());
			}
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

	public static int getNumElementos() {
		return numElementos;
	}

	public void setNumElementos(int numElementos) {
		this.numElementos = numElementos;
	}
	

}
