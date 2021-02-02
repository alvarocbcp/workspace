package garceta;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio1_4 {
	
	public static void main(String[] args) {
		
		Runtime r = Runtime.getRuntime();
		String comando = "java -cp ../Procesos/bin garceta.Ejemplo2_0";
		//String comando = "cmd /c cd C:\\Users\\alvar\\OneDrive\\Documentos\\FP2\\BLOQUE 3\\workspace\\Procesos\\bin && java garceta.Ejemplo2_0";
		Process p = null;
		try {
			p = r.exec(comando);
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String linea;
			while((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			br.close();
		}
		catch (Exception e) {
			System.out.println("Error en: " + comando);
			e.printStackTrace();
		}
		
		int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de salida: " + exitVal);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

}
