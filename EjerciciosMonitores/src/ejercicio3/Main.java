package ejercicio3;

public class Main {

	public static void main(String[] args) {
		
		Plato_Rueda pr = new Plato_Rueda();
		
		Hamster h1 = new Hamster(1, pr);
		Hamster h2 = new Hamster(2, pr);
		Hamster h3 = new Hamster(3, pr);
		Hamster h4 = new Hamster(4, pr);
		Hamster h5 = new Hamster(5, pr);
		Hamster h6 = new Hamster(6, pr);
		Hamster h7 = new Hamster(7, pr);
		Hamster h8 = new Hamster(8, pr);
		Hamster h9 = new Hamster(9, pr);
		Hamster h10 = new Hamster(10, pr);
		
		
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		h5.start();
		h6.start();
		h7.start();
		h8.start();
		h9.start();
		h10.start();

	}

}
