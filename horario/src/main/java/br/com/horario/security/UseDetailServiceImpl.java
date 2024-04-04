package br.com.horario.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.horario.entity.UsuarioEntity;
import br.com.horario.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UseDetailServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException{
		
		UsuarioEntity usuario = this.usuarioRepository.getOneByCpf(cpf);
		
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado. ");
		}
		return new User(usuario.getCpf(),usuario.getPassword(),true,true,true,true,usuario.getAuthorities());
	}


}
