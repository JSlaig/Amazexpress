package controlador;

public class Comprador extends Persona{
	
	//Atributos de Comprador
	private String idComprador;
		
		//Constructor con los param de la superclase
		public Comprador(String nombre, String apellidos, String email, String password, String telefono, String idComprador) {
			
			//Atributos ya inicializados en la superclase
			super(nombre, apellidos, email, password, telefono);
			
			this.idComprador = idComprador;
		}
		
		//Getters
		public String getIdComprador() {
			return this.idComprador;
		}
}
