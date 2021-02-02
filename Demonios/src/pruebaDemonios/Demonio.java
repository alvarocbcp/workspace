package pruebaDemonios;

public class Demonio extends Thread{
	
	public void run() {
		while(true);
	}

	public static void main(String[] args) throws InterruptedException {
		
		Demonio d = new Demonio();				//Creamos el hilo
		d.setDaemon(true);						//Le ponemos como demonio
		d.start();								//Iniciamos el hilo
		Thread.sleep(30000);					//Dormimos main 30s
		System.out.println("Acaba el main");
		

	}

}
