package clienteservidor;

public class Lanzador2 {
        public void lanzarCliente(int i){
                String clase="clienteservidor.TCPCli2";
                ProcessBuilder pb;
                try {
//                        pb = new ProcessBuilder(
//                                        "java", "-cp", "bin",  clase,
//                                        "localhost",  "5000", Integer.toString(i));
                        pb = new ProcessBuilder(
                                "java", "-cp", "bin",  clase,
                                "localhost",  "5000", Integer.toString(i));
                        pb.start();
                } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
        }
        
        public static void main(String[] args){
        	int i;
                Lanzador2 l=new Lanzador2();
                for (i=1; i<=10;i++) {
                	l.lanzarCliente(i);
                	System.out.println(i);
                }
                System.out.println("Lanzados " + (i-1) + " clientes ");
                // Si no hay hilos en el servidor los atiende, si puede, secuencialmente
                // En esta versión del lanzador mando al cliente un indicador del orden en 
                // que se manda para verlo al ejecutarse, ojo que va con TCPCli2
        }
}