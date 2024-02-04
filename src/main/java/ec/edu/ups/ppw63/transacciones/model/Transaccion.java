package ec.edu.ups.ppw63.transacciones.model;

public class Transaccion {

	private int idClienteOrigen;
	private int idClienteDestino;
	private float monto;
	private boolean tipo;
	public int getIdClienteOrigen() {
		return idClienteOrigen;
	}
	public void setIdClienteOrigen(int idClienteOrigen) {
		this.idClienteOrigen = idClienteOrigen;
	}
	public int getIdClienteDestino() {
		return idClienteDestino;
	}
	public void setIdClienteDestino(int idClienteDestino) {
		this.idClienteDestino = idClienteDestino;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public boolean isTipo() {
		return tipo;
	}
	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	
	
}
