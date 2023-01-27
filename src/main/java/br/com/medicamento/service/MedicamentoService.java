package br.com.medicamento.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.medicamento.dao.DAO;
import br.com.medicamento.model.Medicamento;
import br.com.medicamento.utility.NegocioException;

public class MedicamentoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DAO<Medicamento> dao;

	public void salvar(Medicamento medicamento) throws NegocioException {
		if (medicamento.getNome().length() < 3) {
			throw new NegocioException("O nome do medicamento não pode ser menor que 3 caracteres");
		}

		dao.salvar(medicamento);
	}

	public void deletar(Medicamento medicamento) throws NegocioException {
		dao.remover(Medicamento.class, medicamento.getId());
	}

	public List<Medicamento> todosOsMedicamentos() {
		String jpql = "select m from Medicamento order by m.nome";
		return dao.buscarTodos(jpql);
	}

}
