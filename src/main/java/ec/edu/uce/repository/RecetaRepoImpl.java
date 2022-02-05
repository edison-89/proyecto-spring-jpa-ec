package ec.edu.uce.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Receta;

@Repository
public class RecetaRepoImpl implements IRecetaRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertarReceta(Receta receta) {

		Object[] datosAInsertar = new Object[] { receta.getId(), receta.getIndicaciones(), receta.getMedicamentos() };
		this.jdbcTemplate.update("insert into receta (id, indicaciones, medicamentos) values (?,?,?)", datosAInsertar);
	}

	@Override
	public Receta buscarReceta(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarReceta(Receta receta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrarReceta(Integer id) {
		// TODO Auto-generated method stub

	}

}
