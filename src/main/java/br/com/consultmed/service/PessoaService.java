package br.com.consultmed.service;

import java.util.List;

import br.com.consultmed.model.Pessoa;
import dao.PessoaDAO;

public class PessoaService implements IPessoa{

	private PessoaDAO service = new PessoaDAO();

	@Override
	public void salvar(Pessoa pessoa) {
		this.service.salvar(pessoa);
	}

	@Override
	public void remover(Long idPessoa) {
		this.service.remover(idPessoa);
	}

	@Override
	public List<Pessoa> listar() {
		return this.service.pessoas();
	}

	@Override
	public void altetar(Pessoa pessoa) {
		this.service.editar(pessoa);
	}

	@Override
	public Pessoa buscarId(Long idPessoa) {
		return this.service.buscarPessoaId(idPessoa);
	}
}
