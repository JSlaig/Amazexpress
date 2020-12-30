package controlador;

public class Vendedor extends Persona{	
	
	
	//Atributos de vendedor
	private int idVendedor;
	private double balance;
	
	
	//Constructor con los param de la superclase
	public Vendedor(String nombre, String apellidos, String email, String password, String telefono, int idVendedor, double balance) {
		
		//Atributos ya inicializados en la superclase
		super(nombre, apellidos, email, password, telefono);
		
		this.idVendedor = idVendedor;	
		this.balance = balance;
	}
	
	
	//Getters
	public int getIdVendedor() {
		return this.idVendedor;
	}
	
	public double getBalance() {
		return this.balance;
	}
}
