package br.com.horario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.horario.entity.SetorEntity;

@Repository
public interface SetorRepository extends JpaRepository< SetorEntity, Long>{


	

}
