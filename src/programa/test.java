package programa;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Controlador.inicioHibernate;
import Modelo.Administrador;
import Modelo.Cliente;
import Vista.Eleccion;

public class test {

	private static Session session;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Cliente clie = new Cliente("asd","asd","asd","asd","asd","asd");
		//Controlador.operaciones.altaUsuario(clie);
		Eleccion frame = new Eleccion();
		frame.setVisible(true);
		//Controlador.operaciones.confirmarInicioSesion("asd", "asd");
		/*session = inicioHibernate.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		crearAdmin("holas","caracolas");
		
		
		tx.commit();
		session.close();
		
		System.exit(0);
		*/

	}
	
	/*public static void crearAdmin(String email,String contraseña){
		
		Administrador admin = new Administrador(email,contraseña);
		session.save(admin);
	}*/

}
