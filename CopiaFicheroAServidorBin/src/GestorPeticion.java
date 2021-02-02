import java.io.*;
import java.net.*;

public class GestorPeticion implements Runnable {
	static final int NBYTES = 2048;
	BufferedInputStream entrada = null;
	BufferedOutputStream salida = null;
	Socket socket;

	static int num = 1;

	public GestorPeticion(Socket s) {
		this.socket = s;
	}

	public void run() {
		try {
			entrada = new BufferedInputStream(socket.getInputStream());

			// Creamos el buffer para recibir datos, a traves del socket asignado
			// a la conexion del cliente.

			// Se abre el fichero donde se hará la copia

			salida = new BufferedOutputStream(new FileOutputStream("fichero" + num + ".jpg"));

			byte[] array = new byte[NBYTES];
			int leidos = entrada.read(array);
			// if (leidos > 0) System.out.println ("leidos "+ leidos);
			while (leidos > 0) {
				salida.write(array, 0, leidos);
				leidos = entrada.read(array);
			}

			num++;

		} catch (Exception e) {
			System.out.println("Error de E/S del socket!");
			e.getStackTrace();
			System.exit(-1);
		} finally {
			try {
				salida.close();
				socket.close();
				System.out.println("Cerrado socket cliente");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}