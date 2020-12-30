package controlador;

public class Administrador extends Persona{	

	//Atributos de Administrador
	private String idAdministrador;
	
	//Constructor con los param de la superclase
	public Administrador(String nombre, String apellidos, String email, String password, String telefono, String idAdministrador) {
		
		//Atributos ya inicializados en la superclase
		super(nombre, apellidos, email, password, telefono);
		
		this.idAdministrador = idAdministrador;
	}
	
	//Getters
	public String getIdAdministrador() {
		return this.idAdministrador;
	}
}
