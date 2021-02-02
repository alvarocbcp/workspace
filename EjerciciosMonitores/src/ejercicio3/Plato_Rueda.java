package ejercicio3;

public class Plato_Rueda {
	
	//private boolean platoLibre = true;
	//private boolean ruedaLibre = true;
	
	private int numPlatos = 4;
	private int numRuedas = 5;
	
	public synchronized void empezarComida(int id) {
		while(numPlatos==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("El hamster " + id + " ha empezado a comer");
		numPlatos--;
		System.out.println("QUEDAN " + numPlatos + " PLATOS LIBRES");
		notifyAll();
	}
	
	public synchronized void terminarComida(int id) {
		System.out.println("El hamster " + id + " ha terminado de comer");
		numPlatos++;
		System.out.println("QUEDAN " + numPlatos + " PLATOS LIBRES");
		notifyAll();
	}
	
	public synchronized void empezarJugar(int id) {
		while(numRuedas==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("El hamster " + id + " ha empezado a jugar");
		numRuedas--;
		System.out.println("QUEDAN " + numRuedas + " RUEDAS LIBRES");
		notifyAll();
	}
	
	public synchronized void terminarJugar(int id) {
		System.out.println("El hamster " + id + " ha terminado de jugar");
		numRuedas++;
		System.out.println("QUEDAN " + numRuedas + " RUEDAS LIBRES");
	}

}
