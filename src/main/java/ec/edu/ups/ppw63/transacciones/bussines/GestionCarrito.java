package ec.edu.ups.ppw63.transacciones.bussines;

import java.util.Date;
import java.util.List;

import ec.edu.ups.ppw63.transacciones.dao.CarritoDAO;
import ec.edu.ups.ppw63.transacciones.dao.CarritoDAO;
import ec.edu.ups.ppw63.transacciones.dao.CarritoDAO;
import ec.edu.ups.ppw63.transacciones.model.Carrito;
import ec.edu.ups.ppw63.transacciones.model.Detalles_Carrito;
import ec.edu.ups.ppw63.transacciones.model.Carrito;
import ec.edu.ups.ppw63.transacciones.model.Transaccion;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionCarrito {

	@Inject
	private CarritoDAO daoCarrito;
	
	public void actualizarCarrito(Carrito carrito) throws Exception {
		Carrito car = daoCarrito.read(carrito.getCodigo());
		if (car != null){
			daoCarrito.update(carrito);
		}else {
			throw new Exception("Carrito no existe");
		}
	}
	
	public void guardarCarritos(Carrito carrito) {
		System.out.println("Codigo: " + carrito.getCodigo());
		Carrito car = daoCarrito.read(carrito.getCodigo());
		if (car != null) {
			System.out.println("Este es: " + carrito);
			daoCarrito.update(carrito);
		}else {
			daoCarrito.insert(carrito);
		}
	}
	
	public Carrito getCarritoPorId(int codigo){
			return daoCarrito.getCarritoPorId(codigo);
	}
	
	public void borrarCarrito(int codigo) {
		daoCarrito.remove(codigo);
	}
	
	public List<Carrito> getCarritos(){
		return daoCarrito.getAll();
	}
	
	public void agregarDetalle(Detalles_Carrito detalleCarrito) throws Exception{
		System.out.println("El detalle es: " + detalleCarrito.getCodigoCarrito());
		Carrito carObtenido = getCarritoPorId(detalleCarrito.getCodigoCarrito());
		
		carObtenido.addDetalles(detalleCarrito);
		
		daoCarrito.update(carObtenido);
	}
	
	public Carrito getClientePorCliente(int codigo){
		return daoCarrito.getCarritoPorCliente(codigo);
	}
}
