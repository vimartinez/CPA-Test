package ar.com.correoargentino.cpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import ar.com.correoargentino.cpa.model.Provincia;
import ar.com.correoargentino.cpa.repositories.ProvinciaRepository;




@Service
public class ProvinciaService {
	@Autowired
	private ProvinciaRepository provinciaRepository;
	
	public Iterable<Provincia> getAllProvincias() {
		List<Provincia> provincias = null;
		provincias = provinciaRepository.findAll();
		return provincias;
	}
	
	public Iterable<Provincia> getProvinciasPorNombre(String nombre) {
		ArrayList<Provincia> provincias = (ArrayList<Provincia>) provinciaRepository.getProvinciasPorNombre(nombre);
		if (provincias.size() == 0) {
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "No se encontraron provincias con ese nombre");
		}
		if (nombre.length()<3) {
			throw new ResponseStatusException(
				HttpStatus.BAD_REQUEST, "El nombre debe tener al menos 3 caracteres");
		}
		return provincias;
	}
	

}
