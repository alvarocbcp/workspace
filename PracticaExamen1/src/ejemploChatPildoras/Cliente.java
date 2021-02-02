package ejemploChatPildoras;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Cliente {

	public static void main(String[] args) {
		
		MarcoCliente mimarco = new MarcoCliente();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoCliente extends JFrame{
	
	public MarcoCliente() {
		
		setBounds(600, 300, 280, 350);
		
		LaminaMarcoCliente miLamina = new LaminaMarcoCliente();
		
		add(miLamina);
		
		setVisible(true);
	}
}

class LaminaMarcoCliente extends JPanel implements Runnable{
	
	public LaminaMarcoCliente() {
		
		nick = new JTextField(5);
		
		add(nick);
		
		JLabel texto = new JLabel("-CHAT-");
		
		add(texto);
		
		ip = new JTextField(8);
		
		add(ip);
		
		campochat = new JTextArea(12, 20);
		
		add(campochat);
		
		campo1 = new JTextField(20);
		
		add(campo1);
		
		miBoton = new JButton("Enviar");
		
		EnviaTexto miEvento = new EnviaTexto();
		
		miBoton.addActionListener(miEvento);
		
		add(miBoton);
		
		Thread mihilo = new Thread(this);
		
		mihilo.start();
		
	}
	
	private class EnviaTexto implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Socket misocket = new Socket("168.192.1.80", 5000);
				
				PaqueteEnvio datos = new PaqueteEnvio();
				
				datos.setNick(nick.getText());
				
				datos.setIp(ip.getText());
				
				datos.setMensaje(campo1.getText());
				
				ObjectOutputStream paquete_datos = new ObjectOutputStream(misocket.getOutputStream());
				
				paquete_datos.writeObject(datos);
				
				misocket.close();
				
				/*DataOutputStream flujo_salida = new DataOutputStream(misocket.getOutputStream());
				
				flujo_salida.writeUTF(campo1.getText());
				
				flujo_salida.close();*/
				
			}catch(UnknownHostException e1) {
				e1.printStackTrace();
			}catch(IOException e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	private JTextField campo1, nick, ip;
	
	private JTextArea campochat;
	
	private JButton miBoton;

	@Override
	public void run() {
		
		try {
			
			ServerSocket servidor_cliente = new ServerSocket(5500);
			
			Socket cliente;
			
			PaqueteEnvio paqueteRecibido;
			
			while(true) {
				
				cliente = servidor_cliente.accept();
				
				ObjectInputStream flujoentrada = new ObjectInputStream(cliente.getInputStream());
				
				paqueteRecibido = (PaqueteEnvio) flujoentrada.readObject();
				
				campochat.append("\n" + paqueteRecibido.getNick() + ": " + paqueteRecibido.getMensaje());
				
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}


class PaqueteEnvio implements Serializable{
	
	private String nick, ip, mensaje;

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}


