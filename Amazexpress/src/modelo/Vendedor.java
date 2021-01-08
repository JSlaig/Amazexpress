package modelo;

public class Vendedor extends Persona{	
	
	
	//Atributos de vendedor
	private int idVendedor;
	private double balance;
	
	
	//Constructor con los param de la superclase
	public Vendedor(String nombre, String apellidos, String email, String nUsuario, String password, String telefono, int idVendedor, double balance) {
		
		//Atributos ya inicializados en la superclase
		super(nombre, apellidos, email, nUsuario, password, telefono);
		
		this.idVendedor = idVendedor;	
		this.balance = balance;
	}
	
	
	//Getters

//PROPUESTA
/*	public Vendedor(String nombre, String apellidos, String email, String nUsuario, String password, String telefono) {
	this.nombre = nombre;
	this.apelidos = apellidos;
	this.email = email;
	this.nUsuario = user;
	this.password = password;
	this.telefono = telefono;
}

//Getters
	public int getIdVendedor() {
		return this.idVendedor;
	}
	
	public double getbalance() {
		return this.balance;
	}
	
	public String getNombre() {
	
	    return this.nombre;
	}
	
	public String getApellido(){
	    return this.apellido;
	}
	
	public String getEmail(){
	    return this.email;
	}
	
	public String getUsuario(){
	    return this.nUsuario;
	}
	
	public String getPassword(){
	    return this.password;
	}

	public String getTelefono(){
	    return this.telefono;
	}*/
}
