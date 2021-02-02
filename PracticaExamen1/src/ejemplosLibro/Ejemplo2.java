package ejemplosLibro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo2 {

	public static void main(String[] args) {
		
		Runtime r = Runtime.getRuntime();
		
		String comando = "CMD /C DIR";
		
		Process p = null;
		
		try {
			p = r.exec(comando);
			
			InputStream entrada = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(entrada));
			
			String linea = "";
			
			while((linea=br.readLine()) != null) {
				System.out.println(linea);
			}
			
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int exitVal;
		
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de salida: " + exitVal); //0 correcto, 1 INCORRECTO
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
