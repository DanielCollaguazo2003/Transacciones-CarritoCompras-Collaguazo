package ec.edu.ups.ppw63.transacciones.bussines;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import ec.edu.ups.ppw63.transacciones.dao.FacturaDAO;
import ec.edu.ups.ppw63.transacciones.dao.ProductoDAO;
import ec.edu.ups.ppw63.transacciones.model.Carrito;
import ec.edu.ups.ppw63.transacciones.model.DetalleFactura;
import ec.edu.ups.ppw63.transacciones.model.Factura;
import ec.edu.ups.ppw63.transacciones.model.Producto;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionFacturas {

	@Inject
	private FacturaDAO daoFactura;
	
	@Inject
	private ProductoDAO daoProducto;
	
	public void actualizarFactura(Factura factura) throws Exception {
		Factura cli = daoFactura.read(factura.getCodigo());
		if (cli != null){
			daoFactura.update(factura);
		}else {
			throw new Exception("Factura no existe");
		}
	}
	
	public void guardarFacturas(Carrito carrito) {
		Factura fac = new Factura();
		fac.setCliente(carrito.getCliente());
		fac.setFechaEmision(new Date());
		fac.setNumero("010101010100101");
		fac.setTotal(1000);
		for(int i = 0; i > carrito.getDetalles().size(); i++) {
			DetalleFactura det  = new DetalleFactura();
			det.setCantidad(carrito.getDetalles().get(i).getCantidad());
			det.setNombre("dsasadas");
			det.setPrecio(1000);
			Producto pro = daoProducto.read(carrito.getDetalles().get(i).getCodigoProducto());
			det.setProducto(pro);
			
			fac.addDetalles(det);
		}
		
		daoFactura.insert(fac);
	}
	
	public void borrarFactura(int codigo) {
		daoFactura.remove(codigo);
	}
	
	public List<Factura> getFacturas(){
		return daoFactura.getAll();
	}
	
	private void generarFactura() {
		
	}
	
}
