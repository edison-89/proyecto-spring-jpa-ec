package ec.edu.uce.modelo;

public class Receta {
	private Integer id;
	private String indicaciones;
	private String medicamentos;

	// Metodos SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIndicaciones() {
		return indicaciones;
	}

	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
	}

	public String getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}

	@Override
	public String toString() {
		return "Receta [id=" + id + ", indicaciones=" + indicaciones + ", medicamentos=" + medicamentos + "]";
	}

}
