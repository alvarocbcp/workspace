import java.net.*;

import java.io.*;

public class TCPServ {
  
  public static void main (String[] args) {
	Socket cliente = null;
	ServerSocket servidor = null;
    try {
	  // Creamos un Socket Servidor.
      servidor=new ServerSocket(5555);

      while (true) {
    	// Esperamos que se conecte un cliente.
          System.out.println("Esperando la conexion de un cliente ...."); 
          cliente=servidor.accept(); //Este metodo es bloqueante
          System.out.println("Recibida la conexion de un cliente");
          
          GestorPeticion gPE = new GestorPeticion(cliente);
		  new Thread(gPE).start();         
      }
	  
           	
      //cliente.close();  // Cerramos el socket asignado al cliente
      //servidor.close(); // Cerramos el socket servidor.
      // mejor en finally, para asegurarnos de que queda cerrado
    }

	// Tratamos las excepciones

    catch (SocketException e) {
      System.err.println("Error en una operacion de socket");
      e.getStackTrace();
    }
    catch (IOException e) {
    	
      System.err.println("Error en una operacion de entrada/salida");
    } finally {
    	try {
			cliente.close();
			servidor.close(); // Cerramos el socket servidor.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Cerramos el socket asignado al cliente
       	       
    }
  }
}


