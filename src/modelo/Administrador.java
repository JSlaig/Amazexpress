package modelo;

public class Administrador extends Persona{	

	//Atributos de Administrador
	private int idAdministrador;
	
	//Constructor con los param de la superclase
	public Administrador(String nombre, String apellidos, String email, String nUsuario, String password, String telefono, int idAdministrador) {
		
		//Atributos ya inicializados en la superclase
		super(nombre, apellidos, email, nUsuario, password, telefono);
		
		this.idAdministrador = idAdministrador;
	}
	
	//Getters
	public int getIdAdministrador() {
		return this.idAdministrador;
	}
}
