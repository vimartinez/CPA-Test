package ar.com.correoargentino.cpa.repositories;

import ar.com.correoargentino.cpa.model.DomicilioBaseCPA;

public interface DomicilioRepositoryCustom {
	Iterable<DomicilioBaseCPA> getAllPosiblesDomiciliosProvDeptoLocalidadCalle(String upperCase, String upperCase2,
			String upperCase3, String upperCase4);

	Iterable<DomicilioBaseCPA> getAllPosiblesDomiciliosProvDeptoCalle(String upperCase, String upperCase2,
			String upperCase3);

	Iterable<DomicilioBaseCPA> getAllPosiblesDomiciliosProvCalle(String upperCase, String upperCase2);
}
