package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ventanaAdmin extends JFrame {

	private JPanel contentPane;
	
	final verClientes verClie = new verClientes();
	
	final gestionarOfertas gestOfer = new gestionarOfertas();
	
	final verProductos gestPro = new verProductos();
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaAdmin frame = new ventanaAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ventanaAdmin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Gonzalo\\workspace\\Inso1\\Fotos\\Logo.jpg"));
		setTitle("Administrador Sport5000");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblqueDeseaHacer = new JLabel("\u00BFQu\u00E9 desea hacer?");
		lblqueDeseaHacer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblqueDeseaHacer.setBounds(25, 40, 177, 14);
		contentPane.add(lblqueDeseaHacer);
		
		JButton btnVerClientes = new JButton("Ver clientes");
		btnVerClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				verClie.setVisible(true);
				dispose();
				
			}
		});
		btnVerClientes.setBounds(43, 89, 145, 70);
		contentPane.add(btnVerClientes);
		
		JButton btnGestionarOfertas = new JButton("Gestionar ofertas");
		btnGestionarOfertas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				gestOfer.setVisible(true);;
				dispose();
			}
		});
		btnGestionarOfertas.setBounds(240, 89, 145, 70);
		contentPane.add(btnGestionarOfertas);
		
		JButton btnGestionarProductos = new JButton("Gestionar productos");
		btnGestionarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				gestPro.setVisible(true);;
				dispose();
			}
		});
		btnGestionarProductos.setBounds(119, 184, 167, 38);
		contentPane.add(btnGestionarProductos);
	}
}
