package ec.edu.ups.ppw63.transacciones.bussines;

import java.util.Date;
import java.util.List;

import ec.edu.ups.ppw63.transacciones.dao.CuentaDAO;
import ec.edu.ups.ppw63.transacciones.dao.CuentaDAO;
import ec.edu.ups.ppw63.transacciones.model.Cuenta;
import ec.edu.ups.ppw63.transacciones.model.Detalles_Cuenta;
import ec.edu.ups.ppw63.transacciones.model.Cuenta;
import ec.edu.ups.ppw63.transacciones.model.Transaccion;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionCuenta {

	@Inject
	private CuentaDAO daoCuenta;
	
	public void actualizarCuenta(Cuenta cuenta) throws Exception {
		Cuenta cue = daoCuenta.read(cuenta.getCodigo());
		if (cue != null){
			daoCuenta.update(cuenta);
		}else {
			throw new Exception("Cuenta no existe");
		}
	}
	
	public void guardarCuentas(Cuenta cuenta) {
		System.out.println("Codigo: " + cuenta.getCodigo());
		Cuenta cli = daoCuenta.read(cuenta.getCodigo());
		if (cli != null) {
			System.out.println("Este es: " + cuenta);
			daoCuenta.update(cuenta);
		}else {
			daoCuenta.insert(cuenta);
		}
	}
	
	public Cuenta getCuentaPorId(int codigo){
			return daoCuenta.getCuentaPorId(codigo);
	}
	
	public void borrarCuenta(int codigo) {
		daoCuenta.remove(codigo);
	}
	
	public List<Cuenta> getCuentas(){
		return daoCuenta.getAll();
	}
	
	public void transferir(Transaccion transferencia) throws Exception{
		System.out.println("Entrando al metodo...");
		Cuenta cuentaOrigen = getCuentaPorId(transferencia.getIdClienteOrigen());
		Cuenta cuentaDestino = getCuentaPorId(transferencia.getIdClienteDestino());
		
		if (cuentaOrigen == null || cuentaDestino == null) {
	        throw new Exception("Cuenta de origen o destino no existe");
	    }
		
		float monto = transferencia.getMonto();
		
		
		if (cuentaOrigen.getAhorros() < monto) {
	        throw new Exception("Fondos insuficientes para realizar la transferencia");
	    }
		
		cuentaOrigen.setAhorros(cuentaOrigen.getAhorros() - monto);
	    cuentaDestino.setAhorros(cuentaDestino.getAhorros() + monto);
	    
	    Detalles_Cuenta detalleOrigen = new Detalles_Cuenta();
	    detalleOrigen.setFecha(new Date());
	    detalleOrigen.setMonto(monto);
	    detalleOrigen.setSaldo(cuentaOrigen.getAhorros());
	    detalleOrigen.setTipo(true);
	    
	    Detalles_Cuenta detalleDestino = new Detalles_Cuenta();
	    detalleDestino.setFecha(new Date());
	    detalleDestino.setMonto(monto);
	    detalleDestino.setSaldo(cuentaDestino.getAhorros());
	    detalleDestino.setTipo(false);
	    
	    cuentaOrigen.addDetalles(detalleOrigen);
	    cuentaDestino.addDetalles(detalleDestino);
	    
	    daoCuenta.update(cuentaOrigen);
	    daoCuenta.update(cuentaDestino);
	    
	}
}
