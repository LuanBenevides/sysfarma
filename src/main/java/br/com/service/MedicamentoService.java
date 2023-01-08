package br.com.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.dao.DAO;
import br.com.model.Medicamento;
import br.com.utilitarios.NegocioException;

public class MedicamentoService implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private DAO<Medicamento> dao;
	
	private String nomeNaBusca;
	
	public void salvar(Medicamento m) throws NegocioException{
		
		if(m.getNome().length() < 3) {
			throw new NegocioException("O nome do medicamento não pode ter mais do que 3 caracteres");
		}
		dao.salvar(m);
	}
	
	public void remover(Medicamento m) throws NegocioException{
		dao.remover(Medicamento.class, m.getId());
	}
	
	public List<Medicamento> todosOsMedicamento(){
		return dao.buscarTodos("select m from Medicamento m order by m.nome");
	}
	
	public List<Medicamento> consultaPorNome() {
		
		List<Medicamento> m = dao.buscarTodos("select m from Medicamento m");
		
		List<Medicamento> results = new ArrayList<Medicamento>();
		
		for(Medicamento i: m) {
			if(i.getNome().equalsIgnoreCase(nomeNaBusca)) {
				System.out.println(i.getNome());
				results.add(i);
			}	
		}
		return results;
	}

	public String getNomeNaBusca() {
		return nomeNaBusca;
	}

	public void setNomeNaBusca(String nomeNaBusca) {
		this.nomeNaBusca = nomeNaBusca;
	} 
}
