package garceta;

import java.io.*;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo3_0 {

	public static void main(String[] args) {
		
		Runtime r = Runtime.getRuntime();
		//String comando = "cmd /c cd bin && java garceta.Saluda Pepe" ;
		//Aquí lo ejecuto desde el intérprete
		//String comando = "cmd /c cd bin && java garceta.Saluda Pepe > fich.txt";
				
		//Me funciona perfectamente ya que lo ejecuto desde la consola
		
		//Esto no va, no ejecuta la redireccion:
		//String comando = "java -cp ./bin garceta.Saluda Esther > fich.txt" ;
		String comando = "java -cp ./bin garceta.Saluda Esther" ;
		Process p = null;
		try {
			p = r.exec(comando);
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String linea;
			while ((linea = br.readLine()) != null) // Lee otra línea
				System.out.println(linea);
			br.close();
		}
		catch (Exception e) {
			System.out.println("Error en: " + comando);
			e.printStackTrace();
		}
		try {			
			InputStream er = p.getErrorStream();
			BufferedReader brer =  new BufferedReader(new InputStreamReader(er));
			String linea = null;
			while ((linea = brer.readLine()) != null) 
			// Lee otra línea
				System.out.println("ERROR >" + linea);
			brer.close();
		}
		catch (IOException ioe) {			
			ioe.printStackTrace();
		}
		// Comprobación de error - 0 bien - 1 mal
		int exitVal;
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de salida: " + exitVal);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}

}