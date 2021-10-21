package ar.com.correoargentino.cpa.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import ar.com.correoargentino.cpa.model.Localidad;
import ar.com.correoargentino.cpa.repositories.LocalidadRepository;

@Service
public class LocalidadService {
	@Autowired
	private LocalidadRepository localidadRepository;


	public Iterable<Localidad> getLocalidadesPorNombre(String str) {
		ArrayList<Localidad> localidades = (ArrayList<Localidad>) localidadRepository.getLocalidadesPorNombre(str);
		if (localidades.size() == 0) {
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "No se encontraron localidades con ese nombre");
		}
		if (str.length()<3) {
			throw new ResponseStatusException(
				HttpStatus.BAD_REQUEST, "El nombre de la localidad debe tener al menos 3 caracteres");
		}
		return localidades;
	}


	public Iterable<Localidad> getLocalidadesPorDepartamento(String str) {
		ArrayList<Localidad> localidades = (ArrayList<Localidad>) localidadRepository.getLocalidadesPorDepartamento(str);
		if (localidades.size() == 0) {
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "No se encontraron localidades en ese departamento");
		}
		if (str.length()<3) {
			throw new ResponseStatusException(
				HttpStatus.BAD_REQUEST, "El nombre de la localidad debe tener al menos 3 caracteres");
		}
		return localidades;
	}

}