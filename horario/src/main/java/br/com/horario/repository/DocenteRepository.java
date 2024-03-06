package br.com.horario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.horario.entity.DocenteEntity;

@Repository
public interface DocenteRepository extends JpaRepository< DocenteEntity, Long>{

	DocenteEntity getOneByIdDocente(Long idDocente);
}
