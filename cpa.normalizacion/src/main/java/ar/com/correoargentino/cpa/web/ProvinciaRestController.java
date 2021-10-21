package ar.com.correoargentino.cpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ar.com.correoargentino.cpa.model.Provincia;
import ar.com.correoargentino.cpa.service.ProvinciaService;

@RestController
@RequestMapping("/provincia")
public class ProvinciaRestController {
	@Autowired
	private ProvinciaService provinciaService;
	
	@GetMapping(value = "/")
	public @ResponseBody Iterable<Provincia> getAllProvincias() {
		return provinciaService.getAllProvincias();
	}
	
	@GetMapping(value = "/{str}", produces = "application/json")
	public @ResponseBody Iterable<Provincia> getProvinciasByName(@PathVariable("str") String str) {
		
			return provinciaService.getProvinciasPorNombre(str);
		
	}
	
}
