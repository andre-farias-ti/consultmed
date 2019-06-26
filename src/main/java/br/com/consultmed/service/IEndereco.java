package br.com.consultmed.service;

import java.util.List;

import br.com.consultmed.model.Endereco;

public interface IEndereco {

	public void salvar(Endereco endereco);
	public void remover(Long idEndereco);
	public List<Endereco> listar();
	public void altetar(Endereco endereco);
	public Endereco buscarId(Long idEndereco);
}
