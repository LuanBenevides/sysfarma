package br.com.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.model.Usuario;
import br.com.service.UsuarioService;
import br.com.utilitarios.Message;
import br.com.utilitarios.NegocioException;

@Named
@SessionScoped
public class UsuarioMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Usuario usuario;
	
	@Inject
	private UsuarioService service;
		
	private List<Usuario> usuarios;
	
	@PostConstruct
	public void carregar() {
		usuarios = service.todosOsUsuarios();
	}
	
	public void adicionar() throws NegocioException {
		try {

			service.salvar(usuario);
			usuario = new Usuario();
			carregar();

			Message.info("Salvo com sucesso!");

		} catch (NegocioException e) {
			Message.erro(e.getMessage());
		}

	}
	
	public void excluir() throws NegocioException {
		try {

			service.remover(usuario);
			carregar();

			Message.info(usuario.getNomeCompleto() + " foi removido!");
		} catch (NegocioException e) {
			Message.erro(e.getMessage());
		}
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
}
