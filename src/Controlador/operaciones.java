package Controlador;


import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;












import Modelo.Administrador;
import Modelo.Cliente;
import Modelo.Ofertas;
import Modelo.Productos;
import Vista.verClientes;

public class operaciones {
	
	public static void altaUsuario(Cliente user){
		
		Session session;
		
		session = inicioHibernate.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		
		
		tx.commit();
		session.close();
		JOptionPane.showMessageDialog(null, "El cliente ha sido registrado correctamente");
	}
	
	public static void actualizarUsuario(Cliente user){
		
		Session session;
		
		session = inicioHibernate.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "UPDATE Cliente set  Nombre = :nombre, Apellidos = :apellidos, DNI = :dni, Direccion = :direccion, Contraseña = :contraseña  WHERE email = :email,";
		Query query = session.createQuery(hql);
		query.setParameter("email",user.getEmail());
		query.setParameter("apellidos",user.getApellidos());
		query.setParameter("dni",user.getDni());
		query.setParameter("direccion",user.getDirección());
		query.setParameter("contraseña",user.getContraseña());
		query.setParameter("nombre",user.getNombre());
		//query.setParameter("customerId",3);
		 
		int affectedRows = query.executeUpdate();
		
		tx.commit();
		session.close();
		JOptionPane.showMessageDialog(null, "El cliente ha sido actualizado correctamente");
		
	}
	
	public static void bajaUsuario(Cliente user){
		
		Session session;
		
		session = inicioHibernate.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(user);
		
		tx.commit();
		session.close();
		JOptionPane.showMessageDialog(null, "El cliente ha sido eliminado correctamente");
		
	}
	
	public static void altaAdministrador(String email,String contraseña){
		
		Session session;
		
		session = inicioHibernate.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Administrador admin = new Administrador(email,contraseña);
		session.save(admin);
		
		tx.commit();
		session.close();
		JOptionPane.showMessageDialog(null, "El admin ha sido registrado correctamente");
	}
	
	
	public static int confirmarInicioSesion(String correo,String contraseña){
		
		int resultado = 0;
		
		Session session;
		
		session = inicioHibernate.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Cliente cliente;
		

		Query query = session.createQuery("from Administrador where email = :email  and  contraseña = :contraseña");
		query.setParameter("email", correo);
		query.setParameter("contraseña", contraseña);
		List<Administrador> list = (List<Administrador>) query.list();
		
		tx.commit();
		session.close();
		
		if(list.size() >0){
			
			resultado = 1;
			return resultado;
		}else{
			
			
			//Session session;
			
			session = inicioHibernate.getSessionFactory().openSession();
			Transaction tx1 = session.beginTransaction();
			//Cliente cliente;
			

			Query query1 = session.createQuery("from Cliente where email = :email  and  contraseña = :contraseña");
			query1.setParameter("email", correo);
			query1.setParameter("contraseña", contraseña);
			List<Cliente> list1 = (List<Cliente>) query1.list();
			
			tx1.commit();
			session.close();
			
			if(list1.size() >0){
				
				resultado = 2;
				System.out.println(resultado);
				return resultado;
				
			}
			
		}
		
		

		System.out.println(resultado);
		return resultado;
		
	}
	
	public static int yaExiste(String correo){
		
		int contador = 0;
		
		Session session;
		
		session = inicioHibernate.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Cliente cliente;
		

		Query query = session.createQuery("from Administrador where email = :email");
		query.setParameter("email", correo);
		
		List<Administrador> list = (List<Administrador>) query.list();
		
		tx.commit();
		session.close();
		
		if(list.size() >0){
			
			contador = 1;
			return contador;
		}else{
			
			
			//Session session;
			
			session = inicioHibernate.getSessionFactory().openSession();
			Transaction tx1 = session.beginTransaction();
			//Cliente cliente;
			

			Query query1 = session.createQuery("from Cliente where email = :email ");
			query1.setParameter("email", correo);
			//query1.getNamedParameters();
			
			List<Cliente> list1 = (List<Cliente>) query1.list();
			
			tx1.commit();
			session.close();
			
			if(list1.size() >0){
				
				contador = 2;
				System.out.println(contador);
				return contador;
				
			}
			
		}
		
		

		System.out.println(contador);
		return contador;
		
		
		
	}
	
	public static void cancelarProducto(String nombre){
		
	try{	
		Session session;
		
		session = inicioHibernate.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Productos where Nombre= :nombre");
		query.setParameter("nombre", nombre);
		Productos prod = (Productos) query.uniqueResult();
		int cant = prod.getStock();
		cant++;
		
		
		
		Query query1 = session.createQuery("update Productos set Stock= :stock where Nombre= :nombre");
		query1.setParameter("nombre",nombre);
		query.setParameter("stock", cant);
		int result = query1.executeUpdate();// se puede quitar el int result?
		
		tx.commit();
		session.close();
		
		
		
	}catch(Exception e1){
		e1.printStackTrace();
	}
	
	}
	
	public static  boolean comprarProducto(String nombre){
		
		boolean agotado = false;
		try{
			
			Session session;
			
			session = inicioHibernate.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			
			Query query = session.createQuery("from Productos where Nombre= :nombre");
			query.setParameter("nombre", nombre);
			Productos prod = (Productos) query.uniqueResult();
			int cant = prod.getStock();
			
			if(cant <=0){
				agotado = true;
				JOptionPane.showMessageDialog(null,"El producto esta agotado, lo lamentamos.");
			}else{
				
				cant--;
				
				
				Query query1 = session.createQuery("update Productos set Stock= :stock where Nombre= :nombre");
				query1.setParameter("nombre",nombre);
				query1.setParameter("stock", cant);
				int result = query1.executeUpdate();// se puede quitar el int result?
				JOptionPane.showMessageDialog(null, "OK.");
				
				
			}
			
			tx.commit();
			session.close();
			
		}catch(Exception e1){
			e1.printStackTrace();
		}
		return agotado;
	}
	
	public static float obtenerPrecio(String nombre){
		
		
		float precio = 0;
		
		
			
			
			try{	
				Session session;
				
				session = inicioHibernate.getSessionFactory().openSession();
				Transaction tx = session.beginTransaction();
				
				Query query = session.createQuery("from Productos where Nombre= :nombre");
				query.setParameter("nombre", nombre);
				Productos prod = (Productos) query.uniqueResult();
				precio = Float.parseFloat(prod.getPrecio());
				
				tx.commit();
				session.close();
			
		
		
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			
					
		}
		
		return precio;
		
	

}
	
	public static String descuentoActual(){
		
		String d = "Descuento";
		String desc = "";
		
		try{
			
			Session session;
			
			session = inicioHibernate.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			
			Query query = session.createQuery("from Ofertas where Tipo= :tipo");
			query.setParameter("tipo", d);
			Ofertas ofer = (Ofertas) query.uniqueResult();
			desc =(ofer.getDescuento());
			
			tx.commit();
			session.close();
			
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			
					
		}
		return desc;
	}
	
public static String precioActual(){
		
		String d = "Precio";
		String desc = "";
		
		try{
			
			Session session;
			
			session = inicioHibernate.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			
			Query query = session.createQuery("from Ofertas where Tipo= :tipo");
			query.setParameter("tipo", d);
			Ofertas ofer = (Ofertas) query.uniqueResult();
			desc =(ofer.getPrecio());
			
			tx.commit();
			session.close();
			
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			
					
		}
		return desc;
	}
	
	
	
	public static ArrayList<Cliente> getListaClientes(){
		
		//ArrayList <Clientes> listaClientes =  new ArrayList<Clientes>();
		
		try{
			Cliente cliente;
			Session session;
			
			session = inicioHibernate.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			
			String hql = "FROM Cliente";
			Query query = session.createQuery(hql);
			List results = query.list();
			
			
			for(int i=0;i<results.size();i++){
					
			}
			
			tx.commit();
			session.close();
			return (ArrayList<Cliente>) results;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			
					
		}
		return null;
	
	
		
	
}
	
	public static void actualizarOfertas(String descuento,String precio,int escoger){
		Session session;
		
		session = inicioHibernate.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		if(escoger == 0){
		
			
			String hql = "UPDATE Ofertas set Descuento = :descuento  WHERE Tipo = :tipo,";
			Query query = session.createQuery(hql);
			query.setParameter("tipo","Descuento");
			query.setParameter("descuento",descuento);
			
			//query.setParameter("customerId",3);
			 
			int affectedRows = query.executeUpdate();
			
			String hql1 = "UPDATE Ofertas set Precio = :precio  WHERE Tipo = :tipo,";
			Query query1 = session.createQuery(hql1);
			query1.setParameter("tipo","Premium");
			query1.setParameter("precio",precio);
			
			//query.setParameter("customerId",3);
			 
			int affectedRows1 = query.executeUpdate();
			
			tx.commit();
			session.close();
			JOptionPane.showMessageDialog(null, "El valor del descuento y el precio del premium han sido actualizados correctamente");
			
			
		}else if (escoger == 1){
		
		
		
		String hql = "UPDATE Ofertas set Descuento = :descuento  WHERE Tipo = :tipo,";
		Query query = session.createQuery(hql);
		query.setParameter("tipo","Descuento");
		query.setParameter("descuento",descuento);
		
		//query.setParameter("customerId",3);
		 
		int affectedRows = query.executeUpdate();
		
		tx.commit();
		session.close();
		JOptionPane.showMessageDialog(null, "El valor del descuento ha sido actualizado correctamente");
		
		}else{
			
			String hql = "UPDATE Ofertas set Precio = :precio  WHERE Tipo = :tipo,";
			Query query = session.createQuery(hql);
			query.setParameter("tipo","Premium");
			query.setParameter("precio",precio);
			
			//query.setParameter("customerId",3);
			 
			int affectedRows = query.executeUpdate();
			
			tx.commit();
			session.close();
			JOptionPane.showMessageDialog(null, "El precio del premium ha sido actualizado correctamente");
			
		}
		
		
		
	}
	/*public static void actualizarTabla(){
		
		DefaultTableModel model = (DefaultTableModel) verClientes.mostrarClie.getModel();
        model.setRowCount(0);
        Show_Users_In_JTable();
	}*/
	
	
}
