package sincronizacionCuenta;

public class Main {

	public static void main(String[] args) {
		
		Cuenta c = new Cuenta(40);
		SacarDinero h1 = new SacarDinero("Ana", c);
		SacarDinero h2 = new SacarDinero("Juan", c);
		IngresarDinero h3 = new IngresarDinero("Juan", c);
		IngresarDinero h4 = new IngresarDinero("Ana", c);
		
		h2.start();
		h1.start();
		h3.start();
		h4.start();

	}

}
