package ec.edu.ups.ppw63.transacciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DetalleFactura {

	@Id
	@GeneratedValue
	private int codigo;
	private String nombre;
	private int cantidad;
	private double precio;
	
	@ManyToOne
    @JoinColumn(name = "codigo_producto")
    private Producto producto;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "DetalleFactura [codigo=" + codigo + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio="
				+ precio + ", producto=" + producto + "]";
	}
	
	
	
	
}
