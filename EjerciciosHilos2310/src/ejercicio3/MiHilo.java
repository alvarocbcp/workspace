package ejercicio3;

public class MiHilo extends Thread{
	
	private long cont;
	private boolean stopHilo= false;
	
	public MiHilo(long cont) {
		this.cont = cont;
	}
	
	public void pararHilo() {
		stopHilo = true;
	}
	
	public long getContador() {
		return cont;
	}
	
	public void interrumpir() {
		interrupt();
	}
	
	public void run() {
		while(true) {
			cont++;
		}
	}
	
}
