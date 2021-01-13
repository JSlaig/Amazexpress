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
//Getters
	public int getIdVendedor() {
		return this.idVendedor;
	}
	
	public double getbalance() {
		return this.balance;
	}
}
