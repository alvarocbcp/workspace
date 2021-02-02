package ejercicio1;

import java.io.*;
import java.net.*;

public class HiloCliente1 extends Thread{
	Socket cliente;
	private int i;
	final static String RUTA = "ficherosServer/";

	public HiloCliente1(Socket cliente, int i) {
		this.cliente = cliente;
		this.i = i;
	}

	public void run() {

		BufferedReader lectura = null;
		String cadena = "";
		PrintWriter salidaArchivo = null;
		FileWriter escrituraFichero = null;

		try {
			lectura = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			escrituraFichero = new FileWriter(RUTA + "fichero" + i + ".txt");
			salidaArchivo = new PrintWriter(escrituraFichero);		
			do {
				cadena = lectura.readLine();
				if(cadena!=null) {
					System.out.println(cadena);
					salidaArchivo.println(cadena);
				}
			}while(cadena!=null);
			System.out.println("-------------------");
			//cliente.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				escrituraFichero.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
