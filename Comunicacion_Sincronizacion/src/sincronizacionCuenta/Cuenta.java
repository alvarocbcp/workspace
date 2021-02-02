package sincronizacionCuenta;

public class Cuenta {
	
	private int saldo;
	
	public Cuenta(int s) {
		saldo = s;
	}
	
	int getSaldo() {
		return saldo;
	}
	
	void restar(int cantidad) {
		saldo = saldo - cantidad;
	}
	
	void sumar(int cantidad) {
		saldo = saldo + cantidad;
	}
	
	synchronized void retirarDinero(int cant, String nom) {
		if(getSaldo() >= cant) {
			System.out.println(nom + " SE VA A RETIRAR SALDO (ACTUAL ES: " + getSaldo() + ")");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			restar(cant);
			System.out.println(nom + " retira => " + cant + " ACTUAL(" + getSaldo() + ")");
		}
		else {
			System.out.println(nom + "No puede retirar dinero, NO HAY SALDO (" + getSaldo() + ")");
		}
		if(getSaldo() < 0) {
			System.out.println("SALDO NEGATIVO => " + getSaldo());
		}
	}
	
	synchronized void ingresarDinero(int cant, String nom) {
		sumar(cant);
		System.out.println(nom + " ingresa => " + cant + " ACTUAL(" + getSaldo() + ")");
	}

}
