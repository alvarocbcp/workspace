package ejercicio1;

public class Main {

	public static void main(String[] args) {
		
		Pelota pelota = new Pelota();
		
		Partido p1 = new Partido(pelota, 1);
		Partido p2 = new Partido(pelota, 2);
		Partido p3 = new Partido(pelota, 3);
		Partido p4 = new Partido(pelota, 4);
		Partido p5 = new Partido(pelota, 5);
		Partido p6 = new Partido(pelota, 6);
		Partido p7 = new Partido(pelota, 7);
		Partido p8 = new Partido(pelota, 8);
		Partido p9 = new Partido(pelota, 9);
		Partido p10 = new Partido(pelota, 10);
		
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		p6.start();
		p7.start();
		p8.start();
		p9.start();
		p10.start();

	}

}
