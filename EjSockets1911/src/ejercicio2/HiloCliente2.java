package ejercicio2;

import java.io.*;
import java.net.*;

public class HiloCliente2 implements Runnable{
	
	static final int NBYTES = 2048;
	BufferedInputStream BIS = null;
	BufferedOutputStream BOS = null;
	Socket cliente;
	
	static int num=1;

	public HiloCliente2(Socket cliente) {
		this.cliente = cliente;
	}

	public void run() {
		try {
			//Creamos el buffer para recibir datos, a traves del socket asignado a la conexion cliente
			BIS = new BufferedInputStream(cliente.getInputStream());
			
			//Se abre el fichero donde se hará la copia
			BOS = new BufferedOutputStream(new FileOutputStream("fichero" + num + ".jpg"));
			
			//Creacion del array donde voy a guardar lo que vaya leyendo de lo que manda el cliente
			byte[] array = new byte[NBYTES];
			
			int leidos = BIS.read(array);
			
			//Cewo el bucle con el que voy a leer lo que me manda el cliente por el socket y lo voy escribiendo en el nuevo fichero de copia
			while(leidos > 0) {
				BOS.write(array, 0, leidos);
				leidos = BIS.read(array);
			}
			
			num++;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//Cerramos la salida de datos y el socket con el cliente
				BOS.close();
				cliente.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

	}

}
