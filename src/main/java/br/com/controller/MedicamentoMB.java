package br.com.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.model.Medicamento;
import br.com.service.MedicamentoService;
import br.com.utilitarios.Message;
import br.com.utilitarios.NegocioException;

@Named
@SessionScoped
public class MedicamentoMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Medicamento medicamento;

	@Inject
	private MedicamentoService service;

	private List<Medicamento> medicamentos;
	
	private String nomeNaBusca;
	
	@PostConstruct
	public void carregar() {
		medicamentos = service.todosOsMedicamento();
	}
	
	public void adicionar() {
		try {

			service.salvar(medicamento);
			medicamento = new Medicamento();
			carregar();

			Message.info("Salvo com sucesso!");

		} catch (NegocioException e) {
			Message.erro(e.getMessage());
		}

	}

	public void excluir() {
		try {

			service.remover(medicamento);
			carregar();

			Message.info(medicamento.getNome() + " foi removido!");
		} catch (NegocioException e) {
			Message.erro(e.getMessage());
		}
	}

	public void consultaPorNome() {
		medicamentos.clear();
				
		medicamentos = service.consultaPorNome();
		
	} 
	
	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	/**
	 * @return the nomeNaBusca
	 */
	public String getNomeNaBusca() {
		return nomeNaBusca;
	}

	/**
	 * @param nomeNaBusca the nomeNaBusca to set
	 */
	public void setNomeNaBusca(String nomeNaBusca) {
		this.nomeNaBusca = nomeNaBusca;
	}

	/**
	 * @return the service
	 */
	public MedicamentoService getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(MedicamentoService service) {
		this.service = service;
	}

	

}
