package ec.edu.ups.ppw63.transacciones.bussines;

import java.util.Date;
import java.util.List;

import ec.edu.ups.ppw63.transacciones.dao.ProductoDAO;
import ec.edu.ups.ppw63.transacciones.dao.ProductoDAO;
import ec.edu.ups.ppw63.transacciones.dao.ProductoDAO;
import ec.edu.ups.ppw63.transacciones.dao.ProductoDAO;
import ec.edu.ups.ppw63.transacciones.model.Producto;
import ec.edu.ups.ppw63.transacciones.model.Producto;
import ec.edu.ups.ppw63.transacciones.model.Transaccion;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionProductos {

	@Inject
	private ProductoDAO daoProducto;
	
	public void actualizarProducto(Producto producto) throws Exception {
		Producto pro = daoProducto.read(producto.getCodigo());
		if (pro != null){
			daoProducto.update(producto);
		}else {
			throw new Exception("Producto no existe");
		}
	}
	
	public void guardarProductos(Producto producto) {
		System.out.println("Codigo: " + producto.getCodigo());
		Producto pro = daoProducto.read(producto.getCodigo());
		if (pro != null) {
			System.out.println("Este es: " + producto);
			daoProducto.update(producto);
		}else {
			daoProducto.insert(producto);
		}
	}
	
	public Producto getProductoPorId(int codigo){
			return daoProducto.getProductoPorId(codigo);
	}
	
	public void borrarProducto(int codigo) {
		daoProducto.remove(codigo);
	}
	
	public List<Producto> getProductos(){
		return daoProducto.getAll();
	}
	
	public void transferir(Transaccion transferencia) throws Exception{
		
	}
}
