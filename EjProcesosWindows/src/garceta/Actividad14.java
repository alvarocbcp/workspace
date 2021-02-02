package garceta;

import java.io.*;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Actividad14 {

	public static void main(String[] args) {
		
		Runtime r = Runtime.getRuntime();
		//String comando = "cmd /c cd C:\\Users\\alumno\\WSEjProcesos\\GEjemplo2\\bin && java garceta.Ejemplo2_2";
		//String comando = "cmd /c java -cp ../GEjemplo2/bin garceta.Ejemplo2_2"; // notación linux
		//String comando = "cmd /c java -cp ..\\GEjemplo2\\bin garceta.Ejemplo2_2"; // notación windows
		//String comando = "cmd /c cd bin  && java garceta.PideNombre Esther";
		//String comando = "cmd /c  java -cp ./bin garceta.PideNombre Esther";
		String comando = "cmd /c  java -cp ../GActividad14_R/bin garceta.PideNombre Esther";
		
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
		
		// Capturamos el posible error en la ejecución del comando
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
