package ejercicio2;

public class Lanzador2 {
	private static int numCli=2;

	public void lanzarCliente(){
		String clase="ejercicio2.Cliente2";
		ProcessBuilder pb;
		try {
			pb = new ProcessBuilder("java", "-cp", "bin",  clase, "localhost",  "5000");
			pb.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		Lanzador2 l =new Lanzador2();
		for (int i=1; i<=numCli;i++) {
			l.lanzarCliente();
		}
		System.out.println("Lanzados " + numCli + " clientes ");
	}

}
