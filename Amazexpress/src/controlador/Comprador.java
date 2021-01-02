package controlador;

public class Comprador extends Persona{
	
	//Atributos de Comprador
	private int idComprador;
	private double balance;
		
		//Constructor con los param de la superclase
		public Comprador(String nombre, String apellidos, String email, String nUsuario, String password, String telefono, int idComprador, double balance) {
			
			//Atributos ya inicializados en la superclase
			super(nombre, apellidos, email, nUsuario, password, telefono);
			
			this.idComprador = idComprador;
			this.balance = balance;
		}
		
		//Getters
		public int getIdComprador() {
			return this.idComprador;
		}
		
		public double getBalance() {
			return this.balance;
		}
}
