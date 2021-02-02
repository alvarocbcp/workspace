package monitoresHamsters;

public class Rueda_Plato {

	private int numRuedas = 3;
	private int numPlatos = 5;
	
	public synchronized void empezarJugar(int id) {
		while(numRuedas==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("El hamster " + id + " ha empezado a jugar.");
		numRuedas--;
		System.out.println("QUEDAN " + numRuedas + " RUEDAS LIBRES");
		notifyAll();
	}
	
	public synchronized void terminarJugar(int id) {
		System.out.println("El hamster " + id + " ha terminado de jugar.");
		numRuedas++;
		System.out.println("QUEDAN " + numRuedas + " RUEDAS LIBRES");
		notifyAll();
	}
	
	public synchronized void empezarComer(int id) {
		while(numPlatos==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("El hamster " + id + " ha empezado a comer.");
		numPlatos--;
		System.out.println("QUEDAN " + numPlatos + " RUEDAS LIBRES");
		notifyAll();
	}
	
	public synchronized void terminarComer(int id) {
		System.out.println("El hamster " + id + " ha terminado de comer.");
		numPlatos++;
		System.out.println("QUEDAN " + numPlatos + " RUEDAS LIBRES");
		notifyAll();
	}

}
