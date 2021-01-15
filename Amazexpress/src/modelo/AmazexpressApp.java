package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//clase que crea el objeto base de toda la aplicacion permitiendo una sola instancia basada en el patron singleton
public class AmazexpressApp {
	
	//Atributos
	
		//Lista de admins
		private List<Administrador> admins;
		
		//Lista de vendedores
		private List<Vendedor> vendedores;
		
		//Lista de compradores
		private List<Comprador> compradores;
		
		public List<Administrador> getAdmins() {
			return admins;
		}

		public List<Vendedor> getVendedores() {
			return vendedores;
		}

		public List<Comprador> getCompradores() {
			return compradores;
		}
		
		//Faltan hashmaps de tienda, producto y pedidos

	//Instancia del objeto para singleton
	private static AmazexpressApp app;
	
	/**
	 * Constructor de la aplicacion que inicializa los hashmaps
	 */
	private AmazexpressApp() {		
		this.admins = new ArrayList<Administrador>();
		this.vendedores = new ArrayList<Vendedor>();
		this.compradores = new ArrayList<Comprador>();
	}
	
	/**
	 * Este metodo crea el objeto que contiene todo el sistema del programa, siempre sera el primero en ser llamado desde la clase main(Amazexpress.java).
	 * Retorna el objeto sobre el cual se ejecutara la interfaz grafica.
	 * @return
	 */
	public static AmazexpressApp getSingletonInstancia() {
		
		if(app == null) {
			app = new AmazexpressApp();
			app.importarBBDD();
		}else {
			//do nothing
		}
		System.out.println("Instancia de amazexpress invocada");
		return app;
	}
	
	/**
	 * Metodo que se encarga de la importacion de datos persistentes de la base de datos
	 */
	public void importarBBDD() {
		//Por implementar
		app.registro("admin", "admin", "admin", "admin", "admin", "admin", "admin");
	}
	
	public Vendedor getLoggedVendedor() {
		Vendedor retorno = null;
		for(Vendedor aux : vendedores) {
			if(aux.getLogged() == true) {
				retorno = aux;
			}
		}
		return retorno;
	}
	public Comprador getLoggedComprador() {
		Comprador retorno = null;
		for(Comprador aux : compradores) {
			if(aux.getLogged() == true) {
				retorno = aux;
			}
		}
		return retorno;
	}
	public Administrador getLoggedAdmin() {
		Administrador retorno = null;
		for(Administrador aux : admins) {
			if(aux.getLogged() == true) {
				retorno = aux;
			}
		}
		return retorno;
	}
	
	
	/**
	 * Metodo que se encarga de registrar usuarios en la aplicacion
	 * @param tipo admin, comprador o vendedor
	 * @param nombre clase Persona
	 * @param apellidos clase Persona
	 * @param email clase Persona
	 * @param nUsuario clase Persona
	 * @param pass clase Persona
	 * @param telefono clase Persona
	 * @return true o false dependiendo de si el registro es exitoso o no
	 */
	public boolean registro(String tipo, String nombre, String apellidos, String email, String nUsuario, String pass, String telefono) {
		
		if(tipo == "admin") {
			int idAdmin;
			
			if(admins.isEmpty()) idAdmin = 1;
			else {
				 idAdmin = admins.size() + 1;				
			}
			
			admins.add(new Administrador(nombre, apellidos, email, nUsuario, pass, telefono, idAdmin));
			
			return true;
			
		}else if(tipo == "comprador") {
			int idComprador;
			
			if(compradores.isEmpty()) idComprador = 1;
			else {
				 idComprador = compradores.size() + 1;				
			}
			
			compradores.add(new Comprador(nombre, apellidos, email, nUsuario, pass, telefono, idComprador, 2000));
			
			return true;
			
		}else if(tipo == "vendedor") {
			int idVendedor;
			
			if(vendedores.isEmpty()) idVendedor = 1;
			else {
				idVendedor = vendedores.size() + 1;				
			}
			
			vendedores.add(new Vendedor(nombre, apellidos, email, nUsuario, pass, telefono, idVendedor, 0));
			
			return true;
			
		}else {
			System.err.println("Tipo de usuario desconocido");
			return false;
		}
		
	
	}

	/**
	 * Metodo que se encarga de validar o no un login
	 * @param tipo admin, comprador o vendedor
	 * @param nUsuario clase Persona
	 * @param pass clase Persona
	 * @return true o false dependiendo de si valida o no
	 */
	public boolean login(String tipo, String nUsuario, String pass) {
		if(tipo == "admin") {			 
			for(Administrador aux : admins) {
				if(nUsuario.equals(aux.getNUsuario()) == true) {
					if(pass.equals(aux.getPass()) == true) {
						return true;
					}
				}
			}
			return false;
			
		}else if(tipo == "comprador") {
			
			for(Comprador aux : compradores) {
				if(nUsuario.equals(aux.getNUsuario()) == true) {
					if(pass.equals(aux.getPass()) == true) {
						return true;
					}
				}
			}
			return false;
			
		}else if(tipo == "vendedor") {			
			for(Vendedor aux : vendedores) {
				if(nUsuario.equals(aux.getNUsuario()) == true) {
					if(pass.equals(aux.getPass()) == true) {
						return true;
					}
				}
			}
			return false;
		}
		return false;
	}

	
	
	//Los metodos de borrado deben implementarse en base a las listas
	public void borrarAdmin(int id) {
		Administrador removable = null;
		for(Administrador aux : admins) {
			if(aux.getIdAdministrador() == id) removable = aux;
		}
		if(removable != null) admins.remove(removable);
	}
	
	public void borrarComprador(int id) {
		Comprador removable = null;
		for(Comprador aux : compradores) {
			if(aux.getIdComprador() == id) removable = aux;
		}
		if(removable != null) compradores.remove(removable);
	}
	
	public void borrarVendedor(int id) {
		Vendedor removable = null;
		for(Vendedor aux : vendedores) {
			if(aux.getIdVendedor() == id) removable = aux;
		}
		if(removable != null) vendedores.remove(removable);
	}
	
	/**
	 * Metodo que devuelve el objeto del usuario que ha iniciado sesion
	 * @param nUsuario Nombre de usuario
	 * @return Objeto del usuario
	 */
	public Administrador getAdmin(String nUsuario) throws NullPointerException{
		Administrador retorno = null;
		for(Administrador aux : admins) {
			if(nUsuario.equals(aux.getNUsuario()) == true) {
				retorno = aux;
			}
		}
		return retorno;
	}
	
	/**
	 * Metodo que devuelve el objeto del usuario que ha iniciado sesion
	 * @param nUsuario Nombre de usuario
	 * @return Objeto del usuario
	 */
	public Vendedor getVendedor(String nUsuario) {
			
		Vendedor retorno = null;
		for(Vendedor aux : vendedores) {
			if(nUsuario.equals(aux.getNUsuario()) == true) {
				retorno = aux;
			}
		}
		return retorno;
	}
	
	/**
	 * Metodo que devuelve el objeto del usuario que ha iniciado sesion
	 * @param nUsuario Nombre de usuario
	 * @return Objeto del usuario
	 */
	public Comprador getComprador(String nUsuario) {
		
		Comprador retorno = null;
		for(Comprador aux : compradores) {
			if(nUsuario.equals(aux.getNUsuario()) == true) {
				retorno = aux;
			}
		}
		return retorno;
	}
	
	/**
	 * Metodo para calcular el numero de usuarios de la app que no son admins.
	 * @return numero de usuarios de la app
	 */
	public int getUserNumber() {
		return this.compradores.size() + this.vendedores.size() + this.admins.size();
	}
}
