package ejemplosClase;

import java.net.*;

public class Direccion {

	public static void main(String[] args) {
		
		if(args.length<1) {
			System.out.println("Debe indicar el nombre de la maquina");
		}
		else {
			try {
				System.out.println("\n********************************************************\n");
				System.out.println("Obtencion de objeto InetAddress");
				System.out.println("\n********************************************************\n");
				
				InetAddress direccionExterna = InetAddress.getByName(args[0]);
				System.out.println("Objeto InetAddress con getByName y sin getHostName() " + direccionExterna);
				
				System.out.println("Objeto getHostAddress " + direccionExterna.getHostAddress());
				
				System.out.println("Objeto getHostName() " + direccionExterna.getHostName());
				
				System.out.println("\n********************************************************\n");
				
				// getAllByName devuelve InetAddress[], varios InetAddress
				
				InetAddress direcciones[] = InetAddress.getAllByName(args[0]);
				
				for(int i=0; i<direcciones.length; i++) {
					System.out.println("Con getAllByName " + direcciones[i]);
				}
				
				System.out.println();
				System.out.println("\n********************************************************\n");
				System.out.println("Objeto InetAddress con getLocalHost ");
				System.out.println("\n********************************************************\n");
				
				System.out.println();
				
				InetAddress direccion = InetAddress.getLocalHost();
				System.out.println("getLoocalHost " + direccion);
				
				System.out.println();
				
				System.out.println("\n********************************************************\n");
				System.out.println("Obtencion de la ip en un array");
				System.out.println("\n********************************************************\n");
				System.out.println();
				
				byte direccionIp[] = direccion.getAddress();
				for(int j=0; j<direccionIp.length; j++) {
					int uByte = (direccionIp[j] < 0 ? direccionIp[j]&255 : direccionIp[j]);
					System.out.println(uByte);
					System.out.println(direccionIp[j]);
				}
				
				System.out.println();
				System.out.println("\n********************************************************\n");
				System.out.println("getHostAddress " + direccion.getHostAddress());
				System.out.println("\n********************************************************\n");
				System.out.println("getCanonicalHostName " + direccion.getCanonicalHostName());
				System.out.println("\n********************************************************\n");
				
			}catch (UnknownHostException e) {
				System.out.println("Imposible encontrar la direccion " + args[0]);
			}
		}

	}

}
