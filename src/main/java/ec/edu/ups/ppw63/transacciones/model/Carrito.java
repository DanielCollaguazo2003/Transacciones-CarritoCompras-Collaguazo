package ec.edu.ups.ppw63.transacciones.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Carrito {

	@Id
	@GeneratedValue
	private int codigo;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo_cliente")
	private Cliente cliente;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="codigo_carrito")
	private List<Detalles_Carrito> detalles;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Detalles_Carrito> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalles_Carrito> detalles) {
		this.detalles = detalles;
	}

	@Override
	public String toString() {
		return "Carrito [codigo=" + codigo + ", cliente=" + cliente + ", detalles=" + detalles + "]";
	}

	public void addDetalles (Detalles_Carrito detalle) {
		if (detalles == null)
			detalles = new ArrayList<Detalles_Carrito>();
			
			detalles.add(detalle);
	}
	 
}
