package br.com.consultmed.service;

import java.util.List;

import br.com.consultmed.model.Endereco;
import dao.EnderecoDAO;

public class EnderecoService implements IEndereco{

	private EnderecoDAO service = new EnderecoDAO();

	@Override
	public void salvar(Endereco endereco) {
		this.service.salvar(endereco);
	}

	@Override
	public void remover(Long idEndereco) {
		this.service.remover(idEndereco);
	}

	@Override
	public List<Endereco> listar() {
		return this.service.enderecos();
	}

	@Override
	public void altetar(Endereco endereco) {
		this.service.editar(endereco);
	}

	@Override
	public Endereco buscarId(Long idEndereco) {
		return this.service.buscarEnderecoId(idEndereco);
	}
	
}
