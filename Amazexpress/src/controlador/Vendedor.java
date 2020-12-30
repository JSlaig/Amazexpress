package controlador;

public class Vendedor extends Persona{	
	
	
	//Atributos de vendedor
	private String idVendedor;
	
	
	//Constructor con los param de la superclase
	public Vendedor(String nombre, String apellidos, String email, String password, String telefono, String idVendedor) {
		
		//Atributos ya inicializados en la superclase
		super(nombre, apellidos, email, password, telefono);
		
		this.idVendedor = idVendedor;		
	}
	
	
	//Getters
	public String getIdVendedor() {
		return this.idVendedor;
	}
}
