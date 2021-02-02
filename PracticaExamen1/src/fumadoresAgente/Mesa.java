package fumadoresAgente;

public class Mesa {
	
	public static int ingredienteFalta = 0;
	public static boolean fumando = false;
	
	public synchronized void empezarFumar(int ingrediente) {
		while(ingrediente != ingredienteFalta || fumando) {
			try {
				System.out.println("El fumador " + ingrediente + " esta esperando para fumar");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//Empieza a fumar
		fumando = true;
		//Deja la mesa vacia
		ingredienteFalta = 0;
		notifyAll();
	}
	
	public synchronized void terminarFumar(int id) {
		System.out.println("El fumador " + id  + " ha terminado de fumar");
		fumando = false;
		notifyAll();
	}
	
	public synchronized void colocar(int ingrediente) {
		while(ingredienteFalta != 0 || fumando) {
			try {
				System.out.println("Estanquero: no puedo poner ingrediente aun");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		ingredienteFalta = ingrediente;
		System.out.println("En la mesa falta el ingrediente " + ingredienteFalta);
		notifyAll();
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	public static int mesa = 0;					//Indica que elemento falta en la mesa
	public static boolean fumando = false;		//Indica si hay alguien fumando
	
	public synchronized void empezarFumar(int ingrediente) {
		while(mesa != ingrediente || fumando) {
			try {
				System.out.println("El fumador " + ingrediente + " no puede fumar aun");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
		//Se hace el cigarro
		mesa = 0; //Mesa vacia
		//Fuma
		fumando=true;
	}
	
	public synchronized void terminarFumar(int id) {
		System.out.println("El fumador " + id + " ha terminado de fumar");
		fumando = false;
		notifyAll();
	}
	
	public synchronized void colocar(int noesta) {
		while(mesa != 0 || fumando) {
			try {
				System.out.println("No puedo poner ingrediente aun");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			mesa = noesta;
			System.out.println("En la mesa no hay ingrediente " + mesa);
			notifyAll();
		}
	}
*/
}
