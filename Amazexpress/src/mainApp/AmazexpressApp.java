package mainApp;

import java.util.HashMap;

import controlador.Administrador;
import controlador.Comprador;
import controlador.Vendedor;

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
	public static AmazexpressApp getSingletonInstance() {
		
		if(app == null) {
			app = new AmazexpressApp();
		}else {
			System.err.println("Solo puede haber una instancia ejecutandose");
		}
		
		return app;
	}
	
	//Metodo de importacion de datos persistentes nada mas comienze la ejecucion del programa, se tendra que encargar de inicializar los hashmaps si no estan creados
	public void initialize() {
		//Por implementar
	}
}
