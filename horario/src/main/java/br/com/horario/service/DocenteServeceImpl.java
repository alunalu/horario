package br.com.horario.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.horario.entity.DocenteEntity;
import br.com.horario.repository.DocenteRepository;


@Service
public class DocenteServeceImpl implements DocenteService {

@Autowired
private DocenteRepository docenteRepository;

private String mensagem;

@Override
public String save(DocenteEntity docenteEntity) throws Exception {
		if (docenteEntity.getNome()== null ) {
			this.mensagem = "DIGITE O NOME DO DOCENTE.";
			throw new Exception("PREENCHA O NOME DO DOCENTE.");
		}
		else if (docenteEntity.getSobrenome()== null) {
			this.mensagem = "PREENCHA O SOBRENOME DO DOCENTE.";
			throw new Exception("PREENCHA O NOME DO DOCENTE.");
		}
		
		else if (docenteEntity.getEmail() == null) {
			this.mensagem = "PREENCHA O EMAIL";
			throw new Exception("PREENCHA O NOME DO DOCENTE.");
		}
		else 
		{
			docenteRepository.saveAndFlush(docenteEntity);
			this.mensagem = "DOCENTE CADASTRADO COM SUCESSO";
		}
		return mensagem;
		}
		
	@Override
	public List<DocenteEntity> findAnll() {
		return docenteRepository.findAll();
		
	}

	@Override
	public DocenteEntity getOneByIdDocente(Long idDocente) throws Exception {
		return docenteRepository.getOneByIdDocente(idDocente);
	}

}
