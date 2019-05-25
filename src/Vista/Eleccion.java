package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Eleccion extends JFrame {

	private JPanel contentPane;
	final LoginCliente loginCliente = new LoginCliente();
	
	final LoginComun loginComun = new LoginComun();
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eleccion frame = new Eleccion();
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
	public Eleccion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Gonzalo\\workspace\\Inso1\\Fotos\\Logo.jpg"));
		setTitle("Login Sport5000");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInicieSesinComo = new JLabel("Inicie sesi\u00F3n como:");
		lblInicieSesinComo.setBounds(37, 37, 116, 14);
		contentPane.add(lblInicieSesinComo);
		
		JButton btnAdministrador = new JButton("Administrador");
		btnAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				loginComun.setVisible(true);
				dispose();
			}
		});
		btnAdministrador.setBounds(60, 100, 116, 50);
		contentPane.add(btnAdministrador);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loginCliente.setVisible(true);
				dispose();
			}
		});
		btnCliente.setBounds(234, 100, 110, 50);
		contentPane.add(btnCliente);
	}
}