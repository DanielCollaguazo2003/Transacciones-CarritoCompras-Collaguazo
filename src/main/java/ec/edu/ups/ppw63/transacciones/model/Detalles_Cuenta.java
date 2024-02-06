package ec.edu.ups.ppw63.transacciones.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Detalles_Cuenta {

	@Id
	@GeneratedValue
	private int codigo;
	private boolean tipo;
	private Date fecha;
	private float monto;
	private float saldo;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public boolean isTipo() {
		return tipo;
	}
	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	@Override
	public String toString() {
		return "Detalles_Cuenta [codigo=" + codigo + ", tipo=" + tipo + ", fecha=" + fecha + ", monto=" + monto
				+ ", saldo=" + saldo + "]";
	}
	
	
}
