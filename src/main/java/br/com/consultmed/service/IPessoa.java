package br.com.consultmed.service;

import java.util.List;

import br.com.consultmed.model.Pessoa;

public interface IPessoa {

	public void salvar(Pessoa pessoa);
	public void remover(Long idPessoa);
	public List<Pessoa> listar();
	public void altetar(Pessoa pessoa);
	public Pessoa buscarId(Long idPessoa);
	
}
