package ejercicio2;

public class Miliki extends Thread{

	private Turno turno;
	private String frase="";
	private String[] arrayFrases = {"Hola Don Pepito...", "Paso usted ya por casa...", "Vio usted a mi abuela...", "Adios don Pepito"};
	
	public Miliki(Turno turno) {
		this.turno = turno;
	}

	public void run() {
		for(int i=0; i<arrayFrases.length; i++) {
			frase = arrayFrases[i];
			turno.cantaMiliki(frase);
		}
	}
}
