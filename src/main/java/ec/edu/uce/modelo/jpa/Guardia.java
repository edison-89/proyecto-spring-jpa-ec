package ec.edu.uce.modelo.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "guardia") // Es absolutamente necesario cuando la tabal tiene un nombre diferente
@Entity
//Declarar los Query de guardia

@NamedQueries({
		@NamedQuery(name = "Guardia.buscarPorApellido", query = "select g from Guardia g where g.apellido=:valor"),
		@NamedQuery(name = "Guardia.buscarPorApellido1", query = "select g from Guardia g where g.apellido=:valor"),
		@NamedQuery(name = "Guardia.buscarPorApellido2", query = "select g from Guardia g where g.apellido=:valor") })


@NamedNativeQuery(name = "Guardia.buscarPorApellidoNative", query = "select * from guardia g where g.apellido=:valor",resultClass = Guardia.class)
public class Guardia {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_guardia1")
	@SequenceGenerator(name = "seq_guardia1", sequenceName = "seq_guardia1", allocationSize = 1)
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "edificio")
	private String edificio;

	// SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEdificio() {
		return edificio;
	}

	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}

	@Override
	public String toString() {
		return "Guardia [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edificio=" + edificio + "]";
	}

}
