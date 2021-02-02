package clienteservidor;

import java.net.*;
import java.io.*;

public class TCPServ {

	public static void main(String[] args) {
		if (args.length == 1) { // 1 parametro: puerto por el que escucha dicha maquina.
			try {
				// Creamos un Socket Servidor.
				ServerSocket servidor = new ServerSocket(Integer.parseInt(args[0]));

				while (true) {
					// Esperamos que se conecte un cliente.
					System.out.println("Esperando la conexion de un cliente ....");
					Socket cliente = servidor.accept(); // Este metodo es bloqueante
					System.out.println("Recibida la conexion de un cliente");

					BufferedReader entrada;
					PrintWriter salida;

					// Creamos el buffer para recibir datos, a traves del socket asignado
					// a la conexion del cliente.
					entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
					// Creamos el buffer para enviar al cliente informacion a traves del socket.
					salida = new PrintWriter(cliente.getOutputStream(), true);

					String msg = " ";
					while (!msg.equals(".")) {
						msg = entrada.readLine(); // Leemos una linea recibida por el socket.
						System.out.println("Mensaje del cliente: " + msg);
					
						salida.println(msg.toUpperCase());
//						try {
//							System.out.println("a dormir");
//							Thread.sleep(5000);
//							System.out.println("se despierta");
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						};
						// Enviamos al cliente la informacion recibida, pero en letra mayuscula.
					} // Fin del bucle
					salida.println("Adios del servidor"); // mensaje de despedida, que tendria que leer el cliente.
					
					cliente.close(); // Cerramos el socket asignado al cliente
					// Es un solo cliente, pero intercambia varios mensajes con el
				}
							
				
				// servidor.close(); // Cerramos el socket servidor., hacer en finally
				// solo atiende a un servidor
			}

			// Tratamos las excepciones

			catch (SocketException e) {
				System.err.println("Error en una operacion de socket");
			} catch (IOException e) {

				System.err.println("Error en una operacion de entrada/salida");
			}
		} else
			System.out.println("Numero de parametros incorrectos");
	}
}
