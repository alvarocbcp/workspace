package ejemplos;

import java.io.*;
import org.apache.commons.net.ftp.*;

public class CrearDirectorio {

	public static void main(String[] args) {
		FTPClient cliente = new FTPClient();
		String servFTP = "localhost";
		System.out.println("Nos conectamos a: " + servFTP);
		String usuario = "usuario1";
		String clave = "usuario1";
		try {
			cliente.connect(servFTP);
			cliente.enterLocalPassiveMode(); //modo pasivo

			boolean login = cliente.login(usuario, clave);
			if (login)
				System.out.println("Login correcto...");
			else {
				System.out.println("Login Incorrecto...");
				cliente.disconnect();
				System.exit(1);
			}
			System.out.println("Directorio actual: "
					+ cliente.printWorkingDirectory());
			
			String direc="DIRECTORIO1";
			if(cliente.makeDirectory (direc)){
			System.out.println("Directorio creado");
			cliente.changeWorkingDirectory (direc);
			}
			else
			System.out.println("NO SE HA PODIDO CREAR DIRECTORIO");


			//ir a otro directorio
			String directorio="/DIRECTORIO1/";
			if(cliente.changeWorkingDirectory (directorio))
				System.out.println("Dir Actual:"+ cliente.printWorkingDirectory());
			else
				System.out.println("NO EXISTE EL DIRECTORIO: "+directorio);


			FTPFile[] files = cliente.listFiles();
			System.out.println("Ficheros en el directorio actual:"
					+ files.length);
			//array para visualizar el tipo de fichero
			String tipos[] = {"Fichero", "Directorio","Enlace simb."};

			for (int i = 0; i < files.length; i++) {
				System.out.println("\t" + files[i].getName() + " => "
						+ tipos[files[i].getType()]);
			}
			boolean logout = cliente.logout();
			if (logout) 
				System.out.println("Logout del servidor FTP...");
			else 
				System.out.println("Error al hacer Logout...");
			//
			cliente.disconnect();
			System.out.println("Desconectado...");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}		
	}

}


