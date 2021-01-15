package modelo;

public class Tienda {
	
	private int idTienda;
	
	private String nombre;
	
	private Vendedor owner;
	
	private String descripcion;
	
	private String localizacion;
	
	
	

	public Tienda(int idTienda, String nombre, Vendedor owner, String descripcion, String localizacion) {
		super();
		this.idTienda = idTienda;
		this.nombre = nombre;
		this.owner = owner;
		this.descripcion = descripcion;
		this.localizacion = localizacion;
	}

	public Vendedor getOwner() {
		return owner;
	}

	public void setOwner(Vendedor owner) {
		this.owner = owner;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdTienda() {
		return idTienda;
	}

	public void setIdTienda(int idTienda) {
		this.idTienda = idTienda;
	}

}
