package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.modelo.Receta;

@Service
public class GestorCitaServiceImpl implements IGestorCitaService {

	@Autowired
	private IPacienteService pacienteService;

	@Autowired
	private IRecetaService recetaService;

	//Transferencia
	@Override
	public void registraNuevaConsulta(Paciente paciente, Receta receta) {
		// sacar el dinero de la cuenta origen
		// poner el dinero en la cuenta destino
		this.pacienteService.guardarPacienteNuevo(paciente);
		this.recetaService.guardarReceta(receta);
	}
	
	

}
