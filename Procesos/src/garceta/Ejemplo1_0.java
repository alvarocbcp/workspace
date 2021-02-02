package garceta;

public class Ejemplo1_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime r = Runtime.getRuntime();
		String comando = "NOTEPAD";
		try {
			Process p = r.exec(comando);
		}
		catch (Exception e) {
			System.out.println("Error en: " + comando);
			e.printStackTrace();
		}
	}

}
