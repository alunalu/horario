package br.com.horario.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "permissao", schema = "horario")
public class PermissaoEntity implements Serializable,GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_permissao")
	private Long idPermissao;

	@Column(name = "nome")
	private String nome;

	@ManyToMany(mappedBy = "permissoes")
	private List<UsuarioEntity> usuarios;

	public List<UsuarioEntity> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}

	public Long getIdPermissao() {
		return idPermissao;
	}

	public void setIdPermissao(Long idPermissao) {
		this.idPermissao = idPermissao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.nome;
	}



}