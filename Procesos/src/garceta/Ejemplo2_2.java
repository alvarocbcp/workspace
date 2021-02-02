package garceta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime r = Runtime.getRuntime();
		String comando = "CMD /C DIR"; // Cambiar para provocar un error
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
		
		// Con try con recursos:
		try (InputStream er = p.getErrorStream();BufferedReader brer =  new BufferedReader(new InputStreamReader(er));) {					
			String linea = null;
			while ((linea = brer.readLine()) != null) 
			// Lee otra línea
				System.out.println("ERROR >" + linea);
			//Ya no hace falta cerrar las referencias
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