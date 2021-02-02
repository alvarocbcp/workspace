package ejercicio1;

public class Pelota {
	
	private int numPelotas = 8;
	
	public synchronized void cogePelota(int numPartido) {
		while(numPelotas==0) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		numPelotas--;
		System.out.println("Empieza el partido " + numPartido);
		System.out.println("Quedan " + numPelotas + " pelotas");
		notifyAll();
	}
	
	public synchronized void devuelvePelota(int numPartido) {
		System.out.println("Acaba el partido " + numPartido + " y se devuelve la pelota");
		numPelotas++;
		System.out.println("Quedan " + numPelotas + " pelotas");
		notifyAll();
	}

}
