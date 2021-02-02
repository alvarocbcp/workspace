package monitoresHamsters;

public class Hamster extends Thread{
	
	private int id;
	private Rueda_Plato rueda_plato;

	public Hamster(int id, Rueda_Plato rueda_plato) {
		this.id = id;
		this.rueda_plato = rueda_plato;
	}
	
	public void run() {
		
		try {
			rueda_plato.empezarJugar(id);
			Thread.sleep(3000);
			rueda_plato.terminarJugar(id);
			rueda_plato.empezarComer(id);
			Thread.sleep(5000);
			rueda_plato.terminarComer(id);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
