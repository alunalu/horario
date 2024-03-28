package br.com.horario.service;

import java.util.List;

import br.com.horario.entity.CursoEntity;

public interface CursoService {
	String save(CursoEntity cursoEntity) throws Exception;

	List<CursoEntity> findAll();

CursoEntity getOneByIdCurso(Long idCurso) throws Exception;

//Começa a exclusão
	String deleteById(Long idCurso) throws Exception;
	//Termina a exclusão

}
