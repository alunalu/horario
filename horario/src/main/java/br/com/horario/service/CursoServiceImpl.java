package br.com.horario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.horario.entity.CursoEntity;
import br.com.horario.repository.CursoRepository;


@Service
public class CursoServiceImpl implements CursoService{
	
	@Autowired
	private CursoRepository cursoRepository;

	private String mensagem;

	@Override
	public String save(CursoEntity cursoEntity) throws Exception {
      cursoRepository.saveAndFlush(cursoEntity);
      mensagem = "Curso cadastrado com sucesso!";
		return mensagem;
	}

	@Override
	public List<CursoEntity> findAll() {
		
		return cursoRepository.findAll();
	}

	@Override
	public CursoEntity getOneByIdCurso(Long idCurso) throws Exception {
		
		return cursoRepository.getOneByIdCurso(idCurso);
	}

	@Override
	public String deleteById(Long idCurso) throws Exception {
    try
    {
    	cursoRepository.deleteById(idCurso);
    	this.mensagem = "Curso excluido com sucesso.";
    	
    } catch (Exception e ) {
    	throw new Exception (e. getMessage());
    }
    return mensagem;
}
	
}
