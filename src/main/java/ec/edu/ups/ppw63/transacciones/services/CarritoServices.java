package ec.edu.ups.ppw63.transacciones.services;

import java.util.List;

import ec.edu.ups.ppw63.transacciones.bussines.GestionCarrito;
import ec.edu.ups.ppw63.transacciones.bussines.GestionCarrito;
import ec.edu.ups.ppw63.transacciones.model.Carrito;
import ec.edu.ups.ppw63.transacciones.model.Detalles_Carrito;
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

@Path("Carritos")
public class CarritoServices {
	
	@Inject
	private GestionCarrito gCarrito;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response agregarDetalle(Detalles_Carrito detalleCarrito) {
		try{
			gCarrito.agregarDetalle(detalleCarrito);
			ErrorMessage error = new ErrorMessage(1, "OK");
			//return Response.ok(Carrito).build();
			return Response.status(Response.Status.CREATED).entity(error).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Carrito carrito) {
		try{
			gCarrito.guardarCarritos(carrito);
			ErrorMessage error = new ErrorMessage(1, "OK");
			//return Response.ok(Carrito).build();
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
	public Response actualizar(Carrito carrito) {
		try{
			gCarrito.actualizarCarrito(carrito);
			return Response.ok(carrito).build();
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
	public Response getCarritos(){
		List<Carrito> carritos = gCarrito.getCarritos();
		if(carritos.size()>0)
			return Response.ok(carritos).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran Carritos");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}

}
