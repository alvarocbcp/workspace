package fumadoresAgente;

public class Fumador extends Thread{

	private Mesa mesa;
	private int id;

	public Fumador(int id, Mesa mesa) {
		this.id = id;
		this.mesa = mesa;
	}

	public void run() {
		try {
			while(true) {
				mesa.empezarFumar(id);
				System.out.println("El fumador " + id + " ha empezado a fumar");
				Thread.sleep(1000);
				mesa.terminarFumar(id);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}








































	/*

	private int id;
	private Mesa mesa;

	public Fumador(int id, Mesa mesa) {
		this.id = id;
		this.mesa = mesa;
	}

	public void run() {
		try {
			while(true) {
				mesa.empezarFumar(id);
				System.out.println("Fumador " + id + " esta fumando");
				Thread.sleep(1000);
				mesa.terminarFumar(id);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 */

}
