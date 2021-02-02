package ejercicio1;

public class Lanzador {
	
	 public void lanzarCliente(int i){
         String clase="ejercicio1.Cliente";
         ProcessBuilder pb;
         try {
        	 pb = new ProcessBuilder("java", "-cp", "bin",  clase, "localhost",  "6000", Integer.toString(i));
             pb.start();
         } catch (Exception e) {
        	 System.out.println(e);
         }
 }

	public static void main(String[] args) {
		int i;
        Lanzador l=new Lanzador();
        for (i=1; i<=5;i++) {
        	l.lanzarCliente(i);
        }
        System.out.println("Lanzados " + (i-1) + " clientes ");

	}

}
