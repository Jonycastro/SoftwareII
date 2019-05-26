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
import Modelo.Productos;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class verProductos extends JFrame {
	

	private JPanel contentPane;
	public JTable mostrarPro;//cambiau
	private JLabel lblNewLabel_1;
	private JLabel lblEmail;
	private JTextField nombreIntrod;
	private JTextField precioIntrod;
	private JTextField stockIntrod;
	private JScrollPane scrollPane;
	private JButton btnVolver;
	//ventanaAdmin venAdmin = new ventanaAdmin();
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public verProductos() {
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
		
		mostrarPro = new JTable();
		mostrarPro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				                                                 
				       // Get The Index Of The Slected Row 
				        int i = mostrarPro.getSelectedRow();

				        TableModel model = mostrarPro.getModel();
				        
				         // Display Slected Row In JTexteFields
				        nombreIntrod.setText(model.getValueAt(i,0).toString());

				        //apellidosIntrod.setText(model.getValueAt(i,1).toString());

				        precioIntrod.setText(model.getValueAt(i,1).toString());

				        stockIntrod.setText(model.getValueAt(i,2).toString());
				        
				       // contraseñaIntrod.setText(model.getValueAt(i,4).toString());
				        
				        //direccionIntrod.setText(model.getValueAt(i,5).toString());
				         
			}
		});
		scrollPane.setViewportView(mostrarPro);
		mostrarPro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		mostrarPro.setBackground(Color.LIGHT_GRAY);
		mostrarPro.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Precio", "Stock"
			}
		));
		
		JLabel lblNewLabel = new JLabel("Modifique los datos que desea cambiar o registre un nuevo producto:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(46, 307, 401, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNombre.setBounds(56, 332, 66, 14);
		contentPane.add(lblNombre);
		
		lblNewLabel_1 = new JLabel("Precio :");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(56, 359, 66, 14);
		contentPane.add(lblNewLabel_1);
		
		lblEmail = new JLabel("Stock:");
		lblEmail.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblEmail.setBounds(56, 384, 66, 14);
		contentPane.add(lblEmail);
		
		nombreIntrod = new JTextField();
		nombreIntrod.setBounds(140, 332, 161, 20);
		contentPane.add(nombreIntrod);
		nombreIntrod.setColumns(10);
		
		precioIntrod = new JTextField();
		precioIntrod.setBounds(140, 357, 161, 20);
		contentPane.add(precioIntrod);
		precioIntrod.setColumns(10);
		
		stockIntrod = new JTextField();
		stockIntrod.setBounds(140, 381, 161, 20);
		contentPane.add(stockIntrod);
		stockIntrod.setColumns(10);
		
		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				Productos pro = new Productos(nombreIntrod.getText(),precioIntrod.getText(),Integer.parseInt(stockIntrod.getText()));
				
				
				if(nombreIntrod.getText().length()==0){
					JOptionPane.showMessageDialog(null, "Es necesario rellenar los campos para añadir al producto.");
				}else if(operaciones.yaExisteProducto(nombreIntrod.getText())== 2){
					JOptionPane.showMessageDialog(null, "Ya existe un producto con ese nombre.");
				}else{
				operaciones.altaProductos(pro);
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
				
				Productos pro = new Productos(nombreIntrod.getText(),precioIntrod.getText(),Integer.parseInt(stockIntrod.getText()));
				
				if(nombreIntrod.getText().length()==0){
					JOptionPane.showMessageDialog(null, "Es necesario introducir el nombre para eliminar el producto.");
				}else if(operaciones.yaExisteProducto(nombreIntrod.getText())== 0){
					JOptionPane.showMessageDialog(null, "No existe ningún producto con ese nombre.");
				}else{
				operaciones.bajaProducto(pro);
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
					
				Productos pro = new Productos(nombreIntrod.getText(),precioIntrod.getText(),Integer.parseInt(stockIntrod.getText()));
					
				if(nombreIntrod.getText().length()==0){
					JOptionPane.showMessageDialog(null, "Es necesario introducir el nombre para eliminar al cliente.");
				}else if(operaciones.yaExisteProducto(nombreIntrod.getText())== 0){
					JOptionPane.showMessageDialog(null, "No existe ningún producto con ese nombre.");
				}else{
				operaciones.actualizarProductos(pro);
				actualizarTabla();
				}
					
					
				
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Verdana", Font.BOLD, 11));
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Gonzalo\\Desktop\\InsoBBDD\\Iconos\\refresh-157064_960_720.png"));
		btnNewButton_2.setBounds(474, 433, 176, 67);
		contentPane.add(btnNewButton_2);
		
		JLabel lblHagaClickEn = new JLabel("Haga click en el producto que quiera modificar:");
		lblHagaClickEn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHagaClickEn.setBounds(46, 31, 308, 14);
		contentPane.add(lblHagaClickEn);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				new ventanaAdmin().setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(713, 491, 89, 23);
		contentPane.add(btnVolver);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{scrollPane, mostrarPro, lblNewLabel, lblNombre, lblNewLabel_1, lblEmail, nombreIntrod, precioIntrod, stockIntrod}));
		
		Show_Users_In_JTable();
	}
	public void actualizarTabla(){
		
		DefaultTableModel model = (DefaultTableModel) mostrarPro.getModel();
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
	       ArrayList<Productos> listaPro = operaciones.getListaProductos();
	       DefaultTableModel model = (DefaultTableModel)mostrarPro.getModel();
	       Object[] row = new Object[3];
	       for(int i = 0; i < listaPro.size(); i++)
	       {
	           row[0] = listaPro.get(i).getNombre();
	           row[1] = listaPro.get(i).getPrecio();
	           row[2] = listaPro.get(i).getStock();
	           
	           
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

