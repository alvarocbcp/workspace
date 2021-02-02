package ejercicio2;

public class Turno {

	private boolean cantaMiliki = true;

	public synchronized void cantaMiliki(String frase) {
		while(!cantaMiliki) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(frase);
		cantaMiliki = false;
		notifyAll();
	}

	public synchronized void cantaNinios(String frase) {
		while(cantaMiliki) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(frase);
		cantaMiliki = true;
		notifyAll();
	}
	
}
