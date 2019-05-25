package Vista;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JSpinner;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.SpinnerListModel;
import javax.swing.JTextField;

import Controlador.operaciones;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class gestionarOfertas extends JFrame {

	private JPanel contentPane;
	private JTextField nuevoDesc;
	private JTextField nuevoPre;
	
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionarOfertas frame = new gestionarOfertas();
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
	public gestionarOfertas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Gonzalo\\workspace\\Inso1\\Fotos\\Logo.jpg"));
		setTitle("Gesti\u00F3n de ofertas Sort 5000");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccione = new JLabel("Seleccione los valores que desea para los siguientes campos :");
		lblSeleccione.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSeleccione.setBounds(40, 24, 352, 14);
		contentPane.add(lblSeleccione);
		
		JLabel lblDescuentoOfertado = new JLabel("Descuento ofertado :");
		lblDescuentoOfertado.setBounds(79, 79, 123, 14);
		contentPane.add(lblDescuentoOfertado);
		
		JLabel lblPrecioPremium = new JLabel("Precio premium :");
		lblPrecioPremium.setBounds(79, 135, 123, 14);
		contentPane.add(lblPrecioPremium);
		
		JButton button = new JButton("Actualizar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String descuento = nuevoDesc.getText();
				String precio = nuevoPre.getText();
				int escoger = 0;
				if(nuevoDesc.getText().length()==0 && nuevoPre.getText().length() !=0){
					 escoger =2;
					operaciones.actualizarOfertas(descuento, precio, escoger);
					
				}else if(nuevoDesc.getText().length()!=0 && nuevoPre.getText().length() ==0){
					escoger = 1;
					operaciones.actualizarOfertas(descuento, precio, escoger);
				}else if(nuevoDesc.getText().length()!=0 && nuevoPre.getText().length() !=0){
					operaciones.actualizarOfertas(descuento, precio, escoger);
				}else if(nuevoDesc.getText().length()==0 && nuevoPre.getText().length() ==0){
					JOptionPane.showMessageDialog(null, "Es necesario rellenar algun campo para actualizar las ofertas.");
				}
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\Gonzalo\\Desktop\\InsoBBDD\\Iconos\\refresh-157064_960_720.png"));
		button.setFont(new Font("Verdana", Font.BOLD, 11));
		button.setBackground(Color.WHITE);
		button.setBounds(79, 183, 176, 67);
		contentPane.add(button);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				new ventanaAdmin().setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(335, 227, 89, 23);
		contentPane.add(btnVolver);
		
		JLabel lblNuevoValor = new JLabel("Nuevo valor :");
		lblNuevoValor.setBounds(196, 54, 83, 14);
		contentPane.add(lblNuevoValor);
		
		JLabel lblAntiguoValor = new JLabel("Valor actual:");
		lblAntiguoValor.setBounds(309, 54, 83, 14);
		contentPane.add(lblAntiguoValor);
		
		nuevoDesc = new JTextField();
		nuevoDesc.setBounds(206, 76, 63, 20);
		contentPane.add(nuevoDesc);
		nuevoDesc.setColumns(10);
		
		nuevoPre = new JTextField();
		nuevoPre.setColumns(10);
		nuevoPre.setBounds(206, 132, 63, 20);
		contentPane.add(nuevoPre);
		
		JLabel lblSelectdesc = new JLabel(operaciones.descuentoActual());
		lblSelectdesc.setBounds(319, 79, 46, 14);
		contentPane.add(lblSelectdesc);
		
		JLabel lblSelectprec = new JLabel(/*operaciones.precioActual()*/);
		lblSelectprec.setBounds(319, 135, 46, 14);
		contentPane.add(lblSelectprec);
	}
	


	
}
