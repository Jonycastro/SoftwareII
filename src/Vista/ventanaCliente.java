package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import Controlador.operaciones;

import java.awt.Toolkit;
import java.awt.Font;

public class ventanaCliente extends JFrame {

	private JPanel contentPane;
	
	
	int numeroProductos1 =0;
	int numeroProductos2 =0;
	int numeroProductos3 =0;
	int numeroProductos4 =0;
	int numeroProductos5 =0;
	int numeroProductos6 =0;
	int numeroProductos7 =0;
	int numeroProductos8 =0;
	int numeroProductos9 =0;
	int numeroProductos10 =0;
	int numeroProductos11 =0;
	int numeroProductos12 =0;
	float precioFinal = 0;
	
	float descuento = Float.parseFloat(operaciones.descuentoActual())/100;
	
	//descuento = descuento/100;
	float precioDescuento = (float) (precioFinal* descuento);
	
	//datosPago datospag = new datosPago();
	
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaCliente frame = new ventanaCliente();
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
	
	
	public ventanaCliente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Gonzalo\\workspace\\Inso1\\Fotos\\Logo.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 988);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//JScrollPane jsp = new JScrollPane(contentPane);
		System.out.println("descccccccc:"+ descuento);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		final JLabel nombre1 = new JLabel("Raqueta tenis1");
		nombre1.setBounds(50, 191, 89, 14);
		contentPane.add(nombre1);
		
		final JLabel Raqueta2 = new JLabel("Raqueta tenis2");
		Raqueta2.setBounds(190, 191, 89, 14);
		contentPane.add(Raqueta2);
		
		final JLabel nombre3 = new JLabel("Bal\u00F3n Atl\u00E9tico");
		nombre3.setBounds(330, 191, 89, 14);
		contentPane.add(nombre3);
		
		final JLabel nombre4 = new JLabel("Bal\u00F3n Madrid");
		nombre4.setBounds(470, 191, 89, 14);
		contentPane.add(nombre4);
		
		final JLabel nombre5 = new JLabel("Tabla Batman");
		nombre5.setBounds(50, 455, 89, 14);
		contentPane.add(nombre5);
		
		final JLabel nombre6 = new JLabel("Tabla Wonder");
		nombre6.setBounds(190, 455, 89, 14);
		contentPane.add(nombre6);
		
		final JLabel nombre7 = new JLabel("Sudadera adidas1");
		nombre7.setBounds(330, 455, 89, 14);
		contentPane.add(nombre7);
		
		final JLabel nombre8 = new JLabel("Sudadera adidas2");
		nombre8.setBounds(463, 455, 89, 14);
		contentPane.add(nombre8);
		
		final JLabel nombre9 = new JLabel("Pantal\u00F3n corto");
		nombre9.setBounds(50, 720, 89, 14);
		contentPane.add(nombre9);
		
		final JLabel nombre10 = new JLabel("Pantal\u00F3n largo");
		nombre10.setBounds(190, 720, 89, 14);
		contentPane.add(nombre10);
		
		final JLabel nombre11 = new JLabel("Zapatillas hombre");
		nombre11.setBounds(330, 720, 89, 14);
		contentPane.add(nombre11);
		
		final JLabel nombre12 = new JLabel("Zapatillas mujer");
		nombre12.setBounds(470, 720, 89, 14);
		contentPane.add(nombre12);
		
		JLabel precio1 = new JLabel(Float.toString(operaciones.obtenerPrecio(nombre1.getText())));
		precio1.setBounds(50, 216, 46, 14);
		contentPane.add(precio1);
		
		final JButton can1 = new JButton("Cancelar");
		can1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String nombre = nombre1.getText();
				
				operaciones.cancelarProducto(nombre);
				
				numeroProductos1 = numeroProductos1-1;
				precioFinal = precioFinal - operaciones.obtenerPrecio(nombre);
				
				JOptionPane.showMessageDialog(null, "OK.");
				if(numeroProductos1 <= 0){
					can1.setVisible(false);
				}
						
			
			}
		});
		
		can1.setVisible(false);
		can1.setBounds(50, 275, 89, 23);
		contentPane.add(can1);
		
		
		final JButton can2 = new JButton("Cancelar");
		can2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String nombre = Raqueta2.getText();
				
				operaciones.cancelarProducto(nombre);
				
				numeroProductos2 = numeroProductos2-1;
				precioFinal = precioFinal - operaciones.obtenerPrecio(nombre);
				
				JOptionPane.showMessageDialog(null, "OK.");
				if(numeroProductos2 <= 0){
					can2.setVisible(false);
				}
				
			}
		});
		can2.setVisible(false);
		can2.setBounds(190, 275, 89, 23);
		contentPane.add(can2);
		
		final JButton can3 = new JButton("Cancelar");
		can3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String nombre = nombre3.getText();
				
				operaciones.cancelarProducto(nombre);
				
				numeroProductos3 = numeroProductos3-1;
				precioFinal = precioFinal - operaciones.obtenerPrecio(nombre);
				
				JOptionPane.showMessageDialog(null, "OK.");
				if(numeroProductos3 <= 0){
					can1.setVisible(false);
				}
				
			}
		});
		can3.setVisible(false);
		can3.setBounds(330, 275, 89, 23);
		contentPane.add(can3);
		
		final JButton can4 = new JButton("Cancelar");
		can4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String nombre = nombre4.getText();
				
				operaciones.cancelarProducto(nombre);
				
				numeroProductos4 = numeroProductos4-1;
				precioFinal = precioFinal - operaciones.obtenerPrecio(nombre);
				
				JOptionPane.showMessageDialog(null, "OK.");
				if(numeroProductos4 <= 0){
					can1.setVisible(false);
				}
				
				
			}
		});
		can4.setVisible(false);
		can4.setBounds(470, 275, 89, 23);
		contentPane.add(can4);
		
		final JButton cancelar5 = new JButton("Cancelar");
		cancelar5.setVisible(false);
		cancelar5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre = nombre5.getText();
				
				operaciones.cancelarProducto(nombre);
				
				numeroProductos5 = numeroProductos5-1;
				precioFinal = precioFinal - operaciones.obtenerPrecio(nombre);
				
				JOptionPane.showMessageDialog(null, "OK.");
				if(numeroProductos5 <= 0){
					cancelar5.setVisible(false);
				}
	
			}
		});
		cancelar5.setBounds(50, 539, 89, 23);
		contentPane.add(cancelar5);
		
		final JButton cancelar6 = new JButton("Cancelar");
		cancelar6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String nombre = nombre6.getText();
				
				operaciones.cancelarProducto(nombre);
				
				numeroProductos6 = numeroProductos6-1;
				precioFinal = precioFinal - operaciones.obtenerPrecio(nombre);
				
				JOptionPane.showMessageDialog(null, "OK.");
				if(numeroProductos6 <= 0){
					cancelar6.setVisible(false);
				}
				
			}
		});
		cancelar6.setVisible(false);
		cancelar6.setBounds(190, 539, 89, 23);
		contentPane.add(cancelar6);
		
		final JButton cancelar7 = new JButton("Cancelar");
		cancelar7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String nombre = nombre7.getText();
				
				operaciones.cancelarProducto(nombre);
				
				numeroProductos7 = numeroProductos7-1;
				precioFinal = precioFinal - operaciones.obtenerPrecio(nombre);
				
				JOptionPane.showMessageDialog(null, "OK.");
				if(numeroProductos7 <= 0){
					cancelar7.setVisible(false);
				}
				
				
			}
		});
		cancelar7.setVisible(false);
		cancelar7.setBounds(330, 539, 89, 23);
		contentPane.add(cancelar7);
		
		final JButton cancelar8 = new JButton("Cancelar");
		cancelar8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String nombre = nombre8.getText();
				
				operaciones.cancelarProducto(nombre);
				
				numeroProductos8 = numeroProductos8-1;
				precioFinal = precioFinal - operaciones.obtenerPrecio(nombre);
				
				JOptionPane.showMessageDialog(null, "OK.");
				if(numeroProductos8 <= 0){
					cancelar8.setVisible(false);
				}
				
				
			}
		});
		cancelar8.setVisible(false);
		cancelar8.setBounds(463, 539, 89, 23);
		contentPane.add(cancelar8);
		
		
		final JButton cancelar9 = new JButton("Cancelar");
		cancelar9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String nombre = nombre9.getText();
				
				operaciones.cancelarProducto(nombre);
				
				numeroProductos9 = numeroProductos9-1;
				precioFinal = precioFinal - operaciones.obtenerPrecio(nombre);
				
				JOptionPane.showMessageDialog(null, "OK.");
				if(numeroProductos9 <= 0){
					cancelar9.setVisible(false);
				}
				
			}
		});
		cancelar9.setVisible(false);
		cancelar9.setBounds(50, 804, 89, 23);
		contentPane.add(cancelar9);
		
		final JButton cancelar10 = new JButton("Cancelar");
		cancelar10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre = nombre10.getText();
				
				operaciones.cancelarProducto(nombre);
				
				numeroProductos10 = numeroProductos10-1;
				precioFinal = precioFinal - operaciones.obtenerPrecio(nombre);
				
				JOptionPane.showMessageDialog(null, "OK.");
				if(numeroProductos10 <= 0){
					cancelar10.setVisible(false);
				}
			}
		});
		cancelar10.setVisible(false);
		cancelar10.setBounds(190, 804, 89, 23);
		contentPane.add(cancelar10);
		
		final JButton cancelar11 = new JButton("Cancelar");
		cancelar11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre = nombre11.getText();
				
				operaciones.cancelarProducto(nombre);
				
				numeroProductos11 = numeroProductos11-1;
				precioFinal = precioFinal - operaciones.obtenerPrecio(nombre);
				
				JOptionPane.showMessageDialog(null, "OK.");
				if(numeroProductos11 <= 0){
					cancelar11.setVisible(false);
				}
			}
		});
		cancelar11.setVisible(false);
		cancelar11.setBounds(330, 804, 89, 23);
		contentPane.add(cancelar11);
		
		final JButton cancelar12 = new JButton("Cancelar");
		cancelar12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre = nombre12.getText();
				
				operaciones.cancelarProducto(nombre);
				
				numeroProductos12 = numeroProductos12-1;
				precioFinal = precioFinal - operaciones.obtenerPrecio(nombre);
				
				JOptionPane.showMessageDialog(null, "OK.");
				if(numeroProductos12 <= 0){
					cancelar12.setVisible(false);
				}
			}
		});
		cancelar12.setVisible(false);
		cancelar12.setBounds(470, 804, 89, 23);
		contentPane.add(cancelar12);
		
		JButton comprar1 = new JButton("Comprar");
		comprar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					//String query="update Cliente set Nombre ='" nombreIntrod.getText()+"',Apellidos ='" apellidosIntrod.getText()+"',DNI ='"dniIntrod.getText()+"',email ='"emailIntrod.getText()+"',Dirección ='"direccionIntod.getText()+"',Contraseña ='"contraseñaIntrod.getText()+" where email='"+emailIntrod.getText()+"'";
					
					
					String nombre = nombre1.getText();
					boolean agotado = operaciones.comprarProducto(nombre);
					
					if(agotado == false){
						
						numeroProductos1= numeroProductos1+1;
						precioFinal = precioFinal +  operaciones.obtenerPrecio(nombre1.getText());
						can1.setVisible(true);
						
					}
				
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		comprar1.setBounds(50, 241, 89, 23);
		contentPane.add(comprar1);
		
		JButton finzalizarCompra = new JButton("Finalizar compra.");
		finzalizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				float preDesc = (float) (precioFinal * 0.8);
				JOptionPane.showMessageDialog(null,"Se ha realizado una compra con un importe total de " + preDesc +" euros, sin el descuente el precio hubiese sido "+ precioFinal +"euros." );
				//datospag.setVisible(true);
				dispose();
			}
		});
		finzalizarCompra.setBounds(232, 838, 154, 47);
		contentPane.add(finzalizarCompra);
		
		
		
		JLabel precio2 = new JLabel(Float.toString(operaciones.obtenerPrecio(Raqueta2.getText())));
		precio2.setBounds(190, 216, 46, 14);
		contentPane.add(precio2);
		
		JLabel precio3 = new JLabel(Float.toString(operaciones.obtenerPrecio(nombre3.getText())));
		precio3.setBounds(330, 216, 46, 14);
		contentPane.add(precio3);
		
		JLabel precio4 = new JLabel(Float.toString(operaciones.obtenerPrecio(nombre4.getText())));
		precio4.setBounds(470, 216, 46, 14);
		contentPane.add(precio4);
		
		JButton comprar2 = new JButton("Comprar");
		comprar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String nombre = Raqueta2.getText();
					boolean agotado = operaciones.comprarProducto(nombre);
					
					if(agotado == false){
						
						numeroProductos2= numeroProductos2+1;
						precioFinal = precioFinal +  operaciones.obtenerPrecio(Raqueta2.getText());
						can1.setVisible(true);
						
					}
					
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		comprar2.setBounds(190, 241, 89, 23);
		contentPane.add(comprar2);
		
		JButton comprar3 = new JButton("Comprar");
		comprar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String nombre = nombre3.getText();
					boolean agotado = operaciones.comprarProducto(nombre);
					
					if(agotado == false){
						
						numeroProductos3= numeroProductos3+1;
						precioFinal = precioFinal +  operaciones.obtenerPrecio(nombre3.getText());
						can3.setVisible(true);
						
					}
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		comprar3.setBounds(330, 241, 89, 23);
		contentPane.add(comprar3);
		
		JButton comprar4 = new JButton("Comprar");
		comprar4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					String nombre = nombre4.getText();
					boolean agotado = operaciones.comprarProducto(nombre);
					
					if(agotado == false){
						
						numeroProductos4= numeroProductos4+1;
						precioFinal = precioFinal +  operaciones.obtenerPrecio(nombre4.getText());
						can4.setVisible(true);
						
					}
				}catch(Exception e1){
					e1.printStackTrace();
				}
				
				
			}
		});
		comprar4.setBounds(470, 241, 89, 23);
		contentPane.add(comprar4);
		
		
		
		JLabel precio5 = new JLabel(Float.toString(operaciones.obtenerPrecio(nombre5.getText())));
		precio5.setBounds(50, 480, 46, 14);
		contentPane.add(precio5);
		
		JLabel precio6 = new JLabel(Float.toString(operaciones.obtenerPrecio(nombre6.getText())));
		precio6.setBounds(190, 480, 46, 14);
		contentPane.add(precio6);
		
		JLabel precio7 = new JLabel(Float.toString(operaciones.obtenerPrecio(nombre7.getText())));
		precio7.setBounds(330, 480, 46, 14);
		contentPane.add(precio7);
		
		JLabel precio8 = new JLabel(Float.toString(operaciones.obtenerPrecio(nombre8.getText())));
		precio8.setBounds(463, 480, 46, 14);
		contentPane.add(precio8);
		
		
		
		
		
		JLabel precio9 = new JLabel(Float.toString(operaciones.obtenerPrecio(nombre9.getText())));
		precio9.setBounds(50, 745, 46, 14);
		contentPane.add(precio9);
		
		JLabel precio10 = new JLabel(Float.toString(operaciones.obtenerPrecio(nombre10.getText())));
		precio10.setBounds(190, 745, 46, 14);
		contentPane.add(precio10);
		
		JLabel precio11 = new JLabel(Float.toString(operaciones.obtenerPrecio(nombre11.getText())));
		precio11.setBounds(330, 745, 46, 14);
		contentPane.add(precio11);
		
		JLabel precio12 = new JLabel(Float.toString(operaciones.obtenerPrecio(nombre12.getText())));
		precio12.setBounds(473, 745, 46, 14);
		contentPane.add(precio12);
		
		JButton comprar9 = new JButton("Comprar");
		comprar9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String nombre = nombre9.getText();
					boolean agotado = operaciones.comprarProducto(nombre);
					
					if(agotado == false){
						
						numeroProductos9= numeroProductos9+1;
						precioFinal = precioFinal +  operaciones.obtenerPrecio(nombre9.getText());
						cancelar9.setVisible(true);
						
					}
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		comprar9.setBounds(50, 770, 89, 23);
		contentPane.add(comprar9);
		
		JButton comprar10 = new JButton("Comprar");
		comprar10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String nombre = nombre10.getText();
					boolean agotado = operaciones.comprarProducto(nombre);
					
					if(agotado == false){
						
						numeroProductos10= numeroProductos10+1;
						precioFinal = precioFinal +  operaciones.obtenerPrecio(nombre10.getText());
						cancelar10.setVisible(true);
						
					}
					
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		comprar10.setBounds(190, 770, 89, 23);
		contentPane.add(comprar10);
		
		JButton comprar11 = new JButton("Comprar");
		comprar11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String nombre = nombre11.getText();
					boolean agotado = operaciones.comprarProducto(nombre);
					
					if(agotado == false){
						
						numeroProductos11= numeroProductos11+1;
						precioFinal = precioFinal +  operaciones.obtenerPrecio(nombre11.getText());
						cancelar11.setVisible(true);
						
					}
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		comprar11.setBounds(330, 770, 89, 23);
		contentPane.add(comprar11);
		
		JButton comprar12 = new JButton("Comprar");
		comprar12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String nombre = nombre12.getText();
					boolean agotado = operaciones.comprarProducto(nombre);
					
					if(agotado == false){
						
						numeroProductos12= numeroProductos12+1;
						precioFinal = precioFinal +  operaciones.obtenerPrecio(nombre12.getText());
						cancelar12.setVisible(true);
						
					}
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		comprar12.setBounds(470, 770, 89, 23);
		contentPane.add(comprar12);
		
		JLabel label_22 = new JLabel("New label");
		label_22.setIcon(new ImageIcon("C:\\Users\\Jonathan\\workspace\\Sport5000.Inso2.zip_expanded\\Fotos\\Balon Atletico.jpg"));
		label_22.setBounds(330, 70, 89, 110);
		contentPane.add(label_22);
		
		JLabel label_23 = new JLabel("New label");
		label_23.setIcon(new ImageIcon("C:\\Users\\Jonathan\\workspace\\Sport5000.Inso2.zip_expanded\\Fotos\\Balon Madrid.jpg"));
		label_23.setBounds(470, 70, 89, 110);
		contentPane.add(label_23);
		
		JLabel label_24 = new JLabel("New label");
		label_24.setIcon(new ImageIcon("C:\\Users\\Jonathan\\workspace\\Sport5000.Inso2.zip_expanded\\Fotos\\Tabla Batman.jpg"));
		label_24.setBounds(50, 334, 89, 110);
		contentPane.add(label_24);
		
		JLabel label_25 = new JLabel("New label");
		label_25.setIcon(new ImageIcon("C:\\Users\\Jonathan\\workspace\\Sport5000.Inso2.zip_expanded\\Fotos\\Tabla Wonder.jpg"));
		label_25.setBounds(190, 334, 89, 110);
		contentPane.add(label_25);
		
		JLabel label_26 = new JLabel("New label");
		label_26.setIcon(new ImageIcon("C:\\Users\\Jonathan\\workspace\\Sport5000.Inso2.zip_expanded\\Fotos\\Chaqueta Adidas.jpg"));
		label_26.setBounds(330, 334, 89, 110);
		contentPane.add(label_26);
		
		JLabel label_27 = new JLabel("New label");
		label_27.setIcon(new ImageIcon("C:\\Users\\Jonathan\\workspace\\Sport5000.Inso2.zip_expanded\\Fotos\\Chaqueta Adidas2.jpg"));
		label_27.setBounds(463, 334, 89, 110);
		contentPane.add(label_27);
		
		JLabel label_28 = new JLabel("New label");
		label_28.setIcon(new ImageIcon("C:\\Users\\Jonathan\\workspace\\Sport5000.Inso2.zip_expanded\\Fotos\\Pantalon Corto Adidas.jpg"));
		label_28.setBounds(50, 599, 89, 110);
		contentPane.add(label_28);
		
		JLabel label_29 = new JLabel("New label");
		label_29.setIcon(new ImageIcon("C:\\Users\\Jonathan\\workspace\\Sport5000.Inso2.zip_expanded\\Fotos\\Pantalon Nike.jpg"));
		label_29.setBounds(190, 599, 89, 110);
		contentPane.add(label_29);
		
		JLabel label_30 = new JLabel("New label");
		label_30.setIcon(new ImageIcon("C:\\Users\\Jonathan\\workspace\\Sport5000.Inso2.zip_expanded\\Fotos\\Zapas Nike.jpg"));
		label_30.setBounds(330, 599, 89, 110);
		contentPane.add(label_30);
		
		JLabel label_31 = new JLabel("New label");
		label_31.setIcon(new ImageIcon("C:\\Users\\Jonathan\\workspace\\Sport5000.Inso2.zip_expanded\\Fotos\\Zapatillas Nike Cortez.jpg"));
		label_31.setBounds(470, 599, 89, 110);
		contentPane.add(label_31);
		
		JButton comprar5 = new JButton("Comprar");
		comprar5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String nombre = nombre5.getText();
					boolean agotado = operaciones.comprarProducto(nombre);
					
					if(agotado == false){
						
						numeroProductos5= numeroProductos5+1;
						precioFinal = precioFinal +  operaciones.obtenerPrecio(nombre5.getText());
						cancelar5.setVisible(true);
						
					}
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		comprar5.setBounds(50, 505, 89, 23);
		contentPane.add(comprar5);
		
		JButton comprar6 = new JButton("Comprar");
		comprar6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String nombre = nombre6.getText();
					boolean agotado = operaciones.comprarProducto(nombre);
					
					if(agotado == false){
						
						numeroProductos6= numeroProductos6+1;
						precioFinal = precioFinal +  operaciones.obtenerPrecio(nombre6.getText());
						cancelar6.setVisible(true);
						
					}
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		comprar6.setBounds(190, 505, 89, 23);
		contentPane.add(comprar6);
		
		JButton comprar7 = new JButton("Comprar");
		comprar7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String nombre = nombre7.getText();
					boolean agotado = operaciones.comprarProducto(nombre);
					
					if(agotado == false){
						
						numeroProductos7= numeroProductos7+1;
						precioFinal = precioFinal +  operaciones.obtenerPrecio(nombre7.getText());
						cancelar7.setVisible(true);
						
					}
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		comprar7.setBounds(330, 505, 89, 23);
		contentPane.add(comprar7);
		
		JButton comprar8 = new JButton("Comprar");
		comprar8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String nombre = nombre8.getText();
					boolean agotado = operaciones.comprarProducto(nombre);
					
					if(agotado == false){
						
						numeroProductos8= numeroProductos8+1;
						precioFinal = precioFinal +  operaciones.obtenerPrecio(nombre8.getText());
						cancelar8.setVisible(true);
						
					}
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		comprar8.setBounds(463, 505, 89, 23);
		contentPane.add(comprar8);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon("C:\\Users\\Jonathan\\workspace\\Sport5000.Inso2.zip_expanded\\Fotos\\Raqueta 1.jpg"));
		label.setBounds(50, 70, 89, 110);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon("C:\\Users\\Jonathan\\workspace\\Sport5000.Inso2.zip_expanded\\Fotos\\Raqueta Head Instinct.jpg"));
		label_1.setBounds(190, 70, 89, 110);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("PRODUCTOS:");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel.setBounds(50, 31, 115, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblHagasePremiumPor = new JLabel("Hagase premium por tan solo ");
		lblHagasePremiumPor.setBounds(50, 895, 186, 14);
		contentPane.add(lblHagasePremiumPor);
		
		JLabel label_2 = new JLabel();// ###############################################################################precioActual()
		label_2.setBounds(242, 895, 35, 14);
		contentPane.add(label_2);
		
		JButton btnNewButton = new JButton("Hacerse premium");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null,"Ha actualizado su cuenta a premium, muchas gracias.");
				
			}
		});
		btnNewButton.setBounds(366, 896, 186, 43);
		contentPane.add(btnNewButton);
		
		JLabel lblDescuentoEnTodos = new JLabel("Descuento en todos los productos del ");
		lblDescuentoEnTodos.setBounds(50, 920, 229, 14);
		contentPane.add(lblDescuentoEnTodos);
		
		JLabel lblNewLabel_1 = new JLabel(operaciones.descuentoActual()+"%");// ###############################################################################descuentoActual()
		lblNewLabel_1.setBounds(276, 920, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		/*JLabel lblHaCompradoUn = new JLabel("Va a comprar un total de :");
		lblHaCompradoUn.setBounds(50, 853, 133, 14);
		contentPane.add(lblHaCompradoUn);
		
		JLabel lblX = new JLabel("x");
		lblX.setBounds(181, 853, 18, 14);
		contentPane.add(lblX);
		
		JLabel lblProductosPorUn = new JLabel("producto(s) por un valor de :");
		lblProductosPorUn.setBounds(209, 853, 145, 14);
		contentPane.add(lblProductosPorUn);
		
		JLabel lblNewLabel_2 = new JLabel("x");
		lblNewLabel_2.setBounds(358, 853, 18, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblEuros = new JLabel("euros.");
		lblEuros.setBounds(386, 853, 46, 14);
		contentPane.add(lblEuros);*/
		
		
		
		
		
		
		
	}
	
	
}
