package ejercicios;

import java.io.IOException;

import org.apache.commons.net.ftp.*;

public class Actividad1 {
	
	public static void main(String[] args) {
		
		FTPClient cliente = new FTPClient();
		String servFTP = "ftp.rediris.es";
		System.out.println("Nos conectamos a: " + servFTP);
		String usuario = "anonymous";
		String clave = "anonymous";
		
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
			
			cliente.changeWorkingDirectory("/");
			System.out.println("Directorio actual: " + cliente.printWorkingDirectory());
			
			
			FTPFile[] directorios = cliente.listFiles();
			
			for (int i=2; i<(directorios.length); i++) {
				listarDirectorio(directorios[i], cliente);
				}		
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void listarDirectorio(FTPFile directorios, FTPClient cliente) {
		try {
			
			String tipos[] = {"Fichero", "Directorio","Enlace simb."};
			
			if(tipos[directorios.getType()].equalsIgnoreCase("Directorio")) {
				cliente.changeWorkingDirectory("/" + directorios.getName());
				System.out.println("Directorio: " + cliente.printWorkingDirectory());
				String[] ficheros;
				ficheros = cliente.listNames();
				for (int j=2; j<(ficheros.length); j++) {
					System.out.println("\t" + ficheros[j]);
				}
			}
			else if(tipos[directorios.getType()].equalsIgnoreCase("Enlace simb.")) {
				System.out.println("Enlace simbolico: " + directorios.getName());
			}
			else {
				System.out.println("Fichero: " + directorios.getName());
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
