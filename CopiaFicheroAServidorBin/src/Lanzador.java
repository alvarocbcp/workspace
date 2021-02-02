public class Lanzador {
        public void lanzarCliente(){
                String clase="TCPCli";
                ProcessBuilder pb;
                try {
                        pb = new ProcessBuilder(
                                        "java", "-cp", "bin",  clase,
                                       "localhost", "5555");
                        pb.start();
                } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
        }
        public static void main(String[] args){
                Lanzador l=new Lanzador();
                for (int i=1; i<=10;i++)
                	l.lanzarCliente();
                
                System.out.println("Ok");
        }
}