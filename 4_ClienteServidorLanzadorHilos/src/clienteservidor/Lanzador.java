package clienteservidor;

public class Lanzador {
        public void lanzarCliente(){
                String clase="clienteservidor.TCPCli";
                ProcessBuilder pb;
                try {
                        pb = new ProcessBuilder(
                                        "java", "-cp", "bin",  clase,
                                        "192.168.56.1",  "5000");
                        pb.start();
                } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
        }
        
        public static void main(String[] args){
        	int i;
                Lanzador l=new Lanzador();
                for (i=1; i<=50;i++)
                	l.lanzarCliente();
                
                System.out.println("Lanzados " + (i-1) + " clientes ");
                // Si no hay hilos en el servidor los atiende, si puede, secuencialmente
        }
}