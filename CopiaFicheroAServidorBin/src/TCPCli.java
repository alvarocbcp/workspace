import java.net.*;
import java.io.*;

public class TCPCli {
	static final int NBYTES = 2048;

	public static void main(String[] args) {
		BufferedInputStream bufferedInput = null;
		BufferedOutputStream bufferedOutput = null;
		Socket misocket = null;

		if (args.length == 2) { // Solo hemos pasado un parametro: nombre de la maquina.
			try {
				misocket = new Socket(args[0], Integer.parseInt(args[1]));
				// Socket enlazado al puerto args[1] en la maquina args[0]

				// Como voy a lanzar el programa desde otro, que lanzar varias instancias del
				// programa:

				String nombreFich = "Invierno.jpg";
				//String nombreFich = "Why.mp3";

				// Lo apropiado es parametrizar todo lo que se pueda
				// Se abre el fichero original para lectura

				bufferedInput = new BufferedInputStream(new FileInputStream(nombreFich));

				bufferedOutput = new BufferedOutputStream(misocket.getOutputStream());

				byte[] array = new byte[NBYTES];
				int leidos = bufferedInput.read(array);
				while (leidos > 0) {
					bufferedOutput.write(array, 0, leidos);
					leidos = bufferedInput.read(array);
				}

			}

			// Tratamiento de las excepciones:
			catch (UnknownHostException e) {
				System.err.println("Nombre de maquina servidora desconocida");
			} catch (ConnectException e) {
				System.err.println("El servidor no esta conectado en " + args[0]);
			} catch (SocketException e) {
				System.err.println("Error en una operacion del socket");
			} catch (IOException e) {
				System.err.println("Error en la lectura/escritura");
			} finally {
				// lectura.close();
				try {
					bufferedInput.close();
					bufferedOutput.close();
					misocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else
			System.out.println("Numero de parametros incorrectos");
	}
}
