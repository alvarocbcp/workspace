package ejercicios;

public class Ejecutable1_6 {
	
	public static void main(String[] args) {

	Runtime r = Runtime.getRuntime();

	String comando = "java -cp ./bin ejercicios.Ejercicio1_6_Main";
	Process p = null;
		try {
			p = r.exec(comando);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
