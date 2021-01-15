package modelo;

public class Producto {

//Atributos de producto
	public int idProducto;
	private String nombre;
	private String vendedor;
	private String descripcion;
	private double precio;
	private int stock;

//Constructor
	public Producto(int idProducto, String nombre, String descripcion, String vendedor, double precio, int stock) {
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.vendedor = vendedor;
		this.setPrecio(precio);
		if (stock >= 0) {
			this.setStock(stock);
		} else {
			this.setStock(0);
		}
	}

//Getters
	public int getIdProducto() {
		return this.idProducto;
	}

	public String getNombre() {

		return this.nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public String getVendedor() {
		return this.vendedor;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}
