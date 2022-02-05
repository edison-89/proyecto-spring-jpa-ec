package ec.edu.uce.repository.jpa;

import java.util.List;

import ec.edu.uce.modelo.jpa.Guardia;

public interface IGuardiaRepo {
	void insertarGuardia(Guardia guardia);

	void actualizarGuardia(Guardia guardia);

	Guardia buscarGuardiaPorId(Integer id);

	void borrarGuardiaPorId(Integer id);

	Guardia buscarGuardiaPorApellido(String apellido);

	Guardia buscarGuardiaPorApellidoType(String apellido);

	Guardia buscarGuardiaPorApellidoNamed(String apellido);

	Guardia buscarGuardiaPorApellidoNative(String apellido);

	Guardia buscarGuardiaPorApellidoNamedNative(String apellido);

	Guardia buscarGuardiaPorApellidoCriteriaAPI(String apellido);

	Guardia buscarGuardiaPorApellidoCriteriaAPIAnd(String apellido, String edificio);

	List<Guardia> buscarGuardiaPorApellidoCriteriaAPIOr(String apellido, String edificio);

	Guardia buscarGuardiaPorApellidoLista(String apellido);

}
