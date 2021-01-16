package net.mesa.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.mesa.model.Vacante;
import net.mesa.service.ICategoriasService;
import net.mesa.service.VacantesService;
import net.mesa.util.Utileria;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {
	
	//@Value("${empleoapp.ruta.imagenes}")
	//private String ruta;
	
	@Autowired
	private VacantesService servicioVacante;
	
	@Autowired
	private ICategoriasService serviceCategorias;
	
	@GetMapping("/index")
	private String mostrarIndex(Model model) {
		
		List<Vacante> lista= servicioVacante.buscarTodas();
		model.addAttribute("vacante", lista);
		return "vacantes/listVacantes";
	}
	
	@GetMapping("/create")
	private String crear(Vacante vacante, Model model) {
		
		model.addAttribute("categorias", serviceCategorias.buscarTodas());
		return "vacantes/formVacante";
	}
	
	/*@GetMapping("/save")
	private String guardar(@RequestParam("nombre") String nombre, 
			@RequestParam("descripcion") String descripcion, 
			@RequestParam("estatus") String estatus,
			@RequestParam("fecha") String fecha,
			@RequestParam("destacado") int destacado,
			@RequestParam("salario") double salario,
			@RequestParam("detalles") String detalles) {
		return "vacantes/listVacantes";
	}*/
	
	@PostMapping("/save")
	private String guardar(Vacante vacante, BindingResult result, RedirectAttributes attributes,
			 @RequestParam("archivoImagen") MultipartFile multiPart ){
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				System.out.println("ocurrio un error rn" + error.getDefaultMessage());
			}
			return "vacantes/formVacante";
		}
		
		if (!multiPart.isEmpty()) {
			//String ruta = "/empleos/img-vacantes/"; // Linux/MAC
			
			String ruta = "E:/empleito/img-vacantes/"; // Windows

			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null){ // La imagen si se subio
			// Procesamos la variable nombreImagen
			vacante.setImagen(nombreImagen);
			}
			}

		
		servicioVacante.guardar(vacante);
		attributes.addFlashAttribute("msg", "Registro guardado");
		return "redirect:/vacantes/index";
	}
	
	
	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idVacante, Model model) {
		System.out.println("Borrando vacnte con id: " + idVacante);
		model.addAttribute("idEliminada", idVacante);
		return "mensaje";
	}

	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id")  int idVacante, Model model) {
		
		Vacante vacante  = servicioVacante.buscarPorId(idVacante);
		
		System.out.println("vacante: "+ vacante);
		model.addAttribute("vacante", vacante);
		return "detalle";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}