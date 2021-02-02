package ejemplosLibro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Ejemplo5 {

	public static void main(String[] args) {

		Runtime r = Runtime.getRuntime();
		
		String comando = "CMD /C DATE";
		
		Process p = null;
		
		try {
			p = r.exec(comando);
			
			OutputStream os = p.getOutputStream();
			os.write("04-11-2020".getBytes());
			os.flush();									//Vacia el buffer de salida
			
			//Lectura
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String linea = "";
			
			while((linea = br.readLine())!=null) {
				System.out.println(linea);
			}
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Con el siguiente bloque de codigo consigo sacar el error de CMD por la consola de Eclipse
		try {
			InputStream er = p .getErrorStream();
			BufferedReader brer =
			new BufferedReader(new InputStreamReader(er));
			String liner = null;
			while ((liner = brer.readLine()) != null)
			System.out.println("ERROR >" + liner);
			} catch (IOException ioe) {
			ioe.printStackTrace() ;
			}
		
		//Comprobacion del error 0-bien 1-mal
		int exitVal;
		
		try {
			exitVal = p.waitFor();
			System.out.println("Val.or de la salida: " + exitVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}

}
