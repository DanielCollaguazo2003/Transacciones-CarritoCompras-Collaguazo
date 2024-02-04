package ec.edu.ups.ppw63.transacciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Detalles_Carrito {

	@Id
	@GeneratedValue
	private int codigo;
	private int cantidad;
	private int codigoProducto;
	private int codigoCarrito;
	
	/**@ManyToOne
    @JoinColumn(name = "codigo_producto")
    private Producto producto;
	 **/
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public int getCodigoCarrito() {
		return codigoCarrito;
	}

	public void setCodigoCarrito(int codigoCarrito) {
		this.codigoCarrito = codigoCarrito;
	}

	@Override
	public String toString() {
		return "Detalles_Carrito [codigo=" + codigo + ", cantidad=" + cantidad + ", codigoProducto=" + codigoProducto
				+ ", codigoCarrito=" + codigoCarrito + "]";
	}

	

	
	
	
}
