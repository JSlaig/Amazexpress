package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//clase que crea el objeto base de toda la aplicacion permitiendo una sola instancia basada en el patron singleton
public class AmazexpressApp {

	// Atributos

	// Lista de admins
	private List<Administrador> admins;

	// Lista de vendedores
	private List<Vendedor> vendedores;

	// Lista de compradores
	private List<Comprador> compradores;
	
	//Lista de productos
	private List<Producto> productos;

	public List<Administrador> getAdmins() {
		return admins; 
	}

	public List<Vendedor> getVendedores() {
		return vendedores;
	}

	public List<Comprador> getCompradores() {
		return compradores;
	}	

	public List<Producto> getProductos() {
		return productos;
	}

	// Faltan hashmaps de tienda, producto y pedidos

	// Instancia del objeto para singleton
	private static AmazexpressApp app;

	/**
	 * Constructor de la aplicacion que inicializa los hashmaps
	 */
	private AmazexpressApp() {
		this.admins = new ArrayList<Administrador>();
		this.vendedores = new ArrayList<Vendedor>();
		this.compradores = new ArrayList<Comprador>();
		this.productos = new ArrayList<Producto>();
	}

	/**
	 * Este metodo crea el objeto que contiene todo el sistema del programa, siempre
	 * sera el primero en ser llamado desde la clase main(Amazexpress.java). Retorna
	 * el objeto sobre el cual se ejecutara la interfaz grafica.
	 * 
	 * @return
	 */
	public static AmazexpressApp getSingletonInstancia() {

		if (app == null) {
			app = new AmazexpressApp();
			app.importarBBDD();
		} else {
			// do nothing
		}
		System.out.println("Instancia de amazexpress invocada");
		return app;
	}

	/**
	 * Metodo que se encarga de la importacion de datos persistentes de la base de
	 * datos
	 */
	public void importarBBDD() {

		app.registro("admin", "admin", "admin", "admin", "admin", "admin", "admin");

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;

		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM amazexpressbbdd.administrador");

			while (rs.next()) {
				int idAdministrador = rs.getInt(1);
				String nombre = rs.getString(2);
				String apellidos = rs.getString(3);
				String email = rs.getString(4);
				String password = rs.getString(5);
				String telefono = rs.getString(6);
				String nUsuario = rs.getString(7);

				admins.add(new Administrador(nombre, apellidos, email, nUsuario, password, telefono, idAdministrador));

				System.out.println(idAdministrador + " - " + nombre + " - " + apellidos + " - " + email + " - "
						+ password + " - " + telefono + " - " + nUsuario);

			}

		} catch (SQLException e) {

		} finally {
			try {

				if (rs != null)
					rs.close();
				if (stm != null)
					stm.close();
				if (cn != null)
					cn.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM amazexpressbbdd.comprador");

			while (rs.next()) {
				int idComprador = rs.getInt(1);
				String nombre = rs.getString(2);
				String apellidos = rs.getString(3);
				String email = rs.getString(4);
				String nUsuario = rs.getString(5);
				String password = rs.getString(6);
				String telefono = rs.getString(7);
				double balance = rs.getDouble(8);

				compradores.add(
						new Comprador(nombre, apellidos, email, nUsuario, password, telefono, idComprador, balance));

				System.out.println(idComprador + " - " + nombre + " - " + apellidos + " - " + email + " - " + nUsuario
						+ " - " + password + " - " + telefono + " - " + balance);

			}

		} catch (SQLException e) {

		} finally {
			try {

				if (rs != null)
					rs.close(); 
				if (stm != null)
					stm.close();
				if (cn != null)
					cn.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM amazexpressbbdd.vendedor");

			while (rs.next()) {
				int idVendedor = rs.getInt(1);
				String nombre = rs.getString(2);
				String apellidos = rs.getString(3);
				String email = rs.getString(4);
				String nUsuario = rs.getString(5);
				String password = rs.getString(6);
				String telefono = rs.getString(7);
				double balance = rs.getDouble(8);

				vendedores
						.add(new Vendedor(nombre, apellidos, email, nUsuario, password, telefono, idVendedor, balance));

				System.out.println(idVendedor + " - " + nombre + " - " + apellidos + " - " + email + " - " + nUsuario
						+ " - " + password + " - " + telefono + " - " + balance);

			}

		} catch (SQLException e) {

		} finally {
			try {

				if (rs != null)
					rs.close();
				if (stm != null)
					stm.close();
				if (cn != null)
					cn.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public Vendedor getLoggedVendedor() {
		Vendedor retorno = null;
		for (Vendedor aux : vendedores) {
			if (aux.getLogged() == true) {
				retorno = aux;
			}
		}
		return retorno;
	}

	public Comprador getLoggedComprador() {
		Comprador retorno = null;
		for (Comprador aux : compradores) {
			if (aux.getLogged() == true) {
				retorno = aux;
			}
		}
		return retorno;
	}

	public Administrador getLoggedAdmin() {
		Administrador retorno = null;
		for (Administrador aux : admins) {
			if (aux.getLogged() == true) {
				retorno = aux;
			}
		}
		return retorno;
	}

	/**
	 * Metodo que se encarga de registrar usuarios en la aplicacion
	 * 
	 * @param tipo      admin, comprador o vendedor
	 * @param nombre    clase Persona
	 * @param apellidos clase Persona
	 * @param email     clase Persona
	 * @param nUsuario  clase Persona
	 * @param pass      clase Persona
	 * @param telefono  clase Persona
	 * @return true o false dependiendo de si el registro es exitoso o no
	 */
	public boolean registro(String tipo, String nombre, String apellidos, String email, String nUsuario, String pass,
			String telefono) {

		if (tipo == "admin") {
			int idAdmin;

			if (admins.isEmpty())
				idAdmin = 1;
			else {
				idAdmin = admins.size() + 1;
			}

			admins.add(new Administrador(nombre, apellidos, email, nUsuario, pass, telefono, idAdmin));

			return true;

		} else if (tipo == "comprador") {
			int idComprador;

			if (compradores.isEmpty())
				idComprador = 1;
			else {
				idComprador = compradores.size() + 1;
			}

			compradores.add(new Comprador(nombre, apellidos, email, nUsuario, pass, telefono, idComprador, 2000));

			return true;

		} else if (tipo == "vendedor") {
			int idVendedor;

			if (vendedores.isEmpty())
				idVendedor = 1;
			else {
				idVendedor = vendedores.size() + 1;
			}

			vendedores.add(new Vendedor(nombre, apellidos, email, nUsuario, pass, telefono, idVendedor, 0));

			return true;

		} else {
			System.err.println("Tipo de usuario desconocido");
			return false;
		}

	}

	/**
	 * Metodo que se encarga de validar o no un login
	 * 
	 * @param tipo     admin, comprador o vendedor
	 * @param nUsuario clase Persona
	 * @param pass     clase Persona
	 * @return true o false dependiendo de si valida o no
	 */
	public boolean login(String tipo, String nUsuario, String pass) {
		if (tipo == "admin") {
			for (Administrador aux : admins) {
				if (nUsuario.equals(aux.getNUsuario()) == true) {
					if (pass.equals(aux.getPass()) == true) {
						return true;
					}
				}
			}
			return false;

		} else if (tipo == "comprador") {

			for (Comprador aux : compradores) {
				if (nUsuario.equals(aux.getNUsuario()) == true) {
					if (pass.equals(aux.getPass()) == true) {
						return true;
					}
				}
			}
			return false;

		} else if (tipo == "vendedor") {
			for (Vendedor aux : vendedores) {
				if (nUsuario.equals(aux.getNUsuario()) == true) {
					if (pass.equals(aux.getPass()) == true) {
						return true;
					}
				}
			}
			return false;
		}
		return false;
	}

	// Los metodos de borrado deben implementarse en base a las listas
	public void borrarAdmin(int id) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;

		int idAdministrador = id;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			stm.executeUpdate(
					"DELETE FROM amazexpressbbdd.administrador WHERE idAdministrador = '" + idAdministrador + "'");
			System.out.println("Administrador borrado");
		} catch (SQLException e) {

		}

		Administrador removable = null;
		for (Administrador aux : admins) {
			if (aux.getIdAdministrador() == id)
				removable = aux;
		}
		if (removable != null)
			admins.remove(removable);

	}

	public void borrarComprador(int id) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;

		int idComprador = id;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			stm.executeUpdate("DELETE FROM amazexpressbbdd.comprador WHERE idComprador = '" + idComprador + "'");
			System.out.println("Comprador borrado");
		} catch (SQLException e) {

		}

		Comprador removable = null;
		for (Comprador aux : compradores) {
			if (aux.getIdComprador() == id)
				removable = aux;
		}
		if (removable != null)
			compradores.remove(removable);
	}

	public void borrarVendedor(int id) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;

		int idVendedor = id;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			stm.executeUpdate("DELETE FROM amazexpressbbdd.vendedor WHERE idVendedor = '" + idVendedor + "'");
			System.out.println("Vendedor borrado");
		} catch (SQLException e) {

		}

		Vendedor removable = null;
		for (Vendedor aux : vendedores) {
			if (aux.getIdVendedor() == id)
				removable = aux;
		}
		if (removable != null)
			vendedores.remove(removable);
	}
	
	public void borrarProducto(int id) {
		Producto removable = null;
		for (Producto aux : productos) {
			if (aux.getIdProducto() == id)
				removable = aux;
		}
		if (removable != null)
			productos.remove(removable);	
		
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;

		int idProducto = id;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			stm.executeUpdate("DELETE FROM amazexpressbbdd.producto WHERE idProducto = '" + idProducto+ "'");
			System.out.println("Producto borrado");
		} catch (SQLException e) {

		}
	}

	/**
	 * Metodo que devuelve el objeto del usuario que ha iniciado sesion
	 * 
	 * @param nUsuario Nombre de usuario
	 * @return Objeto del usuario
	 */
	public Administrador getAdmin(String nUsuario) throws NullPointerException {
		Administrador retorno = null;
		for (Administrador aux : admins) {
			if (nUsuario.equals(aux.getNUsuario()) == true) {
				retorno = aux;
			}
		}
		return retorno;
	}

	/**
	 * Metodo que devuelve el objeto del usuario que ha iniciado sesion
	 * 
	 * @param nUsuario Nombre de usuario
	 * @return Objeto del usuario
	 */
	public Vendedor getVendedor(String nUsuario) {

		Vendedor retorno = null;
		for (Vendedor aux : vendedores) {
			if (nUsuario.equals(aux.getNUsuario()) == true) {

				retorno = aux;
			}
		}
		return retorno;
	}

	/**
	 * Metodo que devuelve el objeto del usuario que ha iniciado sesion
	 * 
	 * @param nUsuario Nombre de usuario
	 * @return Objeto del usuario
	 */
	public Comprador getComprador(String nUsuario) {

		Comprador retorno = null;
		for (Comprador aux : compradores) {
			if (nUsuario.equals(aux.getNUsuario()) == true) {
				retorno = aux;
			}
		}
		return retorno;
	}
	
	public Vendedor getVendedorProducto(String id) {

		Producto retorno = null;
		for (Producto aux : productos) {
			if (id.equals(aux.getIdProducto()) == true) {
				retorno = aux;
			}
		}
		return getVendedor(retorno.getVendedor());
	}

	/**
	 * Metodo para calcular el numero de usuarios de la app que no son admins.
	 * 
	 * @return numero de usuarios de la app
	 */
	public int getUserNumber() {
		return this.compradores.size() + this.vendedores.size() + this.admins.size();
	}	

}
