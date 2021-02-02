package garceta;


public class Saluda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		if (args.length == 1)
			for (int i=0;i<5;i++)
				System.out.println(args[0]);
		else
			System.out.println("Falta el parámetro: ");
	}

}
