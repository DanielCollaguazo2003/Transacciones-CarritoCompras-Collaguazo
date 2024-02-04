package ec.edu.ups.ppw63.transacciones.services;

import java.util.List;

import ec.edu.ups.ppw63.transacciones.bussines.GestionCuenta;
import ec.edu.ups.ppw63.transacciones.model.Cuenta;
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

@Path("Cuentas")
public class CuentaServices {
	
	@Inject
	private GestionCuenta gCuenta;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Cuenta cuenta) {
		try{
			gCuenta.guardarCuentas(cuenta);
			ErrorMessage error = new ErrorMessage(1, "OK");
			//return Response.ok(Cuenta).build();
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
	public Response actualizar(Cuenta cuenta) {
		try{
			gCuenta.actualizarCuenta(cuenta);
			return Response.ok(cuenta).build();
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
	public Response getCuentas(){
		List<Cuenta> cuentas = gCuenta.getCuentas();
		if(cuentas.size()>0)
			return Response.ok(cuentas).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran Cuentas");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}

}
