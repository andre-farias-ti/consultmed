package br.com.consultmed.service;

import java.util.List;

import br.com.consultmed.model.Exame;
import dao.ExameDAO;

public class ExameService implements IExame {

	private ExameDAO service = new ExameDAO();

	@Override
	public void salvar(Exame exame) {
		this.service.salvar(exame);
	}

	@Override
	public void remover(Long idExame) {
		this.service.remover(idExame);
	}

	@Override
	public List<Exame> listar() {
		return this.service.exames();
	}

	@Override
	public void altetar(Exame exame) {
		this.service.editar(exame);
	}

	@Override
	public Exame buscarId(Long idExame) {
		return this.service.buscarExameId(idExame);
	}
}
