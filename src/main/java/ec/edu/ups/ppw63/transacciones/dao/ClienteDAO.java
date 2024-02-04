package ec.edu.ups.ppw63.transacciones.dao;

import java.util.List;

import ec.edu.ups.ppw63.transacciones.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ClienteDAO {
	
	@PersistenceContext
	private EntityManager em;

	public void insert(Cliente  cliente) {
		em.persist(cliente);
	}
		
	public void update(Cliente cliente) {
		em.merge(cliente);	
	}

	public void remove(int codigo) {
		Cliente cliente = em.find(Cliente.class, codigo);
		em.remove(cliente);
	}
	
	public Cliente read(int codigo) {
		Cliente cliente = em.find(Cliente.class, codigo);
		return cliente;
	}
	
	public List<Cliente> getAll(){
		String jpql = "SELECT c FROM Cliente c"; //JPQL es sensible a mayusculas --- para realizar una consulta es similar pero hay q ue tener en cuenta que se tiene una variabe en lugar del alterisco y hay que referenciar a la entidad  no a la tabla
												 // Es decir se debe consultar en la entidad mas no directamente a una tabla de la base de datos 
												 // En lugar del * se coloca una variable, esa variable hace referencia al alias de la entidad
		Query q = em.createQuery(jpql, Cliente.class);
		return q.getResultList();
	}
	
	public Cliente getClientePorCedula(String cedula) {

		String jpql = "SELECT c FROM Cliente c WHERE c.dni = :cedula";
		Query q = em.createQuery(jpql, Cliente.class);
		q.setParameter("cedula", cedula);
		List<Cliente> clientes = q.getResultList();
		if (clientes.size() > 0)
			return clientes.get(0);
		return null;
		}
	
	public Cliente getClientePorId(int codigo) {
		String jpql = "SELECT c FROM Cliente c WHERE c.codigo = :codigo";
		Query q = em.createQuery(jpql, Cliente.class);
		q.setParameter("codigo", codigo);
		List<Cliente> clientes = q.getResultList();
		if (clientes.size() > 0)
			return clientes.get(0);
		return null;
		}
}
