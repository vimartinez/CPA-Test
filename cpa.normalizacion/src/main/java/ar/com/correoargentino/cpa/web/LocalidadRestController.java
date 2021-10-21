package ar.com.correoargentino.cpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.correoargentino.cpa.model.Localidad;
import ar.com.correoargentino.cpa.service.LocalidadService;

@RestController
@RequestMapping("/localidad")
public class LocalidadRestController {
	@Autowired
	LocalidadService localidadService;
	
	@GetMapping(value = "/getLocalidadesPorNombre/{str}", produces = "application/json")
	public @ResponseBody Iterable<Localidad> getLocalidadesPorNombre(@PathVariable("str") String str) {
		
			return localidadService.getLocalidadesPorNombre(str);
		
	}
	
	@GetMapping(value = "/getLocalidadesPorDepartamento/{str}", produces = "application/json")
	public @ResponseBody Iterable<Localidad> getLocalidadesPorDepartamento(@PathVariable("str") String str) {
		
			return localidadService.getLocalidadesPorDepartamento(str);
		
	}

}
