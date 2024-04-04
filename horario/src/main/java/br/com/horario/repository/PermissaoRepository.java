package br.com.horario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.horario.entity.PermissaoEntity;

@Repository
public interface PermissaoRepository extends JpaRepository<PermissaoEntity, Long> {

	PermissaoEntity getOneByIdPermissao(Long idPermissao);

}
