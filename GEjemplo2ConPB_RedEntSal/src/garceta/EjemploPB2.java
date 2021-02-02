package garceta;

import java.io.*;
import java.util.*;


public class EjemploPB2 {

	public static void main(String[] args) {
		
		ProcessBuilder pb = new ProcessBuilder("CMD");
		
		try {
			File fBat = new File("C:\\Users\\alvar\\OneDrive\\Documentos\\FP2\\BLOQUE 3\\workspace\\GEjemplo2ConPB_RedEntSal\\fichero.bat");
			File fOut = new File("C:\\Users\\alvar\\OneDrive\\Documentos\\FP2\\BLOQUE 3\\workspace\\GEjemplo2ConPB_RedEntSal\\Pruebas\\salida.txt"); // Salida no tiene por qué existir
			File fErr = new File("C:\\Users\\alvar\\OneDrive\\Documentos\\FP2\\BLOQUE 3\\workspace\\GEjemplo2ConPB_RedEntSal\\Pruebas\\error.txt");
			
			pb.redirectInput(fBat);
			pb.redirectOutput(fOut);
			pb.redirectError(fErr);
			
			Process p = pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
