package ejemplosLibro;

import java.io.*;

public class Ejemplo2conPB {

	public static void main(String[] args) {

		Process p = null;
		
		ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "DIR");
		
		try {
			p = pb.start();
			
			InputStream entrada = p.getInputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(entrada));
			
			String linea = "";
			
			while((linea = br.readLine())!=null) {
				System.out.println(linea);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int exitVal;
		
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de la salida: " + exitVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}

}
