package ejemplosClase;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class GetSocketInfo {

	public static void main(String[] args) {
		int puerto;
		if(args.length == 2) {
			try {
				puerto = Integer.parseInt(args[1]);
				if(puerto >= 0 && puerto <= 65535) {
					Socket miSocket = new Socket(args[0], puerto);
					System.out.println("Conectado a " + miSocket.getInetAddress().getHostName() + " en el puerto " + miSocket.getPort() + 
							" desde el puerto " + miSocket.getLocalPort() + miSocket.getLocalAddress().getHostName());
					
				}
			}catch(UnknownHostException e) {
				System.out.println("No puedo encontrar " + args[0]);
			}catch (SocketException e) {
				System.out.println("No puedo conectarme a " + args[0] + " en el puerto " + args[1]);
			}catch(NumberFormatException e) {
				System.out.println("#Puerto valor entero");
			}catch(IOException e) {
				System.out.println(e);
			}
		}

	}

}
