package br.com.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.dao.DAO;
import br.com.model.Usuario;
import br.com.utilitarios.NegocioException;

public class UsuarioService implements Serializable{

	private static final long serialVersionUID = 6755767919641598594L;

	@Inject
	private DAO<Usuario> dao;
	
	public void salvar(Usuario usuario) throws NegocioException{
		dao.salvar(usuario);
	}
	
	public void remover(Usuario usuario) throws NegocioException{
		dao.remover(Usuario.class, usuario.getId());
	}
	
	public List<Usuario> todosOsUsuarios(){
		return dao.buscarTodos("select u from Usuario u");
	}
	
}
