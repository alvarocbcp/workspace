package garceta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime r = Runtime.getRuntime();
		String comando = "DIR";
		// Esto dará un error al ejecutarlo, ya que no hay DIR.exe
		// Probar a ejecutarlo en la línea de comandos
		Process p = null;
		// Con try-with-resources no tiene sentido, porque no se ha ejecutado el exec!!!!
		//try (InputStream is= p.getInputStream(); BufferedReader br= new BufferedReader(new InputStreamReader(is))) {
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
		// Tratamos el error leyendo del stream de errores
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