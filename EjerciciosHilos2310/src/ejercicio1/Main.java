package ejercicio1;

public class Main {

	public static void main(String[] args) {
		
		Thread ArrayHilos[] = new Thread[20];
		
		for(int i=0; i<20; i++) {
			MiHilo h = new MiHilo(Integer.toString(i+1));
			h.setPriority(6 + (int) (Math.random() * (8 - 6)));
			ArrayHilos[i] = h;
		}
		
		for(int i=0; i<20; i++) {
			ArrayHilos[i].start();
		}

	}

}
