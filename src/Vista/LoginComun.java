package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextArea;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class LoginComun extends JFrame {

	private JPanel contentPane;
	private JTextField correoIntroducido;
	private JPasswordField contraseñaIntroducida;
	
	private int usuario;
	
	//Connection connection=ConexionBaseDatos.dbConector();
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginComun frame = new LoginComun();
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
	public LoginComun() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Gonzalo\\workspace\\Inso1\\Fotos\\Logo.jpg"));
		setTitle("Inicio de sesi\u00F3n Sport5000");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIntroduzcaSuCorreo = new JLabel("Introduzca su correo electr\u00F3nico y usuario:");
		lblIntroduzcaSuCorreo.setBounds(35, 40, 310, 14);
		lblIntroduzcaSuCorreo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblIntroduzcaSuCorreo);
		
		JLabel lblCorreoElectrnico = new JLabel("Correo electr\u00F3nico:");
		lblCorreoElectrnico.setBounds(35, 95, 110, 14);
		contentPane.add(lblCorreoElectrnico);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(35, 140, 100, 14);
		contentPane.add(lblContrasea);
		
		correoIntroducido = new JTextField();
		correoIntroducido.setBounds(155, 92, 190, 20);
		contentPane.add(correoIntroducido);
		correoIntroducido.setColumns(10);
		
		contraseñaIntroducida = new JPasswordField();
		contraseñaIntroducida.setBounds(155, 137, 190, 20);
		contentPane.add(contraseñaIntroducida);
		
		JButton btnIniciarSesin = new JButton("Iniciar sesi\u00F3n");
		btnIniciarSesin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				usuario = Controlador.operaciones.confirmarInicioSesion(correoIntroducido.getText(),contraseñaIntroducida.getText());
				
				if (usuario == 1){
					
					ventanaAdmin venAdmin = new ventanaAdmin();
					JOptionPane.showMessageDialog(null, "Ha iniciado sesión como administrador.");
					venAdmin.setVisible(true);
					dispose();
				}else if (usuario==2){
					
					ventanaCliente venClie = new ventanaCliente();
					JOptionPane.showMessageDialog(null, "Ha iniciado sesión como cliente.");
					venClie.setVisible(true);
					dispose();
					
				}
				
			}
		});
		btnIniciarSesin.setBounds(81, 199, 125, 37);
		contentPane.add(btnIniciarSesin);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.setBounds(227, 199, 125, 37);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null, "Ha abandonado Sport5000, que tenga un buen día.");
				dispose();
			}
		});
		contentPane.add(btnNewButton);

				
	
	}
	
	/*private int confirmarInicioSesion(String correo,String contraseña){
		
		int resultado = 0;
		//Connection connection = ConexionBaseDatos.dbConector();

		try{
			String query = "SELECT * FROM Administrador WHERE email='"+correo+"' AND Contraseña='"+contraseña+"'";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			int count=0;
				while(rs.next()){
					count++;
				}
				rs.close();
				pst.close();
				if(count == 1){
					resultado = 1;
					count++;
				}
				else{
					query = "SELECT * FROM Cliente WHERE email='"+correo+"' AND Contraseña='"+contraseña+"'";
					pst = connection.prepareStatement(query);
					rs = pst.executeQuery();
					while(rs.next()){
						count++;
					}
					rs.close();
					pst.close();
				}
				
				if(count==1){
					resultado=2;
				}else if(count==0){
					JOptionPane.showMessageDialog(null, "Correo electrónico o contraseña incorrectos");
				}
				//connection.close();
				//rs.close();
				//pst.close();
				
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
		
		return resultado;
		
		
	}
*/	
}

