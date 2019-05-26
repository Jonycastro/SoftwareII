package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

import Modelo.Cliente;

import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Toolkit;

public class LoginCliente extends JFrame {

	private JPanel defaultt;
	private JTextField nombreCliente;
	private JTextField apellidosCliente;
	private JTextField dniCliente;
	private JTextField correoCliente;
	private JTextField direccionCliente;
	private JPasswordField passCliente;
	private JLabel lblDireccion;
	private JLabel lblTelfono;
	private JLabel lbllosCamposMarcados;
	private JButton btnRegistrarse;
	private JButton btnYaTengoCuenta;
	private JTextField telefonoCliente;
	private JLabel lblContrasea_1;
	
	
	public int id =0;
	//Connection connection=ConexionBaseDatos.dbConector();
	private JPasswordField pass1Cliente;
	
	final LoginComun loginComun = new LoginComun();
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginCliente frame = new LoginCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @return 
	 */
	/*public int dameID(){
		 
	 id = 0000;
		id++;
		return id;
	}*/
	
	public LoginCliente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Gonzalo\\workspace\\Inso1\\Fotos\\Logo.jpg"));
		setTitle("Registro Sport5000");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		defaultt = new JPanel();
		setContentPane(defaultt);
		defaultt.setLayout(null);
		
		JLabel lblBienvenidoASport = new JLabel("BIENVENIDO A SPORT5000");
		lblBienvenidoASport.setBounds(40, 41, 268, 25);
		lblBienvenidoASport.setFont(new Font("Tahoma", Font.PLAIN, 20));
		defaultt.add(lblBienvenidoASport);
		
		JLabel lblRelleneElSiguiente = new JLabel("Rellene los siguientes datos para registrarse:");
		lblRelleneElSiguiente.setBounds(40, 86, 268, 15);
		lblRelleneElSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		defaultt.add(lblRelleneElSiguiente);
		
		JLabel lblNombre = new JLabel("Nombre*:");
		lblNombre.setBounds(29, 133, 65, 14);
		defaultt.add(lblNombre);
		
		nombreCliente = new JTextField();
		nombreCliente.setBounds(125, 130, 207, 20);
		defaultt.add(nombreCliente);
		nombreCliente.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos*:");
		lblApellidos.setBounds(29, 164, 65, 14);
		defaultt.add(lblApellidos);
		
		apellidosCliente = new JTextField();
		apellidosCliente.setBounds(125, 161, 207, 20);
		defaultt.add(apellidosCliente);
		apellidosCliente.setColumns(10);
		
		JLabel lblDireccin = new JLabel("DNI* :");
		lblDireccin.setBounds(29, 195, 56, 14);
		defaultt.add(lblDireccin);
		
		dniCliente = new JTextField();
		dniCliente.setBounds(125, 192, 207, 20);
		defaultt.add(dniCliente);
		dniCliente.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("E-mail*:");
		lblNewLabel.setBounds(29, 226, 65, 14);
		defaultt.add(lblNewLabel);
		
		correoCliente = new JTextField();
		correoCliente.setBounds(125, 223, 207, 20);
		defaultt.add(correoCliente);
		correoCliente.setColumns(10);
		
		direccionCliente = new JTextField();
		direccionCliente.setBounds(125, 316, 207, 20);
		defaultt.add(direccionCliente);
		direccionCliente.setColumns(10);
		
		passCliente = new JPasswordField();
		passCliente.setBounds(125, 254, 207, 20);
		defaultt.add(passCliente);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a*:");
		lblContrasea.setBounds(29, 257, 86, 14);
		defaultt.add(lblContrasea);
		
		lblDireccion = new JLabel("Direcci\u00F3n*:");
		lblDireccion.setBounds(29, 316, 65, 17);
		defaultt.add(lblDireccion);
		
		lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(29, 346, 65, 14);
		defaultt.add(lblTelfono);
		
		lbllosCamposMarcados = new JLabel("(Los campos marcados con * son obligatorios)");
		lbllosCamposMarcados.setBounds(50, 378, 268, 14);
		defaultt.add(lbllosCamposMarcados);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent ae0) {
				
				int count = Controlador.operaciones.yaExiste(correoCliente.getText());
				/*int count=0;
				try{

					String query="SELECT * FROM Cliente WHERE email='"+correoCliente.getText()+"'";
					
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
						while(rs.next()){
							count++;
						}
						
						query="SELECT * FROM Administrador WHERE email='"+correoCliente.getText()+"'";
						
						pst=connection.prepareStatement(query);
						rs=pst.executeQuery();
						
					
					while(rs.next()){
						count++;
					}

						rs.close();
						pst.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}*/
				
				if(nombreCliente.getText().length()==0||passCliente.getText().length()==0||pass1Cliente.getText().length()==0||dniCliente.getText().length()==0 || correoCliente.getText().length()==0|| direccionCliente.getText().length()==0){
					
					JOptionPane.showMessageDialog(null, "Los campos obligatorios no pueden estar vacios");
					passCliente.setText("");
					pass1Cliente.setText("");
					
				}else if(!isPasswordCorrect(passCliente.getPassword(), pass1Cliente.getPassword())){
					
					JOptionPane.showMessageDialog(null, "¡Las contraseñas no coinciden!");
					passCliente.setText("");
					pass1Cliente.setText("");
					
				}else if(count!=0){

					JOptionPane.showMessageDialog(null, "El correo empleado ya está en uso.");
					
				}/*else if(textDNI.getText().length() != 9){
					JOptionPane.showMessageDialog(null, "El DNI no es válido.");
					*/
				
				else if(!validarNif(dniCliente.getText())){
					
					JOptionPane.showMessageDialog(null, "El DNI introducido no es válido.");
					
				}else{
					try{	
					Cliente clie = new Cliente(correoCliente.getText(),nombreCliente.getText(),apellidosCliente.getText(),dniCliente.getText(),direccionCliente.getText(),passCliente.getText());
					Controlador.operaciones.altaUsuario(clie);
					loginComun.setVisible(true);
					dispose();
					
					}catch(Exception e1){
						e1.printStackTrace();
					}
					
					
				}
		}
				
			
		});
		btnRegistrarse.setBounds(40, 405, 135, 35);
		defaultt.add(btnRegistrarse);
		
		btnYaTengoCuenta = new JButton("Ya tengo cuenta");
		btnYaTengoCuenta.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				loginComun.setVisible(true);
				dispose();
			}
		});
		btnYaTengoCuenta.setBounds(199, 405, 133, 35);
		defaultt.add(btnYaTengoCuenta);
		
		telefonoCliente = new JTextField();
		telefonoCliente.setBounds(125, 347, 207, 20);
		defaultt.add(telefonoCliente);
		telefonoCliente.setColumns(10);
		
		lblContrasea_1 = new JLabel("Contrase\u00F1a*:");
		lblContrasea_1.setBounds(29, 284, 86, 22);
		defaultt.add(lblContrasea_1);
		
		pass1Cliente = new JPasswordField();
		pass1Cliente.setBounds(125, 285, 207, 20);
		defaultt.add(pass1Cliente);
	}
	private boolean isPasswordCorrect(char[] j1,char[] j2) {
		boolean valor = true;
		int puntero = 0;
		if (j1.length != j2.length){
				valor = false;
		}
		else{
			while((valor)&&(puntero < j1.length)){
				if (j1[puntero] != j2[puntero]){
					valor = false;
				}	
				puntero++;
			}
		}
		return valor;
	}
	
	public static boolean validarNif(String nif){
        boolean correcto=false;
        Pattern pattern=Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
        Matcher matcher=pattern.matcher(nif);
        if(matcher.matches()){
            String letra=matcher.group(2);
            String letras="TRWAGMYFPDXBNJZSQVHLCKE";
            int index=Integer.parseInt(matcher.group(1));
            index=index%23;
            String reference=letras.substring(index,index+1);
            if(reference.equalsIgnoreCase(letra)){
                correcto=true;
            }else{
                correcto=false;
            }
        }else{
            correcto=false;
        }
        return correcto;
    }
}
