package ec.edu.uce.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Guardia;

/**
 * @author edison
 *
 */
@Transactional
@Repository
public class GuardiaRepoImpl implements IGuardiaRepo {

	private static final Logger LOG = LoggerFactory.getLogger(GuardiaRepoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

//	@Override
	public void insertarGuardia(Guardia guardia) {
		this.entityManager.persist(guardia);
	}

//	@Override
	public void actualizarGuardia(Guardia guardia) {
		this.entityManager.merge(guardia);
	}

//	@Override
	public Guardia buscarGuardiaPorId(Integer id) {
		return this.entityManager.find(Guardia.class, id);
	}

//	@Override
	public void borrarGuardiaPorId(Integer id) {
		Guardia guardiaABorrar = this.buscarGuardiaPorId(id);
		this.entityManager.remove(guardiaABorrar);
	}

//	@Override
	public Guardia buscarGuardiaPorApellido(String apellido) {
		// SQL normal: select * from guardia where apellido='MVN'

		// JPQL: select g from Guardia g where g.apellido=:valor
		// select g from Guardia g where g.apellido='MVN'
		Guardia g = null;
		try {
			Query miQuery = this.entityManager.createQuery("select g from Guardia g where g.apellido=:valor");
			miQuery.setParameter("valor", apellido);

			g = (Guardia) miQuery.getSingleResult();
		} catch (NoResultException e) {
			LOG.error("No exite un resultado para:" + apellido, e);
		}

		return g;
	}

	/**
	 * Este metodo es igual que el buscarGuardiaPorApellido nada mas que con
	 * TypedQuery
	 */
//	@Override
	public Guardia buscarGuardiaPorApellidoType(String apellido) {
//		TypedQuery<Guardia> myTypedQuery = this.entityManager
//				.createQuery("select g from Guardia g where g.apellido=:valor");

		TypedQuery<Guardia> myTypedQuery = this.entityManager
				.createQuery("select g from Guardia g where g.apellido=:valor", Guardia.class);
		myTypedQuery.setParameter("valor", apellido);
		return myTypedQuery.getSingleResult();
	}

	/**
	 * Este metodo es igual que el buscarGuardiaPorApellido nada mas que con
	 * NamedQuery
	 */
	@Override
	public Guardia buscarGuardiaPorApellidoNamed(String apellido) {
		Query miQuery = this.entityManager.createNamedQuery("Guardia.buscarPorApellido", Guardia.class);
		miQuery.setParameter("valor", apellido);
		return (Guardia) miQuery.getSingleResult();
	}

	@Override
	public Guardia buscarGuardiaPorApellidoNative(String apellido) {
		Query miQuery = this.entityManager.createNativeQuery("select * from guardia g where g.apellido=:valor",
				Guardia.class);
		miQuery.setParameter("valor", apellido);
		return (Guardia) miQuery.getSingleResult();
	}

	@Override
	public Guardia buscarGuardiaPorApellidoNamedNative(String apellido) {
		Query miQuery = this.entityManager.createNamedQuery("Guardia.buscarPorApellidoNative", Guardia.class);
		miQuery.setParameter("valor", apellido);
		return (Guardia) miQuery.getSingleResult();
	}

	@Override
	public Guardia buscarGuardiaPorApellidoCriteriaAPI(String apellido) {
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();

		CriteriaQuery<Guardia> myQuery = myCriteria.createQuery(Guardia.class);

		// select * from Tabla where
		// Aqui empiezo a construir mi SQL
		Root<Guardia> myTable = myQuery.from(Guardia.class);

		// los where en criteria API se los conoce como Predicados
		// select * from guardia g where g.apellido=:valor
		Predicate p1 = myCriteria.equal(myTable.get("apellido"), apellido);
//		Predicate p2 = myCriteria.equal(myTable.get("apellido"), apellido);

		// empezamos a conformar el select
		myQuery.select(myTable).where(p1);

		TypedQuery<Guardia> typedQuery = this.entityManager.createQuery(myQuery);

		return typedQuery.getSingleResult();
	}

	@Override
	public Guardia buscarGuardiaPorApellidoCriteriaAPIAnd(String ape, String edi) {
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();

		CriteriaQuery<Guardia> myQuery = myCriteria.createQuery(Guardia.class);

		// select * from Tabla where
		// Aqui empiezo a construir mi SQL
		Root<Guardia> myTable = myQuery.from(Guardia.class);

		// los where en criteria API se los conoce como Predicados
		// SELECT * FROM guardia where apellido = 'MVN2' and edificio = 'Villaflora';
		Predicate p1 = myCriteria.equal(myTable.get("apellido"), ape); // apellido = 'MVN2'
		Predicate p2 = myCriteria.equal(myTable.get("edificio"), edi); // edificio = 'Villaflora
		Predicate predicadoFinal = myCriteria.and(p1, p2); // apellido = 'MVN2' and edificio = 'Villaflora'

		// empezamos a conformar el select
		myQuery.select(myTable).where(predicadoFinal);

		TypedQuery<Guardia> typedQuery = this.entityManager.createQuery(myQuery);

		return typedQuery.getSingleResult();
	}

	@Override
	public List<Guardia> buscarGuardiaPorApellidoCriteriaAPIOr(String ape, String edi) {
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();

		CriteriaQuery<Guardia> myQuery = myCriteria.createQuery(Guardia.class);

		// select * from Tabla where
		// Aqui empiezo a construir mi SQL
		Root<Guardia> myTable = myQuery.from(Guardia.class);

		// los where en criteria API se los conoce como Predicados
		// SELECT * FROM guardia where apellido = 'MVN2' or edificio = 'Villaflora';
		Predicate p1 = myCriteria.equal(myTable.get("apellido"), ape); // apellido = 'MVN2'
		Predicate p2 = myCriteria.equal(myTable.get("edificio"), edi); // edificio = 'Villaflora
		Predicate predicadoFinal = predicadoFinal= myCriteria.or(p1, p2); // apellido = 'MVN2' or edificio = 'Villaflora'

		// empezamos a conformar el select
		myQuery.select(myTable).where(predicadoFinal);

		TypedQuery<Guardia> typedQuery = this.entityManager.createQuery(myQuery);

		return typedQuery.getResultList();
	}

	/**
	 *
	 */
	public Guardia buscarGuardiaPorApellidoLista(String apellido) {
		// SQL normal: select * from guardia where apellido='MVN'

		// JPQL: select g from Guardia g where g.apellido=:valor
		// select g from Guardia g where g.apellido='MVN'
		Query miQuery = this.entityManager.createQuery("select g from Guardia g where g.apellido=:valor");
		miQuery.setParameter("valor", apellido);

		List<Guardia> listaDeGuardias = miQuery.getResultList();

		if (!listaDeGuardias.isEmpty()) {
			LOG.info("Tiene mas de un registro:" + listaDeGuardias.size());
			return listaDeGuardias.get(0);
		} else {
			return null;
		}

	}

}
