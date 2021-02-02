package clienteservidor;

import java.net.*;
import java.io.*;

public class TCPServ {

	public static void main(String[] args) {
		ServerSocket servidor = null;
		if (args.length == 1) { // 1 parametro: puerto por el que escucha dicha maquina.
			try {
				// Creamos un Socket Servidor.
				servidor = new ServerSocket(Integer.parseInt(args[0]));

				while (true) {
					// Esperamos que se conecte un cliente.
					System.out.println("Esperando la conexion de un cliente ....");
					Socket cliente = servidor.accept(); // Este metodo es bloqueante
					System.out.println("Recibida la conexion de un cliente");

					// Aquí creo un hilo para cada cliente y traslado la operacion alli
														
					Thread hiloParaTratarElCliente = new HiloParaTratarElCliente(cliente);
					hiloParaTratarElCliente.start();
					
					//Donde HiloParaTratarElCliente sería una clase que herede de Thread y que haga todo lo que tenga que hacer con el socket para tratar con el cliente.
					
					//cliente.close(); // Cerramos el socket asignado al cliente					
					// Si lo cierro no se puede ejecutar el tratamiento del cliente en el hilo
					// lo cierro en el hilo
				}
											
			}

			// Tratamos las excepciones

			catch (SocketException e) {
				System.err.println("Error en una operacion de socket");
			} catch (IOException e) {
				System.err.println("Error en una operacion de entrada/salida");
			} finally {
				try {
					servidor.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // Cerramos el socket servidor., hacer en finally
			}
		} else
			System.out.println("Numero de parametros incorrectos");
	}
}
