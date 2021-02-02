package ejercicio3;

public class Hamster extends Thread{
	
	private int id;
	private Plato_Rueda plato_rueda;
	
	public Hamster(int id, Plato_Rueda plato_rueda) {
		this.id = id;
		this.plato_rueda = plato_rueda;
	}
	
	public void run() {
		try {
			plato_rueda.empezarComida(id);
			Thread.sleep(5000);
			plato_rueda.terminarComida(id);
			plato_rueda.empezarJugar(id);
			Thread.sleep(3000);
			plato_rueda.terminarJugar(id);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
