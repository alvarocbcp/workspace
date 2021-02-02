package ejemplosLibro;

import java.io.IOException;

public class Ejemplo1 {

	public static void main(String[] args) {
		
		Runtime r = Runtime.getRuntime();
		
		String comando = "CMD /C start cmd.exe";
		//String comando = "NOTEPAD";
		
		Process p;
		
		try {
			p = r.exec(comando);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
