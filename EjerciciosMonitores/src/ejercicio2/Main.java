package ejercicio2;

public class Main {

	public static void main(String[] args) {
		
		Turno t = new Turno();
		Miliki m = new Miliki(t);
		Ninios n = new Ninios(t);
		
		m.start();
		n.start();

	}

}
