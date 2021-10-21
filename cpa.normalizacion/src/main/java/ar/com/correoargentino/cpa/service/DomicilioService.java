package ar.com.correoargentino.cpa.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import ar.com.correoargentino.cpa.model.Domicilio;
import ar.com.correoargentino.cpa.model.DomicilioBaseCPA;
import ar.com.correoargentino.cpa.model.DomicilioNormalizado;
import ar.com.correoargentino.cpa.repositories.DomicilioRepository;

/* Servicio para normalizar domicilios
 * Mejoras:
 * 		Condicional gigantesco para evaluar como obtener los candidatos
 * 		Colocar toda la lista de cpa en memoria para no acceder constantemente a bd (mientras tanto indexar tabla)
 * 		Segurizar con usuario y clave al menos
 * 		Registrar todas las solicitudes
 */

@Service
public class DomicilioService {
	@Autowired
	private DomicilioRepository domicilioRepository;
	
	public Iterable<DomicilioNormalizado> getDomicilioNormalizado(Domicilio domicilioEntrada) {
		ArrayList<DomicilioBaseCPA> domiciliosPosibles = null;
		ArrayList<DomicilioNormalizado> resultado = new ArrayList<DomicilioNormalizado>();
		
		if(domicilioEntrada.getProvincia()!="" || domicilioEntrada.getCalle()!="" || domicilioEntrada.getNumero()!=0 ) {
			if(domicilioEntrada.getDepartamento()!="") {
				if(domicilioEntrada.getLocalidad()!="") {
					domiciliosPosibles = (ArrayList<DomicilioBaseCPA>) domicilioRepository.getAllPosiblesDomiciliosProvDeptoLocalidadCalle(domicilioEntrada.getProvincia().toUpperCase(),domicilioEntrada.getDepartamento().toUpperCase(),domicilioEntrada.getLocalidad().toUpperCase(), domicilioEntrada.getCalle().toUpperCase());	
				}
				else {
					//llamada a repository con custom Query
					//domiciliosPosibles = domicilioRepository.getAllPosiblesDomicilios(domicilioEntrada.getProvincia().toUpperCase(),domicilioEntrada.getDepartamento().toUpperCase(), domicilioEntrada.getCalle().toUpperCase());
					domiciliosPosibles = (ArrayList<DomicilioBaseCPA>) domicilioRepository.getAllPosiblesDomiciliosProvDeptoCalle(domicilioEntrada.getProvincia().toUpperCase(),domicilioEntrada.getDepartamento().toUpperCase(), domicilioEntrada.getCalle().toUpperCase());
				}
			}
			else {
				domiciliosPosibles = (ArrayList<DomicilioBaseCPA>) domicilioRepository.getAllPosiblesDomiciliosProvCalle(domicilioEntrada.getProvincia().toUpperCase(), domicilioEntrada.getCalle().toUpperCase());
			}
			
		}else {
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, "Debe enviar como mínimo provincia, calle y número para normalizar");
		}
		
		if (domiciliosPosibles.size() > 0) {
			for(int i=0;i<domiciliosPosibles.size();i++) {
				if((domiciliosPosibles.get(i).getDesde() < domicilioEntrada.getNumero()) && (domiciliosPosibles.get(i).getHasta() > domicilioEntrada.getNumero()) && ((domiciliosPosibles.get(i).getHasta() % 2) == (domicilioEntrada.getNumero() %2))) {
					resultado.add(new DomicilioNormalizado());
					resultado.get(resultado.size()-1).setDireccion(domiciliosPosibles.get(i).getCalleNormalizada() + " " + domicilioEntrada.getNumero());
					resultado.get(resultado.size()-1).setCp4(domiciliosPosibles.get(i).getCp4());
					resultado.get(resultado.size()-1).setCp8(domiciliosPosibles.get(i).getCpa8());
					resultado.get(resultado.size()-1).setProvincia(domiciliosPosibles.get(i).getProvincia());
					resultado.get(resultado.size()-1).setLocalidad(domiciliosPosibles.get(i).getLocalidad());
					resultado.get(resultado.size()-1).setDepartamento(domiciliosPosibles.get(i).getDepartamento());
				}
			}
		}
		if (resultado.size() == 0)throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "No se pudo normalizar el domicilio con esos datos");
		return resultado;
	}

}
