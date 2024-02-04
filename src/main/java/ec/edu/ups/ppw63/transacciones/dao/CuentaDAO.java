package ec.edu.ups.ppw63.transacciones.dao;

import java.util.List;

import ec.edu.ups.ppw63.transacciones.model.Cuenta;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class CuentaDAO {

	@PersistenceContext
	private EntityManager em;

	public void insert(Cuenta  cuenta) {
		em.persist(cuenta);
	}
		
	public void update(Cuenta cuenta) {
		em.merge(cuenta);	
	}

	public void remove(int codigo) {
		Cuenta cuenta = em.find(Cuenta.class, codigo);
		em.remove(cuenta);
	}
	
	public Cuenta read(int codigo) {
		Cuenta cuenta = em.find(Cuenta.class, codigo);
		return cuenta;
	}
	
	public List<Cuenta> getAll(){
		String jpql = "SELECT c FROM Cuenta c"; //JPQL es sensible a mayusculas --- para realizar una consulta es similar pero hay q ue tener en cuenta que se tiene una variabe en lugar del alterisco y hay que referenciar a la entidad  no a la tabla
												 // Es decir se debe consultar en la entidad mas no directamente a una tabla de la base de datos 
												 // En lugar del * se coloca una variable, esa variable hace referencia al alias de la entidad
		Query q = em.createQuery(jpql, Cuenta.class);
		return q.getResultList();
	}
	
	public Cuenta getCuentaPorId(int codigo) {
		String jpql = "SELECT c FROM Cuenta c WHERE c.codigo = :codigo";
		Query q = em.createQuery(jpql, Cuenta.class);
		q.setParameter("codigo", codigo);
		List<Cuenta> cuentas = q.getResultList();
		if (cuentas.size() > 0)
			return cuentas.get(0);
		return null;
		}
}
