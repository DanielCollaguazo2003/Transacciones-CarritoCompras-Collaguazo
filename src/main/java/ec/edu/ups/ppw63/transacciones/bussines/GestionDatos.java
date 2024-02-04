package ec.edu.ups.ppw63.transacciones.bussines;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import ec.edu.ups.ppw63.transacciones.dao.CarritoDAO;
import ec.edu.ups.ppw63.transacciones.dao.ClienteDAO;
import ec.edu.ups.ppw63.transacciones.dao.CuentaDAO;
import ec.edu.ups.ppw63.transacciones.dao.FacturaDAO;
import ec.edu.ups.ppw63.transacciones.dao.ProductoDAO;
import ec.edu.ups.ppw63.transacciones.model.Carrito;
import ec.edu.ups.ppw63.transacciones.model.Cliente;
import ec.edu.ups.ppw63.transacciones.model.Cuenta;
import ec.edu.ups.ppw63.transacciones.model.DetalleFactura;
import ec.edu.ups.ppw63.transacciones.model.Detalles_Carrito;
import ec.edu.ups.ppw63.transacciones.model.Detalles_Cuenta;
import ec.edu.ups.ppw63.transacciones.model.Factura;
import ec.edu.ups.ppw63.transacciones.model.Producto;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup      //Hace que no espere a que un cliente lo llame sino que se ejecutara ni bien se lanza la aplicacion
public class GestionDatos {
	
	@Inject
	private ClienteDAO daoCliente;
	
	@Inject
	private CuentaDAO daoCuenta;
	
	
	@Inject
	private ProductoDAO daoProducto;
	
	@Inject
	private CarritoDAO daoCarrito;
	
	@Inject
	private FacturaDAO daoFactura;
	
	@PostConstruct
	public void init() {
System.out.println("iniciando");
		
		Cliente cliente = new Cliente();
		cliente.setApellido("Collaguazo");
		cliente.setNombre("Daniel");
		cliente.setCedula("0107193708");
		
		Cliente cliente2 = new Cliente();
		cliente2.setApellido("Sigua");
		cliente2.setNombre("Paul");
		cliente2.setCedula("0107193708");
		
		daoCliente.insert(cliente);
		daoCliente.insert(cliente2);
		
		Cuenta cuenta1 = new Cuenta();
		cuenta1.setCliente(cliente);
		cuenta1.setAhorros(1000);
		cuenta1.setNumero("01028514292-111s");
		
		Cuenta cuenta2 = new Cuenta();
		cuenta2.setCliente(cliente2);
		cuenta2.setAhorros(5000);
		cuenta2.setNumero("99429043204-111s");
		
		Detalles_Cuenta detalle1 = new Detalles_Cuenta();
		detalle1.setFecha(new Date());
		detalle1.setMonto(100);
		detalle1.setSaldo(4900);
		detalle1.setTipo(true);
		
		cuenta2.addDetalles(detalle1);
		
		Detalles_Cuenta detalle2 = new Detalles_Cuenta();
		detalle2.setFecha(new Date());
		detalle2.setMonto(100);
		detalle2.setSaldo(1100);
		detalle2.setTipo(false);
		
		cuenta1.addDetalles(detalle2);
		
		
		daoCuenta.insert(cuenta1);
		daoCuenta.insert(cuenta2);
		
		
		Producto p1 = new Producto();
		p1.setNombre("Celular");
		p1.setPrecio(100);
		

		Producto p2 = new Producto();
		p2.setNombre("Computadora");
		p2.setPrecio(1000);
		

		Producto p3 = new Producto();
		p3.setNombre("Cargado");
		p3.setPrecio(15);
		

		Producto p4 = new Producto();
		p4.setNombre("Audifonos");
		p4.setPrecio(250);
		
		daoProducto.insert(p1);
		daoProducto.insert(p2);
		daoProducto.insert(p3);
		daoProducto.insert(p4);
		
		Carrito car1 = new Carrito();
		car1.setCliente(cliente);
		
		Detalles_Carrito dcar1 = new Detalles_Carrito();
		dcar1.setCantidad(2);
		dcar1.setCodigoProducto(1);
		
		Detalles_Carrito dcar2 = new Detalles_Carrito();
		dcar2.setCantidad(2);
		dcar2.setCodigoProducto(2);
		
		car1.addDetalles(dcar1);
		car1.addDetalles(dcar2);
		
		daoCarrito.insert(car1);
		
		Carrito car2 = new Carrito();
		car2.setCliente(cliente2);
		
		
		Detalles_Carrito dcar3 = new Detalles_Carrito();
		dcar3.setCantidad(2);
		dcar3.setCodigoProducto(3);
		
		Detalles_Carrito dcar4 = new Detalles_Carrito();
		dcar4.setCantidad(2);
		dcar4.setCodigoProducto(4);
		
		car2.addDetalles(dcar3);
		car2.addDetalles(dcar4);
		
		daoCarrito.insert(car2);
		
		
		Factura factura = new Factura();
		factura.setCliente(cliente);
		factura.setNumero("001-001-00000001");
		factura.setFechaEmision(new Date());
		factura.setTotal(1000.52);
		
		
		
		DetalleFactura det = new DetalleFactura();
		det.setNombre("TV");
		det.setCantidad(2);
		det.setPrecio(100.50);
		
		factura.addDetalles(det);
		
		det = new DetalleFactura();
		det.setNombre("Cocina");
		det.setCantidad(1);
		det.setPrecio(150.50);
		
		factura.addDetalles(det);
		
		
		daoFactura.insert(factura);
		/*System.out.println("\n------------- Clientes");
		List<Cliente> list = daoCliente.getAll();
		for (Cliente cli: list) {
			System.out.println(cli.getCodigo() + "\t" + cli.getNombre());
		}*/
		System.out.println("\n------------- Facturas2");
		List<Factura> list3 = daoFactura.getAll();
		for (Factura fac: list3) {
			System.out.println(fac);
		}
		
		System.out.println("\n------------- TotalFacturas");
		List<Cuenta> list = daoCuenta.getAll();
		for (Cuenta cue: list) {
			System.out.println(cue);
		}
		
		System.out.println("\n------------- Carritos");
		List<Carrito> list2 = daoCarrito.getAll();
		for (Carrito cue: list2) {
			System.out.println(cue);
		}
	}
}
