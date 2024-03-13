package br.com.horario.service;

import java.util.List;

import br.com.horario.entity.DocenteEntity;

public interface DocenteService {
	
String save(DocenteEntity docenteEntity) throws Exception;
List<DocenteEntity> findAnll();
DocenteEntity getOneByIdDocente(Long idDocente) throws Exception;

}
