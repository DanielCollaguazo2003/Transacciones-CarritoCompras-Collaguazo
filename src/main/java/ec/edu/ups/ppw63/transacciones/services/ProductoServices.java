package ec.edu.ups.ppw63.transacciones.services;

import java.util.List;

import ec.edu.ups.ppw63.transacciones.bussines.GestionProductos;
import ec.edu.ups.ppw63.transacciones.model.Producto;
import ec.edu.ups.ppw63.transacciones.model.Producto;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("Productos")
public class ProductoServices {
	
	@Inject
	private GestionProductos gProducto;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Producto producto) {
		try{
			gProducto.guardarProductos(producto);
			ErrorMessage error = new ErrorMessage(1, "OK");
			//return Response.ok(Producto).build();
			return Response.status(Response.Status.CREATED).entity(error).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
	}
	

	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Producto producto) {
		try{
			gProducto.actualizarProducto(producto);
			return Response.ok(producto).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getProductos(){
		List<Producto> productos = gProducto.getProductos();
		if(productos.size()>0)
			return Response.ok(productos).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran Productos");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}

}
