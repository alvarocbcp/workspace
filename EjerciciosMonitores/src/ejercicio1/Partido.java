package ejercicio1;

public class Partido extends Thread{
	
	private Pelota pelota;
	private int numPartido;
	
	public Partido(Pelota pelota, int numPartido) {
		this.pelota = pelota;
		this.numPartido = numPartido;
	}
	
	public void run() {
		pelota.cogePelota(numPartido);
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			
		}
		pelota.devuelvePelota(numPartido);
	}

}
