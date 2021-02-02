package ejercicio2;

public class Ninios extends Thread{

	private Turno turno;
	private String frase="";
	private String[] arrayFrases = {"Hola Don Jose...", "Por su casa yo pase...", "A su abuela yo la vi...", "Adios don Jose"};
	
	public Ninios(Turno turno) {
		this.turno = turno;
	}

	public void run() {
		for(int i=0; i<arrayFrases.length; i++) {
			frase = arrayFrases[i];
			turno.cantaNinios(frase);
		}
	}

}
