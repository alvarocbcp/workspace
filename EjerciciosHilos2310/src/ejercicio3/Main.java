package ejercicio3;

public class Main {
	
	public static void main(String args[]) {
		MiHilo h1 = new MiHilo(0);
		MiHilo h2 = new MiHilo(400);
		
		h1.setPriority(Thread.MAX_PRIORITY);
		h2.setPriority(Thread.MIN_PRIORITY);
		
		h1.start();
		h2.start();
		
		while(h1.getContador() < h2.getContador()) {
			System.out.println(h1.getContador() + "-");
			System.out.println(h2.getContador());
		}
		h1.interrumpir();
		h2.interrumpir();
		System.out.println("---------------");
		System.out.println(h1.getContador() + "-");
		System.out.println(h2.getContador());
	}

}
