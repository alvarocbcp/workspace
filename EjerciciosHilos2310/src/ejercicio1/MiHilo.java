package ejercicio1;

public class MiHilo extends Thread{
	
	private boolean stopHilo= false;
	
	public MiHilo(String nombre) {
		super(nombre);
	}
	
	public void pararHilo() {
		stopHilo = true;
	}
	
	public void run() {
		
		//No se porque no me imprime los hilos 10 veces y no me controla cuando acaban
		int num = Integer.parseInt(this.getName());
		int j=0;
		for(int i=0; i<10; i++) {
			while(j<num) {
				System.out.print("-");
				j++;
			}
		}
		System.out.println("Fin Hilo: " + num);
	}

}
