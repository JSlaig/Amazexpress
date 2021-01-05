package modelo;

public class Persona {
	
	//Atributos
	
	private String nombre;
	
	private String apellidos;
	
	private String email;
	
	private String nUsuario;
	
	private String pass;
	
	private String telefono;
	
	
	//Constructor
	
	public Persona(String nombre, String apellidos, String email, String nUsuario, String pass, String telefono) {		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.nUsuario = nUsuario;
		this.pass = pass;
		this.telefono = telefono;
	}
	
	
	//Getters

	public String getNombre() {
		return nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public String getEmail() {
		return email;
	}
	
	public String getNUsuario() {
		return this.nUsuario;
	}


	public String getPass() {
		return pass;
	}


	public String getTelefono() {
		return telefono;
	}


	//Setters
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public void setNUsuario(String nUsuario) {
		this.nUsuario = nUsuario;
	}

	public void setPassword(String pass) {
		this.pass = pass;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}	
}
