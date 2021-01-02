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
	
	/**
	 * Constructor de la aplicacion que inicializa los hashmaps
	 */
	private AmazexpressApp() {		
		this.admins = new HashMap<Integer, Administrador>();
		this.vendedores = new HashMap<Integer, Vendedor>();
		this.compradores = new HashMap<Integer, Comprador>();
	}
	
	/**
	 * Este metodo crea el objeto que contiene todo el sistema del programa, siempre sera el primero en ser llamado desde la clase main(Amazexpress.java).
	 * Retorna el objeto sobre el cual se ejecutara la interfaz grafica.
	 * @return
	 */
	public static AmazexpressApp getSingletonInstancia() {
		
		if(app == null) {
			app = new AmazexpressApp();
			System.out.println("Amazexpress ejecutado correctamente");
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

	/**
	 * Metodo que se encarga de validar o no un login
	 * @param tipo admin, comprador o vendedor
	 * @param nUsuario clase Persona
	 * @param pass clase Persona
	 * @return true o false dependiendo de si valida o no
	 */
	public boolean login(String tipo, String nUsuario, String pass) {
		
		if(tipo == "admin") {
			
			int i = 1;
			
			if(admins.get(i) == null) return false;
				
			while(!nUsuario.equals(admins.get(i).getNUsuario()) && i < admins.size()) {
				i++;
			}
			
			if(nUsuario.equals(admins.get(i).getNUsuario()) && pass.equals(admins.get(i).getPass())) {
				return true;
			}else {
				return false;
			}
			
		}else if(tipo == "comprador") {
			
			int i = 1;
			
			if(compradores.get(i) == null) return false;
				
			while(!nUsuario.equals(compradores.get(i).getNUsuario()) && i < compradores.size()) {
				i++;
			}
			
			if(nUsuario.equals(compradores.get(i).getNUsuario()) && pass.equals(compradores.get(i).getPass())) {
				return true;
			}else{
				return false;
			}
			
		}else if(tipo == "vendedor") {
			
			int i = 1;
			
			if(vendedores.get(i) == null) return false;
				
			while(!nUsuario.equals(vendedores.get(i).getNUsuario()) && i < vendedores.size()) {
				i++;
			}
			
			if(nUsuario.equals(vendedores.get(i).getNUsuario()) && pass.equals(vendedores.get(i).getPass())) {
				return true;
			}else{
				return false;
			}
			
		}else {
			System.err.println("Tipo de usuario desconocido");
			return false;
		}
	}
}
