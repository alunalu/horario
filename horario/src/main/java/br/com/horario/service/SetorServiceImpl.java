package br.com.horario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.horario.entity.SetorEntity;
import br.com.horario.repository.SetorRepository;


@Service
public class SetorServiceImpl implements SetorService {
	
	@Autowired
	private SetorRepository setorRepository;
	
	@Override
	public List<SetorEntity> finAll() {
		// TODO Auto-generated method stub
		return setorRepository.findAll();
	}

	

}
