package clienteservidor;

import java.net.*;
import java.io.*;

/*
 * Este programa lo pruebo copiando el servidor a la máquina real y ejecutando los clientes desde la máquina virtual
 * Si ejecuto dos clientes el servidor no lo atiende porque está preparado para un solo cliente
 */
public class TCPCli {

	public static void main(String[] args) {
		if (args.length == 2) { // 2 parametros: nombre de la maquina remota a la que se conecta y puerto por el
								// que escucha dicha máquina.
			try {
				Socket misocket = new Socket(args[0], Integer.parseInt(args[1]));
				// Socket enlazado al puerto 5555 en la maquina args[0]
				BufferedReader lectura, lee_datos;
				PrintWriter escritura;

				// Creamos el Buffer que nos permitira leer la informacion que nos llegue
				// a traves del socket.
				lectura = new BufferedReader(new InputStreamReader(misocket.getInputStream()));

				// Creamos el buffer que nos permitira enviar informacion a traves del socket.
				escritura = new PrintWriter(misocket.getOutputStream(), true);

				// Buffer para leer los datos que introducimos por el teclado
				lee_datos = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Introduce tus mensajes al servidor (para salir escribe . ):");

				String msg = " "; // variable para almacenar la informacion del teclado.

				while (!msg.equals(".")) {

					msg = lee_datos.readLine(); // Leemos una linea por el teclado
					escritura.println(msg); // La enviamos a traves del socket al servidor

					// Leemos lo que nos llega del servidor, y lo mostramos por pantalla.
					System.out.println("Mensaje del servidor: " + lectura.readLine());
				} // Fin del bucle

				System.out.println("Mensaje de despedida del servidor: " + lectura.readLine());
				
				misocket.close();
			}

			// Tratamiento de las excepciones:

			catch (UnknownHostException e) {
				System.err.println("Nombre de maquina servidora desconocida");
			} catch (ConnectException e) {
				System.err.println("El servidor no esta conectado en " + args[0] + " " + args[1]);
			} catch (SocketException e) {
				System.err.println("Error en una operacion del socket");
			} catch (IOException e) {
				System.err.println("Error en la lectura/escritura");
			}
		} else
			System.out.println("Numero de parametros incorrectos");
	}
}
