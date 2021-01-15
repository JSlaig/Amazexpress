package modelo;

import java.util.HashMap;

public class Vendedor extends Persona{	
	
	
	//Atributos de vendedor
	private int idVendedor;
	private double balance;
	
	private HashMap<Integer, Producto> productos;
	
	
	//Constructor con los param de la superclase
	public Vendedor(String nombre, String apellidos, String email, String nUsuario, String password, String telefono, int idVendedor, double balance) {
		
		//Atributos ya inicializados en la superclase
		super(nombre, apellidos, email, nUsuario, password, telefono);
		
		this.idVendedor = idVendedor;	
		this.balance = balance;
		
		productos = new HashMap<Integer, Producto>();
	}
	
	
	//Getters
//Getters
	public int getIdVendedor() {
		return this.idVendedor;
	}
	
	public double getbalance() {
		return this.balance;
	}


	public HashMap<Integer, Producto> getProductos() {
		return productos;
	}
}
