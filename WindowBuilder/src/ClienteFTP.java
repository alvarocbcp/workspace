import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ProtocolCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ClienteFTP extends JFrame {
	private static final long serialVersionUID = 1L;

	//Campos de la cabecera
	static JTextField cab1 = new JTextField();
	static JTextField cab2 = new JTextField();
	static JTextField cab3 = new JTextField();

	//Campos de mensajes parte inferior
	private static JTextField campo1 = new JTextField();
	private static JTextField campo2 = new JTextField();

	//Botones
	JButton botonCargar = new JButton();
	JButton botonDescargar = new JButton();
	JButton botonBorrar = new JButton();
	JButton botonCrearDir = new JButton();
	JButton botonDelDir = new JButton();
	JButton botonSalir = new JButton();
	JButton botonRenombrar = new JButton();

	//Lista para los datos del directorio
	static JList listaDirec = new JList();

	//contenedor
	private final Container c = getContentPane();

	//Datos del servidor FTP
	private static FTPClient cliente;
	String servidor = "localhost";
	String user = "usuariol";
	String pasw = "usuariol";
	boolean login;
	static String direcInicial = "/";

	//para saber el directorio y fichero seleccionado
	static String direcSelec = direcInicial;
	static String ficheroSelec = "";

	/**
	 * Create the frame.
	 */
	public ClienteFTP(FTPClient cliente) throws IOException{
		super("CLIENTE FTP");
		this.cliente = cliente;
		//para ver los comandos que se originan
		cliente.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		//cliente.connect(servidor);
		//login = cliente.login(user, pasw);

		//Se establece el directorio de trabajo actual
		cliente.changeWorkingDirectory(direcInicial);

		//Obteniendo ficheros y directorios del directorio actual
		FTPFile[] files = cliente.listFiles();

		//Construyendo la lista de ficheros y directorios del directorio de trabajo actual
		llenarLista(files, direcInicial);

		//Preparacion de la lista
		//Se configura el tipo de seleccion para que solo se pueda seleccionar un elemento de la lista
		listaDirec.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		//Barra de desplazamiento para la lista
		JScrollPane barraDesplazamiento = new JScrollPane(listaDirec);
		barraDesplazamiento.setPreferredSize(new Dimension(335, 420));
		barraDesplazamiento.setBounds(new Rectangle(5, 65, 335, 420));
		c.add(barraDesplazamiento);
		c.setLayout(null);

		//Botones

		botonCargar.setText("Subir fichero");
		botonCargar.setBounds(367, 63, 239, 25);
		getContentPane().add(botonCargar);

		botonDescargar.setText("Descargar fichero");
		botonDescargar.setBounds(367, 111, 239, 25);
		getContentPane().add(botonDescargar);

		botonBorrar.setText("Eliminar fichero");
		botonBorrar.setBounds(367, 159, 239, 25);
		getContentPane().add(botonBorrar);
		
		botonRenombrar.setText("Renombrar fichero");
		botonRenombrar.setBounds(367, 207, 239, 25);
		getContentPane().add(botonRenombrar);

		botonCrearDir.setText("Crear directorio");
		botonCrearDir.setBounds(367, 255, 239, 25);
		getContentPane().add(botonCrearDir);

		botonDelDir.setText("Eliminar directorio");
		botonDelDir.setBounds(367, 303, 239, 25);
		getContentPane().add(botonDelDir);

		botonSalir.setText("Salir");
		botonSalir.setBounds(367, 351, 239, 25);
		getContentPane().add(botonSalir);

		cab1.setText("Servidor FTP: " + servidor);
		cab1.setBounds(5, 11, 135, 20);
		getContentPane().add(cab1);
		cab1.setColumns(10);
		cab1.setEditable(false);

		cab2.setText("Usuario: "+ user);
		cab2.setBounds(501, 11, 105, 20);
		getContentPane().add(cab2);
		cab2.setColumns(10);
		cab2.setEditable(false);

		cab3.setText("DIRECTORIO RAIZ: "+ direcInicial);
		cab3.setBounds(5, 42, 135, 20);
		getContentPane().add(cab3);
		cab3.setColumns(10);
		cab3.setEditable(false);

		campo1.setText("<< ARBOL DE DIRECCIONES CONSTRUIDO >>");
		campo1.setBounds(5, 496, 335, 20);
		getContentPane().add(campo1);
		campo1.setColumns(10);
		campo1.setEditable(false);

		campo2.setBounds(5, 530, 335, 20);
		getContentPane().add(campo2);
		campo2.setColumns(10);	
		campo2.setEditable(false);

		//Se a�aden el resto de los campos de la pantalla


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(650, 600);
		setVisible(true);

		//Acciones al pulsar en la lista o en los botones

		listaDirec.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting()) {
					ficheroSelec = "";
					//Elemento que se ha seleccionado de la lista
					String fic = listaDirec.getSelectedValue().toString();
					if(listaDirec.getSelectedIndex()==0) {
						//Se hace clic en el primer elemento del JList
						//Se comprueba si es el directorio inicial
						if(!fic.equals(direcInicial)) {
							//Si no estamos en el directorio inicial, hay que subir al directorio padre
							try {
								cliente.changeToParentDirectory();
								direcSelec = cliente.printWorkingDirectory();
								FTPFile[] ff2 = null;
								//Directorio de trabajo actual = directorio padre
								cliente.changeWorkingDirectory(direcSelec);
								//Se obtienen ficheros y directorios
								ff2 = cliente.listFiles();
								campo1.setText("");
								//Se llena la lista con fich. del directorio padre
								llenarLista(ff2, direcSelec);
							}catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
					//No se puede hacer clic en el primer elemento del JList
					//Puede ser un fichero o un directorio
					else {
						if(fic.substring(0, 6).equals("(DIRE) ")) {
							//Se trata de un directorio
							try {
								fic = fic.substring(6);
								String direcSelec2 = "";
								if (direcSelec.equals("/")) {
									direcSelec2 = direcSelec + fic;
								}
								else {
									direcSelec2 = direcSelec + "/" + fic;
								}
								FTPFile[] ff2 = null;
								cliente.changeWorkingDirectory(direcSelec2);
								ff2 = cliente.listFiles();
								campo1.setText("DIRECTORIO: " + fic + ", " + ff2.length + " elementos");
								//Directorio actual
								direcSelec = direcSelec2;
								//Se llena la lista dcon datos del directorio
								llenarLista(ff2, direcSelec);
							}catch (IOException e1) {
								e1.printStackTrace();
							}
						}
						else {
							//Se trata de un fichero
							ficheroSelec = direcSelec;
							if(direcSelec.equals("/")) {
								ficheroSelec += fic;
							}
							else {
								ficheroSelec += "/" + fic;
							}
							campo1.setText("FICHERO seleccionado: " + ficheroSelec);
							ficheroSelec = fic; //Me quedo con el nombre
						}//fin else
					}//fin else del fichero o directorio
					campo2.setText("DIRECTORIO ACTUAL: " + direcSelec);
				}//fin if inicial
			}
		});//fin accion del JList

		botonCargar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser f;
				File file;
				f = new JFileChooser();
				//Solo se pueden seleccionar ficheros
				f.setFileSelectionMode(JFileChooser.FILES_ONLY);
				//Titulo de la ventana
				f.setDialogTitle("Selecciona el Fichero a SUBIR AL SERVIDOR FTP");
				//Se muestra la ventana
				int returnVal = f.showDialog(f, "Cargar");
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					//Fichero seleccionado
					file = f.getSelectedFile();
					//nombre completo del fichero
					String archivo = file.getAbsolutePath();
					//solo nombre del fichero
					String nombreArchivo = file.getName();
					try {
						SubirFichero(archivo, nombreArchivo);
					}catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});//fin boton subir

		botonDescargar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String directorio = direcSelec;
				if(!direcSelec.equals("/")) {
					directorio = directorio + "/";
				}
				if(!direcSelec.equals("")) {
					DescargarFichero(directorio + ficheroSelec, ficheroSelec);
				}

			}
		});//fin boton descargar
		
		botonBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String directorio = direcSelec;
				if (!direcSelec.equals("/")) {
					directorio = directorio + "/";
				}
				if (!ficheroSelec.equals("")) {
					BorrarFichero(directorio + ficheroSelec, ficheroSelec);
				}
			}
		});//fin boton borrar
		
		botonRenombrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String directorio = direcSelec;
				if(!direcSelec.equals("/")) {
					directorio = directorio + "/";
				}
				if(!ficheroSelec.equals("")) {
					RenombrarFichero(directorio + ficheroSelec, ficheroSelec);
				}
				
			}
		});
		
		botonCrearDir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombreCarpeta = JOptionPane.showInputDialog(null, "Introduce el nombre del directorio", "carpeta");
				if(!(nombreCarpeta==null)) {
					String directorio = direcSelec;
					if(!direcSelec.equals("/")) {
						directorio = directorio + "/";
					}
					//nombre del directorio a crear
					directorio += nombreCarpeta.trim();//quita los blancos a derecha e izquierda
					try {
						if(cliente.makeDirectory(directorio)) {
							String m = nombreCarpeta.trim() + " => Se ha creado ocorrectamente...";
							JOptionPane.showMessageDialog(null, m);
							campo1.setText(m);
							//Directorio ode trabajo actual
							cliente.changeWorkingDirectory(direcSelec);
							FTPFile[] ff2 = null;
							//Obtener ficheros del directorio actual
							ff2 = cliente.listFiles();
							//Llenar lista
							llenarLista(ff2, direcSelec);
						}
						else {
							JOptionPane.showMessageDialog(null, nombreCarpeta.trim() + " => No se ha podido crear...");
						}
					}catch (IOException e1) {
						e1.printStackTrace();
					}
				}//fin if
			}
		});//fin botonCrearDir
		
		botonDelDir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombreCarpeta = JOptionPane.showInputDialog(null, "Introduce el nombre del directorio a eliminar", "carpeta");
				if(!(nombreCarpeta==null)) {
					String directorio = direcSelec;
					if(!direcSelec.equals("/")) {
						directorio = directorio + "/";
					}
					//Nombre del directorio a eliminar
					directorio += nombreCarpeta.trim();
					try {
						if(cliente.removeDirectory(directorio)) {
							String m = nombreCarpeta + " => Se ha eliminado correctamente...";
							JOptionPane.showMessageDialog(null, m);
							campo1.setText(m);
							cliente.changeWorkingDirectory(direcSelec);
							FTPFile[] ff2 = null;
							ff2 = cliente.listFiles();
							//Llenar la lista
							llenarLista(ff2, direcSelec);
						}
						else {
							JOptionPane.showMessageDialog(null, nombreCarpeta.trim() + " => No se ha podido eliminar...");
						}
					}catch (IOException e1) {
						e1.printStackTrace();
					}
				}//fin if
			}
		});// fin botonDelDir
		
		botonSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					cliente.disconnect();
				}catch (IOException e1) {
					e1.printStackTrace();
				}
				System.exit(0);

			}
		});

	}

	private static void llenarLista(FTPFile[] files, String direc2) {
		if(files==null) {
			return;
		}

		//Se crea un objeto DefaultListModel
		DefaultListModel modeloLista = new DefaultListModel();
		modeloLista = new DefaultListModel();

		//se definen propiedades para la lista, color y tipo de fuente
		listaDirec.setForeground(Color.blue);
		Font fuente = new Font("Courier", Font.PLAIN, 12);
		listaDirec.setFont(fuente);

		//Se eliminan todos los elementos de la lista
		listaDirec.removeAll();

		try {
			//Se establece el directorio de trabajo actual
			cliente.changeWorkingDirectory(direc2);
		}catch (IOException e) {
			e.printStackTrace();
		}
		direcSelec = direc2; //Directorio actual

		//Se a�ade el directorio de trabajo al listmodel, primer elemento
		modeloLista.addElement(direc2);

		//Se recorre el array con los ficheros y directorios
		for (int i=0; i<files.length; i++) {
			if(!(files[i].getName()).equals(".") && !(files[i].getName()).equals("..")) {
				//Nos saltamos los directorios . y ..
				//Se obtiene el nombre del fichero o directorio
				String f = files[i].getName();
				//Si es directorio se a�ade al nombre (DIR)
				if(files[i].isDirectory()) {
					f = "(DIR) " + f;
				}
				//Se a�ade el nombre del fichero o directorio al listmodel
				modeloLista.addElement(f);
			}//fin if
		}//fin for
		try {
			//Se asigna el listmodel a JList
			//Se muestra en pantalla la lista de ficheros y directorios
			listaDirec.setModel(modeloLista);
		}catch (NullPointerException e) {
			e.printStackTrace();
		}
	}//Fin llenarLista

	private boolean SubirFichero (String archivo, String soloNombre) throws IOException{
		cliente.setFileType(FTP.BINARY_FILE_TYPE);
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(archivo));
		boolean ok = false;
		//directorio de trabajo actual
		cliente.changeWorkingDirectory(direcSelec);
		if(cliente.storeFile(soloNombre, in)) {
			String s = " " + soloNombre + " => SUBIDO CORRECTAMENTE...";
			campo1.setText(s);
			campo2.setText("Se va a actualizar el arbol de directorios...");
			JOptionPane.showMessageDialog(null, s);
			FTPFile[] ff2 = null;
			//Obtener ficheros del directorio actual
			ff2 = cliente.listFiles();
			//Llenar la lista con los ficheros del directorio actual
			llenarLista(ff2, direcSelec);
			ok = true;
		}
		else {
			campo1.setText("No se ha podido subir..." + soloNombre);
		}
		return ok;
	}//fin SubirFichero

	private void DescargarFichero(String NombreCompleto, String nombreFichero) {
		File file;
		String archivoyCarpetaDestino = "";
		String carpetaDestino = "";
		JFileChooser f = new JFileChooser();
		//Solo se pueden seleccionar directorios
		f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		//Titulo de la ventana
		f.setDialogTitle("Selecciona el Directorio donde DESCARGAR EL FICHERO");
		int returnVal = f.showDialog(null, "Descargar");
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			file = f.getSelectedFile();
			//Obtener carpeta de destino
			carpetaDestino = (file.getAbsolutePath()).toString();
			//Construimos el nombre completo que se creara en nuestro disco
			archivoyCarpetaDestino = carpetaDestino + File.separator + nombreFichero;
			try {
				cliente.setFileType(FTP.BINARY_FILE_TYPE);
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(archivoyCarpetaDestino));
				if(cliente.retrieveFile(NombreCompleto, out)) {
					JOptionPane.showMessageDialog(null, nombreFichero + " ==> Se ha descargado correctamente...");
				}
				else {
					JOptionPane.showMessageDialog(null, nombreFichero + " => No se ha podido descargar...");
				}
				out.close();
			}catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}//fin DescargarFichero

	private void BorrarFichero(String NombreCompleto, String nombreFichero) {
		//pide informacion
		int seleccion = JOptionPane.showConfirmDialog(null, "�Desea eliminar el fichero seleccionado?");
		if(seleccion == JOptionPane.OK_OPTION) {
			try {
				if(cliente.deleteFile(NombreCompleto)) {
					String m = nombreFichero + " => Eliminado correctamente... ";
					JOptionPane.showMessageDialog(null, m);
					campo1.setText(m);
					//Directorio de trabajo actual
					cliente.changeWorkingDirectory(direcSelec);
					FTPFile[] ff2 = null;
					//Obtener ficheros del directorio actual
					ff2 = cliente.listFiles();
					//Llenar la lista con los ficheros del directorio actual
					llenarLista(ff2, direcSelec);
				}
				else {
					JOptionPane.showMessageDialog(null, nombreFichero + " => No se ha podido eliminar...");
				}
			}catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}//fin BorrarFichero
	
	private void RenombrarFichero(String NombreCompleto, String nombreFichero) {
		//Pide informacion
		String nuevoNombre = JOptionPane.showInputDialog("Introduce el nuevo nombre del fichero");
		try {
			if(cliente.rename(NombreCompleto, nuevoNombre)) {
				String m = nombreFichero + " => Renombrado correctamente...";
				JOptionPane.showMessageDialog(null, m);
				campo1.setText(m);
				//Directorio de trabajo actual
				cliente.changeWorkingDirectory(direcSelec);
				FTPFile[] ff2 = null;
				//Obtener ficheros del directorio actual
				ff2 = cliente.listFiles();
				//Llenar la lista con los ficheros del directorio actual
				llenarLista(ff2, direcSelec);
			}
			else {
				JOptionPane.showMessageDialog(null, nombreFichero + " => No se ha podido renombrar...");
			}
		}catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
