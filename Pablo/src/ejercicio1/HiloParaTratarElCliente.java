package ejercicio1;

import java.io.*;
import java.net.*;

public class HiloParaTratarElCliente extends Thread{

	Socket cliente;
	private int cont;

	public HiloParaTratarElCliente(Socket cliente, int cont) {
		this.cliente = cliente;
		this.cont=cont;
	}

	public void run() {
		BufferedReader entrada;
		FileWriter fichero = null;
		PrintWriter pw = null;
		String mensaje;

		try {
			entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

			fichero = new FileWriter("ficherosServidor\\fichero"+getCont()+".txt");
			pw = new PrintWriter(fichero);

			do {
				mensaje = entrada.readLine();
				if(mensaje!=null) {
					pw.println(mensaje);
				}
			}while(mensaje != null);
			System.out.println("Fichero copiado con exito");

			cliente.close();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fichero.close();
			}catch(Exception e) {
				System.err.println("Error en la operacion");
			}
		}

	}

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

}
