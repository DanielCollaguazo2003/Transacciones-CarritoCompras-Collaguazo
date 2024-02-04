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
public class Cuenta {
	
	@Id
	@GeneratedValue
	private int codigo;
	private float ahorros;
	private String numero;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo_cliente")
	private Cliente cliente;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="codigo_cuenta")
	private List<Detalles_Cuenta> detalles;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float getAhorros() {
		return ahorros;
	}

	public void setAhorros(float ahorros) {
		this.ahorros = ahorros;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Detalles_Cuenta> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalles_Cuenta> detalles) {
		this.detalles = detalles;
	}

	@Override
	public String toString() {
		return "Cuenta [codigo=" + codigo + ", ahorros=" + ahorros + ", numero=" + numero + ", cliente=" + cliente
				+ ", detalles=" + detalles + "]";
	}
	
	public void addDetalles (Detalles_Cuenta detalle) {
		if (detalles == null)
			detalles = new ArrayList<Detalles_Cuenta>();
			
			detalles.add(detalle);
	}
}
