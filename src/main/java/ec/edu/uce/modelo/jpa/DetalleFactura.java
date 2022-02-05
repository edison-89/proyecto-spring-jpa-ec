package ec.edu.uce.modelo.jpa;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_factura")
public class DetalleFactura {

	@Id
	@Column(name = "defa_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_detalle")
	@SequenceGenerator(name = "seq_detalle", sequenceName = "seq_detalle", allocationSize = 1)
	private Integer id;

	@Column(name = "defa_cantidad")
	private Integer cantidad;

	@Column(name = "defa_precio")
	private BigDecimal precio;

	@ManyToOne
	@JoinColumn(name = "fact_id")
	private Factura factura;

	// SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
}
