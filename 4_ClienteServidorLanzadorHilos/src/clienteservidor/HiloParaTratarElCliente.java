package clienteservidor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloParaTratarElCliente extends Thread {
	Socket cliente;

	public HiloParaTratarElCliente(Socket cliente) {
		this.cliente = cliente;
	}

	public void run() {
		try {
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

				// Enviamos al cliente la informacion recibida, pero en letra mayuscula.
			} // Fin del bucle
			salida.println("Adios del servidor"); // mensaje de despedida, que tendria que leer el cliente.
			
			cliente.close();
			System.out.println("Cerrado socket cliente");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
