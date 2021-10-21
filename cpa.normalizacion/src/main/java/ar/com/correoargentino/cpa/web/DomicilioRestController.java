package ar.com.correoargentino.cpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.correoargentino.cpa.model.Domicilio;
import ar.com.correoargentino.cpa.model.DomicilioNormalizado;
import ar.com.correoargentino.cpa.service.DomicilioService;


@RestController
@RequestMapping("/domicilio")
public class DomicilioRestController {
	@Autowired
	private DomicilioService domicilioService;
	
	@GetMapping(value = "/")
	public @ResponseBody Iterable<DomicilioNormalizado> getDomicilioNormalizado(@RequestBody Domicilio domicilio) {
		return domicilioService.getDomicilioNormalizado(domicilio);
	}

}

