package ec.edu.ups.ppw63.transacciones.bussines;

import java.util.List;

import ec.edu.ups.ppw63.transacciones.dao.ClienteDAO;
import ec.edu.ups.ppw63.transacciones.model.Cliente;
import ec.edu.ups.ppw63.transacciones.model.Cuenta;
import ec.edu.ups.ppw63.transacciones.model.Transaccion;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionClientes {

	@Inject
	private ClienteDAO daoCliente;
	
	public void actualizarCliente(Cliente cliente) throws Exception {
		Cliente cli = daoCliente.read(cliente.getCodigo());
		if (cli != null){
			daoCliente.update(cliente);
		}else {
			throw new Exception("Cliente no existe");
		}
	}
	
	public void guardarClientes(Cliente cliente) {
		System.out.println("Codigo: " + cliente.getCodigo());
		Cliente cli = daoCliente.read(cliente.getCodigo());
		if (cli != null) {
			System.out.println("Este es: " + cliente);
			daoCliente.update(cliente);
		}else {
			daoCliente.insert(cliente);
		}
	}
	
	public Cliente getClientePorCedula(String cedula) throws Exception{
		if (cedula.length() != 10) 
			throw new Exception("Cedula incorrecta");
			
			return daoCliente.getClientePorCedula(cedula);
	}
	
	public Cliente getClientePorId(int codigo){
			return daoCliente.getClientePorId(codigo);
	}
	
	public void borrarCliente(int codigo) {
		daoCliente.remove(codigo);
	}
	
	public List<Cliente> getClientes(){
		return daoCliente.getAll();
	}
	
}
