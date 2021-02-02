package ejercicios;

import java.io.*;
import java.net.*;

import org.apache.commons.net.ftp.*;

public class Actividad2 {

	public static void main(String[] args) {
		FTPClient cliente = new FTPClient();
		String servidor = "localhost";
		System.out.println("Nos conectamos a: " + servidor);
		String user = "usuario1";
		String pasw = "usuario1";

		try {
			cliente.connect(servidor);
			System.out.println("Conectado");
			boolean login = cliente.login(user, pasw);

			cliente.setFileType(FTP.BINARY_FILE_TYPE);
			String direc = "/NUEVODIREC";
			cliente.enterLocalPassiveMode();

			if (login) {				
				System.out.println("Login correcto");

				if (!cliente.changeWorkingDirectory(direc)) {
					String directorio = "NUEVODIREC";

					// Lo crea o busca en el directorio del usuario1

					if (cliente.makeDirectory(directorio)) {
						System.out.println("Directorio :  " + 
								directorio + " creado ...");
						cliente.changeWorkingDirectory(directorio);
					} else {
						System.out.println("No se ha podido crear el Directorio");
						System.exit(0);
					}

				}
				
				System.out.println();

				System.out.println("Directorio actual: "
						+ cliente.printWorkingDirectory());

				//Subir archivos
				
				System.out.println("-----Subida de ficheros-----");
				
				String archivo1 ="C:\\Users\\alvar\\OneDrive\\Imágenes\\Wallpapers\\Bolas_dragon.jpg";
				String archivo2 ="C:\\Users\\alvar\\OneDrive\\Imágenes\\Wallpapers\\Shenron.jpg";
				String archivo3 ="C:\\Users\\alvar\\OneDrive\\Imágenes\\Wallpapers\\Mandalorian.jpg";
				
				subirFichero(archivo1, "archivo1.jpg", cliente);
				subirFichero(archivo2, "archivo2.jpg", cliente);
				subirFichero(archivo3, "archivo3.jpg", cliente);
				
				System.out.println();
				
				//Mostrar archivos y tamaño
				
				System.out.println("-----Mostrar contenido del directorio-----");
				
				mostrarContenido("NUEVODIREC", cliente);
				
				System.out.println();

				//Renombrar archivo
				
				System.out.println("-----Renombrar archivo-----");

				direc="C:\\Users\\alvar\\OneDrive\\Documentos\\FP2\\BLOQUE 3\\CarpetaCompartidaFTP\\NUEVODIREC\\archivo1.jpg";
				renameFichero(direc, cliente);
				
				System.out.println();

				//Eliminar archivo
				
				System.out.println("-----Eliminar archivo-----");

				direc="C:\\Users\\alvar\\OneDrive\\Documentos\\FP2\\BLOQUE 3\\CarpetaCompartidaFTP\\NUEVODIREC\\archivo2.jpg";
				deleteFichero(direc, cliente);
				

				cliente.logout();
				cliente.disconnect();
			}
			else {
				System.out.println("No logueado");
			}


		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	public static void mostrarContenido(String directorio, FTPClient cliente) {
		try {
			cliente.changeWorkingDirectory (directorio);
			FTPFile[] files = cliente.listFiles();
			for(int i=0; i<files.length; i++) {
				System.out.println("Nombre: " + files[i].getName() + "\tTamaño: " + files[i].getSize());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void subirFichero(String file, String nombreFinal, FTPClient cliente) {
		BufferedInputStream in = null;

		try {
			in = new BufferedInputStream(new FileInputStream(file));
			if (cliente.storeFile(nombreFinal, in)) {	//cliente.completePendingCommand(); 
				System.out.println("Subido correctamente... ");
			}
			else {
				System.out.println("No se ha podido subir el fichero... ");
			}
			in.close(); // Cerrar flujo
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public static void renameFichero(String direc, FTPClient cliente) {
		try {
			cliente.changeWorkingDirectory(direc);
			if(cliente.rename("archivo1.jpg", "Bolas_Dragon.jpg")) {
				System.out.println("Fichero renombrado... ");
			}
			else {
				System.out.println("No se ha podido renombar el Fichero... ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void deleteFichero(String direc, FTPClient cliente) {
		try {
			if (cliente.deleteFile(direc)) {
				System.out.println("Fichero eliminado... ");
			}
			else {
				System.out.println("No se ha podido eliminar Fichero... ");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
