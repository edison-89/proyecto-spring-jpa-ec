package ec.edu.uce.repository;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Paciente;

@Repository
public class PacienteRepoImpl implements IPacienteRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertarPaciente(Paciente paciente) throws PersistenceException {
		// insert into paciente (id, nombre, apellido, edad) values(1, 'Edison',
		// 'Cayambe', 32)
		// Mi arreglo de los datos a insertar
		Object[] datosAInsertar = new Object[] { paciente.getId(), paciente.getNombre(), paciente.getApellido(),
				paciente.getEdad() };

		this.jdbcTemplate.update("insert into paciente (id, nombre, apellido, edad)values(?,?,?,?)", datosAInsertar);
	}

	@Override
	public Paciente buscarPaciente(Integer id) {
		// select * from paciente where id=1
		Object[] datoBuscar = new Object[] { id };
		return this.jdbcTemplate.queryForObject("select * from paciente where id=?", datoBuscar, new BeanPropertyRowMapper<Paciente>(Paciente.class));
	}

	@Override
	public void actualizarPaciente(Paciente paciente) {
		// update paciente set id=1,nombre='Edison1',apellido='Cayambe1',edad=33 where
		// id=1
		Object[] datoActualizar = new Object[] { paciente.getId(), paciente.getNombre(), paciente.getApellido(),
				paciente.getEdad(), paciente.getId() };
		this.jdbcTemplate.update("update paciente set id=?,nombre=?,apellido=?,edad=? where id=?", datoActualizar);
	}

	@Override
	public void borrarPaciente(Integer id) {
		// delete from paciente where id=1
		Object[] datoABorrar = new Object[] { id };
		this.jdbcTemplate.update("delete from paciente where id=?", datoABorrar);
	}

}
