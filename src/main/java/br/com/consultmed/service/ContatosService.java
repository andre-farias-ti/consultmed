package br.com.consultmed.service;

import java.util.List;

import br.com.consultmed.model.Contato;
import dao.ContatoDAO;

public class ContatosService implements IContato {
	
	private ContatoDAO service = new ContatoDAO();

	@Override
	public void salvar(Contato contato) {
		this.service.salvar(contato);
	}

	@Override
	public void remover(Long idContato) {
		this.service.remover(idContato);
	}

	@Override
	public List<Contato> listar() {
		return this.service.contatos();
	}

	@Override
	public void altetar(Contato contato) {
		this.service.editar(contato);
	}

	@Override
	public Contato buscarId(Long idContato) {
		return this.service.buscarContatoId(idContato);
	}

}
