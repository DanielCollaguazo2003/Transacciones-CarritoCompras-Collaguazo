package ec.edu.ups.ppw63.transacciones.services;

import java.util.List;

import ec.edu.ups.ppw63.transacciones.bussines.GestionClientes;
import ec.edu.ups.ppw63.transacciones.bussines.GestionCuenta;
import ec.edu.ups.ppw63.transacciones.model.Transaccion;
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

@Path("transferencia")
public class TransferenciaServices {
	
	@Inject
	private GestionCuenta gCuenta;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response transferir(Transaccion transferencia) {
		try{
			gCuenta.transferir(transferencia);;
			ErrorMessage error = new ErrorMessage(1, "OK");
			//return Response.ok(cliente).build();
			return Response.status(Response.Status.CREATED).entity(error).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
	}
}
