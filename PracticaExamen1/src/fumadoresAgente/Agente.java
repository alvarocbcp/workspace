package fumadoresAgente;

import java.util.*;

public class Agente extends Thread{
	
	private Mesa mesa;
	private Random r;
	
	public Agente(Mesa mesa) {
		this.mesa = mesa;
		r = new Random();
	}
	
	public void run() {
		while(true) {
			mesa.colocar(r.nextInt(3)+1);
		}
	}
}
