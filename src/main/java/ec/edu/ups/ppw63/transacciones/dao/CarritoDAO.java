package ec.edu.ups.ppw63.transacciones.dao;

import java.util.List;

import ec.edu.ups.ppw63.transacciones.model.Carrito;
import ec.edu.ups.ppw63.transacciones.model.Carrito;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class CarritoDAO {
	
	@PersistenceContext
	private EntityManager em;

	public void insert(Carrito  carrito) {
		em.persist(carrito);
	}
		
	public void update(Carrito carrito) {
		em.merge(carrito);	
	}

	public void remove(int codigo) {
		Carrito carrito = em.find(Carrito.class, codigo);
		em.remove(carrito);
	}
	
	public Carrito read(int codigo) {
		Carrito carrito = em.find(Carrito.class, codigo);
		return carrito;
	}
	
	public List<Carrito> getAll(){
		String jpql = "SELECT c FROM Carrito c"; //JPQL es sensible a mayusculas --- para realizar una consulta es similar pero hay q ue tener en cuenta que se tiene una variabe en lugar del alterisco y hay que referenciar a la entidad  no a la tabla
												 // Es decir se debe consultar en la entidad mas no directamente a una tabla de la base de datos 
												 // En lugar del * se coloca una variable, esa variable hace referencia al alias de la entidad
		Query q = em.createQuery(jpql, Carrito.class);
		return q.getResultList();
	}
	
	
	public Carrito getCarritoPorId(int codigo) {
		String jpql = "SELECT c FROM Carrito c WHERE c.codigo = :codigo";
		Query q = em.createQuery(jpql, Carrito.class);
		q.setParameter("codigo", codigo);
		List<Carrito> carritos = q.getResultList();
		if (carritos.size() > 0)
			return carritos.get(0);
		return null;
		}
	
	public Carrito getCarritoPorCliente(int codigoCliente) {
	    String jpql = "SELECT c FROM Carrito c WHERE c.cliente.codigo = :codigo";
	    Query q = em.createQuery(jpql, Carrito.class);
	    q.setParameter("codigo", codigoCliente);
	    try {
	        return (Carrito) q.getSingleResult();
	    } catch (NoResultException e) {
	        return null;
	    }
	}

}
