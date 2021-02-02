package hilos;

public class EjemploHiloPrioridad1 {
	public static void main(String args[]) {
		HiloPrioridadl h1 = new HiloPrioridadl();
		HiloPrioridadl h2 = new HiloPrioridadl();
		HiloPrioridadl h3 = new HiloPrioridadl();
		h1.setPriority(Thread.NORM_PRIORITY);
		h2.setPriority(Thread.MAX_PRIORITY);
		h3.setPriority(Thread.MIN_PRIORITY);
		h1.start ();
		h2.start ();
		h3.start ();
		try {
			Thread.sleep(10000);
		} catch (Exception e) { }
		h1.pararHilo() ;
		h2.pararHilo() ;
		h3.pararHilo() ;
		System.out.println("h2 (Prioridad Maxima): " + h2.getContador());
		System.out.println("hi (Prioridad Normal): " + h1.getContador());
		System.out.println("h3 (Prioridad Minima): " + h3.getContador());
	}
}
