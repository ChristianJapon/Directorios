package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Controlador;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Caret;
import javax.swing.event.ListSelectionEvent;
import javax.swing.AbstractListModel;

public class VtnDirectorio extends JFrame {

	private JPanel contentPane;
	
	private Controlador controlador;
	private JTextField txtRuta;
	private JButton btnListar;
	
	
	DefaultListModel modeloLista = new DefaultListModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VtnDirectorio frame = new VtnDirectorio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VtnDirectorio() {
		controlador = new Controlador();
		initComponents();
	
	}

	
	
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRuta = new JLabel("Ruta :");
		lblRuta.setBounds(10, 11, 46, 14);
		contentPane.add(lblRuta);
		
		txtRuta = new JTextField();
		txtRuta.setBounds(54, 8, 329, 20);
		contentPane.add(txtRuta);
		txtRuta.setColumns(10);
		
		JLabel lblArchivos = new JLabel("Archivos");
		lblArchivos.setBounds(10, 70, 64, 14);
		contentPane.add(lblArchivos);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listar();
			}
		});
		btnListar.setBounds(393, 7, 89, 23);
		contentPane.add(btnListar);
		
		JList list = new JList();
		list.setBounds(10, 97, 383, 322);
		contentPane.add(list);
		
				
	}

	protected void Listar() {
		
		controlador.Ruta(txtRuta.getText());
		String [] resultado = controlador.getArchivos();
		System.out.println(txtRuta.getText());
		System.out.println("lista :"+resultado.length);
		modeloLista.addElement(resultado);
		
final String NOMBRE_DIRECTORIO = txtRuta.getText() ;
        
        try(DirectoryStream<Path> ds = Files.newDirectoryStream(Paths.get(NOMBRE_DIRECTORIO))){
            
            for(Path ruta : ds){
            //	txtarea.setCaret((Caret) ruta.getFileName());
                System.out.println(ruta.getFileName());
                modeloLista.addElement(ruta.getFileName());               
            }
        } catch(IOException e){
            System.err.println("Error -> " + e.getMessage());
        }
    
	
		
	}
}
