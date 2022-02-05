package ec.edu.uce;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.jpa.DetalleFactura;
import ec.edu.uce.modelo.jpa.Factura;
import ec.edu.uce.modelo.jpa.Guardia;
import ec.edu.uce.service.IFacturaService;
import ec.edu.uce.service.IGestorCitaService;
import ec.edu.uce.service.IGuardiaService;
import ec.edu.uce.service.IPacienteService;

@SpringBootApplication
public class ProyectoSpringJpaEcApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoSpringJpaEcApplication.class);

	@Autowired
	private IPacienteService pacienteService;

	@Autowired
	private IGestorCitaService gestorCitaService;

	@Autowired
	private IGuardiaService guardiaService;

	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoSpringJpaEcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Paciente paciente1 = new Paciente();
//		paciente1.setId(6);
//		paciente1.setNombre("Pepito");
//		paciente1.setApellido("A");
//		paciente1.setEdad(14);
//
//		this.pacienteService.insertarPacienteNuevo(paciente1);
//
//		this.pacienteService.borrarPacientePorId(3);

//		Paciente pacienteA = new Paciente();
//		pacienteA.setId(2);
//		pacienteA.setNombre("A");
//		pacienteA.setApellido("B");
//		pacienteA.setEdad(15);
//		this.pacienteService.actualizarPaciente(pacienteA);
//
//		Paciente p1 = this.pacienteService.buscarPacientePorId(100);
//		System.out.println("El paciente que usted esta buscando es:");
//		System.out.println(p1);

//		Paciente p1 = new Paciente();
//		p1.setId(7);
//		p1.setNombre("Daniel");
//		p1.setApellido("Constante");
//		p1.setEdad(45);
//
//		Receta r1 = new Receta();
//		r1.setId(2);
//		r1.setIndicaciones("Guardar reposo 5 semanas");
//		r1.setMedicamentos("Paracetamol");
//
//		this.gestorCitaService.registraNuevaConsulta(p1, r1);

//		Guardia g1 = new Guardia();
//		g1.setNombre("Consola");
//		g1.setApellido("MVN");
//		g1.setEdificio("JAVA");
//		this.guardiaService.guardar(g1);

//		Guardia g2 = new Guardia();
//		g2.setId(3);
//		g2.setNombre("Juanito");
//		g2.setApellido("Teran");
//		g2.setEdificio("Villaflora");
//		
//		this.guardiaService.actualizar(g2);

		Guardia g102 = this.guardiaService.buscar(102);
		System.out.println(g102);

//		this.guardiaService.borrar(157);

//		Guardia gApellido = this.guardiaService.buscarPorApellido("Torres11111");
//		System.out.println(gApellido);

//		Guardia gApellido = this.guardiaService.buscarPorApellidoLista("Torres");
//		System.out.println(gApellido);

		// Aqui buscar con TypedQuery
//		Guardia gApellido = this.guardiaService.buscarPorApellidoTyped("MVN2");
//		System.out.println(gApellido);

//		Guardia gApellido = this.guardiaService.buscarPorApellidoNamed("MVN2");
//		LOG.info("EL guardia es: " + gApellido);

		//
//		Guardia gApellido = this.guardiaService.buscarPorApellidoNative("MVN2");
//		LOG.info("EL guardia es (SQL native): " + gApellido);

//		Guardia gApellido = this.guardiaService.buscarPorApellidoNamedNative("MVN2");
//		LOG.info("EL guardia es (Named SQL native): " + gApellido);

//		Guardia gApellido = this.guardiaService.buscarPorApellidoCriteriaAPI("MVN2");
//		LOG.info("EL guardia es (Criteria): " + gApellido);

//		Guardia gApellido = this.guardiaService.buscarPorApellidoCriteriaAPIAnd("Torres","Naciones Unidas");
//		LOG.info("EL guardia es (Criteria AND): " + gApellido);

		List<Guardia> listaGuardias = this.guardiaService.buscarPorApellidoCriteriaAPIOr("MVN2", "Villaflora");
		for (Guardia g : listaGuardias) {
			LOG.info("El guardia es: " + g);
		}

		Factura miFactura = new Factura();
		miFactura.setCedula("09834747");
		LocalDateTime miFecha=LocalDateTime.of(2021,Month.AUGUST,8,12,45);
		
		miFactura.setFecha(miFecha);
		miFactura.setNumero("12361263-23631278");
		
		//Vamos a contruir la lista de detalles
		List<DetalleFactura> detalles = new ArrayList<>();
		
		//Primer detalle
		DetalleFactura d1=new DetalleFactura();
		d1.setCantidad(2);
		d1.setPrecio(new BigDecimal(2.57));
		d1.setFactura(miFactura);
		
		//Segundo detalle
		DetalleFactura d2=new DetalleFactura();
		d2.setCantidad(10);
		d2.setPrecio(new BigDecimal(10.50));
		d2.setFactura(miFactura);

		detalles.add(d1);
		detalles.add(d2);
		
		miFactura.setDetalles(detalles);

		this.facturaService.guardarFactura(miFactura);

	}

}
