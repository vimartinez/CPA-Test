package ar.com.correoargentino.cpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.correoargentino.cpa.model.Departamento;
import ar.com.correoargentino.cpa.service.DepartamentoService;

@RestController
@RequestMapping("/departamento")
public class DepartamentoRestController {
	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping(value = "/")
	public @ResponseBody Iterable<Departamento> getAllDepartamentos() {
		return departamentoService.getAllDepartamentos();
	}
	
	@GetMapping(value = "/getDepartamentosPorNombre/{str}", produces = "application/json")
	public @ResponseBody Iterable<Departamento> getDepartamentosByName(@PathVariable("str") String str) {
		
			return departamentoService.getDepartamentosPorNombre(str);
		
	}
	
	@GetMapping(value = "/getDepartamentosPorProvincia/{str}", produces = "application/json")
	public @ResponseBody Iterable<Departamento> getDepartamentosPorProvincia(@PathVariable("str") String str) {
		
			return departamentoService.getDepartamentosPorProvincia(str);
		
	}
	
	@GetMapping(value = "/{prov}/{depto}", produces = "application/json")
	public @ResponseBody Iterable<Departamento> getDepartamentosByNameYProvincia(@PathVariable("prov") String prov,@PathVariable("depto") String depto ) {
		
			return departamentoService.getDepartamentosPorNombreYProvincia(depto, prov);
		
	}

}
