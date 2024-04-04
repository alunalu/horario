package br.com.horario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.horario.entity.UsuarioEntity;
import jakarta.transaction.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
	
boolean existsByCpf(String cpf);
boolean existsByEmail(String email);
UsuarioEntity getOneByCpf(String cpf);
	
@Modifying
@Query(value = "update horario.usuario set senha = ?2", nativeQuery = true)  
@Transactional
void alterarSenha(String nomeSenha, String cpf);

}