package fumadoresAgente;

public class Main {

	public static void main(String[] args) {
		
		Mesa mesa = new Mesa();
		Fumador f1 = new Fumador(1, mesa);
		Fumador f2 = new Fumador(2, mesa);
		Fumador f3 = new Fumador(3, mesa);
		Agente a = new Agente(mesa);
		
		f1.start();
		f2.start();
		f3.start();
		a.start();

	}

}
