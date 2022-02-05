package ec.edu.uce.repository;

import ec.edu.uce.modelo.Receta;

public interface IRecetaRepo {
	void insertarReceta(Receta receta);

	Receta buscarReceta(Integer id);

	void actualizarReceta(Receta receta);

	void borrarReceta(Integer id);
}
