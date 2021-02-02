package ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import ejercicio2.Cliente;

public class Servidor {

	public static void main(String[] args) {

		try {
			ServerSocket servidor = new ServerSocket(Integer.parseInt(args[0]));
			PrintWriter salida = null;
			BufferedReader lectura = null;
			Socket socket = null;
			float resultado=0;
			String simbolo="";
			float num1;
			float num2;


			System.out.println("Esperando la conexion de un cliente...");
			socket = servidor.accept();
			System.out.println("Recibida la conexion del cliente ");
			salida = new PrintWriter(socket.getOutputStream(), true);
			lectura = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			do{
				simbolo = lectura.readLine();
				if(simbolo.equalsIgnoreCase("$")) {

				}
				else {
					num1 = Float.parseFloat(lectura.readLine());
					num2 = Float.parseFloat(lectura.readLine());
					switch(simbolo) {
					case "*":
						resultado = num1 * num2;
						System.out.println(num1 + " * " + num2 + " = " + resultado);
						salida.println("SERVIDOR: " + num1 + "*" + num2 + " = " + resultado);
						break;
					case "/":
						resultado = num1 / num2;
						System.out.println(num1 + " / " + num2 + " = " + resultado);
						salida.println("SERVIDOR: " + num1 + "/" + num2 + " = " + resultado);
						break;
					case "+":
						resultado = num1 + num2;
						System.out.println(num1 + " + " + num2 + " = " + resultado);
						salida.println("SERVIDOR: " + num1 + "+" + num2 + " = " + resultado);
						break;
					case "-":
						resultado = num1 - num2;
						System.out.println(num1 + " - " + num2 + " = " + resultado);
						salida.println("SERVIDOR: " + num1 + "-" + num2 + " = " + resultado);
						break;
					default:
						simbolo="$";
					}
				}
			}while(!simbolo.equalsIgnoreCase("$"));
			System.out.println("Cierre del socket");
			socket.close();
			System.out.println("Cierre del servidor");
			servidor.close();
		}catch(SocketException e) {
			System.err.println("Error en una operacion del socket");
		}catch(IOException e) {
			System.err.println("Error en una operacion de entrada/salida");
		}catch(Exception e) {
			System.err.println(e);
		}

	}

}
