package br.com.consultmed.service;

import java.util.List;

import br.com.consultmed.model.Contato;

public interface IContato {

	public void salvar(Contato contato);
	public void remover(Long idContato);
	public List<Contato> listar();
	public void altetar(Contato contato);
	public Contato buscarId(Long idContato);
	
}
