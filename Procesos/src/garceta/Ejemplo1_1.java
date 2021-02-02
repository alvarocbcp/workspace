package garceta;

import java.util.concurrent.TimeUnit;

public class Ejemplo1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime r = Runtime.getRuntime();
		String comando = "NOTEPAD";
		try {
			Process p = r.exec(comando);
			p.waitFor(10, TimeUnit.SECONDS);
		      // A los 10 sg se cierra notepad
		    p.destroy();
		}
		catch (Exception e) {
			System.out.println("Error en: " + comando);
			e.printStackTrace();
		}
	}

}
