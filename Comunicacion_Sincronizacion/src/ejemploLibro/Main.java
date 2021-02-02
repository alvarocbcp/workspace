package ejemploLibro;

public class Main {

	public static void main(String[] args) {
		
		Contador cont = new Contador(100);
		HiloA a = new HiloA("HiloA", cont);
		HiloB b = new HiloB("HiloB", cont);
		a.start();
		b.start();

	}

}
