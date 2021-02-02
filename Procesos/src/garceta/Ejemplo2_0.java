package garceta;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo2_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime r = Runtime.getRuntime();
		String comando = "CMD /C DIR";
		Process p = null;
		try {
			
			p = r.exec(comando);
			// DIR es un comando que no es un ejecutable, por lo que debemos ejecutarlo en 
			// la línea de comandos, como un parámetro de CMD
					
			// Leemos la salida del proceso creado con getInputStream
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String linea;
			while ((linea = br.readLine()) != null) // Lee otra línea del stream
				System.out.println(linea);
			br.close();
		}
		catch (Exception e) {
			System.out.println("Error en: " + comando);
			e.printStackTrace();
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