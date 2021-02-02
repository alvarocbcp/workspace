package monitoresHamsters;

public class Main {

	public static void main(String[] args) {
		Rueda_Plato rp = new Rueda_Plato();
		
		Hamster[] hamsters = new Hamster[10];
		
		for(int i = 1; i<=10; i++) {
			hamsters[(i-1)] = new Hamster(i, rp);
			hamsters[(i-1)].start();
		}
	}

}
