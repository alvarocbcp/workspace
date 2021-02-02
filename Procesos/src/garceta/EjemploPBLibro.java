package garceta;

import java.io.*;
import java.util.*;

public class EjemploPBLibro {

	public static void main(String[] args) {
		
		ProcessBuilder test = new ProcessBuilder();
		
		Map<String, String> entorno = test.environment();
		
		System.out.println("Variables de entorno: " + entorno);
		
		test = new ProcessBuilder("java", "-cp", "bin", "garceta.Ejemplo2_0");
		try {
			test.start();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		List<String> l = test.command();
		Iterator<String> iter = l.iterator();
		System.out.println("Argumentos de comando:");
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		test = test.command("CMD", "/C", "DIR");
		try {
			Process p = test.start();
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String linea;
			
			while((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
