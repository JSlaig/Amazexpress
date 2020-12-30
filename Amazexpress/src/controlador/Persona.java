package controlador;

public class Persona {
	
	//Atributos
	
	private String nombre;
	
	private String apellidos;
	
	private String email;
	
	private String password;
	
	private String telefono;
	
	
	//Constructor
	
	public Persona(String nombre, String apellidos, String email, String password, String telefono) {		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
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


	public String getPassword() {
		return password;
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


	public void setPassword(String password) {
		this.password = password;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}	
}
