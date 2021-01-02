package controlador;

import java.util.HashMap;

//clase que crea el objeto base de toda la aplicacion permitiendo una sola instancia basada en el patron singleton
public class AmazexpressApp {
	
	//Atributos
	
		//Lista de admins
		private HashMap<Integer, Administrador> admins;
		
		//Lista de vendedores
		private HashMap<Integer, Vendedor> vendedores;
		
		//Lista de compradores
		private HashMap<Integer, Comprador> compradores;
		
	//Instancia del objeto para singleton
	private static AmazexpressApp app;
	
	
	private AmazexpressApp() {
		//Tomaria los datos de la base de datos mediante metodos anidados para no violar la encapsulacion
	}
	
	/**
	 * Este metodo crea el objeto que contiene todo el sistema del programa, siempre sera el primero en ser llamado desde la clase main(Amazexpress.java).
	 * Retorna el objeto sobre el cual se ejecutara la interfaz grafica.
	 * @return
	 */
	public static AmazexpressApp getSingletonInstancia() {
		
		if(app == null) {
			app = new AmazexpressApp();
		}else {
			System.err.println("Solo puede haber una instancia ejecutandose");
		}
		
		return app;
	}
	
	/**
	 * Metodo que se encarga de la importacion de datos persistentes de la base de datos
	 */
	public void initializar() {
		//Por implementar
	}
	
	public boolean registro(String tipo, String nombre, String apellidos, String email, String nUsuario, String pass, String telefono) {
		
		if(tipo == "admin") {
			int idAdmin;
			
			if(admins.isEmpty()) idAdmin = 1;
			else {
				 idAdmin = admins.size() + 1;				
			}
			
			admins.put(idAdmin, new Administrador(nombre, apellidos, email, nUsuario, pass, telefono, idAdmin));
			
			return true;
			
		}else if(tipo == "comprador") {
			int idComprador;
			
			if(compradores.isEmpty()) idComprador = 1;
			else {
				 idComprador = compradores.size() + 1;				
			}
			
			compradores.put(idComprador, new Comprador(nombre, apellidos, email, nUsuario, pass, telefono, idComprador, 2000));
			
			return true;
			
		}else if(tipo == "vendedor") {
			int idVendedor;
			
			if(vendedores.isEmpty()) idVendedor = 1;
			else {
				idVendedor = vendedores.size() + 1;				
			}
			
			vendedores.put(idVendedor, new Vendedor(nombre, apellidos, email, nUsuario, pass, telefono, idVendedor, 0));
			
			return true;
			
		}else {
			System.err.println("Tipo de usuario desconocido");
			return false;
		}
		
	
	}
}
