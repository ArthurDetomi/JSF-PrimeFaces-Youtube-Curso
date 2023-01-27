package br.com.medicamento.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.medicamento.model.Medicamento;
import br.com.medicamento.service.MedicamentoService;
import br.com.medicamento.utility.Message;
import br.com.medicamento.utility.NegocioException;

@Named
@ViewScoped
public class MedicamentoMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Medicamento medicamento;

	@Inject
	private MedicamentoService service;

	private List<Medicamento> medicamentos;

	// esse metodo será criado junto com a inicialização da classe
	@PostConstruct
	public void carregar() {
		medicamentos = service.todosOsMedicamentos();
	}

	public void adicionarMedicamento() {
		try {
			service.salvar(medicamento);
			medicamento = new Medicamento();
			carregar();

			Message.info("Salvo com sucesso");
		} catch (NegocioException e) {
			Message.erro(e.getMessage());
		}
	}

	public void excluir() {
		try {
			service.deletar(medicamento);
			medicamento = new Medicamento();
			carregar();

			Message.info("Deletado com sucesso");
		} catch (NegocioException e) {
			Message.erro(medicamento.getNome() + e.getMessage());
		}
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

}
