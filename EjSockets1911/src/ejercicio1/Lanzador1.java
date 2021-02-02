package ejercicio1;

public class Lanzador1 {
	
	private static int numCli=2;

	public static int getNumCli() {
		return numCli;
	}

	public static void setNumCli(int numCli) {
		Lanzador1.numCli = numCli;
	}

	public void lanzarCliente(){
		String clase="ejercicio1.Cliente1";
		ProcessBuilder pb;
		try {
			pb = new ProcessBuilder("java", "-cp", "bin",  clase, "localhost",  "5000");
			pb.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		Lanzador1 l=new Lanzador1();
		for (int i=1; i<=numCli;i++) {
			l.lanzarCliente();
		}
		System.out.println("Lanzados " + numCli + " clientes ");
	}
}
