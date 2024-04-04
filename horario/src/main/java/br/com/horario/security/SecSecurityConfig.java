package br.com.horario.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig {

	@Autowired
	private UseDetailServiceImpl useDetailServiceImpl;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean 
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(
				auth -> auth
				.requestMatchers("/signin", "/signup").permitAll()
				.requestMatchers("/preferencia").hasAnyAuthority("professor", "coordenador_curso")
				.requestMatchers("/disponibilidade").hasAnyAuthority("professor", "coordenador_curso")
				.requestMatchers("/docente").hasAuthority("administrador")
				//QUALQUER REQUISIÇÃO AO @CONTROLLER O USUARIO PRECISA ESTAR AUTENTICADO
				.anyRequest().authenticated()
				)
		        .formLogin(fromLogin -> fromLogin
		        		//DIRECIONA PARA ESSE @CONTROLLER QUANDO O LOGIN ESTÁ CORRETO
		        		.defaultSuccessUrl("/principal" , true)
		        		.permitAll()
		        		)
		        .rememberMe(remmemberMe -> remmemberMe.key("AbcdEfghIjkl..."))
		        .logout(logout -> logout.logoutUrl("/signout").permitAll());
		
		return http.build();
	}
	
	@Autowired 
	public void configureGlobal(AuthenticationManagerBuilder auth)
	throws Exception {
		//SERVE DE EXEMPLO PARA GERAR UMA SENHA CRIPTOGRAFADA 
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		System.out.println(b.encode("123456"));
		//Cripitografa a senha para salvar no banco de dados 
		auth.userDetailsService(useDetailServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
		       
		
	}
}
