package hilos;

public class HiloEjemploInterrup extends Thread {
	public void run() {
		try {
			while (!isInterrupted()) {
				System.out.println("En el Hilo");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("HA OCURRIDO UNA EXCEPCIÓN");
		}
		System.out.println("FIN HILO");
	}
	public void interrumpir() {
		interrupt();
	}
	public static void main(String[] args) {
		HiloEjemploInterrup h = new HiloEjemploInterrup();
		h . start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		h . interrumpir();
	}
}