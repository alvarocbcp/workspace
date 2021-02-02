package ejercicio3;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

public class Cliente3_1 {
	
	public static void main(String[] args) {
		
		try {
			Socket misocket = new Socket(args[0], Integer.parseInt(args[1]));
			BufferedReader lectura = new BufferedReader(new InputStreamReader(misocket.getInputStream()));
			PrintWriter salida = new PrintWriter(misocket.getOutputStream(), true);
			String msg = "";
			String respuesta = "";
			
			while(!msg.equalsIgnoreCase("FIN")) {
				msg = JOptionPane.showInputDialog("Introduce el mensaje para el Cliente2");
				if(!msg.equalsIgnoreCase("FIN")) {
					salida.println(msg);
					respuesta = lectura.readLine();
					JOptionPane.showMessageDialog(null, respuesta);
				}
				else {
					salida.println(msg);
				}
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

}
