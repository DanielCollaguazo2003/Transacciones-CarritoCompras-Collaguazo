package ec.edu.ups.ppw63.transacciones.dao;

import java.util.List;

import ec.edu.ups.ppw63.transacciones.model.Producto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ProductoDAO {
	
	@PersistenceContext
	private EntityManager em;

	public void insert(Producto  producto) {
		em.persist(producto);
	}
		
	public void update(Producto producto) {
		em.merge(producto);	
	}

	public void remove(int codigo) {
		Producto producto = em.find(Producto.class, codigo);
		em.remove(producto);
	}
	
	public Producto read(int codigo) {
		Producto producto = em.find(Producto.class, codigo);
		return producto;
	}
	
	public List<Producto> getAll(){
		String jpql = "SELECT c FROM Producto c"; //JPQL es sensible a mayusculas --- para realizar una consulta es similar pero hay q ue tener en cuenta que se tiene una variabe en lugar del alterisco y hay que referenciar a la entidad  no a la tabla
												 // Es decir se debe consultar en la entidad mas no directamente a una tabla de la base de datos 
												 // En lugar del * se coloca una variable, esa variable hace referencia al alias de la entidad
		Query q = em.createQuery(jpql, Producto.class);
		return q.getResultList();
	}
	
	public Producto getProductoPorId(int codigo) {
		String jpql = "SELECT c FROM Producto c WHERE c.codigo = :codigo";
		Query q = em.createQuery(jpql, Producto.class);
		q.setParameter("codigo", codigo);
		List<Producto> productos = q.getResultList();
		if (productos.size() > 0)
			return productos.get(0);
		return null;
		}
}
