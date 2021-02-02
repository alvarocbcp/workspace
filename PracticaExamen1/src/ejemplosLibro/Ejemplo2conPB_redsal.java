package ejemplosLibro;

import java.io.*;

public class Ejemplo2conPB_redsal {
	
	public static String RUTA="ficheros/";

	public static void main(String[] args) {
		
		try {
			Process p = null;
			
			ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "DIRR");
			
			File FOut = new File(RUTA + "salida.txt");
			File FErr = new File(RUTA + "error.txt");
			
			pb.redirectOutput(FOut);
			pb.redirectError(FErr);
			p = pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
