package sincronizacionCuenta;

public class IngresarDinero extends Thread{
	private Cuenta c;
	String nom;
	public IngresarDinero(String n, Cuenta c){
		super(n);
		this.c = c;
	}
	
	public void run() {
		for(int i=1; i<=4; i++) {
			c.ingresarDinero(100, getName());
		}
	}
}
