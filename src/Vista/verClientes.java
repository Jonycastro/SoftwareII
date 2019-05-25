package Vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JSpinner;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import Controlador.operaciones;
import Modelo.Cliente;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class verClientes extends JFrame {

	private JPanel contentPane;
	public JTable mostrarClie;//cambiau
	private JLabel lblNewLabel_1;
	private JLabel lblEmail;
	private JTextField nombreIntrod;
	private JTextField dniIntrod;
	private JTextField emailIntrod;
	private JScrollPane scrollPane;
	
	
	//Connection connection=ConexionBaseDatos.dbConector();
	
	private JLabel lblNewLabel_2;
	private JTextField apellidosIntrod;
	private JTextField contraseñaIntrod;
	private JTextField direccionIntrod;
	private JButton btnVolver;
	//ventanaAdmin venAdmin = new ventanaAdmin();
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public verClientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Gonzalo\\workspace\\Inso1\\Fotos\\Logo.jpg"));
		setTitle("Clientes Sport 5000");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 56, 657, 215);
		contentPane.add(scrollPane);
		
		mostrarClie = new JTable();
		mostrarClie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				                                                 
				       // Get The Index Of The Slected Row 
				        int i = mostrarClie.getSelectedRow();

				        TableModel model = mostrarClie.getModel();
				        
				         // Display Slected Row In JTexteFields
				        nombreIntrod.setText(model.getValueAt(i,0).toString());

				        apellidosIntrod.setText(model.getValueAt(i,1).toString());

				        dniIntrod.setText(model.getValueAt(i,2).toString());

				        emailIntrod.setText(model.getValueAt(i,3).toString());
				        
				        contraseñaIntrod.setText(model.getValueAt(i,4).toString());
				        
				        direccionIntrod.setText(model.getValueAt(i,5).toString());
				         
			}
		});
		scrollPane.setViewportView(mostrarClie);
		mostrarClie.setFont(new Font("Tahoma", Font.PLAIN, 11));
		mostrarClie.setBackground(Color.LIGHT_GRAY);
		mostrarClie.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Apellidos", "DNI", "Email", "Contrase\u00F1a", "Direcci\u00F3n"
			}
		));
		
		JLabel lblNewLabel = new JLabel("Modifique los datos que desea cambiar o registre un nuevo cliente :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(46, 307, 401, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNombre.setBounds(56, 332, 66, 14);
		contentPane.add(lblNombre);
		
		lblNewLabel_1 = new JLabel("DNI :");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(56, 359, 66, 14);
		contentPane.add(lblNewLabel_1);
		
		lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblEmail.setBounds(56, 384, 66, 14);
		contentPane.add(lblEmail);
		
		nombreIntrod = new JTextField();
		nombreIntrod.setBounds(140, 332, 161, 20);
		contentPane.add(nombreIntrod);
		nombreIntrod.setColumns(10);
		
		dniIntrod = new JTextField();
		dniIntrod.setBounds(140, 357, 161, 20);
		contentPane.add(dniIntrod);
		dniIntrod.setColumns(10);
		
		emailIntrod = new JTextField();
		emailIntrod.setBounds(140, 381, 161, 20);
		contentPane.add(emailIntrod);
		emailIntrod.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Apellidos :");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(370, 335, 95, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a :");
		lblContrasea.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblContrasea.setBounds(370, 360, 95, 14);
		contentPane.add(lblContrasea);
		
		apellidosIntrod = new JTextField();
		apellidosIntrod.setColumns(10);
		apellidosIntrod.setBounds(489, 330, 161, 20);
		contentPane.add(apellidosIntrod);
		
		contraseñaIntrod = new JTextField();
		contraseñaIntrod.setColumns(10);
		contraseñaIntrod.setBounds(489, 357, 161, 20);
		contentPane.add(contraseñaIntrod);
		
		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				Cliente clie = new Cliente(emailIntrod.getText(),nombreIntrod.getText(),apellidosIntrod.getText(),dniIntrod.getText(),direccionIntrod.getText(),contraseñaIntrod.getText());
				
				
				if(emailIntrod.getText().length()==0){
					JOptionPane.showMessageDialog(null, "Es necesario rellenar los campos para añadir al cliente.");
				}else if(operaciones.yaExiste(emailIntrod.getText())== 2){
					JOptionPane.showMessageDialog(null, "Ya existe un cliente con ese email.");
				}else{
				operaciones.altaUsuario(clie);
				actualizarTabla();
				}
			}
		});
		
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Gonzalo\\Desktop\\InsoBBDD\\Iconos\\insert.png"));
		btnNewButton.setBounds(56, 433, 176, 67);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int count=0;	
				
				Cliente clie = new Cliente(emailIntrod.getText(),nombreIntrod.getText(),apellidosIntrod.getText(),dniIntrod.getText(),direccionIntrod.getText(),contraseñaIntrod.getText());
				
				if(emailIntrod.getText().length()==0){
					JOptionPane.showMessageDialog(null, "Es necesario introducir el email para eliminar al cliente.");
				}else if(operaciones.yaExiste(emailIntrod.getText())== 0 || operaciones.yaExiste(emailIntrod.getText())==1){
					JOptionPane.showMessageDialog(null, "No existe ningún cliente con ese email.");
				}else{
				operaciones.bajaUsuario(clie);
				actualizarTabla();
				}
				
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Gonzalo\\Desktop\\InsoBBDD\\Iconos\\delete-icon-1.png"));
		btnNewButton_1.setBounds(262, 433, 185, 67);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Actualizar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				Cliente clie = new Cliente(emailIntrod.getText(),nombreIntrod.getText(),apellidosIntrod.getText(),dniIntrod.getText(),direccionIntrod.getText(),contraseñaIntrod.getText());
					
				if(emailIntrod.getText().length()==0){
					JOptionPane.showMessageDialog(null, "Es necesario introducir el email para eliminar al cliente.");
				}else if(operaciones.yaExiste(emailIntrod.getText())== 0 ||operaciones.yaExiste(emailIntrod.getText())== 1){
					JOptionPane.showMessageDialog(null, "No existe ningún cliente con ese email.");
				}else{
				operaciones.actualizarUsuario(clie);
				actualizarTabla();
				}
					
					
				
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Gonzalo\\Desktop\\InsoBBDD\\Iconos\\refresh-157064_960_720.png"));
		btnNewButton_2.setBounds(474, 433, 176, 67);
		contentPane.add(btnNewButton_2);
		
		JLabel lblHagaClickEn = new JLabel("Haga click en el usuario sobre el que operar :");
		lblHagaClickEn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHagaClickEn.setBounds(46, 31, 308, 14);
		contentPane.add(lblHagaClickEn);
		
		JLabel lblparaRegistrarUn = new JLabel("*Para actualizar un cliente es necesario mantener el email igual.");
		lblparaRegistrarUn.setBounds(76, 409, 371, 14);
		contentPane.add(lblparaRegistrarUn);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n :");
		lblDireccin.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblDireccin.setBounds(370, 385, 95, 14);
		contentPane.add(lblDireccin);
		
		direccionIntrod = new JTextField();
		direccionIntrod.setColumns(10);
		direccionIntrod.setBounds(489, 382, 161, 20);
		contentPane.add(direccionIntrod);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				new ventanaAdmin().setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(713, 491, 89, 23);
		contentPane.add(btnVolver);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{scrollPane, mostrarClie, lblNewLabel, lblNombre, lblNewLabel_1, lblEmail, nombreIntrod, dniIntrod, emailIntrod}));
		
		Show_Users_In_JTable();
	}
	public void actualizarTabla(){
		
		DefaultTableModel model = (DefaultTableModel) mostrarClie.getModel();
        model.setRowCount(0);
        Show_Users_In_JTable();
	}
	/*public ArrayList<Cliente> getListaClientes(){
		
		ArrayList <Cliente> listaClientes =  new ArrayList<Cliente>();
		
		try{

			String query="SELECT * FROM Cliente ";
			
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			Cliente cliente;
			
			while(rs.next()){
				cliente = new Cliente(rs.getString("Nombre"),rs.getString("Apellidos"),rs.getString("dni"),rs.getString("email"),rs.getString("Contraseña"),rs.getString("Dirección"));
				listaClientes.add(cliente);
			}
			
		
			rs.close();
			pst.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			
					
		}
		return listaClientes;
	
	}*/
	
	
	 public void Show_Users_In_JTable()
	   {
	       ArrayList<Cliente> listaClie = operaciones.getListaClientes();
	       DefaultTableModel model = (DefaultTableModel)mostrarClie.getModel();
	       Object[] row = new Object[6];
	       for(int i = 0; i < listaClie.size(); i++)
	       {
	           row[0] = listaClie.get(i).getNombre();
	           row[1] = listaClie.get(i).getApellidos();
	           row[2] = listaClie.get(i).getDni();
	           row[3] = listaClie.get(i).getEmail();
	           row[4] = listaClie.get(i).getContraseña();
	           row[5] = listaClie.get(i).getDirección();
	           
	           model.addRow(row);
	       }
	    }
	 /*public static boolean validarNif(String nif){
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
	    }*/
}

