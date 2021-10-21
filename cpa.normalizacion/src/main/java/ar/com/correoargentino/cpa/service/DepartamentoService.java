package ar.com.correoargentino.cpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import ar.com.correoargentino.cpa.model.Departamento;
import ar.com.correoargentino.cpa.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	public Iterable<Departamento> getAllDepartamentos() {
		List<Departamento> departamentos = null;
		departamentos = departamentoRepository.findAll();
		return departamentos;
	}

	public Iterable<Departamento> getDepartamentosPorNombre(String str) {
		ArrayList<Departamento> departamentos = (ArrayList<Departamento>) departamentoRepository.getDepartamentosPorNombre(str);
		if (departamentos.size() == 0) {
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "No se encontraron departamentos con ese nombre");
		}
		if (str.length()<3) {
			throw new ResponseStatusException(
				HttpStatus.BAD_REQUEST, "El nombre debe tener al menos 3 caracteres");
		}
		return departamentos;
	}
	
	public Iterable<Departamento> getDepartamentosPorProvincia(String str) {
		ArrayList<Departamento> departamentos = (ArrayList<Departamento>) departamentoRepository.getDepartamentosPorProvincia(str);
		if (departamentos.size() == 0) {
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "No se encontraron departamentos en la provincia indicada");
		}
		if (str.length()<3) {
			throw new ResponseStatusException(
				HttpStatus.BAD_REQUEST, "El nombre de provincia debe tener al menos 3 caracteres");
		}
		return departamentos;
	}
	
	public Iterable<Departamento> getDepartamentosPorNombreYProvincia(String nombreDepto, String nombreProv) {
		ArrayList<Departamento> departamentos = (ArrayList<Departamento>) departamentoRepository.getDepartamentosPorNombreYProvincia(nombreDepto, nombreProv);
		if (departamentos.size() == 0) {
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "No se encontraron departamentos con ese nombre o provincia");
		}
		if (nombreDepto.length()<3) {
			throw new ResponseStatusException(
				HttpStatus.BAD_REQUEST, "El nombre debe tener al menos 3 caracteres");
		}
		if (nombreProv.length()<3) {
			throw new ResponseStatusException(
				HttpStatus.BAD_REQUEST, "La provincia debe tener al menos 3 caracteres");
		}
		return departamentos;
	}

}
