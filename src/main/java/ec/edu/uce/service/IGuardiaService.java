package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.modelo.jpa.Guardia;

public interface IGuardiaService {
	void guardar(Guardia guardia);

	void actualizar(Guardia guardia);

	Guardia buscar(Integer id);

	void borrar(Integer id);

	Guardia buscarPorApellido(String apellido);

	Guardia buscarPorApellidoTyped(String apellido);

	Guardia buscarPorApellidoNamed(String apellido);

	Guardia buscarPorApellidoNative(String apellido);

	Guardia buscarPorApellidoNamedNative(String apellido);

	Guardia buscarPorApellidoCriteriaAPI(String apellido);

	Guardia buscarPorApellidoCriteriaAPIAnd(String apellido, String edificio);

	List<Guardia> buscarPorApellidoCriteriaAPIOr(String apellido, String edificio);

	Guardia buscarPorApellidoLista(String apellido);
}
