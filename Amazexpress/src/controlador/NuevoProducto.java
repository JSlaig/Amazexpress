package controlador;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import modelo.AmazexpressApp;
import modelo.Producto;
import modelo.Vendedor;

public class NuevoProducto {
	
	private Vendedor vendedor;

	@FXML
	private TextArea descripcion;

	@FXML
	private TextField precio;

	@FXML
	private Button cancelar;

	@FXML
	private AnchorPane root;

	@FXML
	private TextField stock;

	@FXML
	private TextField nombre;

	@FXML
	private Button crear;

	private AmazexpressApp app;

	@FXML
	void initialize() {
		app = AmazexpressApp.getSingletonInstancia();
		 
		vendedor = app.getLoggedVendedor();
		
		cancelar.setOnAction(new EventHandler<ActionEvent>() {		 

			@Override
			public void handle(ActionEvent e) {
				try {
					cargarVentana("/vista/VendedorProductosUI.fxml");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});

		crear.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					app = AmazexpressApp.getSingletonInstancia();
					Producto producto = new Producto(app.getProductos().size() + 1, nombre.getText(), descripcion.getText(),
							app.getLoggedVendedor().getNUsuario(), Double.valueOf(precio.getText()),
							Integer.valueOf(stock.getText()));
					app.getProductos().add(producto);
					vendedor.getProductos().add(producto);

					cargarVentana("/vista/VendedorProductosUI.fxml");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	private void cargarVentana(String ruta) throws IOException {
		Parent ventana = FXMLLoader.load(getClass().getResource(ruta));
		root.getChildren().removeAll();
		root.getChildren().setAll(ventana);
	}
}
